/*
LICENCIA JOSE JAVIER BO
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
Lista de paquetes:
 */
package ud2_ejer04.gui.dibujos;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

/**
 *
 * @author Jose Javier Bailon Ortiz
 */
public abstract class Dibujo {

    protected int x;
    protected int y;
    protected double fase;

    public Dibujo(int x, int y) {
        this.x = x;
        this.y = y;
        this.fase = 0;
    }

    abstract public void dibujar(Graphics2D g2d);

    public void setFase(double fase) {
        this.fase = fase;
    }

}//end Dibujo
