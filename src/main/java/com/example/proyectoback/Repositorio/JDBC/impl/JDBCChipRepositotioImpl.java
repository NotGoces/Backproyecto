package com.example.proyectoback.Repositorio.JDBC.impl;

import com.example.proyectoback.Modelo.Chip;
import com.example.proyectoback.Repositorio.JDBC.JDBCChipRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JDBCChipRepositotioImpl implements JDBCChipRepositorio {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Chip> findChipByIdUsuario(Integer codgrupo) {
        String sql = "SELECT * FROM chip WHERE codgrupo = :codgrupo";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("codgrupo", codgrupo);
        return jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Chip.class));
    }

    @Override
    public void cambiarEstadoChip(Integer idChip) {
        String SQL= "UPDATE chip SET estado = :estado WHERE id_chip = :idChip";
    }

    @Override
    public void cambiarNombreChip(Integer idChip) {
        String SQL= "UPDATE chip SET nombre = :nombre WHERE id_chip = :idChip";
    }

    @Override
    public void cambiarTaplinkChip(Integer idChip) {
        String SQL= "UPDATE CHIP SET taplink = :taplink WHERE id_chip = :idChip";
    }
}
