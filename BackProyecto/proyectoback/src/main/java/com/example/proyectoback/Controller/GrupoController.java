package com.example.proyectoback.Controller;

import com.example.proyectoback.Modelo.Grupo;
import com.example.proyectoback.Modelo.Usuario;
import com.example.proyectoback.Servicios.GrupoService;
import com.example.proyectoback.Servicios.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/grupo")
public class GrupoController {

    private final GrupoService grupoService;
    private final UsuarioService usuarioService;

    @GetMapping("/all")
    public List<Grupo> getGrupo() {
        return (grupoService.grupos());
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearGrupo(@RequestBody Grupo grupo) {
        try {
            Grupo grupoNuevo = grupoService.nuevoGrupo(grupo);
            return ResponseEntity.status(HttpStatus.CREATED).body("Grupo creado correctamente");
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el grupo");
        }
    }

    @GetMapping("/mostrarbyuser")
    public ResponseEntity<List<Grupo>> getGrupoByUser(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(grupoService.encontrarGruposPorUsuario(id));
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarGrupo(@PathVariable("id") Integer id) {
        try {
            Grupo grupo = grupoService.encontrarGrupo(id).orElse(null);
            if (grupo != null) {
                grupoService.borrarGrupo(id);
                return ResponseEntity.ok("Grupo eliminado correctamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el grupo con el ID especificado");
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al borrar el grupo");
        }
    }

    @PutMapping("/cambiarEstado")
    public ResponseEntity<String> cambiarEstadoGrupo(@RequestParam Integer id) {
        try {
            Grupo grupo = grupoService.encontrarGrupo(id).orElse(null);
            if (grupo != null) {
                grupoService.cambiarEstadoGrupo(id);
                return ResponseEntity.ok("Estado de grupo cambiado correctamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el grupo con el ID especificado");
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al cambiar el estado del grupo");
        }
    }

}
