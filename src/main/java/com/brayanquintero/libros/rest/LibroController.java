package com.brayanquintero.libros.rest;

import com.brayanquintero.libros.LibrosApplication;
import com.brayanquintero.libros.entity.Libro;
import com.brayanquintero.libros.exception.LibroNoEncontradoException;
import com.brayanquintero.libros.exception.LibroNoEncontradoResponse;
import com.brayanquintero.libros.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibroController {

    private LibroService libroService;

    @Autowired
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping("/libros")
    public ResponseEntity<List<Libro>> getAll() {
        return new ResponseEntity<>(libroService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/libros/{id}")
    public ResponseEntity<Libro> getById(@PathVariable int id) {
        return new ResponseEntity<>(libroService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/libros")
    public ResponseEntity<Void> agregarLibro(@RequestBody Libro libro) {
        libroService.save(libro);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/libros")
    public ResponseEntity<Void> actualizarLibro(@RequestBody Libro libro) {
        libroService.update(libro);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/libros/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        libroService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
