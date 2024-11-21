/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.dao;

import com.pandateam.sfsaludmaven.backend.database.DatabaseManager;
import com.pandateam.sfsaludmaven.backend.dto.NoSocioDTO;
import com.pandateam.sfsaludmaven.backend.mappers.NoSocioMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author santi
 */
public class NoSocioDAO implements DAO<NoSocioDTO> {

    private Connection connection;
    private NoSocioMapper socioMapper;

    public NoSocioDAO() {
        connection = DatabaseManager.getInstance().getConnection();
        socioMapper = new NoSocioMapper();
    }

    @Override
    public boolean create(NoSocioDTO object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public NoSocioDTO read(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(NoSocioDTO object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public NoSocioDTO delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<NoSocioDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ResultSet obtenerNoSocios(String documento, String numeroSocio) throws SQLException {

        // Construir la consulta SQL correctamente
        String sql = "SELECT p.Per_ID, p.Per_Nombre, p.Per_Apellido, p.Per_NumeroDocumento, s.S_NumeroSocio "
                + "FROM Persona p "
                + "JOIN Paciente pac ON p.Per_ID = pac.Per_ID "
                + "LEFT JOIN Socio s ON pac.Per_ID = s.Per_ID "
                + "WHERE p.Per_Nombre LIKE ? AND p.Per_Apellido LIKE ? "
                + "AND p.Per_NumeroDocumento LIKE ? AND s.S_NumeroSocio LIKE ?;";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            // Asignar los valores a los parámetros
            pstmt.setString(1, "%" + documento + "%");
            pstmt.setString(2, "%" + numeroSocio + "%");

            ResultSet rs = pstmt.executeQuery();

            // Devolver el ResultSet si aún lo necesitas
            return rs;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
    
    public boolean borrarSocio(int id) {
        
        String sql = "DELETE FROM NoSocio WHERE Per_ID = ?;";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, Integer.toString(id));

            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
