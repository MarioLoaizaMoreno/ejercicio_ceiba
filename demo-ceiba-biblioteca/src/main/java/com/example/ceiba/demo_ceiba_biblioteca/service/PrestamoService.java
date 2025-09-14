package com.example.ceiba.demo_ceiba_biblioteca.service;

import com.example.ceiba.demo_ceiba_biblioteca.model.*;
import com.example.ceiba.demo_ceiba_biblioteca.repository.*;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class PrestamoService {

    //Objeto para acceder a la BD.
    private final PrestamoRepository prestamoRepository;

    public PrestamoService(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    public Prestamo crearPrestamo(Prestamo prestamo) {
        // Validar si el usuario invitado ya tiene préstamo
        if (prestamo.getTipoUsuario() == 3) {
            Optional<Prestamo> existente = prestamoRepository
                    .findByIdentificacionUsuarioAndTipoUsuario(prestamo.getIdentificacionUsuario(), 3);
            if (existente.isPresent()) {
                throw new RuntimeException("El usuario con identificación " 
                        + prestamo.getIdentificacionUsuario() + " ya tiene un libro prestado");
            }
        }

        // Calcular fecha máxima de devolución
        int dias = 0;
        if (prestamo.getTipoUsuario() == 1) {
            dias = 10;
        } else if (prestamo.getTipoUsuario() == 2) {
            dias = 8;
        } else if (prestamo.getTipoUsuario() == 3) {
            dias = 7;
        }

        LocalDate fechaMaxima = calcularFechaHabil(LocalDate.now(), dias);
        prestamo.setFechaMaximaDevolucion(fechaMaxima);

        return prestamoRepository.save(prestamo);
    }

    private LocalDate calcularFechaHabil(LocalDate inicio, int diasHabiles) {
        LocalDate fecha = inicio;
        int cont = 0;
        while (cont < diasHabiles) {
            fecha = fecha.plusDays(1);
            if (!(fecha.getDayOfWeek() == DayOfWeek.SATURDAY || fecha.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                cont++;
            }
        }
        return fecha;
    }

    // método para buscar por ID
    public Prestamo getPrestamoById(Long id) {
        return prestamoRepository.findById(id).orElse(null);
    }
}
