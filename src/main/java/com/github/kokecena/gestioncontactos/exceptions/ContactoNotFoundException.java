package com.github.kokecena.gestioncontactos.exceptions;

public class ContactoNotFoundException extends RuntimeException {
    public ContactoNotFoundException(){
        super("Contacto no encontrado.");
    }
}
