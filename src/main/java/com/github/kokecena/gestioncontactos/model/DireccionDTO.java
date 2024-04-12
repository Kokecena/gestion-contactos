package com.github.kokecena.gestioncontactos.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

@Getter
@Setter
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
    @Max(value = 5)
    @Pattern(regexp = "^((s/n)|(S/N)|(sn)|(SN)|(\\d+([A-Za-z])?)|(\\d+([A-Za-z])?-\\d+)|(\\d+))$",
            message = "Número no válido")
    private String numero;
    @Max(value = 5)
    @Pattern(regexp = "^((s/n)|(S/N)|(sn)|(SN)|(\\d+([A-Za-z])?)|(\\d+([A-Za-z])?-\\d+)|(\\d+))$",
            message = "Número externo no válido")
    private String numeroExterno;
}
