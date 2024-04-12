package com.github.kokecena.gestioncontactos.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Direccion {
    private String colonia;
    private String codigoPostal;
    private String primeraCalle;
    private String segundaCalle;
    private String numInterno;
    private String numExterno;
}
