package com.github.kokecena.gestioncontactos.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class Informacion {
    private String nombre;
    private String apellido;
    private String alias;
    private String fechaCumpleanhos;
}
