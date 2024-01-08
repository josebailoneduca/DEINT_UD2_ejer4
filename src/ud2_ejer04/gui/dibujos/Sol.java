/*
LICENCIA JOSE JAVIER BO
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
Lista de paquetes:
 */
package ud2_ejer04.gui.dibujos;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import ud2_ejer04.gui.Lienzo;

/**
 * Dibuja un sol centrado en la posicion x,y.
 * Tiene aplicada una escala y rotacion en funcion de la fase
 * 
 * @author Jose Javier Bailon Ortiz
 */
public class Sol extends Dibujo {

    /**
     * Constructor
     * @param x Centro del sol en X
     * @param y Centro del sol en Y
     */
    public Sol(int x, int y) {
        super(x, y);
    }

    @Override
    public void dibujar(Graphics2D g2d) {

        //calcular escala que toca
        double escala = Math.sin(fase * 20) / 4 + 1;
        
        //calcular rotacion que toca
        double rotacion = fase * 5;
        
        //trasladar al sitio
        g2d.translate(x, y);
        
        //rotar
        g2d.rotate(rotacion);
        
        //escalar
        g2d.scale(escala, escala);
        
        //dibujar
        g2d.setColor(Colores.SOL);
        g2d.fillOval(-35, -35, 70, 70);
        float i = 0;
        g2d.setStroke(new BasicStroke(5));
        //rayos
        while (i < 2 * Math.PI) {
            g2d.drawLine(0, 0, 70, 70);
            g2d.rotate(0.7);
            i += 0.7;
        }

       g2d.setTransform(Lienzo.resetTransform);
    }

}//end NewClass
