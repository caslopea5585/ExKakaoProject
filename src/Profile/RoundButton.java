package Profile;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RoundButton extends JButton {
	ImageIcon icon;
	
	public RoundButton(ImageIcon icon) {
		super(icon);
		
		setContentAreaFilled(false);
	    setOpaque(false);
		setBorderPainted(true);
		
	}
	protected void paintComponent(Graphics g) {
		/*
		if (getModel().isArmed()) {
			System.out.println("³ª´­·¶¾î?");
			g.setColor(new Color(233, 233, 233));
		} else {
			g.setColor(new Color(233, 233, 233));
		}
		*/
		
		//g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
		
		super.paintComponent(g);
	}
	  protected void paintBorder(Graphics g) {
		    g.setColor(new Color(233, 233, 233));
		    g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
		 }

	// Hit detection.
	Shape shape;
	
	public boolean contains(int x, int y) {
		// If the button has changed size,  make a new shape object.
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
			
		}
		return shape.contains(x, y);
		
	}
	

}
