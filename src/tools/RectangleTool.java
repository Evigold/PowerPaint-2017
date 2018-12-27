/*
 * TCSS 305 - Autumn 2017
 * Assignment 5b - PowerPaint
 */

package tools;

import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
 * A tool for drawing a Rectangle.
 * 
 * @author Eviatar Goldschmidt (evigold@uw.edu).
 * @version Nov 22, 2017.
 */
public class RectangleTool extends AbstractFillShape {

    /** String Name for this Tool. */
    private static final String NAME = "Rectangle"; 
    
    /**
     * Constructs an instance of this tool.
     */
    public RectangleTool() {
        super(NAME);
    }
    
    @Override
    public Shape getShape() {
        return new Rectangle2D.Double(getAnchorX(), getAnchorY(), getWidth(), getheight());
    }

    @Override
    public String getName() {
        return NAME;
    }
}
