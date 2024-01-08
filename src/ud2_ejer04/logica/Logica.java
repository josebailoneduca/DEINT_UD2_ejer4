/*
LICENCIA JOSE JAVIER BO
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
Lista de paquetes:
 */
package ud2_ejer04.logica;

import ud2_ejer04.gui.Ventana;

/**
 *
 * Ejercicio UD2_4
 *
 * Logica crea Ventana de la animacion. Ventana es un JFrame y tiene un Timer y
 * un boton. Al pulsar el boton se alterna el estado del Timer entre pausado o
 * funcionando.
 *
 * Cuando Timer genera un ActionEvent se recalcula un nuevo fotograma.
 *
 * Ventana tiene también un JPanel de la clase Lienzo. Este Lienzo en su
 * paintComponent dibuja la escena. La escena la componen varias clases que son
 * subclases de Dibujo. Estos Dibujo tienen un metodo Dibujo#dibujar(Graphics2D
 * g2d) donde se especifica cómo debe dibujarse. El dibujado depende de un valor
 * de fase de animacion que esta contenido en Ventana.
 *
 *
 * Cuando Ventana calcula un nuevo fotograma aumenta su atributo fase. Esta fase
 * es usada por los Dibujos para determinar la fase de su animación en la que
 * deben dibujarse. La fase de animacion por defecto debe tenerse en cuenta de 
 * 0 a 1 (0 inicio 1 fin) pero cada dibujo la usa segun sus necesidades
 * multiplicando el valor o dividiendolo, calculando senos y cosenos... para
 * obtener los valores de posicion y giro que necesitan en funcion de esa fase
 * que hay registrada en Ventana.
 *
 * @author Jose Javier Bailon Ortiz
 * @see Ventana
 * @see Lienzo
 * @see Dibujo
 */
public class Logica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Ventana v = new Ventana();
            v.setLocationRelativeTo(null);
            v.setVisible(true);

        });
    }

}
