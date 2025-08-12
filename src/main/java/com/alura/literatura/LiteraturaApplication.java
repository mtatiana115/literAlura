package com.alura.literatura;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alura.literatura.service.LibroService;

@SpringBootApplication
public class LiteraturaApplication  implements CommandLineRunner{

    @Autowired
    private LibroService libroService;

	public static void main(String[] args) {
		SpringApplication.run(LiteraturaApplication.class, args);
	}

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Menú LiterAlura ---");
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Listar libros registrados");
            System.out.println("3. Listar autores registrados");
            System.out.println("4. Listar autores vivos en un año");
            System.out.println("5. Listar libros por idioma");
            System.out.println("6. Mostrar estadísticas por idioma");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            int opcion;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida. Intenta de nuevo.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el título del libro: ");
                    String titulo = scanner.nextLine();
                    libroService.buscarYGuardarLibro(titulo);
                    break;
                case 2:
                    libroService.listarLibros().forEach(System.out::println);
                    break;
                case 3:
                    libroService.listarAutores().forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Ingresa el año: ");
                    int año;
                    try {
                        año = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Año inválido.");
                        continue;
                    }
                    libroService.listarAutoresVivosEnAño(año).forEach(System.out::println);
                    break;
                case 5:
                    System.out.print("Ingresa el idioma (ej. ES, EN): ");
                    String idioma = scanner.nextLine();
                    libroService.listarLibrosPorIdioma(idioma).forEach(System.out::println);
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

}
