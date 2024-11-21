/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.dao;

import com.pandateam.sfsaludmaven.backend.database.DatabaseManager;
import com.pandateam.sfsaludmaven.backend.dto.SocioDTO;
import com.pandateam.sfsaludmaven.backend.mappers.SocioMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author santi
 */
public class SocioDAO implements DAO<SocioDTO> {

    private Connection connection;
    private SocioMapper socioMapper;

    public SocioDAO() {
        connection = DatabaseManager.getInstance().getConnection();
        socioMapper = new SocioMapper();
    }

    @Override
    public boolean create(SocioDTO object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SocioDTO read(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(SocioDTO object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SocioDTO delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SocioDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ResultSet miembrosDeSuscripcion(String id) throws SQLException {

        String sql = "SELECT P_TieneSuscripcion FROM Paciente"
                + "WHERE Per_ID = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            // Asignar los valores a los parámetros
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();

            // Devolver el ResultSet si aún lo necesitas
            rs.next();
            String tieneSus = rs.getString("P_TieneSuscripcion");

            if (tieneSus.equals("Sí")) {
                sql = "SELECT Sus_ID FROM Socio"
                        + "WHERE Per_ID = ?";
                pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, id);
                rs = pstmt.executeQuery();

                rs.next();
                String susId = rs.getString("Sus_ID");

                sql = "SELECT \n"
                        + "    p.Per_Nombre, \n"
                        + "    p.Per_Apellido, \n"
                        + "    p.Per_NumeroDocumento, \n"
                        + "    s.S_NumeroSocio\n"
                        + "FROM \n"
                        + "    socio s\n"
                        + "INNER JOIN persona p ON s.Per_ID = p.Per_ID\n"
                        + "INNER JOIN paciente pa ON pa.Per_ID = p.Per_ID\n"
                        + "WHERE \n"
                        + "    s.Sus_ID = ?";
                
                pstmt = connection.prepareStatement(sql);
                pstmt.setString(1, susId);
                
                return pstmt.executeQuery();
            } else {
                return null;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

}
