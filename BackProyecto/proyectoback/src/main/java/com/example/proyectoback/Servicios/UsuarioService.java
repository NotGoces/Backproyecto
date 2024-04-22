package com.example.proyectoback.Servicios;

import com.example.proyectoback.Dto.LoginRequest;
import com.example.proyectoback.Dto.UsuarioOutputDto;
import com.example.proyectoback.Modelo.Grupo;
import com.example.proyectoback.Modelo.Usuario;
import com.example.proyectoback.Repositorio.JDBC.JDBCUsuarioRepositorio;
import com.example.proyectoback.Repositorio.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepositorio usuarioRepositorio;

    private final JDBCUsuarioRepositorio JDBCUsuarioRepositorio;


    public List<Usuario> usuarios() {
        return new ArrayList<>(usuarioRepositorio.findAll());
    }

    //Crear un usuario
    public Usuario nuevoUsuario(Usuario usuario) {
        return this.usuarioRepositorio.save(usuario);
    }

    //Borrar un ususario
    public void borrarUsuario(Integer id) {
        usuarioRepositorio.deleteById(id);
    }

    //Buscar por id un usuario NO COMPROBADO FUNCIONAMIENTO
    public Optional<Usuario> encontrarUsuario(Integer id) {
        return usuarioRepositorio.findById(id);
    }

    //Hacer login
    public UsuarioOutputDto login(LoginRequest usuario) {
        return JDBCUsuarioRepositorio.login(usuario);
    }
}
