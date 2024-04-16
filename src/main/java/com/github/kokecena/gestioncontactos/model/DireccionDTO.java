package com.github.kokecena.gestioncontactos.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.kokecena.gestioncontactos.model.annotations.AddressNumber;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DireccionDTO {
    @Max(value = 50, message = "Colonia solo puede tener hasta 50 caracteres")
    private String colonia;
    @Max(value = 25, message = "Codigo postal solo puede tener hasta 25 caracteres")
    private String codigoPostal;
    @Max(value = 100, message = "Primera calle solo puede tener hasta 100 caracteres")
    private String primeraCalle;
    @Max(value = 100, message = "Segunda calle solo puede tener hasta 100 caracteres")
    private String segundaCalle;
    @AddressNumber(message = "Número no válido")
    private String numero;
    @AddressNumber(message = "Número externo no válido")
    private String numeroExterno;
}
