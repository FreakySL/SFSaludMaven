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
public class JPanAdmServicios extends javax.swing.JPanel {

    /**
     * Creates new form JPanAdmServicios
     */
    private void ShowPanel (JPanel pan){
        pan.setSize(650,500);
        pan.setLocation(0,0);
        
        jPanContentPacientes.removeAll();
        jPanContentPacientes.add(pan, BorderLayout.CENTER);
        jPanContentPacientes.revalidate();
        jPanContentPacientes.repaint();
    }
    
    public JPanAdmServicios() {
        initComponents();
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
        jPanContentPacientes = new javax.swing.JPanel();
        jPanButtonConsultarServicios = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanButtonCargarServicio = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(650, 570));
        setMinimumSize(new java.awt.Dimension(650, 570));

        jLabel1.setFont(new java.awt.Font("Roboto Condensed", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 153));
        jLabel1.setText("Administración de Servicios");

        jPanContentPacientes.setBackground(new java.awt.Color(255, 255, 255));
        jPanContentPacientes.setMaximumSize(new java.awt.Dimension(650, 500));
        jPanContentPacientes.setMinimumSize(new java.awt.Dimension(650, 500));
        jPanContentPacientes.setPreferredSize(new java.awt.Dimension(650, 500));

        jPanButtonConsultarServicios.setBackground(new java.awt.Color(0, 128, 155));
        jPanButtonConsultarServicios.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanButtonConsultarServicios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanButtonConsultarServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanButtonConsultarServiciosMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Roboto Condensed Light", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Consultar servicios");
        jPanButtonConsultarServicios.add(jLabel5);

        jPanButtonCargarServicio.setBackground(new java.awt.Color(0, 128, 155));
        jPanButtonCargarServicio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanButtonCargarServicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanButtonCargarServicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanButtonCargarServicioMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Roboto Condensed Light", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Cargar nuevo servicio");
        jPanButtonCargarServicio.add(jLabel6);

        javax.swing.GroupLayout jPanContentPacientesLayout = new javax.swing.GroupLayout(jPanContentPacientes);
        jPanContentPacientes.setLayout(jPanContentPacientesLayout);
        jPanContentPacientesLayout.setHorizontalGroup(
            jPanContentPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanContentPacientesLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addGroup(jPanContentPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanButtonCargarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanButtonConsultarServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanContentPacientesLayout.setVerticalGroup(
            jPanContentPacientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanContentPacientesLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jPanButtonCargarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanButtonConsultarServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanContentPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanContentPacientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPanButtonConsultarServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanButtonConsultarServiciosMouseClicked
        // TODO add your handling code here:
        JPanAdmEnConstruccion pan = new JPanAdmEnConstruccion();
        ShowPanel(pan);
    }//GEN-LAST:event_jPanButtonConsultarServiciosMouseClicked

    private void jPanButtonCargarServicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanButtonCargarServicioMouseClicked
        // TODO add your handling code here:
        JPanAdmServiciosCargar pan = new JPanAdmServiciosCargar();
        ShowPanel(pan);
        
    }//GEN-LAST:event_jPanButtonCargarServicioMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanButtonCargarServicio;
    private javax.swing.JPanel jPanButtonConsultarServicios;
    private javax.swing.JPanel jPanContentPacientes;
    // End of variables declaration//GEN-END:variables
}
