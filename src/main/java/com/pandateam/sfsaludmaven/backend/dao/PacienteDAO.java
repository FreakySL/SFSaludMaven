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
    public PacienteDTO read(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(PacienteDTO object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PacienteDTO delete(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<PacienteDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ResultSet filtrarPacientes(String nombre, String apellido, String documento, String numeroSocio) throws SQLException {

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
            pstmt.setString(1, "%" + nombre + "%");
            pstmt.setString(2, "%" + apellido + "%");
            pstmt.setString(3, "%" + documento + "%");
            pstmt.setString(4, "%" + numeroSocio + "%");

            ResultSet rs = pstmt.executeQuery();

            // Mostrar los resultados en consola
            while (rs.next()) {
                // Obtener los datos de cada columna
                int id = rs.getInt("Per_ID");
                String nombrePaciente = rs.getString("Per_Nombre");
                String apellidoPaciente = rs.getString("Per_Apellido");
                String documentoPaciente = rs.getString("Per_NumeroDocumento");
                String numeroSocioPaciente = rs.getString("S_NumeroSocio");

                // Mostrar los datos en consola
                System.out.println("ID: " + id);
                System.out.println("Nombre: " + nombrePaciente);
                System.out.println("Apellido: " + apellidoPaciente);
                System.out.println("Documento: " + documentoPaciente);
                System.out.println("Número de Socio: " + numeroSocioPaciente);
                System.out.println("----------------------------------");
            }

            // Devolver el ResultSet si aún lo necesitas
            return rs;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

}
