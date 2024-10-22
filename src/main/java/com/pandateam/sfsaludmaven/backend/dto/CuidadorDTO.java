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
public class CuidadorDTO {
    
    private int idCuidador;
    private String profesion;
    private String experiencia;
    private String categoria;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaNacimiento;
    private int telefono;
    private String mail;
    private String espPersona;

    public CuidadorDTO(int idCuidador, String profesion, String experiencia, String categoria, String nombre, String apellido, String dni, Date fechaNacimiento, int telefono, String mail, String espPersona) {
        this.idCuidador = idCuidador;
        this.profesion = profesion;
        this.experiencia = experiencia;
        this.categoria = categoria;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.mail = mail;
        this.espPersona = espPersona;
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
    
    
}
