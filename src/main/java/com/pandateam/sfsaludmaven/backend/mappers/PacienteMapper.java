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
        
        pacienteDTO.setIdPaciente(rs.getInt("Per_ID"));
        pacienteDTO.setSuscrip(rs.getBoolean("P_TieneSuscripcion"));
        pacienteDTO.setEsp(rs.getString("P_Esp"));
        
        return pacienteDTO;
    }
    
}
