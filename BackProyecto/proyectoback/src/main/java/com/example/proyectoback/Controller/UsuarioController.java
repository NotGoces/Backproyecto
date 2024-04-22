package com.example.proyectoback.Controller;


import com.example.proyectoback.Dto.LoginRequest;
import com.example.proyectoback.Dto.UsuarioOutputDto;
import com.example.proyectoback.Modelo.Usuario;
import com.example.proyectoback.Servicios.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping("/all")
    public List<Usuario> getUsuario() {
        return (usuarioService.usuarios());
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario usuarioNuevo = usuarioService.nuevoUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado correctamente");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el usuario");
        }
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarUsuario(@PathVariable("id") Integer id) {
        try {
            Usuario usuario = usuarioService.encontrarUsuario(id).orElse(null);
            if (usuario != null) {
                usuarioService.borrarUsuario(id);
                return ResponseEntity.ok("Usario eliminado correctamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el Usuario con el ID especificado");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al borrar el usuario");
        }
    }

    @PostMapping(path = "/login")
    public ResponseEntity<UsuarioOutputDto> login(@RequestBody LoginRequest loginRequest) {
        try {
            String correo = loginRequest.getCorreo();
            String contraseña = loginRequest.getContraseña();

            if (usuarioService.login(loginRequest) == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

            } else {
                return ResponseEntity.ok(usuarioService.login(loginRequest));


            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


}
