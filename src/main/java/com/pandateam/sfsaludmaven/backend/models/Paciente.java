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
    
    private int idPaciente;
    private boolean suscrip;
    private String esp;

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public boolean isSuscrip() {
        return suscrip;
    }

    public void setSuscrip(boolean suscrip) {
        this.suscrip = suscrip;
    }

    public String getEsp() {
        return esp;
    }

    public void setEsp(String esp) {
        this.esp = esp;
    }
}
