package com.brayanquintero.libros.mapper;

import com.brayanquintero.libros.dto.LibroRequestDTO;
import com.brayanquintero.libros.dto.LibroResponseDTO;
import com.brayanquintero.libros.entity.Libro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LibroMapStructMapper {

    //@Mapping(source = "email", target = "correo")
    Libro toEntity(LibroRequestDTO dto);

    LibroResponseDTO toDTO(Libro libro);

    List<LibroResponseDTO> toDTOList(List<Libro> libros);
}
