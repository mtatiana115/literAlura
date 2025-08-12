package com.alura.literatura.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Integer añoNacimiento;
    private Integer añoFallecimiento;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros = new ArrayList<>();

    // Constructor vacío para JPA
    public Autor() {}

    // Constructor con datos
    public Autor(String nombre, Integer añoNacimiento, Integer añoFallecimiento) {
        this.nombre = nombre;
        this.añoNacimiento = añoNacimiento;
        this.añoFallecimiento = añoFallecimiento;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Integer getAñoNacimiento() { return añoNacimiento; }
    public void setAñoNacimiento(Integer añoNacimiento) { this.añoNacimiento = añoNacimiento; }
    public Integer getAñoFallecimiento() { return añoFallecimiento; }
    public void setAñoFallecimiento(Integer añoFallecimiento) { this.añoFallecimiento = añoFallecimiento; }
    public List<Libro> getLibros() { return libros; }
    public void setLibros(List<Libro> libros) { this.libros = libros; }

    // Método para agregar libro
    public void agregarLibro(Libro libro) {
        libros.add(libro);
        libro.setAutor(this);
    }

    @Override
    public String toString() {
        return "Autor: " + nombre + " (Nacimiento: " + añoNacimiento + ", Fallecimiento: " + (añoFallecimiento != null ? añoFallecimiento : "Vivo") + ")";
    }
}