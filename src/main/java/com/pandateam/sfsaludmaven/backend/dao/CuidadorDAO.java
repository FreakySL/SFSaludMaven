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
public class CuidadorDAO implements DAO<CuidadorDTO>{
    
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
    public CuidadorDTO read(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(CuidadorDTO object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CuidadorDTO delete(long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CuidadorDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public ResultSet getAll() throws SQLException {
        String sql = "String sql = \"SELECT p.Per_ID, p.Per_Nombre, p.Per_Apellido, p.Per_NumeroDocumento, s.S_NumeroSocio \" +\n"
                + "                     \"FROM Persona p \" +\n"
                + "                     \"JOIN Paciente pac ON p.Per_ID = pac.Per_ID \" +\n"
                + "                     \"LEFT JOIN Socio s ON pac.Per_ID = s.Per_ID \" +\n"
                + "                     \"WHERE p.Per_Nombre LIKE ? AND p.Per_Apellido LIKE ? \" +\n"
                + "                     \"AND p.Per_NumeroDocumento LIKE ? AND s.S_NumeroSocio LIKE ?\";";
        try (Statement stmt = connection.createStatement()) {
   
            return stmt.executeQuery(sql);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    
}
