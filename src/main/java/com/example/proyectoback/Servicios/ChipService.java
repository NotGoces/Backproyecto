package com.example.proyectoback.Servicios;


import com.example.proyectoback.Dto.ChipInputDto;
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


    //Crear un chip
    public Chip nuevoChip(Chip chip) {
        return this.chipRepositorio.save(chip);
    }

    //Borrar por id un chip
    public void borrarChip(Integer id) {
        chipRepositorio.deleteById(id);
    }

    //Apagar encender un chip por id
    public void cambiarEstadoChip(Integer id) {
        Chip chip = chipRepositorio.findById(id).orElse(null);
        if (chip.getEstado()) {
            chip.setEstado(false);
            chipRepositorio.save(chip);
        } else {
            chip.setEstado(true);
            chipRepositorio.save(chip);
        }
    }

    //Renombrar un tapLink
    public void modificarChip(ChipInputDto chipInputDto) {
        Chip chip = chipRepositorio.findById(chipInputDto.getId()).orElse(null);

        if (chip != null) {

            if (chipInputDto.getNombre() == null) {
                chip.setTapLink(chipInputDto.getTapLink());
                chipRepositorio.save(chip);
            } else if (chipInputDto.getTapLink() == null) {
                chip.setNombre(chipInputDto.getNombre());
                chipRepositorio.save(chip);
            } else {
                chip.setNombre(chipInputDto.getNombre());
                chip.setTapLink(chipInputDto.getTapLink());
                chipRepositorio.save(chip);
            }
        }
    }

    //Encontrar chips de un usuario especifico
    public List<Chip> encontrarChipsPorUsuario(Integer id) {
        return jdbcChipRepositorio.findChipByIdUsuario(id);
    }

    //Buscar por id un Chip
    public Optional<Chip> encontrarChip(Integer id) {
        return chipRepositorio.findById(id);
    }

    //Encontrar todos los chips
    public List<Chip> chips() {
        return new ArrayList<>(chipRepositorio.findAll());
    }
}
