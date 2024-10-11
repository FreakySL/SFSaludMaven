/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.managers;

import com.pandateam.sfsaludmaven.backend.dao.ServicioDAO;
import com.pandateam.sfsaludmaven.backend.dto.ServicioDTO;

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

    // Métodos adicionales para actualizar y eliminar servicios...
}

