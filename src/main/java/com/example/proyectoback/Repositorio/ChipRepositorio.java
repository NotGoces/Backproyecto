package com.example.proyectoback.Repositorio;

import com.example.proyectoback.Modelo.Chip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChipRepositorio extends JpaRepository<Chip, Integer> {

}
