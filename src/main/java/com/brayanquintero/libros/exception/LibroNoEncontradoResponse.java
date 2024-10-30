package com.brayanquintero.libros.exception;

public class LibroNoEncontradoResponse {

    private int estatus;
    private String mensaje;
    private Long timeStamp;

    public LibroNoEncontradoResponse() {
    }

    public LibroNoEncontradoResponse(int estatus, String mensaje, Long timeStamp) {
        this.estatus = estatus;
        this.mensaje = mensaje;
        this.timeStamp = timeStamp;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "LibroNoEncontradoResponse{" +
                "estatus=" + estatus +
                ", mensaje='" + mensaje + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
