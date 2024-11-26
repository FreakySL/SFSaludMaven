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

    public SocioDTO map(ResultSet rs) throws SQLException {
        SocioDTO socioDTO = new SocioDTO();

        if (rs.next()) {
            socioDTO.setIdSocio(rs.getInt("Per_ID"));
            socioDTO.setNombre(rs.getString("Per_Nombre"));
            socioDTO.setApellido(rs.getString("Per_Apellido"));
            socioDTO.setDni(rs.getString("Per_NumeroDocumento"));
            socioDTO.setFechaNacimiento(rs.getDate("Per_FechaNacimiento"));
            socioDTO.setTelefono(rs.getInt("Per_Telefono"));
            socioDTO.setMail(rs.getString("Per_Correo"));
            socioDTO.setEspPersona(rs.getString("Per_Esp"));
            socioDTO.setSuscrip(rs.getString("P_TieneSuscripcion"));
            socioDTO.setEspPaciente(rs.getString("P_Esp"));
            socioDTO.setNumAfiliado(rs.getString("S_NumeroSocio"));
            socioDTO.setSuscripcionId(rs.getInt("Sus_ID"));
        }

        return socioDTO;
    }

}
