/*
 * TCSS 305 - Autumn 2017
 * Assignment 5b - PowerPaint
 */

package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
import tools.PaintTool;
import tools.PencilTool;

/**
 * A panel for drawing Shapes.
 * 
 * @author Eviatar Goldschmidt (evigold@uw.edu).
 * @version Nov 22, 2017.
 */
public class DrawingPanel extends JPanel {

    /** A generated serialization ID. */
    private static final long serialVersionUID = -4282239450316255434L;

    /** The preferred size of this panel. */
    private static final Dimension SIZE = new Dimension(200, 200);
    
    /** The default drawing Color for the Shapes. */
    private static final Color DEFAULT_DRAW_COLOR = new Color(51, 0, 111);
    
    /** The default filling Color for the Shape.  */
    private static final Color DEFAULT_FILL_COLOR = new Color(232, 211, 162);
    
    /** The default background Color. */
    private static final Color DEFAULT_BACKGROUND_COLOR = Color.WHITE;
    
    /** The default Stroke for the Shape. */
    private static final BasicStroke DEFAULT_STROKE = new BasicStroke(5);
    
    /** the DEfault Fill state. */
    private static final boolean DEFAULT_FILL = false;
    
    /** The Default off canvas X and Y Coordinates for shapes. */ 
    private static final int XY_STARRT_COORDINATE = -10;
    
    /** A collection of the previously drawn tools. */
    private final List<ShapeInfo> myShapes;
    
    /** The Paint Tool currently used. */
    private PaintTool myCurrentTool;
    
    /** The Color currently used. */
    private Color myDrawColor;
    
    /** The fill Color currently used. */
    private Color myFillColor;
    
    /** The Stroke currently used. */
    private BasicStroke myStrokeSize;
    
     /** Boolean of whether to fill current shape. */
    private boolean myFill;

    /**The pencil tool for use when selected.*/
    private Path2D myPath;
    
    /** Are there shapes. */
    private boolean myShapesEmpty;
    
    /**
     * Initializes the panel.
     */
    public DrawingPanel() {
        super();
        myShapes = new ArrayList<>();
        myShapesEmpty = myShapes.isEmpty();
        setFields();
        initializePanel();
        setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
    }
    
    /** 
     * Sets default values to fields. 
     */
    private void setFields() {
        myDrawColor = DEFAULT_DRAW_COLOR;
        myFillColor = DEFAULT_FILL_COLOR;
        myStrokeSize = DEFAULT_STROKE;
        myFill = DEFAULT_FILL;
    }
    
    /** 
     * Sets up the Panel.
     */
    private void initializePanel() {
        setPreferredSize(SIZE);
        setBackground(DEFAULT_BACKGROUND_COLOR);
        final MouseInputAdapter mouseHandler = new MyMouseLsitener();
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);
    }
    
    /**
     * Clears the panel by removing all Shapes from the Shapes collections.
     */
    public void clearPanel() {
        myShapes.clear();
        myShapesEmpty = myShapes.isEmpty();
        repaint();
    }
    
    /**
     * Sets the current Paint Tool.
     * 
     * @param theTool the PaintTool to use.
     */
    public void setTool(final PaintTool theTool) {
        myCurrentTool = theTool;
        if (myCurrentTool instanceof PencilTool) {
            myPath = (Path2D) myCurrentTool.getShape();
        }
    }
    
    /**
     * Sets whether to fill the current shape.
     * 
     * @param theFill boolean of whether to fill shape.
     */
    public void setFill(final boolean theFill) {
        myFill = theFill;
    }
    
    /**
     * Sets the current stroke Size.
     * 
     * @param theStrokeSize integer representing the size of the stroke.
     */
    public void setStrokeSize(final int theStrokeSize) {
        myStrokeSize = new BasicStroke(theStrokeSize);
    }
    
    /**
     * Sets the current Drawing color.
     * 
     * @param theColor the drawing color to use.
     */
    public void setDrawColor(final Color theColor) {
        myDrawColor = theColor;
    }

    /**
     * Sets the current Fill color.
     * 
     * @param theColor the fill color to use.
     */
    public void setFillColor(final Color theColor) {
        myFillColor = theColor;
    }
    
    /**
     * Returns the current fill color in use.
     * 
     * @return the current fill color.
     */
    public Color getFillColor() {
        return myFillColor;
    }

    /**
     * Returns the current drawing color in use.
     * 
     * @return the current drawing color.
     */
    public Color getDrawColor() {
        return myDrawColor;
    }
    
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D paint = (Graphics2D) theGraphics;
        paint.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                               RenderingHints.VALUE_ANTIALIAS_ON);

        for (final ShapeInfo info : myShapes) {
            paint.setStroke(info.getStrokeSize());
            if (info.isFill() && info.getShape() instanceof RectangularShape) {
                paint.setPaint(info.getFillColor());
                paint.fill(info.getShape());
            }
            paint.setPaint(info.getDrawColor());
            paint.setStroke(info.getStrokeSize());
            paint.draw(info.getShape());
        }
        
        if (myCurrentTool != null) {
            if (myCurrentTool.getShape() instanceof Path2D) {
                paint.draw(myPath);
            } else {
                if (myFill && myCurrentTool.getShape() instanceof RectangularShape) {
                    paint.setPaint(myFillColor);
                    paint.fill(myCurrentTool.getShape());
                }
                paint.setColor(myDrawColor);
                paint.setStroke(myStrokeSize);
                paint.draw(myCurrentTool.getShape());
            }
        }
    }
    
    /**
     * Inner Mouse Listener class for drawing on this Panel.
     */
    private class MyMouseLsitener extends MouseInputAdapter {

        @Override
        public void mousePressed(final MouseEvent theEvent) {
            if (myCurrentTool instanceof PencilTool) {
                myPath.moveTo(theEvent.getX(), theEvent.getY());
            } else {
                myCurrentTool.setStartXAndY(theEvent.getX(), theEvent.getY());
                myCurrentTool.setEndXAndY(theEvent.getX(), theEvent.getY());
            }
            repaint();
        }
        
        @Override
        public void mouseDragged(final MouseEvent theEvent) {
            if (myCurrentTool instanceof PencilTool) {
                myPath.lineTo(theEvent.getX(), theEvent.getY());
            } else {
                myCurrentTool.setEndXAndY(theEvent.getX(), theEvent.getY());
            }
            repaint();
        }
        
        @Override
        public void mouseReleased(final MouseEvent theEvent) {
            if (myCurrentTool instanceof PencilTool) {
                myShapes.add(new ShapeInfo(myPath, myDrawColor, myFillColor, myStrokeSize, 
                                           myFill));
                myPath = (Path2D) myCurrentTool.getShape();
            } else {
                myShapes.add(new ShapeInfo(myCurrentTool.getShape(), myDrawColor, myFillColor,
                                           myStrokeSize, myFill));
                myCurrentTool.setStartXAndY(XY_STARRT_COORDINATE, XY_STARRT_COORDINATE);
                myCurrentTool.setEndXAndY(XY_STARRT_COORDINATE, XY_STARRT_COORDINATE);
            }
            firePropertyChange("clearPanel", myShapesEmpty, myShapes.isEmpty());
            myShapesEmpty = myShapes.isEmpty();
            repaint();
        }
    }
}
