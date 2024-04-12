package com.github.kokecena.gestioncontactos.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class InformacionDTO {
    private String nombre;
    private String apellido;
    private String alias;
    private LocalDate fechaCumpleanhos;
}
