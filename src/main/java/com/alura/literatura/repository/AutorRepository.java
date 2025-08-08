package com.alura.literatura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.literatura.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByNacimientoLessThanEqualAndFallecimientoGreaterThanEqual(int nacimiento, int fallecimiento);
}
