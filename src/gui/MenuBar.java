/*
 * TCSS 305 - Autumn 2017
 * Assignment 5b - PowerPaint
 */

package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Builds and manages the Menu Bar for this application.
 * 
 * @author Eviatar Goldschmidtn(evigold@uw.edu).
 * @version Nov 22, 2017.
 */
public class MenuBar extends JMenuBar implements PropertyChangeListener {
    
    /** A generated serialization ID. */
    private static final long serialVersionUID = -8418263068634989642L;

    /** The minimal stroke size for the thickness slide bar. */
    private static final int MIN_THICKNESS = 0;
    
    /** The maximal stroke size for the thickness slide bar. */
    private static final int MAX_THICKNESS = 25;
    
    /** The initial default stroke size.  */
    private static final int INITIAL_THICKNESS = 5;
    
    /** The size of the major spacing in the slide bar. */
    private static final int MAJOR_SPACING = 0;
    
    /** The size of the minor spacing in the slide bar. */
    private static final int MINOR_SPACING = 0;

    /** The Drawing Panel of this application. */
    private final DrawingPanel myPanel;
    
    /** THe clear button for this application. */
    private final JMenuItem myClearButton;
    
    /**
     * Constructs the MenuBar for this application.
     * 
     * @param theToolsActions the different actions for each of the tools to be added to 
     * buttons.
     * @param thePanel the Drawing Panel used in this application.
     * @param theIconURL the URL for the Icon for the about message.
     */
    protected MenuBar(final AbstractAction[] theToolsActions, final DrawingPanel thePanel, 
                   final URL theIconURL) {
        super();
        myClearButton = clearButton();
        options();
        toolsMenu(theToolsActions);
        help(theIconURL);
        myPanel = thePanel;
    }

    /**
     * Creates the menu displaying all the drawing tools for this application.
     * 
     * @param theToolsActions the different actions for each of the tools.
     */
    private void toolsMenu(final AbstractAction[] theToolsActions) {
        final JMenu menu = new JMenu("Tools");
        final ButtonGroup toolButtonGroup = new ButtonGroup();
        for (final AbstractAction toolAction: theToolsActions) {
            final JRadioButtonMenuItem toolButton = new JRadioButtonMenuItem(toolAction);
            toolButtonGroup.add(toolButton);
            menu.add(toolButton);
        }
        add(menu);
    }
    
    /**
     * Creates and returns a JMenu with all the alteration options the user can do to the 
     * drawing tool.
     */
    private void options() {
        final JMenu menu = new JMenu("Options");
        menu.setMnemonic(KeyEvent.VK_P);
        menu.add(thickness());
        menu.addSeparator();
        menu.add(drawColor());
        menu.add(fillColor());
        menu.addSeparator();
        menu.add(fillCheckBox());
        menu.addSeparator();
        menu.add(myClearButton);
        add(menu);
    }
    
    /**
     * Creates and returns the button that clears the Drawing Panel.
     * 
     * @return the button that clears the Drawing Panel.
     */
    private JMenuItem clearButton() {
        final JMenuItem button = new JMenuItem("clear");
        button.setMnemonic(KeyEvent.VK_C);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myPanel.clearPanel();
                button.setEnabled(false);
            }

        });

        button.setEnabled(false);
        return button;
    }
    
    /**
     * Creates and returns a CheckBox menu item telling the application whether to 
     * fill the shapes.
     * 
     * @return A CheckBox of whether to fill in the shapes.
     */
    private JCheckBox fillCheckBox() {
        final JCheckBox box = new JCheckBox("Fill");
        box.setMnemonic(KeyEvent.VK_F);
        box.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(final ItemEvent theEvent) {
                if (theEvent.getStateChange() == ItemEvent.DESELECTED) {
                    myPanel.setFill(false);
                } else if (theEvent.getStateChange() == ItemEvent.SELECTED) {
                    myPanel.setFill(true);
                }
            }
        });
        return box;
    }
    
    /**
     * JMenu that has a single button that opens a window with information about the program.
     * 
     * @param theIconURL the URL for the Icon to be placed in the info window.
     */
    private void help(final URL theIconURL) {
        final JMenu menu = new JMenu("Help");
        menu.setMnemonic(KeyEvent.VK_H);
        final JMenuItem button = new JMenuItem("About...");
        button.setMnemonic(KeyEvent.VK_A);
        button.addActionListener(new ActionListener() {
            @Override 
            public void actionPerformed(final ActionEvent theEvent) {
                final ImageIcon icon = new ImageIcon(theIconURL);
                JOptionPane.showMessageDialog(menu, "TCSS 305 Power Paint\n"
                                + "Autumn 2017 \nEviatar Goldschmidt", "About", 
                                JOptionPane.WARNING_MESSAGE, icon);
                //help.add(la)
            }
        });
        menu.add(button);
        add(menu);
    }
    
    /**
     * The menu item that manages the slider bar for the Stroke thickness and updates changes
     * to the Drawing Panel.
     * 
     * @return a JMenu with a button that opens the Slide Bar for the stroke size.
     */
    private JMenu thickness() {
        final JMenu sliderMenu = new JMenu("Thickness");
        sliderMenu.setMnemonic(KeyEvent.VK_T);
        final JSlider slider = new JSlider(SwingConstants.HORIZONTAL, MIN_THICKNESS, 
                                     MAX_THICKNESS, INITIAL_THICKNESS);
        slider.setMajorTickSpacing(MAJOR_SPACING);
        slider.setMinorTickSpacing(MINOR_SPACING);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(final ChangeEvent arg0) {
                myPanel.setStrokeSize(slider.getValue());
            }
            
        });
        sliderMenu.add(slider);
        return sliderMenu;
    }
    
    /**
     * Menu Item that opens and handles the drawing Color Chooser and sets the new value
     * into the Drawing Panel.
     *  
     * @return the menu item that manages the drawing Color Chooser.
     */
    private JMenuItem drawColor() {
        final JMenuItem button = new JMenuItem("Draw Color...");
        button.setMnemonic(KeyEvent.VK_D);
        button.addActionListener(new ActionListener() {
                public void actionPerformed(final ActionEvent theEvent) {
                    myPanel.setDrawColor(JColorChooser.showDialog(button, "Draw Color", 
                                                      myPanel.getDrawColor()));
                }
            });
        return button;
    }
    
    /**
     * Menu Item that opens and handles the fill Color Chooser and sets the new value
     * into the Drawing Panel.
     *  
     * @return the menu item that manages the fill Color Chooser.
     */
    private JMenuItem fillColor() {
        final JMenuItem button = new JMenuItem("fill Color...");
        button.setMnemonic(KeyEvent.VK_I);
        button.addActionListener(new ActionListener() {
                public void actionPerformed(final ActionEvent theEvent) {
                    myPanel.setFillColor(JColorChooser.showDialog(button, "fill Color", 
                                                      myPanel.getFillColor()));
                }
            });
        return button;
    }

    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if ("clearPanel".equals(theEvent.getPropertyName())) {
            myClearButton.setEnabled(true);
        }
    }
}
