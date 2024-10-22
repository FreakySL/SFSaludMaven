/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.mappers;

import com.pandateam.sfsaludmaven.backend.dto.CuidadorDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author santi
 */
public class CuidadorMapper {

    public CuidadorDTO map(ResultSet rs) throws SQLException {
        CuidadorDTO cuidadorDTO = new CuidadorDTO();

        if (rs.next()) {
            cuidadorDTO.setIdCuidador(rs.getInt("Per_ID"));
            cuidadorDTO.setProfesion(rs.getString("C_Profesion"));
            cuidadorDTO.setExperiencia(rs.getString("C_Experiencia"));
            cuidadorDTO.setCategoria(rs.getString("C_Categoria"));
            cuidadorDTO.setNombre(rs.getString("Per_Nombre"));
            cuidadorDTO.setApellido(rs.getString("Per_Apellido"));
            cuidadorDTO.setDni(rs.getString("Per_NumeroDocumento"));
            cuidadorDTO.setFechaNacimiento(rs.getDate("Per_FechaNacimiento"));
            cuidadorDTO.setTelefono(rs.getInt("Per_Telefono"));
            cuidadorDTO.setMail(rs.getString("Per_Correo"));
            cuidadorDTO.setEspPersona(rs.getString("Per_Esp"));
        }

        return cuidadorDTO;
    }

}
