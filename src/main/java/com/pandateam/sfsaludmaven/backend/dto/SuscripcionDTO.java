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
public class SuscripcionDTO {
    
    private int idSuscripcion;
    private Date fechaInicio;
    private int titular;
    private int descuento;
    private String estado;

    public SuscripcionDTO(int idSuscripcion, Date fechaInicio, int titular, int descuento, String estado) {
        this.idSuscripcion = idSuscripcion;
        this.fechaInicio = fechaInicio;
        this.titular = titular;
        this.descuento = descuento;
        this.estado = estado;
    }

    public SuscripcionDTO() {
    }
    
    public int getIdSuscripcion() {
        return idSuscripcion;
    }

    public void setIdSuscripcion(int idSuscripcion) {
        this.idSuscripcion = idSuscripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getTitular() {
        return titular;
    }

    public void setTitular(int titular) {
        this.titular = titular;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
