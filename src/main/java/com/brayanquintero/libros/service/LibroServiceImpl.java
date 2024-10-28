package com.brayanquintero.libros.service;

import com.brayanquintero.libros.entity.Libro;
import com.brayanquintero.libros.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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

        if (libroRepository.existsByNombre(libro.getNombre())) {
            throw new IllegalArgumentException("El libro ya existe");
        }

        libro.setId(null);
        return libroRepository.save(libro);
    }

    @Override
    public Libro update(Libro libro) {
        if (!libroRepository.existsById(libro.getId())) {
            System.out.println("Error al actualizar");
        }
        if (libroRepository.existsByNombreAndIdNot(libro.getNombre(), libro.getId())) {
            throw new IllegalArgumentException("El libro ya existe");
        }
        return libroRepository.save(libro);
    }

    @Override
    public void deleteById(int id) {
        libroRepository.deleteById(id);
    }
}
