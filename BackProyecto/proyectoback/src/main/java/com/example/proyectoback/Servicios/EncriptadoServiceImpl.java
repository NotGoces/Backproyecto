package com.example.proyectoback.Servicios;

import com.example.proyectoback.Modelo.Usuario;
import com.example.proyectoback.Repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class EncriptadoServiceImpl implements EncriptadoService {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public String encriptar(String contraseña) {
        return BCrypt.hashpw(contraseña, BCrypt.gensalt());
    }

    @Override
    public boolean verificar(String originalContraseña, String hashContraseña) {
        return BCrypt.checkpw(originalContraseña, hashContraseña);
    }

    public Usuario saveUsuario(Usuario nuevoUsuario) {
        return this.usuarioRepositorio.save(nuevoUsuario);
    }
}
