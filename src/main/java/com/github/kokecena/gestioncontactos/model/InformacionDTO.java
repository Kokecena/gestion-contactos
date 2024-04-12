package com.github.kokecena.gestioncontactos.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InformacionDTO {
    @NotNull(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 30, message = "El nombre debe tener de 3 a 30 caracteres")
    @Pattern(regexp = "\\D*",message = "El nombre solo debe teber letras")
    private String nombre;
    @Size(min = 3, max = 30, message = "El apellido debe tener de 3 a 30 caracteres")
    @Pattern(regexp = "\\D*",message = "El apellido solo debe teber letras")
    private String apellido;
    @Size(min = 3, max = 30, message = "El alias debe tener de 3 a 30 caracteres")
    private String alias;
    private LocalDate fechaCumpleanhos;
}
