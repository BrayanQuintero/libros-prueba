package com.brayanquintero.libros.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<LibroNoEncontradoResponse> libroNoEncontrado(LibroNoEncontradoException e) {
        LibroNoEncontradoResponse error = new LibroNoEncontradoResponse();

        error.setEstatus(HttpStatus.NOT_FOUND.value());
        error.setMensaje(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<LibroNoEncontradoResponse> otroError(Exception e) {
        LibroNoEncontradoResponse error = new LibroNoEncontradoResponse();

        error.setEstatus(HttpStatus.BAD_REQUEST.value());
        error.setMensaje(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<Map<String, String>> erroresValid(MethodArgumentNotValidException e) {
        Map<String, String> errores = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError)error).getField();
            String errorMessage = error.getDefaultMessage();
            errores.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }
}
