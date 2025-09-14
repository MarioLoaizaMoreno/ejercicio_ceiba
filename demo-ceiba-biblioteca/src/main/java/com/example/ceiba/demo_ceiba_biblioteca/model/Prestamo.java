package com.example.ceiba.demo_ceiba_biblioteca.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbn;
    private String identificacionUsuario;
    private int tipoUsuario;
    private LocalDate fechaMaximaDevolucion;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getIdentificacionUsuario() { return identificacionUsuario; }
    public void setIdentificacionUsuario(String identificacionUsuario) { this.identificacionUsuario = identificacionUsuario; }

    public int getTipoUsuario() { return tipoUsuario; }
    public void setTipoUsuario(int tipoUsuario) { this.tipoUsuario = tipoUsuario; }

    public LocalDate getFechaMaximaDevolucion() { return fechaMaximaDevolucion; }
    public void setFechaMaximaDevolucion(LocalDate fechaMaximaDevolucion) { this.fechaMaximaDevolucion = fechaMaximaDevolucion; }
}
