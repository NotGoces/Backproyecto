package com.example.proyectoback.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "grupo")
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CodGrupo", nullable = false)
    private Integer CodGrupo;

    @Column(name = "Estado", nullable = false)
    private Boolean estado = false;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "IdUsuario", nullable = false)
    private Integer idUsuario;
}