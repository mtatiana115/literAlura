package com.alura.literatura.service;

import com.alura.literatura.model.Autor;
import com.alura.literatura.model.Libro;
import com.alura.literatura.repository.AutorRepository;
import com.alura.literatura.repository.LibroRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private ConsumidorApi consumidorApi;

    @Autowired
    private ConversorDatos conversorDatos;

    public void buscarYGuardarLibro(String titulo) {
        String url = "https://gutendex.com/books/?search=" + titulo.replace(" ", "%20");
        String json = consumidorApi.obtenerDatos(url);

        // Verificamos si la respuesta de la API es nula o vacía.
        if (json == null || json.isEmpty()) {
            System.out.println("Error: No se pudo obtener el libro de la API o la respuesta está vacía.");
            return;
        }

        JsonNode nodoResultados = conversorDatos.obtenerNodo(json).path("results");

        if (nodoResultados.isEmpty() || !nodoResultados.isArray()) {
            System.out.println("Libro no encontrado en la API.");
            return;
        }

        JsonNode primerLibroJson = nodoResultados.get(0);

        String tituloLibro = primerLibroJson.path("title").asText();
        Integer descargas = primerLibroJson.path("download_count").asInt();
        String idioma = primerLibroJson.path("languages").get(0).asText();  // Primer idioma

        JsonNode autorJson = primerLibroJson.path("authors").get(0);  // Primer autor
        String nombreAutor = autorJson.path("name").asText();
        Integer nacimiento = autorJson.has("birth_year") && !autorJson.path("birth_year").isNull()
                     ? autorJson.path("birth_year").asInt() : null;

        Integer fallecimiento = autorJson.has("death_year") && !autorJson.path("death_year").isNull()
                        ? autorJson.path("death_year").asInt() : null;

        if (libroRepository.findByTitulo(tituloLibro) != null) {
            System.out.println("El libro ya está registrado.");
            return;
        }

        Autor autor = autorRepository.findByNombre(nombreAutor);
        if (autor == null) {
            autor = new Autor(nombreAutor, nacimiento, fallecimiento);
            autorRepository.save(autor);
        }

        Libro libro = new Libro(tituloLibro, idioma, descargas);
        libro.setAutor(autor);
        autor.agregarLibro(libro);
        libroRepository.save(libro);

        System.out.println("\n----------------- LIBRO -----------------");
        System.out.println("Título: " + tituloLibro);
        System.out.println("Autor: " + nombreAutor);
        System.out.println("Idioma: " + idioma);
        System.out.println("Número de descargas: " + descargas);
        System.out.println("-----------------------------------------\n");
    }

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    public List<Autor> listarAutoresVivosEnAño(int año) {
        return autorRepository.findAutoresVivosEnAño(año);
    }

    public List<Libro> listarLibrosPorIdioma(String idioma) {
        return libroRepository.findByIdioma(idioma.toUpperCase());
    }
}