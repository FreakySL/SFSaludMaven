/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.dao;

import com.pandateam.sfsaludmaven.backend.database.DatabaseManager;
import com.pandateam.sfsaludmaven.backend.dto.ServicioDTO;
import com.pandateam.sfsaludmaven.backend.mappers.ServicioMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class ServicioDAO implements DAO<ServicioDTO> {

    private Connection connection;
    private ServicioMapper servicioMapper;

    public ServicioDAO() {
        connection = DatabaseManager.getInstance().getConnection();
        servicioMapper = new ServicioMapper();
    }

    @Override
    public boolean create(ServicioDTO servicioDTO) {
        String sql = "INSERT INTO Servicio (S_Descripcion, S_FechaInicio, S_FechaFin, S_Costo, S_Tipo, Per_IDPaciente, Per_IDCuidador) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, servicioDTO.getDescripcion());
            pstmt.setDate(2, new java.sql.Date(servicioDTO.getFechaInicio().getTime()));
            pstmt.setDate(3, new java.sql.Date(servicioDTO.getFechaFin().getTime()));
            pstmt.setDouble(4, servicioDTO.getCosto());
            pstmt.setString(5, servicioDTO.getTipoServicio());
            pstmt.setLong(6, servicioDTO.getIdPaciente());
            pstmt.setLong(7, servicioDTO.getIdCuidador());

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Carga exitosa");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Carga incorrecta");
            return false;
        }
    }

    @Override
    public ServicioDTO read(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(ServicioDTO object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ServicioDTO delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ServicioDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ResultSet filtrarServicios(String documentoPaciente, String documentoCuidador) throws SQLException {

        String sql = "SELECT s.S_ID AS `ID Servicio`, s.S_Descripcion AS Descripcion, s.S_FechaInicio AS `Fecha de Inicio`, s.S_FechaFin AS `Fecha de Fin`, s.S_Tipo AS `Tipo de Servicio`, "
                + "pa.Per_NumeroDocumento AS `DNI Paciente`, pa.Per_Nombre AS `Nombre Paciente`, pa.Per_Apellido AS `Apellido Paciente`, "
                + "cu.Per_NumeroDocumento AS `DNI Cuidador`, cu.Per_Nombre AS `Nombre Cuidador`, cu.Per_Apellido AS `Apellido Cuidador` "
                + "FROM servicio s "
                + "INNER JOIN persona pa ON s.Per_IDPaciente = pa.Per_ID "
                + "INNER JOIN persona cu ON s.Per_IDCuidador = cu.Per_ID "
                + "WHERE pa.Per_NumeroDocumento LIKE ? AND cu.Per_NumeroDocumento LIKE ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            pstmt.setString(1, "%" + documentoPaciente + "%");
            pstmt.setString(2, "%" + documentoCuidador + "%");

            ResultSet rs = pstmt.executeQuery();

            return rs;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

}
