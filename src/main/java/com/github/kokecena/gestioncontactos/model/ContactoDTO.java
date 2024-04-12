package com.github.kokecena.gestioncontactos.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ContactoDTO {
    private InformacionDTO informacion;
    private DireccionDTO direccion;
    private String correo;
    private String telefono;
}
