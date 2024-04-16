package com.github.kokecena.gestioncontactos.service;

import com.github.kokecena.gestioncontactos.model.ContactoDTO;
import com.github.kokecena.gestioncontactos.model.ContactoResponse;

import java.util.List;

public interface ContactoService {
    List<ContactoDTO> findAll();
    ContactoDTO findBy(String telefono);
    ContactoResponse saveContacto(ContactoDTO contacto);
    ContactoResponse updateContacto(String telefono, ContactoDTO toUpdate);
    ContactoResponse deleteContacto(String telefono);
}
