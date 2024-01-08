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
 * Genera el fondo de la escena creando un Cielo, tres arboles y el suelo
 * 
 * @author Jose Javier Bailon Ortiz
 * @see Cielo
 * @see Arbol
 * @see Suelo
 */
public class Fondo extends Dibujo {
    private final Cielo cielo = new Cielo(0,0);
    private final Arbol arbol1=new Arbol(400,320);
    private final Arbol arbol2=new Arbol(500,320);
    private final Arbol arbol3=new Arbol(600,320);
    private final Suelo suelo = new Suelo(0,300);
    public Fondo(int x, int y) {
        super(x, y);
    }

    @Override
    public void dibujar(Graphics2D g2d) {
        //cielo
        cielo.setFase(fase);
        cielo.dibujar(g2d);
        
        //arboles cada uno con un desplazamiento en la fase de animacion
        arbol1.setFase(fase);
        arbol1.dibujar(g2d);
        arbol2.setFase(fase+0.1);
        arbol2.dibujar(g2d);
        arbol3.setFase(fase+0.2);
        arbol3.dibujar(g2d);
        
        //suelo
        suelo.setFase(fase);
        suelo.dibujar(g2d);
        g2d.setTransform(Lienzo.resetTransform);

    }

}//end NewClass
