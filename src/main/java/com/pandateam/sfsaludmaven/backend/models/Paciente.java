/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.models;

/**
 *
 * @author santi
 */
public class Paciente extends Persona{
    
    private long idPaciente;
    private boolean suscrip;

    public long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public boolean isSuscrip() {
        return suscrip;
    }

    public void setSuscrip(boolean suscrip) {
        this.suscrip = suscrip;
    }
    
}
