/*
 * TCSS 305 - Autumn 2017
 * Assignment 5b - PowerPaint
 */

package gui;

import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Starts the POwerPaint Application.
 * 
 *  @author Eviatar Goldschmidt (evigold@uw.edu).
 * @version Nov 22, 2017.
 */
public final class PowerPaintMain  {

    /**
     * Private constructor to inhibit instantiation.
     */
    private PowerPaintMain() {
        throw new IllegalStateException();
    }
    
    /**
     * Set the look and feel for the GUI program.
     */
    private static void setLookAndFeel() {
        
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (final UnsupportedLookAndFeelException e) {
            System.out.println("UnsupportedLookAndFeelException");
        } catch (final ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
        } catch (final InstantiationException e) {
            System.out.println("InstantiationException");
        } catch (final IllegalAccessException e) {
            System.out.println("IllegalAccessException");
        }
    }

    
    /**
     * Start point for the program.
     * 
     * @param theArgs command line arguments - ignored
     */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setLookAndFeel();
                new PowerPaintGUI().start();
            }
        });
    }
}
