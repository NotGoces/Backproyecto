package com.example.proyectoback.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "chip")
public class Chip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdChip", nullable = false)
    private Integer idChip;

    @Column(name = "Estado", nullable = false)
    private Boolean estado = false;

    @Column(name = "ZipLink", nullable = false)
    private String zipLink;

    @Column(name = "TapLink", nullable = false)
    private String tapLink;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    private Integer codGrupo;
}