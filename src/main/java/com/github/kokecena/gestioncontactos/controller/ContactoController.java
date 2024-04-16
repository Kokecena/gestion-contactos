package com.github.kokecena.gestioncontactos.controller;

import com.github.kokecena.gestioncontactos.commons.response.Response;
import com.github.kokecena.gestioncontactos.model.ContactoDTO;
import com.github.kokecena.gestioncontactos.model.ContactoResponse;
import com.github.kokecena.gestioncontactos.model.annotations.PhoneNumber;
import com.github.kokecena.gestioncontactos.service.ContactoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/contactos")
@RequiredArgsConstructor
@Validated
public class ContactoController {

    private final ContactoService contactoService;

    @GetMapping("/todos")
    public ResponseEntity<Response<List<ContactoDTO>>> findAll() {
        return Response.success(contactoService.findAll());
    }

    @GetMapping
    public ResponseEntity<Response<ContactoDTO>> findByPhoneNumber(@RequestParam @PhoneNumber String telefono) {
        return Response.success(contactoService.findBy(telefono));
    }

    @PostMapping
    public ResponseEntity<Response<ContactoResponse>> saveContacto(@Valid @RequestBody ContactoDTO contacto) {
        return Response.success(contactoService.saveContacto(contacto));
    }

    @PutMapping("/{telefono}")
    public ResponseEntity<Response<ContactoResponse>> updateContacto(@PathVariable @PhoneNumber String telefono,
                                                                     @Valid @RequestBody ContactoDTO contacto) {
        return Response.success(contactoService.updateContacto(telefono, contacto));
    }

    @DeleteMapping
    public ResponseEntity<Response<ContactoResponse>> deleteContacto(@RequestParam @PhoneNumber String telefono) {
        return Response.success(contactoService.deleteContacto(telefono));
    }

}