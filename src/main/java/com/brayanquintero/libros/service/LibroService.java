package com.brayanquintero.libros.service;

import com.brayanquintero.libros.entity.Libro;

import java.util.List;

public interface LibroService {

    List<Libro> getAll();

    Libro getById(int id);

    Libro save(Libro libro);

    void deleteById(int id);
}
