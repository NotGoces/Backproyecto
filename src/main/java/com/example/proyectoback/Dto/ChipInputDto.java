package com.example.proyectoback.Dto;

public class ChipInputDto {
    private Integer id;
    private String nombre;
    private String tapLink;

    public ChipInputDto(Integer id, String tapLink, String nombre) {
        this.id = id;
        this.tapLink = tapLink;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTapLink() {
        return tapLink;
    }

    public void setTapLink(String tapLink) {
        this.tapLink = tapLink;
    }
}
