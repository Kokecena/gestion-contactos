package com.github.kokecena.gestioncontactos.controller;

import com.github.kokecena.gestioncontactos.commons.response.Response;
import com.github.kokecena.gestioncontactos.entity.Contacto;
import com.github.kokecena.gestioncontactos.service.ContactoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/contactos")
@RequiredArgsConstructor
public class ContactoController {

    private final ContactoService contactoService;

    @GetMapping("/todos")
    public ResponseEntity<Response<List<Contacto>>> findAll() {
        return Response.success(contactoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Response<Contacto>> saveContacto(Contacto contacto) {
        return Response.success(contactoService.saveContacto(contacto));
    }

    @DeleteMapping
    public ResponseEntity<Response<Contacto>> deleteContacto(Contacto contacto) {
        return Response.success(contactoService.deleteContacto(contacto));
    }

}