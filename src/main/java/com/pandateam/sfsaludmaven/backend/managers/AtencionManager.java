/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.managers;

import com.pandateam.sfsaludmaven.backend.dao.AtencionDAO;
import com.pandateam.sfsaludmaven.backend.dto.AtencionDTO;
import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author santi
 */
public class AtencionManager {

    private static AtencionDAO atencionDAO = new AtencionDAO();

    public static List<AtencionDTO> obtenerAtencionesDeServicio(int servicio) {
        return atencionDAO.obtenerAtencionesPorServicio(servicio);
    }

    public static double obtenerHorasDeAtenciones(List<AtencionDTO> atenciones) {
        long totalMinutos = 0;

        for (AtencionDTO atencion : atenciones) {
            Time horaInicio = atencion.getHoraInicio();
            Time horaFin = atencion.getHoraFinal();
            // Calcular la diferencia en milisegundos 
            long diferenciaMillis = horaFin.getTime() - horaInicio.getTime(); 
            // Convertir la diferencia a minutos 
            long diferenciaMinutos = TimeUnit.MILLISECONDS.toMinutes(diferenciaMillis);
            totalMinutos += diferenciaMinutos;
        } 
        
        // Convertir el total de minutos a horas (con decimales) y redondear hacia arriba
        return Math.ceil(totalMinutos / 60.0);

    }

}
