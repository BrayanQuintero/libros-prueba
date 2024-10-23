package com.brayanquintero.libros.repository;

import com.brayanquintero.libros.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Integer> {
}
