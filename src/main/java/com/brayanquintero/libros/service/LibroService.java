package com.brayanquintero.libros.service;

import com.brayanquintero.libros.dto.LibroRequestDTO;
import com.brayanquintero.libros.dto.LibroResponseDTO;
import com.brayanquintero.libros.entity.Libro;

import java.util.List;

public interface LibroService {

    List<LibroResponseDTO> getAll();

    LibroResponseDTO getById(int id);

    LibroResponseDTO save(LibroRequestDTO libro);

    LibroResponseDTO update(LibroRequestDTO libro);

    void deleteById(int id);
}
