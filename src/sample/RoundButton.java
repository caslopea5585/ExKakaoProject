package sample;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public final class RoundButton extends JButton{
	ImageIcon icon;
	Insets m;
	JLayeredPane layeredPane;
	
	public RoundButton(ImageIcon icon) {
		
	    super(icon);

	    
	 
	   // setBackground(Color.WHITE);
	    setFocusable(false);
	 
	    /*
	     These statements enlarge the button so that it 
	     becomes a circle rather than an oval.
	    */
	    Dimension size = getPreferredSize();
	    //size.width = size.height = Math.max(size.width, size.height);
	    //setPreferredSize(size);
	 
	    /*
	     This call causes the JButton not to paint the background.
	     This allows us to paint a round background.
	    */
	    m= new Insets(0, 0, 0, 0);
	    setContentAreaFilled(false);
	    setMargin(m);
	    setOpaque(false);
	    
	  }
	 
	  protected void paintComponent(Graphics g) {
	    if (getModel().isArmed()) {
	      g.setColor(Color.RED);
	    } else {
	      g.setColor(getBackground());
	    }
	    g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
	 
	    super.paintComponent(g);
	  }
	 
	  protected void paintBorder(Graphics g) {
	    g.setColor(Color.BLUE);
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
	 
	  public static void main(String[] args) {
	 
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    JFrame frame = new JFrame("Rounded Button Example");
	    frame.setLayout(new FlowLayout());
	    
	    
	    ImageIcon icon = new ImageIcon("C:/java_workspace2/ExKakaoProject/res/duck1.png");
	    
	    JButton b1 = new RoundButton(icon);
	    JButton b2 = new RoundButton(icon);
	 
	    
	    
	    
	    frame.add(b1);
	    frame.add(b2);
	 
	    frame.setSize(500, 150);
	    frame.setBackground(Color.black);
	    frame.setVisible(true);
	  }
}