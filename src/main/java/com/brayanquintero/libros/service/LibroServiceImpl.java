package com.brayanquintero.libros.service;

import com.brayanquintero.libros.entity.Libro;
import com.brayanquintero.libros.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class LibroServiceImpl implements LibroService{

    private LibroRepository libroRepository;

    @Autowired
    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }
    @Override
    public List<Libro> getAll() {
        return libroRepository.findAll();
    }

    @Override
    public Libro getById(int id) {
        Optional<Libro> optional = libroRepository.findById(id);
        Libro libro = null;

        if (optional.isPresent()) {
            libro = optional.get();
        }

        return libro;
    }

    @Override
    public Libro save(Libro libro) {
        return null;
    }

    @Override
    public Libro deleteById(int id) {
        return null;
    }
}
