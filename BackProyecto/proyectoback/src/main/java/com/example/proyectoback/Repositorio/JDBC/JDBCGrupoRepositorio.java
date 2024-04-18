package com.example.proyectoback.Repositorio.JDBC;

import com.example.proyectoback.Modelo.Grupo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JDBCGrupoRepositorio {
    List<Grupo> findGrupoByIdUsuario(Integer idUsuario);
    void cambiarEstadoGrupo(Integer idGrupo);
}
