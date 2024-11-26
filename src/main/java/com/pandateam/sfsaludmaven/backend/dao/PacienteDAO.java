/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.dao;

import com.pandateam.sfsaludmaven.backend.database.DatabaseManager;
import com.pandateam.sfsaludmaven.backend.dto.PacienteDTO;
import com.pandateam.sfsaludmaven.backend.mappers.PacienteMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author santi
 */
public class PacienteDAO implements DAO<PacienteDTO> {

    private Connection connection;
    private PacienteMapper pacienteMapper;

    public PacienteDAO() {
        connection = DatabaseManager.getInstance().getConnection();
        pacienteMapper = new PacienteMapper();
    }

    @Override
    public boolean create(PacienteDTO object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PacienteDTO read(int id) throws SQLException {

        String sql = "SELECT * \n"
                + "FROM Persona per\n"
                + "JOIN Paciente pac ON per.Per_ID = pac.Per_ID\n"
                + "WHERE per.Per_ID = ?;";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            // Asignar los valores a los parámetros
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            return pacienteMapper.map(rs);

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
    
    public PacienteDTO buscarPorDNI(String dni) throws SQLException {

        String sql = "SELECT * \n"
                + "FROM Persona per\n"
                + "JOIN Paciente pac ON per.Per_ID = pac.Per_ID\n"
                + "WHERE per.Per_NumeroDocumento = ?;";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            // Asignar los valores a los parámetros
            pstmt.setString(1, dni);

            ResultSet rs = pstmt.executeQuery();

            return pacienteMapper.map(rs);

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }

    }

    @Override
    public boolean update(PacienteDTO object) {
        String sql = "UPDATE paciente SET P_TieneSuscripcion = ?, P_Esp = ? WHERE Per_ID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, object.getSuscrip());
            pstmt.setString(2, object.getEspPaciente());
            pstmt.setInt(3, object.getIdPaciente());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public PacienteDTO delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PacienteDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ResultSet filtrarPacientes(String nombre, String apellido, String documento) throws SQLException {

        // Construir la consulta SQL correctamente
        String sql = "SELECT p.Per_ID, p.Per_Nombre, p.Per_Apellido, p.Per_NumeroDocumento, pac.P_TieneSuscripcion "
                + "FROM Persona p "
                + "JOIN Paciente pac ON p.Per_ID = pac.Per_ID "
                + "LEFT JOIN Socio s ON pac.Per_ID = s.Per_ID "
                + "WHERE p.Per_Nombre LIKE ? AND p.Per_Apellido LIKE ? "
                + "AND p.Per_NumeroDocumento LIKE ?;";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            // Asignar los valores a los parámetros
            pstmt.setString(1, "%" + nombre + "%");
            pstmt.setString(2, "%" + apellido + "%");
            pstmt.setString(3, "%" + documento + "%");

            ResultSet rs = pstmt.executeQuery();

            // Devolver el ResultSet si aún lo necesitas
            return rs;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
    
    public boolean isSuscripto(int id) throws SQLException {
        
        PacienteDTO paciente = this.read(id);
        
        if (paciente.getSuscrip().equals("Sí"))
            return true;
        else
            return false;
        
    }

}
