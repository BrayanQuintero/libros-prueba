package com.brayanquintero.libros.rest;

import com.brayanquintero.libros.LibrosApplication;
import com.brayanquintero.libros.entity.Libro;
import com.brayanquintero.libros.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Libro> getAll() {
        return libroService.getAll();
    }

    @GetMapping("/libros/{id}")
    public Libro getById(@PathVariable int id) {
        return libroService.getById(id);
    }

    @PostMapping("/libros")
    public void agregarLibro(@RequestBody Libro libro) {
        libroService.save(libro);
    }

    @PutMapping("/libros")
    public void actualizarLibro(Libro libro) {
        libroService.save(libro);
    }

    @DeleteMapping("/libros")
    public void deleteById(int id) {
        libroService.deleteById(id);
    }


}
