/*
 * TCSS 305 - Autumn 2017
 * Assignment 5b - PowerPaint
 */

package gui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import tools.PaintTool;

/**
 * The Action for selecting a tool.
 * 
 * @author Eviatar Goldschmidt (evigold@uw.edu).
 * @version Nov 22, 2017.
 */
public class ShapeAction extends AbstractAction {

    /** A generated serialization ID. */
    private static final long serialVersionUID = 2740408929251430441L;

    /** The Paint Tool of this Action. */
    private final PaintTool myTool;
    
    /** The DrawingPanel for this action to perform on. */
    private final DrawingPanel myPanel;
    
    /**
     * Initializes the ShapeAction object. 
     * 
     * @param theTool The PaintTool for this Shape Action.
     * @param thePanel the DrawingPanel for this action to perform on.
     */
    public ShapeAction(final PaintTool theTool, final DrawingPanel thePanel) {
        super(theTool.getName(), theTool.getIcon());
        setup(theTool);
        myTool = theTool;
        myPanel = thePanel;
    }
    
    /** 
     * Simplifies the initiation and setup of the action.
     * 
     * @param theTool The PaintTool for this Shape Action.
     */
    private void setup(final PaintTool theTool) {
        putValue(Action.SMALL_ICON, theTool.getIcon());
        final ImageIcon icon = (ImageIcon) theTool.getIcon();
        final Image largeImage =
            icon.getImage().getScaledInstance(15, -1, java.awt.Image.SCALE_SMOOTH);
        final ImageIcon largeIcon = new ImageIcon(largeImage);
        putValue(Action.LARGE_ICON_KEY, largeIcon);
        putValue(Action.MNEMONIC_KEY, 
                 KeyEvent.getExtendedKeyCodeForChar(theTool.getName().charAt(0)));
        putValue(Action.SHORT_DESCRIPTION, theTool.getName());
        putValue(Action.SELECTED_KEY, true);
        
    }
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        myPanel.setTool(myTool);
    }
 
    /**
     * Returns the PaintTool of this Action.
     * 
     * @return the paintTool of this action.
     */
    public PaintTool getTool() {
        return myTool;
    }
}
