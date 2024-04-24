package com.example.proyectoback.Controller;

import com.example.proyectoback.Dto.ChipInputDto;
import com.example.proyectoback.Modelo.Chip;
import com.example.proyectoback.Servicios.ChipService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/chip")
public class ChipController {

    private final ChipService chipService;

    @PostMapping("/crear")
    public ResponseEntity<String> crearChip(@RequestBody Chip chip) {
        try {
            Chip chipNuevo = chipService.nuevoChip(chip);
            return ResponseEntity.status(HttpStatus.CREATED).body("Chip creado correctamente");
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear el chip");
        }
    }

    @GetMapping("/mostrarbygrupo")
    public ResponseEntity<List<Chip>> getChipoByUser(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(chipService.encontrarChipsPorUsuario(id));
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarChip(@PathVariable("id") Integer id) {
        try {
            Chip chip = chipService.encontrarChip(id).orElse(null);
            if (chip != null) {
                chipService.borrarChip(id);
                return ResponseEntity.ok("Chip eliminado correctamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el chip con el ID especificado");
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al borrar el chip");
        }
    }

    @PutMapping("/cambiarEstado/{id}")
    public ResponseEntity<String> cambiarEstadoChip(@PathVariable("id") Integer id) {
        try {
            Chip chip = chipService.encontrarChip(id).orElse(null);
            if (chip != null) {
                chipService.cambiarEstadoChip(id);
                return ResponseEntity.ok("Estado de chip cambiado correctamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el chip con el ID especificado");
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error al cambiar el estado del chip");
        }
    }

    @PutMapping("/modificar")
    public void modificarChip(@RequestBody ChipInputDto chip) {
        try{
             chipService.modificarChip(chip);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
