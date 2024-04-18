package com.example.proyectoback.Controller;

import com.example.proyectoback.Modelo.Chip;
import com.example.proyectoback.Modelo.Usuario;
import com.example.proyectoback.Servicios.ChipService;
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
@RequestMapping("/login")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/all")
    public List<Usuario> getUsuario() {
        return (usuarioService.usuarios());
    }

}
