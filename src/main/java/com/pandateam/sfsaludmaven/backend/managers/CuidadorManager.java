/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.managers;

import com.pandateam.sfsaludmaven.backend.dao.CuidadorDAO;
import com.pandateam.sfsaludmaven.backend.database.DatabaseManager;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author santi
 */
public class CuidadorManager {
    
    private static CuidadorDAO cuidadorDAO;
    
    public DefaultTableModel consultarCuidadores() throws Exception {
        
        try {
            
            ResultSet rs = cuidadorDAO.getAll();
            return DatabaseManager.resultToTable(rs);
            
        } catch (Exception e) {
            throw e;
        }
        
    }
}
