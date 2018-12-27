/*
 * TCSS 305 - Autumn 2017
 * Assignment 5b - PowerPaint
 */

package tools;

import java.awt.Shape;
import java.awt.geom.Path2D;

/**
* A tool for free drawing.
* 
* @author Eviatar Goldschmidt (evigold@uw.edu).
* @version Nov 22, 2017.
*/
public class PencilTool extends AbstractPaintTool {

    /** The Default off canvas X and Y Coordinates for shapes. */ 
    private static final int XY_STARRT_COORDINATE = -10;
    
    /** String Name for this Tool. */
    private static final String NAME = "Pencil";
    
    /**
     * Constructs an instance of this tool.     
     */
    public PencilTool() {
        super(NAME);
    }
    
    @Override
    public Shape getShape() {
        final Path2D path = new Path2D.Double();
        path.moveTo(XY_STARRT_COORDINATE, XY_STARRT_COORDINATE);
        return path;
    }

    @Override
    public String getName() {
        return NAME;
    }
}
