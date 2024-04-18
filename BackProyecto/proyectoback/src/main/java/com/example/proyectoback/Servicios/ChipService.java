package com.example.proyectoback.Servicios;


import com.example.proyectoback.Modelo.Chip;
import com.example.proyectoback.Repositorio.ChipRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChipService {

  private final ChipRepositorio chipRepositorio;



    public List<Chip> chips() {
        return new ArrayList<>(chipRepositorio.findAll());
    }
}
