package com.github.kokecena.gestioncontactos.service;

import com.github.kokecena.gestioncontactos.model.ContactoDTO;
import com.github.kokecena.gestioncontactos.model.ContactoResponse;

import java.util.List;

public interface ContactoService {
    List<ContactoDTO> findAll();

    ContactoResponse saveContacto(ContactoDTO contacto);

    ContactoResponse deleteContacto(ContactoDTO contacto);
}
