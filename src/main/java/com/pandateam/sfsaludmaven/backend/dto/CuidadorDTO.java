/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.dto;

/**
 *
 * @author santi
 */
public class CuidadorDTO {
    
    private int idCuidador;
    private String profesion;
    private String experiencia;
    private String categoria;

    public CuidadorDTO(int idCuidador, String profesion, String experiencia, String categoria) {
        this.idCuidador = idCuidador;
        this.profesion = profesion;
        this.experiencia = experiencia;
        this.categoria = categoria;
    }

    public CuidadorDTO() {
    }
    
    public int getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(int idCuidador) {
        this.idCuidador = idCuidador;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
