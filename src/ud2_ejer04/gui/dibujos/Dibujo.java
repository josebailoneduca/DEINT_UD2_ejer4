/*
LICENCIA JOSE JAVIER BO
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
Lista de paquetes:
 */
package ud2_ejer04.gui.dibujos;

import java.awt.Graphics2D;

/**
 * Clase base para los dibujos. Contiene coordenadas y fase. La fase es el valor
 * de avance de la animación. Siendo 0 inicio de animacion 1 fin de animacion aunque
 * puede ser modificado por el propio dibujo segun su necesidad
 *
 * @author Jose Javier Bailon Ortiz
 */
public abstract class Dibujo {

    //coordeadas
    protected int x;
    protected int y;
    
    //fase de avance de la animacion
    protected double fase;

    protected Dibujo(int x, int y) {
        this.x = x;
        this.y = y;
        this.fase = 0;
    }

    /**
     * Debe ser implementado por las clases que hereden implementando la manera en 
     * que se genera el dibujo usando el g2d
     * 
     * @param g2d  Graphics2D a usar para dibujar
     */
    abstract public void dibujar(Graphics2D g2d);

    /**
     * Define la fase de animacion actual
     * 
     * @param fase La fase
     */
    public void setFase(double fase) {
        this.fase = fase;
    }

}//end Dibujo
