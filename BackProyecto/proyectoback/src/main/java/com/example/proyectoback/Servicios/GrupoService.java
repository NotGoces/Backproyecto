package com.example.proyectoback.Servicios;


import com.example.proyectoback.Modelo.Grupo;
import com.example.proyectoback.Repositorio.GrupoRepositorio;
import com.example.proyectoback.Repositorio.JDBC.JDBCGrupoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GrupoService {

    private final GrupoRepositorio grupoRepositorio;

    @Qualifier("JDBCGrupoRepositorio")
    private final JDBCGrupoRepositorio jdbcGrupoRepositorio;

    //Crear un grupo
    public Grupo nuevoGrupo(Grupo grupo){
        return this.grupoRepositorio.save(grupo);
    }

    //Borrar un grupo
    public void borrarGrupo(Integer id) {
        grupoRepositorio.deleteById(id);
    }

    //Cambiar estado de un grupo
    public void cambiarEstadoGrupo(Integer id){
        Grupo grupo=grupoRepositorio.findById(id).orElse(null);
        if (grupo.getEstado()){
            grupo.setEstado(false);
            grupoRepositorio.save(grupo);
        }else{
            grupo.setEstado(true);
            grupoRepositorio.save(grupo);
        }
    }

    //Obtener los grupos de un Usuario
    public List<Grupo> encontrarGruposPorUsuario(Integer id) {
        return jdbcGrupoRepositorio.findGrupoByIdUsuario(id);
    }

    //Buscar por id un grupo
    public Optional<Grupo> encontrarGrupo(Integer id) {
        return grupoRepositorio.findById(id);
    }
}
