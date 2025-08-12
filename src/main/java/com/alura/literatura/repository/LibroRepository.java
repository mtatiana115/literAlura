package com.alura.literatura.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.literatura.model.Libro;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    Libro findByTitulo(String titulo);  // Para verificar duplicados
    List<Libro> findByIdioma(String idioma);
}