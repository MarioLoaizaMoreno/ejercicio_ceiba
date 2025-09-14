//Declaracion del paquete contiene la ruta donde esta el proyecto
package com.example.ceiba.demo_ceiba_biblioteca.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Prestamo {

    @Id
    //Indica que el valor del ID será generado por la base de datos (auto-increment)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbn;
    private String identificacionUsuario;
    private int tipoUsuario;
    private LocalDate fechaMaximaDevolucion;

    // Getters y Setters, permiten acceder/editar campos privados.
    //Método que devuelve el valor de id.
    public Long getId() { return id; }
    //Setter que asigna un valor a id.
    public void setId(Long id) { this.id = id; }
    // Get-Set para isbn. Permiten leer y escribir el ISBN desde controladores/servicios/serializadores.
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    //Get-Set para identificacionUsuario.
    public String getIdentificacionUsuario() { return identificacionUsuario; }
    public void setIdentificacionUsuario(String identificacionUsuario) { this.identificacionUsuario = identificacionUsuario; }
    //Get-Set para tipoUsuario.
    public int getTipoUsuario() { return tipoUsuario; }
    public void setTipoUsuario(int tipoUsuario) { this.tipoUsuario = tipoUsuario; }
    //Get-Set para la fechaMaximaDevolucion. Importante para que el servicio calcule y el controlador devuelva esa fecha en la respuesta JSON.
    public LocalDate getFechaMaximaDevolucion() { return fechaMaximaDevolucion; }
    public void setFechaMaximaDevolucion(LocalDate fechaMaximaDevolucion) { this.fechaMaximaDevolucion = fechaMaximaDevolucion; }
}
