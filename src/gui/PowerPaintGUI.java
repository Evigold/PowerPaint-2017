/*
 * TCSS 305 - Autumn 2017
 * Assignment 5b - PowerPaint
 */

package gui;

import java.awt.BorderLayout;
import java.awt.Image;
import java.net.URL;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import tools.EllipseTool;
import tools.LineTool;
import tools.PaintTool;
import tools.PencilTool;
import tools.RectangleTool;
import tools.RoundRectangleTool;


/**
 * Builds the Frame with all the components for the application.
 * 
 * @author Eviatar Goldschmidt (evigold@uw.edu).
 * @version Nov 22, 2017.
 */
public class PowerPaintGUI {

    /** URL for the Icon of this program. */
    private static final URL ICON_URL = PowerPaintGUI.class.getResource("/resources/icon.gif");
    
    /** The Icon for this Application. */
    private static final Image ICON = new ImageIcon(ICON_URL).getImage();

    /** The Default starting PaintTool (Shape) for this application. */
    private static final PaintTool DEFAULT_TOOL = new LineTool();
    
    /** The frame (top level window) for this application. */
    private final JFrame myFrame;
    
    /** A Panel for drawing on. */
    private final DrawingPanel myPanel;
    
    /** The MenuBar for this application. */
    private final MenuBar myMenuBar;
    
    /** The ToolBar for this application. */
    private final ToolBar myToolBar;
    
    /**
     * Initializes the GUI.
     */
    public PowerPaintGUI() {
        myFrame = new JFrame("\"TCSS 305 - PowerPaint");
        myPanel = new DrawingPanel();
        final ShapeAction initialAction = new ShapeAction(DEFAULT_TOOL, myPanel);
        final AbstractAction[] toolsAction = new AbstractAction[] 
            {initialAction, new ShapeAction(new PencilTool(), myPanel), 
            new ShapeAction(new RectangleTool(), myPanel), 
            new ShapeAction(new RoundRectangleTool(), myPanel), 
            new ShapeAction(new EllipseTool(), myPanel)};

        myMenuBar = new MenuBar(toolsAction, myPanel, ICON_URL);
        myToolBar = new ToolBar(toolsAction);
        initialAction.setEnabled(true);
        myPanel.setTool(DEFAULT_TOOL);
        myPanel.addPropertyChangeListener(myMenuBar);
    }
    
    /** 
     * Sets up the elements for the GUI. 
     */
    public  void start() {
        myFrame.setVisible(false);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.add(myPanel, BorderLayout.CENTER);
        myFrame.setJMenuBar(myMenuBar);
        myFrame.setIconImage(ICON);
        myFrame.add(myToolBar, BorderLayout.SOUTH);
        myFrame.setMinimumSize(null);
        myFrame.pack();
        myFrame.setMinimumSize(myFrame.getSize());
        myFrame.setLocationRelativeTo(null);
        myFrame.setVisible(true);
    }
}
