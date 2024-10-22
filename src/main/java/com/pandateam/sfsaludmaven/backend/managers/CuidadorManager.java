/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.managers;

import com.pandateam.sfsaludmaven.backend.dao.CuidadorDAO;
import com.pandateam.sfsaludmaven.backend.database.DatabaseManager;
import com.pandateam.sfsaludmaven.backend.dto.CuidadorDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author santi
 */
public class CuidadorManager {

    private static CuidadorDAO cuidadorDAO = new CuidadorDAO();

    public static DefaultTableModel consultarCuidador() throws SQLException {

        try {
            ResultSet rs = cuidadorDAO.obtenerCuidadores();
            return DatabaseManager.resultToTable(rs);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static CuidadorDTO verCuidador(int id) throws SQLException {
        return cuidadorDAO.read(id);
    }
}
