package com.github.kokecena.gestioncontactos.model.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.lang.annotation.*;

@NotBlank
@Pattern(regexp = "^[+]?[(]?\\d{3}[)]?[-\\s.]?\\d{3}[-\\s.]?\\d{4,6}$")
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {})
@ReportAsSingleViolation
public @interface PhoneNumber {
    String message() default "Debe ser un telefono valido.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
