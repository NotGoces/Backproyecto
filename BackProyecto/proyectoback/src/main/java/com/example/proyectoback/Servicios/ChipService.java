package com.example.proyectoback.Servicios;


import com.example.proyectoback.Modelo.Chip;
import com.example.proyectoback.Repositorio.ChipRepositorio;
import com.example.proyectoback.Repositorio.JDBC.JDBCChipRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChipService {

  private final ChipRepositorio chipRepositorio;

    @Qualifier("JDBCChipRepositorio")
    private final JDBCChipRepositorio jdbcChipRepositorio;


    //Añadir un chip
    public Chip nuevoChip(Chip chip) {
        return this.chipRepositorio.save(chip);
    }

    //Borrar por id un chip
    public void borrarChip(Integer id) {
        chipRepositorio.deleteById(id);
    }

    //Apagar encender un chip por id
    public void cambiarEstadoChip(Integer id){
        Chip chip=chipRepositorio.findById(id).orElse(null);
        if (chip.getEstado()){
            chip.setEstado(false);
            chipRepositorio.save(chip);
        } else {
            chip.setEstado(true);
            chipRepositorio.save(chip);
        }
    }

    //Buscar por id un Chip
    public Optional<Chip> encontrarChip(Integer id) {
        return chipRepositorio.findById(id);
    }

    //Renombrar un chip

    //Renombrar un tapLink

    //Encontrar los chips de un grupo especifico

    //Encontrar chips de un usuario especifico
    public List<Chip> encontrarChipsPorUsuario(Integer id){
        return jdbcChipRepositorio.findChipByIdUsuario(id);
    }

    //Encontrar todos los chips
    public List<Chip> chips() {
        return new ArrayList<>(chipRepositorio.findAll());
    }

}
