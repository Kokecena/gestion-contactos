package com.github.kokecena.gestioncontactos.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

@Getter
@Setter
@Embeddable
public class Informacion {
    @Column(length = 30, nullable = false)
    private String nombre;
    @Column(length = 30)
    private String apellido;
    @Column(length = 30)
    private String alias;
    private LocalDate fechaCumpleanhos;
}
