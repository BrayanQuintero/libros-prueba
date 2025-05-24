package com.brayanquintero.libros.mapper;

import com.brayanquintero.libros.dto.LibroRequestDTO;
import com.brayanquintero.libros.dto.LibroResponseDTO;
import com.brayanquintero.libros.entity.Libro;

public class LibroMapper {

    public static LibroResponseDTO toResponseDTO(Libro libro) {
        return new LibroResponseDTO(
                libro.getId(),
                libro.getNombre(),
                libro.getPrecio(),
                libro.getStock()
        );
    }

    public static Libro toEntity(LibroRequestDTO dto) {
        return new Libro(
                dto.getId(),
                dto.getNombre(),
                dto.getPrecio(),
                dto.getStock()
        );
    }

}
