package com.pandateam.sfsaludmaven.backend.dao;
import com.pandateam.sfsaludmaven.backend.database.DatabaseManager;
import com.pandateam.sfsaludmaven.backend.models.Usuario;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsuarioDAO implements DAO<Usuario> {

    private Connection connection;

    public UsuarioDAO() {
        connection = DatabaseManager.getInstance().getConnection();
    }
    
    @Override
    public boolean create(Usuario usuario) {
        String sql = "INSERT INTO Usuarios (Usuario_Nombre, Usuario_Contrasena) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            // Encriptar la contraseña
            String hashedContrasena = BCrypt.hashpw(usuario.getContrasena(), BCrypt.gensalt());

            // Asignar los valores
            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, hashedContrasena);
            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean verificarUsuario(String nombre, String contrasena) {
        String sql = "SELECT Usuario_Contrasena FROM Usuario WHERE Usuario_Nombre = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String hashedContrasena = rs.getString("Usuario_Contrasena");
                    return BCrypt.checkpw(contrasena, hashedContrasena);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Usuario object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario read(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Usuario> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 
}