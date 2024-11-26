/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.dao;

import com.pandateam.sfsaludmaven.backend.database.DatabaseManager;
import com.pandateam.sfsaludmaven.backend.dto.SocioDTO;
import com.pandateam.sfsaludmaven.backend.mappers.SocioMapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class SocioDAO implements DAO<SocioDTO> {

    private Connection connection;
    private SocioMapper socioMapper;

    public SocioDAO() {
        connection = DatabaseManager.getInstance().getConnection();
        socioMapper = new SocioMapper();
    }

    @Override
    public boolean create(SocioDTO object) {
        String sql = "INSERT INTO socio (Per_ID, S_NumeroSocio, Sus_ID) VALUES (?,?,?);";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, object.getIdSocio());
            pstmt.setString(2, object.getNumAfiliado());
            pstmt.setInt(3, object.getSuscripcionId());

            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Carga exitosa");
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Carga incorrecta");
            return false;
        }
    }

    @Override
    public SocioDTO read(int id) throws SQLException {
        // Construir la consulta SQL correctamente
        String sql = "SELECT *\n"
                + "FROM Socio\n"
                + "WHERE per_id = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            // Asignar los valores a los parámetros
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            // Devolver el ResultSet si aún lo necesitas
            return socioMapper.map(rs);

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public boolean update(SocioDTO object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SocioDTO delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody  
    }

    @Override
    public List<SocioDTO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ResultSet miembrosDeSuscripcion(int id) throws SQLException {
        String sql = "SELECT \n"
                + "    p.Per_Nombre, \n"
                + "    p.Per_Apellido, \n"
                + "    p.Per_NumeroDocumento, \n"
                + "    s.S_NumeroSocio\n"
                + "FROM socio s\n"
                + "INNER JOIN persona p ON s.Per_ID = p.Per_ID\n"
                + "INNER JOIN paciente pa ON pa.Per_ID = p.Per_ID\n"
                + "WHERE \n"
                + "    s.Sus_ID = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);

            // Asignar los valores a los parámetros
            pstmt.setInt(1, id);

            return pstmt.executeQuery();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    /*
    
    public ResultSet miembrosDeSuscripcion(String id) throws SQLException {

        String sql = "SELECT P_TieneSuscripcion FROM Paciente "
                + "WHERE Per_ID = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = connection.prepareStatement(sql);

            // Asignar los valores a los parámetros
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            // Verificar si hay resultados
            if (rs.next()) {
                String tieneSus = rs.getString("P_TieneSuscripcion");

                if (tieneSus.equals("Sí")) {
                    sql = "SELECT Sus_ID FROM Socio "
                            + "WHERE Per_ID = ?";
                    pstmt = connection.prepareStatement(sql);
                    pstmt.setString(1, id);
                    rs = pstmt.executeQuery();

                    // Verificar si hay resultados
                    if (rs.next()) {
                        String susId = rs.getString("Sus_ID");

                        sql = "SELECT \n"
                                + "    p.Per_Nombre, \n"
                                + "    p.Per_Apellido, \n"
                                + "    p.Per_NumeroDocumento, \n"
                                + "    s.S_NumeroSocio\n"
                                + "FROM socio s\n"
                                + "INNER JOIN persona p ON s.Per_ID = p.Per_ID\n"
                                + "INNER JOIN paciente pa ON pa.Per_ID = p.Per_ID\n"
                                + "WHERE \n"
                                + "    s.Sus_ID = ?";

                        pstmt = connection.prepareStatement(sql);
                        pstmt.setString(1, susId);
                        rs = pstmt.executeQuery();

                        return rs;
                    }
                } else {
                    System.out.println("La persona no tiene suscripción.");
                    return null;
                }
            } else {
                System.out.println("No se encontró la persona.");
                return null;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            // Cerrar el PreparedStatement
            if (pstmt != null) {
                pstmt.close();
            }
        }
        return null;
    }
    
     */
    public boolean tieneMenosDeCuatroMiembros(int susId) {
        String sql = "SELECT COUNT(*) AS total_miembros FROM socio WHERE Sus_ID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, susId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int totalMiembros = rs.getInt("total_miembros");
                    return totalMiembros < 4; // Retorna true si hay menos de 5 miembros 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // Retorna false si no hubo resultados o en caso de error 
    }

    public boolean existeNumeroSocio(String numeroSocio) {
        String sql = "SELECT COUNT(*) FROM Socio WHERE S_NumeroSocio = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, numeroSocio);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; // Retorna true si el número de socio ya existe 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // Retorna false si no hubo resultados
    }
}
