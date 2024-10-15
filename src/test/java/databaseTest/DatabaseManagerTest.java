/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseTest;

import com.pandateam.sfsaludmaven.backend.database.DatabaseManager;
import java.sql.Connection;
import org.junit.jupiter.api.Test;

/**
 *
 * @author santi
 */
public class DatabaseManagerTest {
    
    
    private Connection connection;
    
    @Test
    public void initial() {
        connection = DatabaseManager.getInstance().getConnection();
    }
}
