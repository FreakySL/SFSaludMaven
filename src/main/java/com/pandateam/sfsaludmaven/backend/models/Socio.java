/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.models;

/**
 *
 * @author santi
 */
public class Socio extends Paciente{
    
    private int idSocio;
    private String numAfiliado;
    private int suscripcionId;
    
    public int getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(int idSocio) {
        this.idSocio = idSocio;
    }

    public String getNumAfiliado() {
        return numAfiliado;
    }

    public void setNumAfiliado(String numAfiliado) {
        this.numAfiliado = numAfiliado;
    }

    public int getSuscripcionId() {
        return suscripcionId;
    }

    public void setSuscripcionId(int suscripcionId) {
        this.suscripcionId = suscripcionId;
    }
    
    
}
