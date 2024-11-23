/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.managers;

import com.pandateam.sfsaludmaven.backend.dao.SocioDAO;
import com.pandateam.sfsaludmaven.backend.database.DatabaseManager;
import com.pandateam.sfsaludmaven.backend.dto.PacienteDTO;
import com.pandateam.sfsaludmaven.backend.dto.SocioDTO;
import com.pandateam.sfsaludmaven.backend.dto.SuscripcionDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author santi
 */
public class SocioManager {
    
    private static SocioDAO socioDAO = new SocioDAO();
    
    
    public static void agregarSocio(SocioDTO socio) {
        socioDAO.create(socio);
    }
    
    public static SocioDTO consultarPorId(int id) throws SQLException {
        return socioDAO.read(id);
    }
    
    public static DefaultTableModel miembrosSuscripcion(int susId) throws Exception {
        try {
            ResultSet rs = socioDAO.miembrosDeSuscripcion(susId);
            return DatabaseManager.resultToTable(rs);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void asignarSuscripcion(PacienteDTO paciente, SuscripcionDTO suscripcion, int grado) {
        
        String numAfiliado = crearNroAfiliado(suscripcion.getTitular(), definirGP(suscripcion.getTitular(), grado));
        
        paciente = PacienteManager.cambiarSuscripcion(paciente);
        
        SocioDTO socio = pacienteToSocio(paciente);
        
        socio.setNumAfiliado(numAfiliado);
        socio.setSuscripcionId(suscripcion.getIdSuscripcion());
        agregarSocio(socio);
        
        NoSocioManager.eliminarNoSocio(paciente.getIdPaciente());
    }
    
    public static SocioDTO pacienteToSocio(PacienteDTO paciente) {
        
        SocioDTO socio = new SocioDTO();
        
        socio.setIdSocio(paciente.getIdPaciente());
        socio.setNombre(paciente.getNombre());
        socio.setApellido(paciente.getApellido());
        socio.setDni(paciente.getDni());
        socio.setFechaNacimiento(socio.getFechaNacimiento());
        socio.setMail(paciente.getMail());
        socio.setTelefono(paciente.getTelefono());
        socio.setSuscrip(paciente.getSuscrip());
        socio.setEspPersona(paciente.getEspPersona());
        socio.setEspPaciente(paciente.getEspPaciente());
        
        return socio;
    }
    
    
    private static String definirGP(String dniTitular, int grado){
        String aux;
        String gp ="";
        
        switch(grado){
            case 1:{
                if(socioDAO.existeNumeroSocio(crearNroAfiliado(dniTitular, "00"))){
                    JOptionPane.showMessageDialog(null, "La suscripción seleccionada ya cuenta con un cónyuge","Error", JOptionPane.WARNING_MESSAGE);
                    break;
                } else{
                    gp = "00";
                }
                break;
            }
            case 2:{
                int i;
                
                for(i=1; i<17; i++){
                    if(i<10){
                        aux = "0" + Integer.toString(i);
                    } else{
                        aux = Integer.toString(i);
                    }
                    
                    if(!socioDAO.existeNumeroSocio(crearNroAfiliado(dniTitular, aux))){
                        gp = aux;
                        break;
                    }
                }
                    
                break;
            }
            case 3:{
                int i;
                
                for(i=17; i<31; i++){
                    
                    aux = Integer.toString(i);
                    
                    if(!socioDAO.existeNumeroSocio(crearNroAfiliado(dniTitular, aux))){
                        gp = aux;
                        break;
                    } 
                }
                break;
            }
            case 4:{
                int i;
                
                for(i=31; i<99; i++){
                    
                    aux = Integer.toString(i);
                    
                    if(!socioDAO.existeNumeroSocio(crearNroAfiliado(dniTitular, aux))){
                        gp = aux;
                        break;
                    }
                }
                break;
            }
        }
        
        return gp;
    }
    
    private static String crearNroAfiliado(String dniTitular, String gp){
    
        String nroSocioAux = dniTitular + gp;
        
        return nroSocioAux;
        
    }
}
