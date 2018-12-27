/*
 * TCSS 305 - Autumn 2017
 * Assignment 5b - PowerPaint
 */

package tools;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 * A tool for drawing an Ellipse.
 * 
 * @author Eviatar Goldschmidt (evigold@uw.edu).
 * @version Nov 22, 2017.
 */
public class EllipseTool extends AbstractFillShape {

    /** String Name for this Tool. */
    private static final String NAME = "Ellipse";
    
    /**
     * Constructs an instance of this tool.
     */
    public EllipseTool() {
        super(NAME);
    }
    
    @Override
    public Shape getShape() {
        return new Ellipse2D.Double(getAnchorX(), getAnchorY(), getWidth(), getheight());
    }

    @Override
    public String getName() {
        return NAME;
    }
}
