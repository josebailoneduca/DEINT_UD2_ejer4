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
import javax.imageio.ImageIO;

/**
 * Dibuja un fondo con una imagen de cielo y un Sol
 * 
 * @author Jose Javier Bailon Ortiz
 * @see Sol
 */
public class Cielo extends Dibujo {
    
    // Textura del cielo
    private BufferedImage textura;
    
    //Objeto sol
    private final Sol sol=new Sol(200,100);
    
    public Cielo(int x, int y) {
        super(x, y);
        
        //cargar textura
        String ruta="ud2_ejer04/recursos/cielo.jpg";
        try {
            textura = ImageIO.read(getClass().getClassLoader().getResource(ruta));
        } catch (IOException ex) {
            System.out.println("Problema cargando la textura "+ruta);
            System.exit(0);
        }
    }

    @Override
    public void dibujar(Graphics2D g2d) {
        //imagen de cielo
        g2d.setPaint(new TexturePaint(textura, new Rectangle(800, 300)));
        g2d.fillRect(x, y, 800, 400);
        
        //sol
        sol.setFase(fase);
        sol.dibujar(g2d);
    }

}//end NewClass
