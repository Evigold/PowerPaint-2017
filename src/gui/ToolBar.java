/*
 * TCSS 305 - Autumn 2017
 * Assignment 5b - PowerPaint
 */

package gui;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * Builds and manages the TollBar for this application.
 * 
 * @author Eviatar Goldschmidtn(evigold@uw.edu).
 * @version Nov 22, 2017.
 */
public class ToolBar  extends JToolBar {

    /** A generated serialization ID. */
    private static final long serialVersionUID = -1006152772883356455L;

    /**
     * Constructs the JToolBar.
     * 
     * @param theToolsActions all the tools actions.
     */
    public ToolBar(final AbstractAction[] theToolsActions) {
        super();
        final ButtonGroup toolButtonGroup = new ButtonGroup();
        for (final AbstractAction toolAction: theToolsActions) {
            final JToggleButton toolButton = new JToggleButton(toolAction);
            toolButtonGroup.add(toolButton);
            add(toolButton);
        }
        toolButtonGroup.clearSelection();
    }
}