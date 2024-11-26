/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoTest;

import com.pandateam.sfsaludmaven.backend.dto.AtencionDTO;
import com.pandateam.sfsaludmaven.backend.managers.AtencionManager;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 *
 * @author santi
 */
public class AtencionManagerTest {
    
    
    @Test
    public void listarAtencionesServicio() {
        List<AtencionDTO> atenciones = new ArrayList();
        
        for (AtencionDTO atencion : atenciones) {
            System.out.println(atencion.getIdAtencion());
        }
    }
    
    @Test
    public void calcularHoras() {
        System.out.println(AtencionManager.obtenerHorasDeAtenciones(AtencionManager.obtenerAtencionesDeServicio(1)));
        ;
    }
    
}
