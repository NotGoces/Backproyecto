package com.example.proyectoback.Servicios;


import com.example.proyectoback.Modelo.Chip;
import com.example.proyectoback.Modelo.Usuario;
import com.example.proyectoback.Repositorio.ChipRepositorio;
import com.example.proyectoback.Repositorio.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

  private final UsuarioRepositorio UsuarioRepositorio;
    private final UsuarioRepositorio usuarioRepositorio;


    public List<Usuario> usuarios() {
        return new ArrayList<>(usuarioRepositorio.findAll());
    }
}
