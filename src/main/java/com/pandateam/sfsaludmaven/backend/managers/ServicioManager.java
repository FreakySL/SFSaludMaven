/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.managers;

import com.pandateam.sfsaludmaven.backend.dao.ServicioDAO;
import com.pandateam.sfsaludmaven.backend.database.DatabaseManager;
import com.pandateam.sfsaludmaven.backend.dto.ServicioDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author santi
 */
public class ServicioManager {
    private static ServicioDAO servicioDAO;

    public ServicioManager() {
        servicioDAO = new ServicioDAO();
    }

    public void agregarServicio(ServicioDTO servicioDTO) {
        servicioDAO.create(servicioDTO);
    }
    
    public static double calcularHorasServicio(int cantAtenciones, int cantHorasDia, double costoHora){
        /*
        long tiempoTranscurrido = fFin.getTime() - fInicio.getTime();
        TimeUnit unidad = TimeUnit.DAYS;
        long dias = unidad.convert(tiempoTranscurrido, TimeUnit.MILLISECONDS);
        */
        return cantAtenciones*cantHorasDia*costoHora+0.0;
    }
    
    public static DefaultTableModel consultarServicio(String nombre, String apellido, String documento, 
            String descripcion, String tipo) throws SQLException {

        try {
            ResultSet rs = servicioDAO.filtrarServicios(nombre, apellido, documento, descripcion, tipo);
            return DatabaseManager.resultToTable(rs);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static double calcularPresupuesto(ServicioDTO servicio, double costo) {
        
        double horas = AtencionManager
                .obtenerHorasDeAtenciones(AtencionManager
                        .obtenerAtencionesDeServicio(servicio.getIdServicio()));
        
        return costo * horas;
        
    }

    // Métodos adicionales para actualizar y eliminar servicios...
}

