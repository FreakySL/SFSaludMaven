/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.mappers;

import com.pandateam.sfsaludmaven.backend.dto.ServicioDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author santi
 */
public class ServicioMapper{
    
    public ServicioDTO map(ResultSet rs) throws SQLException {
        ServicioDTO servicioDTO = new ServicioDTO();
        servicioDTO.setIdServicio(rs.getLong("idServicio"));
        servicioDTO.setDescripcion(rs.getString("descripcion"));
        servicioDTO.setFechaInicio(rs.getDate("fechaInicio"));
        servicioDTO.setFechaFin(rs.getDate("fechaFin"));
        servicioDTO.setCosto(rs.getDouble("costo"));
        servicioDTO.setTipoServicio(rs.getInt("tipoServicio"));
        servicioDTO.setIdPaciente(rs.getLong("idPaciente"));
        servicioDTO.setIdCuidador(rs.getLong("idCuidador"));
        return servicioDTO;
    }
}

