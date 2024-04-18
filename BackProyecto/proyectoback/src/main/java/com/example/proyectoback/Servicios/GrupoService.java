package com.example.proyectoback.Servicios;


import com.example.proyectoback.Modelo.Chip;
import com.example.proyectoback.Modelo.Grupo;
import com.example.proyectoback.Repositorio.ChipRepositorio;
import com.example.proyectoback.Repositorio.GrupoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GrupoService {

    private final GrupoRepositorio grupoRepositorio;



    public List<Grupo> grupos() {
        return new ArrayList<>(grupoRepositorio.findAll());
    }
}
