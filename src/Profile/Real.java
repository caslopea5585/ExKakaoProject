package Profile;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class Real extends JFrame{
	Canvas north_img,south_img,can_profile;
	//ImageIcon profile;
	JLabel status_msg,name;
	URL url,url2,url3,url4;
	BufferedImage bg_north,bg_south,profile,p_background;
	JLayeredPane layeredPane;
	
	
	
	public Real() {
		layeredPane = new JLayeredPane();
		url = this.getClass().getResource("/bg_north.png");
		url2=this.getClass().getResource("/bg_south.png");
		url3=this.getClass().getResource("/default_profile.png");
		url4=this.getClass().getResource("/null.png");
		try {
			bg_north = ImageIO.read(url);
			bg_south = ImageIO.read(url2);
			profile= ImageIO.read(url4);
			p_background=ImageIO.read(url3);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		north_img = new Canvas(){
			public void paint(Graphics g) {
				g.drawImage((Image)bg_north, 0, 0, 300, 280,this);
			}
		};
		south_img = new Canvas(){
			public void paint(Graphics g) {
				g.drawImage((Image)bg_south, 0, 0, 300, 150,this);
			}
		};
		
		can_profile= new Canvas(){
			public void paint(Graphics g) {
				 int w = profile.getWidth();
			       int h = profile.getHeight();
			       
			        Ellipse2D.Double ellipse1 = new Ellipse2D.Double(0,0,50,50); 
			        Area circle = new Area(ellipse1);
			     

			        Graphics2D g2 = (Graphics2D)g;
			       g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			       g2.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
			       g2.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
			        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
			        g2.setClip(circle);
			        
			        g2.drawImage(p_background, 0, 0, null);
			        
			        g2.setClip(null);
			        Stroke s = new BasicStroke(2);
			        g2.setStroke(s);
			        g2.setColor(Color.BLACK);
			        g2.draw(circle);
			        g2.dispose();
			        
			}
		};
		
		
		//                            x  y   width  height
		north_img.setBounds(0, 0, 300, 300);
		south_img.setBounds(0, 280, 300, 150);
		
		can_profile.setBounds(105, 200, 60, 60);
		
		layeredPane.add(north_img, 1);
		layeredPane.add(south_img, 2,1);
		layeredPane.add(can_profile, 3,2);
		
		
		add(layeredPane);
		
		
		setBackground(Color.black);
		setSize(310, 450);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	public static void main(String[] args) {
		new Real();
	}
}
