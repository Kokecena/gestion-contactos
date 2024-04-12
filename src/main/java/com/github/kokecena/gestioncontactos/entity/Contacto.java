package com.github.kokecena.gestioncontactos.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "contactos", schema = "system")
@Entity
@Getter
@Setter
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Informacion informacion;
    @Embedded
    private Direccion direccion;
    @Column
    private String correo;
    @Column(nullable = false)
    private String numTelefono;
}
