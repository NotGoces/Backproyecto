package com.example.proyectoback.Repositorio.JDBC;

import com.example.proyectoback.Modelo.Chip;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JDBCChipRepositorio {
    List<Chip> findChipByIdUsuario(Integer idUsuario);
    void cambiarEstadoChip(Integer idChip);
    void cambiarNombreChip(Integer idChip);
    void cambiarTaplinkChip(Integer idChip);
}
