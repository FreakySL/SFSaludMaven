/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.dao;

import com.pandateam.sfsaludmaven.backend.database.DatabaseManager;
import com.pandateam.sfsaludmaven.backend.dto.SuscripcionDTO;
import com.pandateam.sfsaludmaven.backend.mappers.PacienteMapper;
import com.pandateam.sfsaludmaven.backend.mappers.SuscripcionMapper;
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
public class SuscripcionDAO implements DAO<SuscripcionDTO> {

    private Connection connection;
    private SuscripcionMapper suscripcionMapper;
    
    public SuscripcionDAO() {
        connection = DatabaseManager.getInstance().getConnection();
        suscripcionMapper = new SuscripcionMapper();
    }

    @Override
    public boolean create(SuscripcionDTO object) {
        String sql = "INSERT INTO Suscripcion (Sus_Titular, Sus_FechaInicio, Sus_Descuento, Sus_Estado) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, object.getTitular());
            pstmt.setDate(2, new java.sql.Date(object.getFechaInicio().getTime()));
            pstmt.setInt(3, object.getDescuento());
            pstmt.setString(4, object.getEstado());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public SuscripcionDTO read(int id) throws SQLException {
        String sql = "SELECT Sus_ID, Sus_Estado, Sus_FechaInicio, Sus_Descuento, Sus_Titular\n"
                + "FROM suscripcion\n"
                + "WHERE suscripcion.Sus_ID = ?;";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            // Asignar los valores a los parámetros
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            return suscripcionMapper.map(rs);

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public boolean update(SuscripcionDTO object) {
        String sql = "UPDATE Suscripcion SET Sus_Titular = ?, Sus_FechaInicio = ?, "
                + "Sus_Descuento = ?, Sus_Estado = ? WHERE Per_ID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, object.getTitular());
            pstmt.setDate(2, new java.sql.Date(object.getFechaInicio().getTime()));
            pstmt.setInt(3, object.getDescuento());
            pstmt.setString(4, object.getEstado());
            pstmt.setInt(5, object.getIdSuscripcion());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public SuscripcionDTO delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SuscripcionDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public SuscripcionDTO encontrarPorTitular(String dni) throws SQLException {
        String sql = "SELECT * \n"
                + "FROM suscripcion\n"
                + "LEFT JOIN persona ON suscripcion.Sus_Titular = persona.Per_NumeroDocumento\n"
                + "WHERE suscripcion.Sus_Titular = ?;";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            // Asignar los valores a los parámetros
            pstmt.setString(1, dni);

            ResultSet rs = pstmt.executeQuery();

            return suscripcionMapper.map(rs);

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

}
