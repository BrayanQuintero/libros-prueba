package com.brayanquintero.libros.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

@Schema(
        description = "LibroRequestDTO Model Infomration"
)
public class LibroRequestDTO {

    private Integer id;

    @Schema(description = "Book title")
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Schema(description = "Book price")
    @Positive(message = "El precio debe ser positivo")
    private BigDecimal precio;

    @Schema(description = "Book stock")
    @PositiveOrZero(message = "El stock debe ser positivo o cero")
    private Integer stock;

    public LibroRequestDTO() {
    }

    public LibroRequestDTO(Integer id, String nombre, BigDecimal precio, Integer stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
