/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.mappers;

import com.pandateam.sfsaludmaven.backend.dto.PersonaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author santi
 */
public class PersonaMapper {

    /*
    private int idPersona;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaNacimiento;
    private int telefono;
    private String mail;
    private String esp;
    */
    public PersonaDTO map(ResultSet rs) throws SQLException {
        PersonaDTO personaDTO = new PersonaDTO();

        personaDTO.setIdPersona(rs.getInt("Per_Nombre"));
        personaDTO.setNombre(rs.getString("Per_Nombre"));
        personaDTO.setApellido(rs.getString("Per_Apellido"));
        personaDTO.setDni(rs.getString("Per_NumeroDocumento"));
        personaDTO.setFechaNacimiento(rs.getDate("Per_FechaNacimiento"));
        personaDTO.setTelefono(rs.getInt("Per_Telefono"));
        personaDTO.setMail(rs.getString("Per_Correo"));
        personaDTO.setEsp(rs.getString("Per_Esp"));
        
        return personaDTO;
    }

}
