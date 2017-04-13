package Profile;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Main extends JFrame{
	JPanel p_north,p_south;
	Canvas profile_image;
	URL url;
	Image img;
	CircleButton circle;
	JLayeredPane layeredPane;
	
	
	public Main() {
		
		p_north = new JPanel();
		p_south = new JPanel();
		url = this.getClass().getResource("/duck1.png");
		
		profile_image = new Canvas(){
			
			public void paint(Graphics g) {
				g.drawImage(img, 35, 70, 50, 50, this);
			}
		};
		circle = new CircleButton();
		layeredPane = new JLayeredPane();
		
		p_north.setBackground(Color.BLACK);
		p_south.setBackground(Color.YELLOW);
		
		p_north.setPreferredSize(new Dimension(300, 300));
		p_south.setPreferredSize(new Dimension(300, 300));
		profile_image.setPreferredSize(new Dimension(70, 70));
		circle.setPreferredSize(new Dimension(50, 50));
		
		layeredPane.add(profile_image, 1);
		layeredPane.add(p_north, 2);
		layeredPane.add(p_south, 3);
		layeredPane.add(circle, 4,3);
		
		add(layeredPane);
		
		
		setSize(350,370);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
}
