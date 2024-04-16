package com.github.kokecena.gestioncontactos.repository;

import com.github.kokecena.gestioncontactos.entity.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {
    void deleteByNumTelefono(String numTelefono);
    Optional<Contacto> findByNumTelefono(String numTelefono);
}
