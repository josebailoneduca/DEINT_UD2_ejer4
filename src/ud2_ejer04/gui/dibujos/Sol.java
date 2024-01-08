/*
LICENCIA JOSE JAVIER BO
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
Lista de paquetes:
 */
package ud2_ejer04.gui.dibujos;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import ud2_ejer04.gui.Lienzo;

/**
 *
 * @author Jose Javier Bailon Ortiz
 */
public class Sol extends Dibujo {

    private BufferedImage textura;

    public Sol(int x, int y) {
        super(x, y);
    }

    @Override
    public void dibujar(Graphics2D g2d) {

        double escala = Math.sin(fase * 20) / 8 + 1;
        double rotacion = fase * 5;
        g2d.translate(x, y);
        g2d.rotate(rotacion);
        g2d.scale(escala, escala);
        g2d.scale(escala, escala);
        g2d.setColor(Colores.sol);
        g2d.fillOval(-35, -35, 70, 70);
        float i = 0;
        g2d.setStroke(new BasicStroke(5));
        while (i < 2 * Math.PI) {
            g2d.drawLine(0, 0, 70, 70);
            g2d.rotate(0.7);
            i += 0.7;
        }

       g2d.setTransform(Lienzo.resetTransform);
    }

}//end NewClass
