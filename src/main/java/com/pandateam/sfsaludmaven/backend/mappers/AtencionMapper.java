/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.mappers;

import com.pandateam.sfsaludmaven.backend.dto.AtencionDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author santi
 */
public class AtencionMapper {

    public AtencionDTO map(ResultSet rs) throws SQLException {
        AtencionDTO atencion = new AtencionDTO();
        atencion.setIdAtencion(rs.getInt("A_ID"));
        atencion.setFecha(rs.getDate("A_Fecha"));
        atencion.setHoraInicio(rs.getTime("A_HoraInicio"));
        atencion.setHoraFinal(rs.getTime("A_HoraFin"));
        atencion.setIdServicio(rs.getInt("S_ID"));
        
        return atencion;
    }

}
