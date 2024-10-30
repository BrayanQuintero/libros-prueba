package com.brayanquintero.libros.service;

import com.brayanquintero.libros.entity.Libro;
import com.brayanquintero.libros.exception.LibroNoEncontradoException;
import com.brayanquintero.libros.exception.LibroNoEncontradoResponse;
import com.brayanquintero.libros.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
        } else {
            throw new LibroNoEncontradoException("El libro con el id " + id + " no existe");
        }

        return libro;
    }

    @Override
    public Libro save(Libro libro) {

        if (libroRepository.existsByNombre(libro.getNombre())) {
            throw new LibroNoEncontradoException("El libro con el nombre " + libro.getNombre() + " ya existe");
        }

        libro.setId(null);
        return libroRepository.save(libro);
    }

    @Override
    public Libro update(Libro libro) {
        if (!libroRepository.existsById(libro.getId())) {
            throw new LibroNoEncontradoException("El libro con el id " + libro.getId() + " no existe");
        }
        if (libroRepository.existsByNombreAndIdNot(libro.getNombre(), libro.getId())) {
            throw new LibroNoEncontradoException("El libro con el nombre " + libro.getNombre() + " ya existe");
        }
        return libroRepository.save(libro);
    }

    @Override
    public void deleteById(int id) {
        if (!libroRepository.existsById(id)) {
            throw new LibroNoEncontradoException("No existe el libro con el id " + id);
        }
        libroRepository.deleteById(id);
    }



}
