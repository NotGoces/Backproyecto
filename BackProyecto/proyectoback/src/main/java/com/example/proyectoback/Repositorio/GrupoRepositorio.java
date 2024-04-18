package com.example.proyectoback.Repositorio;

import com.example.proyectoback.Modelo.Grupo;
import com.example.proyectoback.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepositorio extends JpaRepository<Grupo, Integer> {

}
