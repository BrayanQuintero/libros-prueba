package com.brayanquintero.libros.exception;

public class LibroNoEncontradoException extends RuntimeException{

    public LibroNoEncontradoException(String mensaje) {
        super(mensaje);
    }

    public LibroNoEncontradoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

    public LibroNoEncontradoException(Throwable causa) {
        super(causa);
    }


}