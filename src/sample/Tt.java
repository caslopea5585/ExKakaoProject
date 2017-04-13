package sample;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class Tt extends JFrame{
	Canvas can,can2;
	URL url;
	BufferedImage img;
	JLayeredPane layeredPane;
	
	public Tt() {
		layeredPane = new JLayeredPane();
		url = this.getClass().getResource("/block.png");
		try {
			img = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		can = new Canvas(){
			public void paint(Graphics g) {
				Path2D p = new Path2D.Double();

				p.append(new RoundRectangle2D.Double(0,0, getWidth(), getHeight(), 200, 200), false);
				System.out.println(getWidth());
				//Creates a circular hole at the centre of window
				int radius =getWidth()/2+15, leftX = getWidth()/2-radius, topY = getHeight()/2-radius;
				p.append(new Ellipse2D.Double(leftX, topY,2*radius, 2*radius), false);

				//setShape(p);
				
			}
		};
		
		
		can2 = new Canvas(){
			
			public void paint(Graphics g) {
				System.out.println("Ddd");
				g.drawImage(img, 50, 50, 150, 150, this);
				
			}
		};
		
		//can.setBounds(0, 0, 50, 50);
		//can2.setBounds(0, 0, 50, 50);
		
		//layeredPane.add(can,1);
		layeredPane.add(can2,1);
		layeredPane.add(can,2,1);
		add(layeredPane);
		
		setBackground(Color.BLACK);
		//add(can2);
		setSize(40,40);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	public static void main(String[] args) {
		new Tt();
	}
}
