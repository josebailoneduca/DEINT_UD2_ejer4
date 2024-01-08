/*
LICENCIA JOSE JAVIER BO
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
Lista de paquetes:
 */

package ud2_ejer04.gui.dibujos;

import java.awt.Graphics2D;
import ud2_ejer04.gui.Lienzo;

/**
 *  Dibuja un arbol con la base del tronco en la posicion X,Y definida
 *  Tiene una animacion basada en el seno de la fase que se aplica como sesgado.
 * @author Jose Javier Bailon Ortiz
 */
public class Arbol extends Dibujo {
    
    /**
     * Constructor
     * @param x Posicion x de la base del tronco
     * @param y Posicion y de la base del tronco
     */
    public Arbol(int x, int y) {
        super(x, y);
     }

    @Override
    public void dibujar(Graphics2D g2d) {
        //valor de sesgado basado en el seno de la fase
        double sesgado = Math.sin(fase*20)/10;
        
        //tronco
        g2d.translate(x, y);
        g2d.shear(sesgado, sesgado);
        g2d.setColor(Colores.TRONCO);
        g2d.fillRect(-10, -90, 20, 100);
        //copa0
        g2d.translate(0, -90);
        g2d.setColor(Colores.COPA_0);
        g2d.fillOval(-30, -50, 60, 90);
        //copa1
        g2d.translate(0, -30);
        g2d.setColor(Colores.COPA_1);
        g2d.fillOval(-20, -40, 40, 80);
        //copa2
        g2d.translate(0, -25);
        g2d.setColor(Colores.COPA_2);
        g2d.fillOval(-10, -20, 20, 40);
        //copa3
        g2d.translate(0, -25);
        g2d.setColor(Colores.COPA_3);
        g2d.fillOval(-5, -15, 10, 30);
        g2d.setTransform(Lienzo.resetTransform);
    }

}//end NewClass
