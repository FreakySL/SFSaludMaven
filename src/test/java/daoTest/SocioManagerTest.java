/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoTest;

import com.pandateam.sfsaludmaven.backend.dto.PacienteDTO;
import com.pandateam.sfsaludmaven.backend.dto.SuscripcionDTO;
import com.pandateam.sfsaludmaven.backend.managers.PacienteManager;
import com.pandateam.sfsaludmaven.backend.managers.SocioManager;
import com.pandateam.sfsaludmaven.backend.managers.SuscripcionManager;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;

/**
 *
 * @author santi
 */
public class SocioManagerTest {
    
    @Test
    public void testAsignarSuscripcion() throws SQLException {
        PacienteDTO paciente = new PacienteDTO();
        SuscripcionDTO suscripcion = new SuscripcionDTO();
        
        paciente = PacienteManager.verPaciente(5);
        suscripcion = SuscripcionManager.verSuscripcion(1);
        
        SocioManager.asignarSuscripcion(paciente, suscripcion, 1);
        
    }
    
}
