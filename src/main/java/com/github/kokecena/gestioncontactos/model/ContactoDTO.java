package com.github.kokecena.gestioncontactos.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.kokecena.gestioncontactos.model.annotations.PhoneNumber;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.Email;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactoDTO {
    private @Valid InformacionDTO informacion;
    private @Valid DireccionDTO direccion;
    @Email(message = "El formato del email no es valido", regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    private String correo;
    @PhoneNumber
    private String telefono;
}
