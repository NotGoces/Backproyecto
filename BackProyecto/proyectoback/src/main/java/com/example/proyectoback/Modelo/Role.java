package com.example.proyectoback.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(name = "CodRol", nullable = false)
    private Integer id;

    @Column(name = "nombreRol", nullable = false)
    private String nombreRol;

}