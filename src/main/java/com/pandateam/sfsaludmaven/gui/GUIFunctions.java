/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pandateam.sfsaludmaven.gui;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author biane
 */
public class GUIFunctions {
    public static void showPanel(JPanel pan, JPanel insertable, int x, int y) {
        pan.setSize(x, y);
        pan.setLocation(0, 0);

        insertable.removeAll();
        insertable.add(pan, BorderLayout.CENTER);
        insertable.revalidate();
        insertable.repaint();
    }
}
