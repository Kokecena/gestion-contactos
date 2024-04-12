package com.github.kokecena.gestioncontactos.repository;

import com.github.kokecena.gestioncontactos.entity.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {
}
