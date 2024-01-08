/*
LICENCIA JOSE JAVIER BO
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
Lista de paquetes:
 */
package ud2_ejer04.gui.dibujos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import ud2_ejer04.gui.Lienzo;

/**
 * Dibuja la persona que anda. La animacion esta estructurada con 4 ejes de
 * giro/desplazamiento: 
 * - ROOT. Punto central a la altura de los pies. Usado
 *   para desplazar a lo largo del camino en funcion de la fase (0 inicio del
 *   camino, 1 fin del camino)
 * - tPELVIS. Punto de giro para las piernas y el tronco.
 * - tBRAZOS. Punto de giro para los brazos
 * - tCABEZA. Punto de giro para la cabeza
 * 
 * - tPelvis depende de root.
 * - tBrazos y tCabeza dependen de tPelvis
 * 
 * 
 * ROOT define la posicion general en X de todo el dibujo en funcion de la fase, 
 * seno y coseno para simular los arcos generales de los pasos
 * 
 * Los brazos y las pierna se giran usando una proporcion del seno y -seno de la fase
 * La cabeza y el tronco giran usando una proporcion del coseno y - coseno de la fase
 * 
 * 
 * Las zapatillas, los brazos, el cuerpo y las piernas estan hechos con polilineas 
 * y poligonos. 
 * 
 * El resto esta hecho con rectangulos, circulos y arcos.
 * 
 * 
 *
 * @author Jose Javier Bailon Ortiz
 */
public class Persona extends Dibujo {

    private BufferedImage textura;
    int[] zapX = {-5, 5, 15, 15, -5,};
    int[] zapY = {60, 60, 65, 70, 70};
    int[] mangaX = {-7, -7, 3, 3};
    int[] mangaY = {0, 20, 20, 0};
    int[] brazoX = {-7, -7, 0, 5, 2, 1};
    int[] brazoY = {20, 30, 50, 45, 30, 20};

    int[] cuerpoX = {-12, 8, 8, 6, -10, -12};
    int[] cuerpoY = {-10, -10, -65, -70, -70, -65};

    int[] piernaX = {-8, -1, -5, 5, 8, 5};
    int[] piernaY = {0, 35, 60, 60, 30, 0};

    BasicStroke borde = new BasicStroke(1);

    public Persona(int x, int y) {
        super(x, y);
    }

    @Override
    public void dibujar(Graphics2D g2d) {

        //ciclo de un paso
        double faseAndar = Math.sin(fase * 60);
        
        //ciclo de un paso doblado
        double dobleFaseAndar = Math.cos(fase * 120);
        
        //ROOT
        //posicion inicial
        g2d.translate(x, y);

        //desplazamiento horizontal segun avance de animacion
        g2d.translate(fase % 1 * 1000, 0);

        //desfase en x e para simular arcos de movimiento de los pasos
        g2d.translate(x - Math.abs(Math.sin(faseAndar)) * 5, -100 - Math.abs(Math.cos(faseAndar)) * 10);

        
        
        //EJE DE GIRO DE LAS PIERNAS Y TRONCO
        AffineTransform tPelvis = g2d.getTransform();

        //GIRO APLICADO AL TRONCO. ES NECESARIO APLICARLO YA PARA CALCULAR
        //LA POSICION DE LOS EJES DE GIRO DE LOS BRAZOS Y CABEZA
        g2d.rotate(dobleFaseAndar / 20 + 0.1);
        AffineTransform tCuerpo = g2d.getTransform();

        //EJE DE GIRO DE LOS BRAZOS
        g2d.translate(0, -65);
        AffineTransform tBrazos = g2d.getTransform();

        //EJE DE GIRO Y GIRO DE CABEZA
        g2d.translate(0, -5);
        g2d.rotate(-dobleFaseAndar / 10 + 0.1);
        AffineTransform tCabeza = g2d.getTransform();

        //PIERNA IZQUIERDA
        //transform
        g2d.setTransform(tPelvis);
        g2d.rotate(faseAndar / 3 + 0.1);

        g2d.setColor(Colores.PANTALONES_OSCURO);
        g2d.fillPolygon(piernaX, piernaY, piernaX.length);
        g2d.setColor(Colores.ZAPATILLAS_OSCURO);
        g2d.fillPolygon(zapX, zapY, zapX.length);
        g2d.setColor(Color.BLACK);
        g2d.fillRect(-5, 70, 20, 2);

        //BRAZO IZQUIERDO
        //transfor
        g2d.setStroke(borde);
        g2d.setTransform(tBrazos);
        g2d.rotate(-faseAndar / 2);
        //manga
        g2d.setColor(Colores.CAMISETA);
        g2d.fillRect(-7, 0, 10, 20);
        g2d.setColor(Colores.CAMISETA_OSCURO);
        g2d.drawPolyline(mangaX, mangaY, mangaX.length);
        //brazo
        g2d.setColor(Colores.PIEL_OSCURA);
        g2d.fillPolygon(brazoX, brazoY, brazoX.length);
        g2d.fillOval(0, 47, 10, 10);

        //CABEZA
        //transform
        g2d.setTransform(tCabeza);
        
        //cabeza
        g2d.setColor(Colores.PIEL);
        g2d.fillRect(-7, -10, 10, 20);
        g2d.fillOval(-10, -30, 28, 30);
        //oreja
        g2d.setColor(Colores.PIEL_OSCURA);
        g2d.drawArc(0, -20, 15, 10, 160, 90);
        //pelo
        g2d.setColor(Colores.PELO);
        g2d.fillArc(-15, -35, 35, 35, 45, 200);
        //boca
        g2d.setColor(Color.BLACK);
        g2d.setStroke(borde);
        g2d.drawArc(8, -12, 15, 5, 180, 90);
        //ojos
        g2d.setColor(Color.WHITE);
        g2d.fillOval(10, -22, 3, 6);
        g2d.setColor(Color.BLACK);
        g2d.fillOval(12, -19, 2, 2);

        //CUERPO
        g2d.setTransform(tCuerpo);
        g2d.setColor(Colores.CAMISETA);
        g2d.fillPolygon(cuerpoX, cuerpoY, cuerpoX.length);
        g2d.setColor(Colores.PANTALONES);
        g2d.fillRect(-14, -10, 22, 10);
        g2d.fillOval(-14, -10, 22, 20);

        //PIERNA DERECHA
        g2d.setTransform(tPelvis);
        g2d.rotate(-faseAndar / 3 + 0.1);
        g2d.setColor(Colores.PANTALONES);
        g2d.fillPolygon(piernaX, piernaY, piernaX.length);
        g2d.setColor(Color.WHITE);
        g2d.fillPolygon(zapX, zapY, zapX.length);
        g2d.setColor(Color.BLACK);
        g2d.fillRect(-5, 70, 20, 2);

        //BRAZO DERECHO
        //transfor
        g2d.setStroke(borde);
        g2d.setTransform(tBrazos);
        g2d.rotate(faseAndar / 2);
        //manga
        g2d.setColor(Colores.CAMISETA);
        g2d.fillRect(-7, 0, 10, 20);
        g2d.setColor(Colores.CAMISETA_OSCURO);
        g2d.drawPolyline(mangaX, mangaY, mangaX.length);
        //brazo
        g2d.setColor(Colores.PIEL);
        g2d.fillPolygon(brazoX, brazoY, brazoX.length);
        g2d.fillOval(0, 47, 10, 10);

        g2d.setTransform(Lienzo.resetTransform);
    }

}//end NewClass
