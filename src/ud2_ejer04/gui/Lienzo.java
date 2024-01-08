/*
LICENCIA JOSE JAVIER BO
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
Lista de paquetes:
 */
package ud2_ejer04.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import ud2_ejer04.gui.dibujos.Dibujo;
import ud2_ejer04.gui.dibujos.Fondo;
import ud2_ejer04.gui.dibujos.Persona;

/**
 *
 * @author Jose Javier Bailon Ortiz
 */
public class Lienzo extends javax.swing.JPanel {

    public static AffineTransform resetTransform;
    private ArrayList<Dibujo> dibujos = new ArrayList<>();

    /**
     * Creates new form Lienzo
     */
    public Lienzo() {
        initComponents();
        crearDibujos();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        resetTransform=g2d.getTransform();
        for (Dibujo dibujo : dibujos) {
            dibujo.setFase(Ventana.fase);
            dibujo.dibujar(g2d);
            g2d.setTransform(resetTransform);
        }
    }

    private void crearDibujos() {
        
        //camino
        Dibujo fondo = new Fondo(0,0);
        dibujos.add(fondo);
        
        //persona
        Dibujo persona = new Persona(-60,460);
        dibujos.add(persona);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
