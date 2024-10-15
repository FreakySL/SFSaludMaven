/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.managers;

import com.pandateam.sfsaludmaven.backend.dao.PacienteDAO;
import com.pandateam.sfsaludmaven.backend.database.DatabaseManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author santi
 */
public class PacienteManager {
    
    private static PacienteDAO pacienteDAO = new PacienteDAO();
    
    public static DefaultTableModel consultarPaciente(String nombre, String apellido, String documento, String numeroSocio) throws SQLException{
        
        try {
            ResultSet rs = pacienteDAO.filtrarPacientes(nombre, apellido, documento, numeroSocio);
            return DatabaseManager.resultToTable(rs);
        } catch (Exception e) {
            throw e;
        }
    }
}
