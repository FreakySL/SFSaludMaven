/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.dto;

import java.util.Date;

/**
 *
 * @author santi
 */
public class ServicioDTO {
    private int idServicio;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private double costo;
    private String tipoServicio;
    private int idPaciente;
    private int idCuidador;

    // Constructor vacío
    public ServicioDTO() {}

    // Constructor completo
    public ServicioDTO(int idServicio, String descripcion, Date fechaInicio, Date fechaFin, double costo, String tipoServicio, int idPaciente, int idCuidador) {
        this.idServicio = idServicio;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costo = costo;
        this.tipoServicio = tipoServicio;
        this.idPaciente = idPaciente;
        this.idCuidador = idCuidador;
    }

    // Getters y Setters

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(int idCuidador) {
        this.idCuidador = idCuidador;
    }
    
    
}

