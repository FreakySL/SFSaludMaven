/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.backend.managers;

import com.pandateam.sfsaludmaven.backend.dao.SocioDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class SocioManager {
    
    private static SocioDAO socioDAO = new SocioDAO();
    
    
    public static String asignarSuscripcion(dni titular, id suscripcion, int grado) {
        
        crearNroAfiliado(titular, definirGP(titular, grado));
    }
    
    public static int obtenerSusID
    
    public String definirGP(int dniTitular, int grado){
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
    
    public String crearNroAfiliado(int dniTitular, String gp){
    
        String nroSocioAux = Integer.toString(dniTitular) + gp;
        
        return nroSocioAux;
        
    }
}
