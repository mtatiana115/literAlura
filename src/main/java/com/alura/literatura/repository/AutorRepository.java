package com.alura.literatura.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.alura.literatura.model.Autor;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    @Query("SELECT a FROM Autor a WHERE a.añoNacimiento <= :año AND (a.añoFallecimiento IS NULL OR a.añoFallecimiento >= :año)")
    List<Autor> findAutoresVivosEnAño(Integer año);

    Autor findByNombre(String nombre); 
}
