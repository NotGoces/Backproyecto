package com.example.proyectoback.Repositorio.JDBC.impl;

import com.example.proyectoback.Modelo.Grupo;
import com.example.proyectoback.Repositorio.JDBC.JDBCGrupoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class JDBCGrupoRepositorioImpl implements JDBCGrupoRepositorio {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Grupo> findGrupoByIdUsuario(Integer idUsuario) {
        String sql = "SELECT * FROM grupo WHERE IdUsuario = :idUsuario";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("idUsuario", idUsuario);
        return jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Grupo.class));
    }

    @Override
    public void cambiarEstadoGrupo(Integer idGrupo) {
        String SQL= "UPDATE grupo SET Estado = :Estado WHERE IdGrupo = :IdGrupo";
    }
}
