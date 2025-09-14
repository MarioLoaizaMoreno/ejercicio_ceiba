package com.example.ceiba.demo_ceiba_biblioteca.repository;

import com.example.ceiba.demo_ceiba_biblioteca.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    Optional<Prestamo> findByIdentificacionUsuarioAndTipoUsuario(String identificacionUsuario, int tipoUsuario);
}
