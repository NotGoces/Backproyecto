package com.example.proyectoback.Repositorio.JDBC;

import com.example.proyectoback.Dto.LoginRequest;
import com.example.proyectoback.Dto.UsuarioOutputDto;
import com.example.proyectoback.Modelo.Grupo;
import com.example.proyectoback.Modelo.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JDBCUsuarioRepositorio {
    UsuarioOutputDto login(LoginRequest usuario);

}
