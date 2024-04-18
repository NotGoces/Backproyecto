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
    @Column(name = "CodGrupo", nullable = false)
    private Integer id;

    @Column(name = "Estado", nullable = false)
    private Boolean estado = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;

}