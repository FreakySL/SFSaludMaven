/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.dto;

/**
 *
 * @author santi
 */
public class PacienteDTO {
    
    private int idPaciente;
    private boolean suscrip;
    private String esp;

    public PacienteDTO(int idPaciente, boolean suscrip, String esp) {
        this.idPaciente = idPaciente;
        this.suscrip = suscrip;
        this.esp = esp;
    }

    public PacienteDTO() {
    }
    
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
