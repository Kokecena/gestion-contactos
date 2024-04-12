package com.github.kokecena.gestioncontactos.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DireccionDTO {
    private String colonia;
    private String codigoPostal;
    private String primeraCalle;
    private String segundaCalle;
    private String numInterno;
    private String numExterno;
}
