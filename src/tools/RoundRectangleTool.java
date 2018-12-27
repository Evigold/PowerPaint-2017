/*
 * TCSS 305 - Autumn 2017
 * Assignment 5b - PowerPaint
 */

package tools;

import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

/**
 * A tool for drawing a Round Rectangle.
 * 
 * @author Eviatar Goldschmidt (evigold@uw.edu).
 * @version Nov 22, 2017.
 */
public class RoundRectangleTool extends AbstractFillShape {

    /** The magnitude of the curves of the edges for this Round Rectangle Tool. */
    private static final int FEFAULT_CURVE = 10;
    
    /** String Name for this Tool. */
    private static final String NAME = "RoundRectangle";
    
    /**
     * Constructs an instance of this tool.
     */
    public RoundRectangleTool() {
        super(NAME);
    }
    
    @Override
    public Shape getShape() {
        return new RoundRectangle2D.Double(getAnchorX(), getAnchorY(), getWidth(), 
                                           getheight(), FEFAULT_CURVE, FEFAULT_CURVE);
    }

    @Override
    public String getName() {
        return NAME;
    }
}