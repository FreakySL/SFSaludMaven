/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.pandateam.sfsaludmaven.gui.panels;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author biane
 */
public class JPanAdmCuidadores extends javax.swing.JPanel {

    /**
     * Creates new form JPanAdmCuidadores
     */
    
    
    private void ShowPanel (JPanel pan){
        pan.setSize(650,500);
        pan.setLocation(0,0);
        
        jPanContentCuidadores.removeAll();
        jPanContentCuidadores.add(pan, BorderLayout.CENTER);
        jPanContentCuidadores.revalidate();
        jPanContentCuidadores.repaint();
    }
    
    public JPanAdmCuidadores() {
        initComponents();
        JPanAdmCuidadoresConsultar pan = new JPanAdmCuidadoresConsultar();
        ShowPanel(pan);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanContentCuidadores = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(650, 570));
        setMinimumSize(new java.awt.Dimension(650, 570));

        jLabel1.setFont(new java.awt.Font("Roboto Condensed", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 153));
        jLabel1.setText("Administración de Cuidadores");

        javax.swing.GroupLayout jPanContentCuidadoresLayout = new javax.swing.GroupLayout(jPanContentCuidadores);
        jPanContentCuidadores.setLayout(jPanContentCuidadoresLayout);
        jPanContentCuidadoresLayout.setHorizontalGroup(
            jPanContentCuidadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanContentCuidadoresLayout.setVerticalGroup(
            jPanContentCuidadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addContainerGap(331, Short.MAX_VALUE))
            .addComponent(jPanContentCuidadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanContentCuidadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanContentCuidadores;
    // End of variables declaration//GEN-END:variables
}
