/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.mappers;

import com.pandateam.sfsaludmaven.backend.dto.PacienteDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author santi
 */
public class PacienteMapper {

    public PacienteDTO map(ResultSet rs) throws SQLException {
        PacienteDTO pacienteDTO = new PacienteDTO();

        if (rs.next()) {
            pacienteDTO.setIdPaciente(rs.getInt("Per_ID"));
            pacienteDTO.setNombre(rs.getString("Per_Nombre"));
            pacienteDTO.setApellido(rs.getString("Per_Apellido"));
            pacienteDTO.setDni(rs.getString("Per_NumeroDocumento"));
            pacienteDTO.setFechaNacimiento(rs.getDate("Per_FechaNacimiento"));
            pacienteDTO.setTelefono(rs.getInt("Per_Telefono"));
            pacienteDTO.setMail(rs.getString("Per_Correo"));
            pacienteDTO.setEspPersona(rs.getString("Per_Esp"));
            pacienteDTO.setSuscrip(rs.getString("P_TieneSuscripcion"));
            pacienteDTO.setEspPaciente(rs.getString("P_Esp"));
        }

        return pacienteDTO;
    }

}
