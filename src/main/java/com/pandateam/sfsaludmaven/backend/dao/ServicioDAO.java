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

    public ResultSet filtrarServicios(String nombre, String apellido, String documento, String descripcion, String tipo) throws SQLException {

        // Construir la consulta SQL correctamente
        String sql = "SELECT s.S_Descripcion, s.S_FechaInicio, s.S_FechaFin, s.S_Costo, \n"
                + "s.S_Tipo, p.Per_Nombre, p.Per_Apellido, p.Per_NumeroDocumento\n"
                + "FROM Persona p\n"
                + "JOIN Servicio s ON p.Per_ID = s.Per_IDPaciente\n"
                + "WHERE p.Per_Nombre LIKE ? AND p.Per_Apellido LIKE ?\n"
                + "AND p.Per_NumeroDocumento LIKE ? AND s.S_Descripcion LIKE ?\n"
                + "AND s.S_Tipo LIKE ?;";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            // Asignar los valores a los parámetros
            pstmt.setString(1, "%" + nombre + "%");
            pstmt.setString(2, "%" + apellido + "%");
            pstmt.setString(3, "%" + documento + "%");
            pstmt.setString(4, "%" + descripcion + "%");
            pstmt.setString(5, "%" + tipo + "%");

            ResultSet rs = pstmt.executeQuery();

            // Devolver el ResultSet si aún lo necesitas
            return rs;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

}
