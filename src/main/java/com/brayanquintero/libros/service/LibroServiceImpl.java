package com.brayanquintero.libros.service;

import com.brayanquintero.libros.dto.LibroRequestDTO;
import com.brayanquintero.libros.dto.LibroResponseDTO;
import com.brayanquintero.libros.entity.Libro;
import com.brayanquintero.libros.exception.LibroNoEncontradoException;
import com.brayanquintero.libros.exception.LibroNoEncontradoResponse;
import com.brayanquintero.libros.mapper.LibroMapStructMapper;
import com.brayanquintero.libros.mapper.LibroMapper;
import com.brayanquintero.libros.repository.LibroRepository;
import org.modelmapper.ModelMapper;
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

    private final LibroRepository libroRepository;
    private final ModelMapper modelMapper;
    private final LibroMapStructMapper mapStructMapper;

    @Autowired
    public LibroServiceImpl(LibroRepository libroRepository, ModelMapper modelMapper,LibroMapStructMapper mapStructMapper) {
        this.libroRepository = libroRepository;
        this.modelMapper = modelMapper;
        this.mapStructMapper = mapStructMapper;
    }

    @Override
    public List<LibroResponseDTO> getAll() {
        return mapStructMapper.toDTOList(libroRepository.findAll());
    }

    @Override
    public LibroResponseDTO getById(int id) {
        Optional<Libro> optional = libroRepository.findById(id);
        Libro libro = null;

        if (optional.isPresent()) {
            libro = optional.get();
        } else {
            throw new LibroNoEncontradoException("El libro con el id " + id + " no existe");
        }

        return mapStructMapper.toDTO(libro);
    }

    @Override
    public LibroResponseDTO save(LibroRequestDTO libro) {

        if (libroRepository.existsByNombre(libro.getNombre())) {
            throw new LibroNoEncontradoException("El libro con el nombre " + libro.getNombre() + " ya existe");
        }

        libro.setId(null);
        Libro libroEntidad = mapStructMapper.toEntity(libro);
        return mapStructMapper.toDTO(libroRepository.save(libroEntidad));
    }

    @Override
    public LibroResponseDTO update(LibroRequestDTO libro) {
        if (!libroRepository.existsById(libro.getId())) {
            throw new LibroNoEncontradoException("El libro con el id " + libro.getId() + " no existe");
        }
        if (libroRepository.existsByNombreAndIdNot(libro.getNombre(), libro.getId())) {
            throw new LibroNoEncontradoException("El libro con el nombre " + libro.getNombre() + " ya existe");
        }

        Libro libroEntidad = mapStructMapper.toEntity(libro);
        return mapStructMapper.toDTO(libroRepository.save(libroEntidad));
    }

    @Override
    public void deleteById(int id) {
        if (!libroRepository.existsById(id)) {
            throw new LibroNoEncontradoException("No existe el libro con el id " + id);
        }
        libroRepository.deleteById(id);
    }
}
