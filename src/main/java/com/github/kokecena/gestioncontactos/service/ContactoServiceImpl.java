package com.github.kokecena.gestioncontactos.service;

import com.github.kokecena.gestioncontactos.mapper.ContactoMapper;
import com.github.kokecena.gestioncontactos.model.ContactoDTO;
import com.github.kokecena.gestioncontactos.model.ContactoResponse;
import com.github.kokecena.gestioncontactos.repository.ContactoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactoServiceImpl implements ContactoService {

    private final ContactoRepository repository;
    private final ContactoMapper mapper;

    @Override
    public List<ContactoDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ContactoResponse saveContacto(ContactoDTO contacto) {
        repository.save(mapper.toEntity(contacto));
        return mapper.toResponse(contacto);
    }

    @Override
    public ContactoResponse deleteContacto(ContactoDTO contacto) {
        throw new IllegalStateException("No implementado XD");
    }
}
