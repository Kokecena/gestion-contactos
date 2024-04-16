package com.github.kokecena.gestioncontactos.model.annotations;

import javax.validation.Constraint;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;
import java.lang.annotation.*;

@Max(value = 5)
@Pattern(regexp = "^((s/n)|(S/N)|(sn)|(SN)|(\\d+([A-Za-z])?)|(\\d+([A-Za-z])?-\\d+)|(\\d+))$",
        message = "Formato no valido")
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {})
@ReportAsSingleViolation
public @interface AddressNumber {
    String message() default "";
}
