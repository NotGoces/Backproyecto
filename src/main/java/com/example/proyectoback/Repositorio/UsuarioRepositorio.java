package com.example.proyectoback.Repositorio;

import com.example.proyectoback.Modelo.Chip;
import com.example.proyectoback.Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

}
