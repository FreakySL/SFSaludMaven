/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.mappers;

import com.pandateam.sfsaludmaven.backend.dto.SocioDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author santi
 */
public class SocioMapper {
    
    /*
    private int idSocio;
    private String numAfiliado;
    private int suscripcionId;
    */
    
    public SocioDTO map(ResultSet rs) throws SQLException {
        SocioDTO pacienteDTO = new SocioDTO();
        
        pacienteDTO.setIdSocio(rs.getInt("Per_ID"));
        pacienteDTO.setNumAfiliado(rs.getString("S_NumeroSocio"));
        pacienteDTO.setSuscripcionId(rs.getInt("Sus_ID"));
        
        return pacienteDTO;
    }
    
}
