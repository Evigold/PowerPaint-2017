/*
 * TCSS 305 - Autumn 2017
 * Assignment 5b - PowerPaint
 */

package tools;

/**
 * Provides common implementation of some fillable paint tools.
 * 
 * @author Eviatar Goldschmidt (evigold@uw.edu).
 * @version Nov 22, 2017.
 */
public abstract class AbstractFillShape extends AbstractPaintTool {

    /**
     * Constructs an instance of the Shape tool.
     * 
     * @param theName String name of the Item.
     */
    public AbstractFillShape(final String theName) {
        super(theName);
    }
    
    /**
     * Returns the X Coordinate of the fillable Shape drawn.
     * 
     * @return the X Coordinate of the fillable Shape drawn.
     */
    public int getAnchorX() {
        final int x;
        if (getStartX() < getEndX()) {
            x = getStartX();
        } else {
            x = getEndX();
        }
        return x;
    }
    
    /**
    * Returns the Y Coordinate of the fillable Shape drawn.
    * 
    * @return the Y Coordinate of the fillable Shape drawn.
    */
    public int getAnchorY() {
        final int y;
        if (getStartY() < getEndY()) {
            y = getStartY();
        } else {
            y = getEndY();
        }
        return y;
    }
    
    /**
     * Returns the width of the fillable Shape drawn.
     * 
     * @return the width of the fillable Shape drawn.
     */
    public int getWidth() {
        return Math.abs(getStartX() - getEndX());
    }
    
    /**
     * Returns the height of the fillable shape drawn.
     * 
     * @return the height of the fillable shape drawn.
     */
    public int getheight() {
        return Math.abs(getStartY() - getEndY());
    }
}
