/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.managers;

import com.pandateam.sfsaludmaven.backend.dao.SuscripcionDAO;
import com.pandateam.sfsaludmaven.backend.dto.PacienteDTO;
import com.pandateam.sfsaludmaven.backend.dto.SuscripcionDTO;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author santi
 */
public class SuscripcionManager {

    private static SuscripcionDAO suscripcionDAO = new SuscripcionDAO();

    public static void crearSuscripcion(SuscripcionDTO suscripcion) {
        suscripcionDAO.create(suscripcion);
    }

    public static boolean agregarSuscripcion(PacienteDTO paciente, String plan, Date fecha, int descuento) {

        SuscripcionDTO sus = new SuscripcionDTO();
        sus.setFechaInicio(fecha);
        sus.setDescuento(descuento);
        sus.setTitular(paciente.getDni());

        if (paciente.getEspPaciente().equals("NoSocio")) {

            PacienteManager.cambiarSuscripcion(paciente);

            switch (plan) {
                case "Junior": {
                    sus.setEstado("PreJunior");
                    break;
                }
                case "Medium": {
                    sus.setEstado("PreMedium");
                    break;
                }
                case "Full": {
                    sus.setEstado("PreFull");
                    break;
                }
            }

            suscripcionDAO.create(sus);

            return true;
        } else {
            return false;
        }

    }
    
    public static SuscripcionDTO consultarSuscripcion(){
        
        return null;
        
    }

    public static void actualizarPlan(SuscripcionDTO sus) {

        LocalDate fechaDadaLocal = sus.getFechaInicio().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Fecha actual 
        LocalDate fechaActual = LocalDate.now();

        long diferenciaEnDias = ChronoUnit.DAYS.between(fechaDadaLocal, fechaActual);
// Verificar si la diferencia es mayor a 90 días 
        if (Math.abs(diferenciaEnDias) > 90) {
            switch (sus.getEstado()) {
                case "PreJunior": {
                    sus.setEstado("Junior");
                    suscripcionDAO.update(sus);
                    break;
                }
                case "PreMedium": {
                    sus.setEstado("Medium");
                    suscripcionDAO.update(sus);
                    break;
                }
                case "PreFull": {
                    sus.setEstado("Full");
                    suscripcionDAO.update(sus);
                    break;
                }
                case "JuniorToMedium":{
                    sus.setEstado("Medium");
                    suscripcionDAO.update(sus);
                    break;
                }
                case "JuniorToFull": {
                    sus.setEstado("Full");
                    suscripcionDAO.update(sus);
                    break;
                }
                case "MediumToFull": {
                    sus.setEstado("Full");
                    suscripcionDAO.update(sus);
                    break;
                }
                case "FullToMedium": {
                    sus.setEstado("Medium");
                    suscripcionDAO.update(sus);
                    break;
                }
                case "FullToJunior": {
                    sus.setEstado("Junior");
                    suscripcionDAO.update(sus);
                    break;
                }
                case "MediumToJunior": {
                    sus.setEstado("Junior");
                    suscripcionDAO.update(sus);
                    break;
                }
            }
        }
    }
}
