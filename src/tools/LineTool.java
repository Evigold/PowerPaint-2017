/*
 * TCSS 305 - Autumn 2017
 * Assignment 5b - PowerPaint
 */

package tools;

import java.awt.Shape;
import java.awt.geom.Line2D;

/**
 * A tool for drawing Lines.
 * 
 * @author Eviatar Goldschmidt (evigold@uw.edu).
 * @version Nov 22, 2017.
 */
public class LineTool extends AbstractPaintTool {

    /** String Name for this Tool. */
    private static final String NAME = "Line";
    
    /**
     * Constructs an instance of this tool.
     */
    public LineTool() {
        super(NAME);
    }
    
    @Override
    public Shape getShape() {
        return new Line2D.Double(getStartX(), getStartY(), getEndX(), getEndY());
    }

    @Override
    public String getName() {
        return NAME;
    }
}
