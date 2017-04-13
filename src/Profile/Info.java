package Profile;

import java.awt.AlphaComposite;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Info extends JFrame{
	JPanel p_north,p_south,p_center;
	JLayeredPane layeredPane;
	Canvas can,can2;
	Ellipse2D.Float outCircle;
	JButton circle2;
	CircleButton circle;
	Toolkit kit;
	//Image img;
	BufferedImage img2;
	
	public Info() {
		p_north = new JPanel();
		p_south = new JPanel();
		URL url =this.getClass().getResource("/block.png"); 
		
		try {
			img2 =ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//circle = new CircleButton();
		//circle2= new JButton(icon);
		
		can2 = new Canvas(){
			public void paint(Graphics g) {
				g.drawImage(img2, 0, 0, 50, 50, this);
			
				
			}
		};
		
		
		p_center = new JPanel();
		
		can = new Canvas(){			
			public void paint(Graphics g) {
				
				//g.drawImage((Image)img2, 0, 0,35,35, this);
				
				Path2D p = new Path2D.Double();

				p.append(new RoundRectangle2D.Double(0,0, getWidth(), getHeight(), 200, 200), false);

				//Creates a circular hole at the centre of window
				int radius =300/2, leftX = 300/2-radius, topY = 300/2-radius;
				
				p.append(new Ellipse2D.Double(leftX, topY,2*radius, 2*radius), false);

				
				setShape(p);
				
			}
		};
		
		layeredPane = new JLayeredPane();
		
	
		p_north.setBackground(Color.BLUE);
		p_south.setBackground(Color.WHITE);
	
		
		p_north.setBounds(0, 0, 100, 100);
		p_south.setBounds(0, 100, 100, 100);

		
		can.setBounds(25,75,40,40);
		can2.setBounds(25, 75, 50, 50);
		
		layeredPane.add(p_north,1);
		layeredPane.add(p_south,2);
		layeredPane.add(can2,3,2);
		layeredPane.add(can, 4,3);

		
		System.out.println(layeredPane);
		add(layeredPane);

		//setUndecorated(true); 타이틀바 삭제
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300, 300);
		
	}
	
	public static void main(String[] args) {
		new Info();
	}
}
