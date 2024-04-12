package com.github.kokecena.gestioncontactos.service;

import com.github.kokecena.gestioncontactos.entity.Contacto;
import com.github.kokecena.gestioncontactos.repository.ContactoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactoServiceImpl implements ContactoService {

    private final ContactoRepository repository;

    @Override
    public List<Contacto> findAll() {
        return repository.findAll();
    }

    @Override
    public Contacto saveContacto(Contacto contacto) {
        return repository.save(contacto);
    }

    @Override
    public Contacto deleteContacto(Contacto contacto) {
        repository.delete(contacto);
        return contacto;
    }
}
