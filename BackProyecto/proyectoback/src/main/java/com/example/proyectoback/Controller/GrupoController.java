package com.example.proyectoback.Controller;

import com.example.proyectoback.Modelo.Grupo;
import com.example.proyectoback.Modelo.Usuario;
import com.example.proyectoback.Servicios.GrupoService;
import com.example.proyectoback.Servicios.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/grupo")
public class GrupoController {

    private final GrupoService grupoService;

    @GetMapping("/all")
    public List<Grupo> getGrupo() {
        return (grupoService.grupos());
    }

}
