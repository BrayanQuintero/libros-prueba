package com.brayanquintero.libros.rest;

import com.brayanquintero.libros.LibrosApplication;
import com.brayanquintero.libros.dto.LibroRequestDTO;
import com.brayanquintero.libros.dto.LibroResponseDTO;
import com.brayanquintero.libros.entity.Libro;
import com.brayanquintero.libros.exception.LibroNoEncontradoException;
import com.brayanquintero.libros.exception.LibroNoEncontradoResponse;
import com.brayanquintero.libros.service.LibroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST API for books management",
        description = "Create book, Update book, Get book, Get all books, Delete book"
)
@RestController
@RequestMapping("/api")
public class LibroController {

    private LibroService libroService;

    @Autowired
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @Operation(
            summary = "Get all books REST API",
            description = "Get all books REST API is used to get all the books from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/libros")
    public ResponseEntity<List<LibroResponseDTO>> getAll() {
        return new ResponseEntity<>(libroService.getAll(), HttpStatus.OK);
    }

    @Operation(
            summary = "Get book by id REST API",
            description = "Get book by id REST API is used to get a single book from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("/libros/{id}")
    public ResponseEntity<LibroResponseDTO> getById(@PathVariable int id) {
        return new ResponseEntity<>(libroService.getById(id), HttpStatus.OK);
    }

    @Operation(
            summary = "Create book REST API",
            description = "Create book REST API is used to save a book in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping("/libros")
    public ResponseEntity<Void> agregarLibro(@Valid @RequestBody LibroRequestDTO libro) {
        libroService.save(libro);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Operation(
            summary = "Update book REST API",
            description = "Update book REST API is used to update a particular book in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @PutMapping("/libros")
    public ResponseEntity<Void> actualizarLibro(@Valid @RequestBody LibroRequestDTO libro) {
        libroService.update(libro);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(
            summary = "Delete book REST API",
            description = "Delete book REST API is used to delete a particular book from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @DeleteMapping("/libros/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        libroService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
