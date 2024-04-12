package com.github.kokecena.gestioncontactos.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Direccion {
    @Column(length = 50)
    private String colonia;
    @Column(length = 25)
    private String codigoPostal;
    @Column(length = 100)
    private String primeraCalle;
    @Column(length = 100)
    private String segundaCalle;
    @Column(length = 5)
    private String numInterno;
    @Column(length = 5)
    private String numExterno;
}
