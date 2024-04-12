package com.github.kokecena.gestioncontactos.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactoDTO {
    private InformacionDTO informacion;
    private DireccionDTO direccion;
    @NotNull(message = "El correo no puede estar vacío")
    @Email(message = "El formato del email no es valido", regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    private String correo;
    @NotNull(message = "El telefono no puede estar vació")
    @Pattern(regexp = "^[+]?[(]?\\d{3}[)]?[-\\s.]?\\d{3}[-\\s.]?\\d{4,6}$", message = "Debe ser un numero de telefono valido.")
    private String telefono;
}
