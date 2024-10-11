/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.conventers;

import com.pandateam.sfsaludmaven.backend.dto.ServicioDTO;
import com.pandateam.sfsaludmaven.backend.models.Servicio;

/**
 *
 * @author santi
 */
public class ServicioConverter {
    public static ServicioDTO toDTO(Servicio servicio) {
        ServicioDTO servicioDTO = new ServicioDTO();
        servicioDTO.setIdServicio(servicio.getIdServicio());
        servicioDTO.setDescripcion(servicio.getDescripcion());
        servicioDTO.setFechaInicio(servicio.getFechaInicio());
        servicioDTO.setFechaFin(servicio.getFechaFin());
        servicioDTO.setCosto(servicio.getCosto());
        servicioDTO.setTipoServicio(servicio.getTipoServicio());
        servicioDTO.setIdPaciente(servicio.getIdPaciente());
        servicioDTO.setIdCuidador(servicio.getIdCuidador());
        return servicioDTO;
    }

    public static Servicio toEntity(ServicioDTO servicioDTO) {
        Servicio servicio = new Servicio();
        servicio.setIdServicio(servicioDTO.getIdServicio());
        servicio.setDescripcion(servicioDTO.getDescripcion());
        servicio.setFechaInicio(servicioDTO.getFechaInicio());
        servicio.setFechaFin(servicioDTO.getFechaFin());
        servicio.setCosto(servicioDTO.getCosto());
        servicio.setTipoServicio(servicioDTO.getTipoServicio());
        servicio.setIdPaciente(servicioDTO.getIdPaciente());
        servicio.setIdCuidador(servicioDTO.getIdCuidador());
        return servicio;
    }
}

