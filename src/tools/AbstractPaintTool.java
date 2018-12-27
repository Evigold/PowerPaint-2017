/*
 * TCSS 305 - Autumn 2017
 * Assignment 5b - PowerPaint
 */

package tools;

import gui.PowerPaintGUI;
import java.net.URL;
import java.util.Locale;
import javax.swing.ImageIcon;

/**
 * Provides common implementation of some Paint Tools behavior.
 * 
 * @author Eviatar Goldschcmidt (evigold@uw.edu).
 * @version Nov 22, 2017
 */
public abstract class AbstractPaintTool implements PaintTool {

    /** The Default off canvas X and Y Coordinates for shapes. */ 
    private static final int XY_STARRT_COORDINATE = -10;
    
    /** The initial anchor X Coordinate for the Shape drawn by this tool. */
    private int myXOne;
    
    /** The initial anchor Y Coordinate for the Shape drawn by this tool. */
    private int myXTwo;
    
    /** The end X Coordinate for the Shape drawn by this tool. */
    private int myYOne;
    
    /** The end Y Coordinate for the Shape drawn by this tool. */
    private int myYTwo;
    
    /** The Icon for this tool. */
    private final ImageIcon myIcon;
    
    /**
     * Constructs a Paint Tool.
     * 
     * @param theName the String name of this tool.
     */
    protected AbstractPaintTool(final String theName) {
        myIcon = new ImageIcon(getIconURL(theName));
        myXOne = XY_STARRT_COORDINATE;
        myXTwo = XY_STARRT_COORDINATE;
        myYOne = XY_STARRT_COORDINATE;
        myYTwo = XY_STARRT_COORDINATE;
    }
    
    /**
     * Generates and returns the URL address for the Icon of this tool.
     * 
     * @param theName String name of this tool.
     * 
     * @return the URL address for the Icon of this tool.
     */
    private URL getIconURL(final String theName) {
        final StringBuilder builder = new StringBuilder();
        builder.append("/resources/");
        builder.append(theName.toLowerCase(Locale.ENGLISH));
        builder.append(".gif");
        return PowerPaintGUI.class.getResource(builder.toString());
    }
    
    @Override
    public void setStartXAndY(final int theX, final int theY) {
        myXOne = theX;
        myYOne = theY;
    }
    
    @Override
    public void setEndXAndY(final int theX, final int theY) {
        myXTwo = theX;
        myYTwo = theY;
    }
    
    /**
     * Returns the anchor start X Coordinate for this paint tool.
     * 
     * @return the anchor start X Coordinate for this paint tool.
     */
    protected int getStartX() {
        return myXOne;
    }
  
    /**
     * Returns the anchor start Y Coordinate for this paint tool.
     * 
     * @return the anchor start Y Coordinate for this paint tool.
     */
    protected int getStartY() {
        return myYOne;
    }
  
    /**
     * Returns the end X Coordinate for this paint tool.
     * 
     * @return the end X Coordinate for this paint tool.
     */
    protected int getEndX() {
        return myXTwo;
    }
  
    /**
     * Returns the end Y Coordinate for this paint tool.
     * 
     * @return the end Y Coordinate for this paint tool.
     */
    protected int getEndY() {
        return myYTwo;
    }

    @Override
    public ImageIcon getIcon() {
        return myIcon;
    }
}
