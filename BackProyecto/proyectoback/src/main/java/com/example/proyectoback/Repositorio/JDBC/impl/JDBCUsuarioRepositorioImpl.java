package com.example.proyectoback.Repositorio.JDBC.impl;

import com.example.proyectoback.Dto.LoginRequest;
import com.example.proyectoback.Dto.UsuarioOutputDto;
import com.example.proyectoback.Modelo.Usuario;
import com.example.proyectoback.Repositorio.JDBC.JDBCUsuarioRepositorio;
import com.example.proyectoback.Servicios.EncriptadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JDBCUsuarioRepositorioImpl implements JDBCUsuarioRepositorio {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final EncriptadoService encriptadoService;

    @Override
    public UsuarioOutputDto login(LoginRequest usuario) {
        String sql = "SELECT * FROM usuarios WHERE BINARY Correo = :login";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("login", usuario.getCorreo());
        List<Usuario> usuarios = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Usuario.class));
        if (usuarios.isEmpty() || !encriptadoService.verificar(usuario.getContraseña(), usuarios.get(0).getContraseña())) {
            return null;
        }
        UsuarioOutputDto usuarioOutputDto = new UsuarioOutputDto();
        usuarioOutputDto.setIdUsuario(usuarios.get(0).getIdUsuario());
        usuarioOutputDto.setCorreo(usuarios.get(0).getCorreo());
        usuarioOutputDto.setCodRol(usuarios.get(0).getCodRol());
        return usuarioOutputDto;
    }
}