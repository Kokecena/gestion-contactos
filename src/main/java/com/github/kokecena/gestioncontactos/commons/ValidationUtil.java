package com.github.kokecena.gestioncontactos.commons;

import org.springframework.core.NestedExceptionUtils;

public final class ValidationUtil {

    private ValidationUtil() {
    }

    public static Throwable getRootCause(Throwable t) {
        Throwable rootCause = NestedExceptionUtils.getRootCause(t);
        return rootCause != null ? rootCause : t;
    }

}