/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.managers;

import com.pandateam.sfsaludmaven.backend.dao.ServicioDAO;
import com.pandateam.sfsaludmaven.backend.dto.ServicioDTO;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author santi
 */
public class ServicioManager {
    private static ServicioDAO servicioDAO;

    public ServicioManager() {
        servicioDAO = new ServicioDAO();
    }

    public static boolean agregarServicio(String descripcion,String tipoServicio, Date fechaInicio, Date fechaFin, double costo, int idPaciente, int idCuidador) {
        
        ServicioDTO servicioDTO = new ServicioDTO(0, descripcion, fechaInicio, fechaFin, costo, tipoServicio, idPaciente, idCuidador);
        
         return servicioDAO.create(servicioDTO);
    }
    
    public static double calcularHorasServicio(String tipoServ, Date fInicio, Date fFin, int cantAtenciones, int cantHorasDia, double costoHora){
        long tiempoTranscurrido = fFin.getTime() - fInicio.getTime();
        TimeUnit unidad = TimeUnit.DAYS;
        long dias = unidad.convert(tiempoTranscurrido, TimeUnit.MILLISECONDS);
        
        return dias*cantAtenciones*cantHorasDia*costoHora+0.0;
    }

    // Métodos adicionales para actualizar y eliminar servicios...
}

