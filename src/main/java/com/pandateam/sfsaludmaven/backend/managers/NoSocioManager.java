/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.managers;

import com.pandateam.sfsaludmaven.backend.dao.NoSocioDAO;
import com.pandateam.sfsaludmaven.backend.database.DatabaseManager;
import com.pandateam.sfsaludmaven.backend.dto.NoSocioDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author santi
 */
public class NoSocioManager {
    private static NoSocioDAO noSocioDAO = new NoSocioDAO();
    
    public static NoSocioDTO consultarPorId(int id) throws SQLException {
        return noSocioDAO.read(id);
    }
    
    public static DefaultTableModel consultarNoSocio(String documento) throws SQLException{
        
        try {
            ResultSet rs = noSocioDAO.obtenerNoSocios(documento);
            return DatabaseManager.resultToTable(rs);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void eliminarNoSocio(int id) {
        noSocioDAO.borrarNoSocio(id);
    }
}
