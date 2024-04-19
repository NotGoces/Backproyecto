package com.example.proyectoback.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "chip")
public class Chip  implements Serializable {
    @Id
    private Integer idChip;

    private String zipLink;

    private String tapLink;

    private Boolean estado = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codGrupo")
    private Grupo codGrupo;

    private String nombre;

}