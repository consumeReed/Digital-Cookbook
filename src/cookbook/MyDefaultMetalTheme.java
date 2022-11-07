package cookbook;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class MyDefaultMetalTheme extends DefaultMetalTheme {
	  public ColorUIResource getWindowTitleInactiveBackground() {
		    return new ColorUIResource(java.awt.Color.DARK_GRAY);
		  }

	  		/**
	  		 * overall background
	  		 */
		  public ColorUIResource getWindowTitleBackground() {
		    return new ColorUIResource(java.awt.Color.DARK_GRAY);
		  }
		  
		  /**
		   * Weird Pattern thing
		   */
		  public ColorUIResource getPrimaryControlHighlight() {
		    return new ColorUIResource(java.awt.Color.DARK_GRAY);
		  }

		  public ColorUIResource getPrimaryControlDarkShadow() {
		    return new ColorUIResource(java.awt.Color.DARK_GRAY);
		  }
		  
		  /**
		   * Buttons and icons
		   */
		  public ColorUIResource getPrimaryControl() {
		    return new ColorUIResource(java.awt.Color.RED);
		  }

		  public ColorUIResource getControlHighlight() {
		    return new ColorUIResource(java.awt.Color.DARK_GRAY);
		  }

		  public ColorUIResource getControlDarkShadow() {
		    return new ColorUIResource(java.awt.Color.DARK_GRAY);
		  }
		  
		  public ColorUIResource getControl() {
		    return new ColorUIResource(java.awt.Color.DARK_GRAY);
		  }
}

