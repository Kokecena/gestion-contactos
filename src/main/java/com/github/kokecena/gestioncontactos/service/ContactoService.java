package com.github.kokecena.gestioncontactos.service;

import com.github.kokecena.gestioncontactos.entity.Contacto;

import java.util.List;

public interface ContactoService {
    List<Contacto> findAll();

    Contacto saveContacto(Contacto contacto);

    Contacto deleteContacto(Contacto contacto);
}
