/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoTest;

import com.pandateam.sfsaludmaven.backend.dao.ServicioDAO;
import com.pandateam.sfsaludmaven.backend.dto.ServicioDTO;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class ServicioDAOTest {
    private ServicioDAO servicioDAO;

    @BeforeEach
    public void setUp() {
        servicioDAO = new ServicioDAO();
    }
    
    @Test
    public void testAgregar() {
        
        ServicioDTO servicioDTO = new ServicioDTO();
        servicioDTO.setDescripcion("Test Service");
        servicioDTO.setFechaInicio(new Date());
        servicioDTO.setFechaFin(new Date());
        servicioDTO.setCosto(100.0);
        servicioDTO.setTipoServicio(1);
        servicioDTO.setIdPaciente(1);
        servicioDTO.setIdCuidador(1);

        boolean resultado = servicioDAO.create(servicioDTO);
        
        assertTrue(resultado);
    }
}


