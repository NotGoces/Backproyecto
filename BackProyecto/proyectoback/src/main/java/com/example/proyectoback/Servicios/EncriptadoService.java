package com.example.proyectoback.Servicios;

import com.example.proyectoback.Modelo.Usuario;

public interface EncriptadoService {


    String encriptar(String contraseña);

    boolean verificar(String originalContraseña, String hashContraseña);
    Usuario saveUsuario(Usuario nuevoUsuario);
}
