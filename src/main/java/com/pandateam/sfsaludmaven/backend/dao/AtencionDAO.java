/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.dao;

import com.pandateam.sfsaludmaven.backend.database.DatabaseManager;
import com.pandateam.sfsaludmaven.backend.dto.AtencionDTO;
import com.pandateam.sfsaludmaven.backend.mappers.AtencionMapper;
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
public class AtencionDAO implements DAO<AtencionDTO> {

    private Connection connection;
    private AtencionMapper atencionMapper;

    public AtencionDAO() {
        connection = DatabaseManager.getInstance().getConnection();
        atencionMapper = new AtencionMapper();
    }
    
    
    public List<AtencionDTO> obtenerAtencionesPorServicio(int servicioId) {
        List<AtencionDTO> atenciones = new ArrayList<>();
        String sql = "SELECT A_ID, A_Fecha, A_HoraInicio, A_HoraFin, S_ID FROM Atencion WHERE S_ID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, servicioId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                atenciones.add(atencionMapper.map(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return atenciones;
    }

    @Override
    public boolean create(AtencionDTO object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AtencionDTO read(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(AtencionDTO object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public AtencionDTO delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<AtencionDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
