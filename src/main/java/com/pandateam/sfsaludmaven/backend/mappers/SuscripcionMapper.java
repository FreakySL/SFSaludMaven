/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.mappers;

import com.pandateam.sfsaludmaven.backend.dto.SuscripcionDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author santi
 */
public class SuscripcionMapper {

    public SuscripcionDTO map(ResultSet rs) throws SQLException {
        SuscripcionDTO suscripcionDTO = new SuscripcionDTO();
        
        if (rs.next()) {
            suscripcionDTO.setIdSuscripcion(rs.getInt("Sus_ID"));
            suscripcionDTO.setFechaInicio(rs.getDate("Sus_FechaInicio"));
            suscripcionDTO.setTitular(rs.getInt("Sus_Titular"));
            suscripcionDTO.setDescuento(rs.getInt("Sus_Descuento"));
            suscripcionDTO.setEstado(rs.getString("Sus_Estado"));
        }

        return suscripcionDTO;
    }

}
