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
public class ServicioMapper {

    public ServicioDTO map(ResultSet rs) throws SQLException {

        if (rs.next()) {
            ServicioDTO servicioDTO = new ServicioDTO();
            servicioDTO.setIdServicio(rs.getInt("S_ID"));
            servicioDTO.setDescripcion(rs.getString("S_Descripcion"));
            servicioDTO.setFechaInicio(rs.getDate("S_FechaInicio"));
            servicioDTO.setFechaFin(rs.getDate("S_FechaFin"));
            servicioDTO.setCosto(rs.getDouble("S_Costo"));
            servicioDTO.setTipoServicio(rs.getString("S_Tipo"));
            servicioDTO.setIdPaciente(rs.getInt("Per_IDPaciente"));
            servicioDTO.setIdCuidador(rs.getInt("Per_IDCuidador"));
            return servicioDTO;
        }
        return null;

    }
}
