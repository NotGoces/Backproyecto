package com.example.proyectoback.Servicios;

import com.example.proyectoback.Dto.LoginRequest;
import com.example.proyectoback.Dto.UsuarioOutputDto;
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

    private final EncriptadoService encriptadoService;


    public List<Usuario> usuarios() {
        return new ArrayList<>(usuarioRepositorio.findAll());
    }

    public Usuario nuevoUsuario(Usuario usuario) {
        String hashcontraseña=encriptadoService.encriptar(usuario.getContraseña());
        usuario.setContraseña(hashcontraseña);
        return this.usuarioRepositorio.save(usuario);
    }

    public void borrarUsuario(Integer id) {
        usuarioRepositorio.deleteById(id);
    }

    public Optional<Usuario> encontrarUsuario(Integer id) {
        return usuarioRepositorio.findById(id);
    }

    public UsuarioOutputDto login(LoginRequest usuario) {
        return JDBCUsuarioRepositorio.login(usuario);
    }
}
