package com.github.kokecena.gestioncontactos.service;

import com.github.kokecena.gestioncontactos.entity.Contacto;
import com.github.kokecena.gestioncontactos.exceptions.ContactoNotFoundException;
import com.github.kokecena.gestioncontactos.mapper.ContactoMapper;
import com.github.kokecena.gestioncontactos.model.ContactoDTO;
import com.github.kokecena.gestioncontactos.model.ContactoResponse;
import com.github.kokecena.gestioncontactos.repository.ContactoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ContactoServiceImpl implements ContactoService {

    private final ContactoRepository repository;
    private final ContactoMapper mapper;

    @Override
    public List<ContactoDTO> findAll() {
        log.info("Returning all contacts");
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ContactoDTO findBy(String telefono) {
        log.info("Finding contact by: {}", telefono);
        return repository.findByNumTelefono(telefono)
                .map(mapper::toDto)
                .orElseThrow(ContactoNotFoundException::new);
    }

    @Override
    @Transactional
    public ContactoResponse saveContacto(ContactoDTO contacto) {
        log.info("Saving contacto: {}", contacto);
        repository.save(mapper.toEntity(contacto));
        return mapper.toResponse(contacto);
    }

    @Override
    @Transactional
    public ContactoResponse updateContacto(String telefono, ContactoDTO toUpdate) {
        log.info("Updating contacto: {}", toUpdate);
        return repository.findByNumTelefono(telefono)
                .map(contacto -> doContactoUpdate(contacto, toUpdate))
                .orElseThrow(ContactoNotFoundException::new);
    }

    private ContactoResponse doContactoUpdate(Contacto fromDb, ContactoDTO toUpdateDto) {
        Contacto toUpdate = mapper.toEntity(toUpdateDto);
        fromDb.setInformacion(toUpdate.getInformacion());
        fromDb.setDireccion(toUpdate.getDireccion());
        fromDb.setNumTelefono(toUpdate.getNumTelefono());
        fromDb.setCorreo(toUpdate.getCorreo());
        repository.save(fromDb);
        return mapper.toResponse(toUpdateDto);
    }

    @Override
    @Transactional
    public ContactoResponse deleteContacto(String telefono) {
        log.info("Removing contact: {}", telefono);
        return repository.findByNumTelefono(telefono).map(contacto -> {
                    log.info("Contact founded: {}", contacto);
                    repository.deleteByNumTelefono(telefono);
                    return mapper.toDto(contacto);
                }).map(mapper::toResponse)
                .orElseThrow(ContactoNotFoundException::new);
    }

}