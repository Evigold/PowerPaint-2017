/*
 * TCSS 305 - Autumn 2017
 * Assignment 5b - PowerPaint
 */

package tools;

import java.awt.Shape;
import javax.swing.ImageIcon;

/**
 * Defines required behavior for all paint tools.
 * 
 * @author Eviatar Goldschmidt (evigold@uw.edu).
 * @version Nov 22,  2017.
 */
public interface PaintTool {

    /**
     * Returns the Shape this tool draws for the current dimensions.
     * 
     * @return the Shape to draw.
     */
    Shape getShape();
    
    /**
     * Returns the Icon of this tool.
     * 
     * @return the Icon of this tool.
     */
    ImageIcon getIcon();
    
    /**
     * Sets the initial X and Y coordinates for the Shape drawn by this tool.
     * 
     * @param theX the starting X coordinate.
     * @param theY the starting Y coordinate.
     */
    void setStartXAndY(int theX, int theY);
    
    /**
     * Sets the end X and Y coordinates for the Shape drawn by this tool.
     * 
     * @param theX the end X coordinate.
     * @param theY the end Y coordinate.
     */
    void setEndXAndY(int theX, int theY);

    /** 
     * Returns the name of this tool.
     * 
     * @return the name of this tool.
     */
    String getName();
}