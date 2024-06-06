package com.example.proyectoback.Dto;

public class UsuarioOutputDto {

    private Integer IdUsuario;
    private String correo;
    private Boolean codRol;

    public Integer getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Boolean getCodRol() {
        return codRol;
    }

    public void setCodRol(Boolean codRol) {
        this.codRol = codRol;
    }
}
