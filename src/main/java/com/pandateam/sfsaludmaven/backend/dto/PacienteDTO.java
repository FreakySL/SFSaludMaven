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
public class PacienteDTO {
    
    private int idPaciente;
    private String suscrip;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaNacimiento;
    private int telefono;
    private String mail;
    private String espPersona;
    private String espPaciente;

    public PacienteDTO(int idPaciente, String suscrip, String nombre, String apellido, String dni, Date fechaNacimiento, int telefono, String mail, String espPersona, String espPaciente) {
        this.idPaciente = idPaciente;
        this.suscrip = suscrip;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.mail = mail;
        this.espPersona = espPersona;
        this.espPaciente = espPaciente;
    }

    public PacienteDTO() {
    }
    
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String isSuscrip() {
        return suscrip;
    }

    public void setSuscrip(String suscrip) {
        this.suscrip = suscrip;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getEspPersona() {
        return espPersona;
    }

    public void setEspPersona(String espPersona) {
        this.espPersona = espPersona;
    }

    public String getEspPaciente() {
        return espPaciente;
    }

    public void setEspPaciente(String espPaciente) {
        this.espPaciente = espPaciente;
    }

    
}
