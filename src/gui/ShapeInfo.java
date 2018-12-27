/*
 * TCSS 305 - Autumn 2017
 * Assignment 5b - PowerPaint
 */

package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Shape;

/**
 * Data type that stores all the information of each of the Shapes already drawn.
 * 
 * @author Eviatar Goldschmidt (evigold@uw.edu).
 * @version Nov 22, 2017.
 */
public final class ShapeInfo {
    
    /** The Shape type to be drawn. */
    private final Shape myShape;
    
    /** The Color for the Shape to be drawn. */
    private final Color myDrawColor;
    
    /** The Color for the fill for the Shape to be drawn. */
    private final Color myFillColor;
    
    /** The Stroke for the Shape to be drawn. */
    private final BasicStroke myStrokeSize;
    
    /** The boolean of whether to add fill to the Shape to be drawn. */ 
    private final boolean myFill;
    
    /**
     * Constructs the ShapeInfo object.
     * 
     * @param theShape the Shape to be stored.
     * @param theDrawColor the Color to be stored.
     * @param theFillColor the Fill Color to be stored.
     * @param theStokeSize the Stroke to be stored.
     * @param theFill boolean of whether to fill shape or not to be stored.
     */
    public ShapeInfo(final Shape theShape, final Color theDrawColor, 
                     final Color theFillColor, final BasicStroke theStokeSize, 
                     final boolean theFill) {
        myShape = theShape;
        myDrawColor = theDrawColor;
        myFillColor = theFillColor;
        myStrokeSize = theStokeSize;
        myFill = theFill;
        
    }
    
    /** 
     * @return the Shape to be drawn.
     */
    public Shape getShape() {
        return myShape;
    }
    
    /**
     * @return the Color for the Shape to be drawn.
     */
    public Color getDrawColor() {
        return myDrawColor;
    }
    
    /** 
     * @return the fill Color for the Shape to be drawn.
     */
    public Color getFillColor() {
        return myFillColor;
    }
    
    /**
     * @return the Stroke for the Shape to be drawn.
     */
    public BasicStroke getStrokeSize() {
        return myStrokeSize;
    }
    
    /**
     * @return whether there will be a fill for the shape being drawn.
     */
    public boolean isFill() {
        return myFill;
    }
}