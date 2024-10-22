/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.dao;

import com.pandateam.sfsaludmaven.backend.database.DatabaseManager;
import com.pandateam.sfsaludmaven.backend.dto.CuidadorDTO;
import com.pandateam.sfsaludmaven.backend.mappers.CuidadorMapper;
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
public class CuidadorDAO implements DAO<CuidadorDTO> {

    private Connection connection;
    private CuidadorMapper cuidadorMapper;

    public CuidadorDAO() {
        connection = DatabaseManager.getInstance().getConnection();
        cuidadorMapper = new CuidadorMapper();
    }

    @Override
    public boolean create(CuidadorDTO object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CuidadorDTO read(int id) throws SQLException {

        String sql = "SELECT * \n"
                + "FROM Persona per\n"
                + "JOIN Cuidador cu ON per.Per_ID = cu.Per_ID\n"
                + "WHERE per.Per_ID = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            // Asignar los valores a los parámetros
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            return cuidadorMapper.map(rs);

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }

    }

    @Override
    public boolean update(CuidadorDTO object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CuidadorDTO delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CuidadorDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ResultSet obtenerCuidadores() throws SQLException {

        String sql = "SELECT p.Per_ID, p.Per_Nombre, p.Per_Apellido, p.Per_NumeroDocumento, cu.C_Experiencia\n"
                + "FROM Persona p\n"
                + "JOIN Cuidador cu ON p.Per_ID = cu.Per_ID;";
        try {
            Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            // Devolver el ResultSet si aún lo necesitas
            return rs;

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

}
