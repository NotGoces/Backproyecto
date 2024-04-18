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
    private Integer id;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "`contraseña`", nullable = false)
    private String contraseña;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CodRol")
    private Role codRol;

}