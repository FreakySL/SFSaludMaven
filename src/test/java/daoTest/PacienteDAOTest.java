/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoTest;

import com.pandateam.sfsaludmaven.backend.dao.PacienteDAO;
import com.pandateam.sfsaludmaven.backend.dto.PacienteDTO;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author santi
 */
public class PacienteDAOTest {

    private PacienteDAO pacienteDAO;

    @BeforeEach
    public void setUp() {
        pacienteDAO = new PacienteDAO();
    }

    @Test
    public void testConsultar() throws SQLException {

        PacienteDTO dto;
        try {
            dto = pacienteDAO.read(1);
            System.out.println(dto.getIdPaciente());
            System.out.println(dto.getNombre());
            System.out.println(dto.getApellido());
            System.out.println(dto.getFechaNacimiento().toString());
            assertNotNull(dto);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
