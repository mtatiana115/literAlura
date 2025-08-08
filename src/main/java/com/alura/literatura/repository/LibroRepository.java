package com.alura.literatura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.literatura.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByIdioma(String idioma);
}
