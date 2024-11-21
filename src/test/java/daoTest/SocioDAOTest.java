/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoTest;

import com.pandateam.sfsaludmaven.backend.dao.SocioDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author santi
 */
public class SocioDAOTest {
    
    private SocioDAO socioDAO;

    @BeforeEach
    public void setUp() {
        socioDAO = new SocioDAO();
    }
    
    @Test
    public void testMostrarMiembrosDeSuscripcion() throws SQLException {
        
        ResultSet rs = socioDAO.miembrosDeSuscripcion("1");

        assertNotNull(rs);
        

    }
    
}
