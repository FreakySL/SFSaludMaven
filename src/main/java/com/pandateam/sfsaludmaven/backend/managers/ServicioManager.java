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
    private ServicioDAO servicioDAO;

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

    // Métodos adicionales para actualizar y eliminar servicios...
}

