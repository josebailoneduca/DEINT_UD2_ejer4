/*
LICENCIA JOSE JAVIER BO
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
Lista de paquetes:
 */
package ud2_ejer04.gui.dibujos;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Jose Javier Bailon Ortiz
 */
public class Suelo extends Dibujo {

    private BufferedImage textura;
    private int[] puntosX;
    private int[] puntosY;

    public Suelo(int x, int y) {
        super(x, y);
        String ruta = "ud2_ejer04/recursos/camino.png";
        try {
            textura = ImageIO.read(getClass().getClassLoader().getResource(ruta));
        } catch (IOException ex) {
            System.out.println("Problema cargando la textura " + ruta);
            System.exit(0);
        }
        crearPuntosHierba();
    }

    @Override
    public void dibujar(Graphics2D g2d) {
        g2d.setColor(Colores.hierba);
        g2d.fillRect(x, y, 800, 400);

        //hierba borde
        g2d.fillPolygon(puntosX, puntosY, puntosX.length);

        //camino
        g2d.setPaint(new TexturePaint(textura, new Rectangle(200, 100)));
        g2d.fillRect(x, y + 100, 800, 50);
        g2d.translate(0, 150);
        g2d.setColor(Colores.hierba);
        g2d.fillPolygon(puntosX, puntosY, puntosX.length);

    }

    private void crearPuntosHierba() {
        ArrayList<Integer> px = new ArrayList<Integer>();
        ArrayList<Integer> py = new ArrayList<Integer>();
        int tx = 0;
        int ty = y;
        while (tx < 801) {
            px.add(tx);
            py.add(ty);
            tx += 3;
            if (ty == y) {
                ty -= 10;
            } else {
                ty = y;
            }
        }
        px.add(800);
        py.add(y);
        puntosX = px.stream().mapToInt(Integer::intValue).toArray();
        puntosY = py.stream().mapToInt(Integer::intValue).toArray();

    }

}//end NewClass
