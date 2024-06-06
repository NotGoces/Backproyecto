package com.example.proyectoback.Modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUsuario", nullable = false)
    private Integer IdUsuario;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "`contraseña`", nullable = false)
    private String contraseña;

    @Column(name = "`CodRol`", nullable = false)
    private Boolean codRol = false;
}