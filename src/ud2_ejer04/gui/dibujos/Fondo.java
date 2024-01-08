/*
LICENCIA JOSE JAVIER BO
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
Lista de paquetes:
 */

package ud2_ejer04.gui.dibujos;

import java.awt.Graphics2D;

/**
 *
 * @author Jose Javier Bailon Ortiz
 */
public class Fondo extends Dibujo {
    private Cielo cielo;
    private Suelo suelo;
    private Arbol arbol1;
    private Arbol arbol2;
    private Arbol arbol3;
    public Fondo(int x, int y) {
        super(x, y);
        cielo = new Cielo(0,0);
        arbol1=new Arbol(400,320);
        arbol2=new Arbol(500,320);
        arbol3=new Arbol(600,320);
        suelo = new Suelo(0,300);
        
    }

    @Override
    public void dibujar(Graphics2D g2d) {
        //cielo
        cielo.setFase(fase);
        cielo.dibujar(g2d);
        
        //arboles
        arbol1.setFase(fase);
        arbol1.dibujar(g2d);
        arbol2.setFase(fase+0.1);
        arbol2.dibujar(g2d);
        arbol3.setFase(fase+0.2);
        arbol3.dibujar(g2d);
        
        //suelo
        suelo.setFase(fase);
        suelo.dibujar(g2d);
        

    }

}//end NewClass
