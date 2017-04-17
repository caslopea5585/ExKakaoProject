package Profile;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Real extends JFrame implements ActionListener,Runnable{
	Canvas north_img,south_img,can_profile;
	//ImageIcon profile;
	JLabel name,la_chat,la_manager,la_profile;
	URL url,url2,url3,url4;
	JPanel p_status;
	BufferedImage bg_north,bg_south,profile,p_background;
	JLayeredPane layeredPane;
	ImageIcon chat,manager;
	RoundButton bt_chat,bt_manager,bt_back_profile;
	Real real;
	String status_msg="���¸޽���";
	JFileChooser chooser;
	Thread thread;
	
	public Real() {
		real = this;
		layeredPane = new JLayeredPane();
		url = this.getClass().getResource("/bg_north.png");	//��ܹ��
		url2=this.getClass().getResource("/bg_south.png");	//�ϴ�
		url3=this.getClass().getResource("/ryan1.png"); //�����ʻ���
		
		System.out.println("����"+url3);
		try {
		
			bg_south = ImageIO.read(url2);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		north_img = new Canvas(){
			public void paint(Graphics g) {
				   
				try {
					bg_north = ImageIO.read(url);
					profile= ImageIO.read(url3);
				} catch (IOException e) {
					e.printStackTrace();
				}		
																					//�߶󳻴� ���� ũ�⸦ ����
		        Ellipse2D.Double ellipse1 = new Ellipse2D.Double(99,181,100,98); 
		        Area circle = new Area(ellipse1);
		        
		        g.drawImage(bg_north, 0, 0, 300,250,this);  //��׶����̹���
		        
		        g.setFont(new Font("����", Font.PLAIN, 25));
		        g.setColor(Color.BLACK);
		        
		        g.drawString(status_msg, 85, 100);						//���¸޽���
		        
		        
		        Graphics2D g2 =(Graphics2D) g;
		        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		        g2.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
		        g2.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		        g2.setClip(circle);
		        
		        g2.drawImage(profile, 100,180,100, 100, null);
		        g2.setColor(Color.WHITE);
		        g2.setClip(null);
		        Stroke s = new BasicStroke(2);
		        g2.setStroke(s);
		        g2.setColor(Color.BLACK);
		        g2.draw(circle);
		        g2.dispose();
		        
			}
			protected void paintComponent(Graphics g) {
				Graphics2D g2 =(Graphics2D) g;
				System.out.println("dddd");
			}
			
			public void update(Graphics g) {
				
				super.update(g);
			}
			
		};
		south_img = new Canvas(){
			public void paint(Graphics g) {
				g.drawImage((Image)bg_south, 0, 0, 300, 300,this);
			}
		};
		
		
		name = new JLabel("���̵��");
		name.setForeground(Color.black);
		
		ImageIcon chat = new ImageIcon("C:/java_workspace2/ExKakaoProject/res/chat.png");
		bt_chat = new RoundButton(chat);
		
		ImageIcon manager = new ImageIcon("C:/java_workspace2/ExKakaoProject/res/manager.png");
		bt_manager = new RoundButton(manager);
		
		ImageIcon back_profile = new ImageIcon("C:/java_workspace2/ExKakaoProject/res/back_select.png");
		bt_back_profile = new RoundButton(back_profile);
		
		chooser= new JFileChooser("C:/java_workspace2/ExKakaoProject/res");
		thread = new Thread(this);
		thread.start();
		
		
		la_chat = new JLabel("ä���ϱ�");
		la_chat.setForeground(Color.BLACK);
		la_manager =new JLabel("�����ϱ�");
		la_manager.setForeground(Color.BLACK);
		la_profile= new JLabel("dddddd");
		la_profile.setForeground(Color.BLACK);
		
		
		

		//                            x  y   width  height
		north_img.setBounds(0, 0, 300, 300);
		name.setBounds(115, 280, 70, 50);
		bt_chat.setBounds(65, 340, 50, 50);
		bt_manager.setBounds(165, 340, 50, 50);
		la_chat.setBounds(65, 390, 70, 30);
		la_manager.setBounds(165, 390, 70, 30);
		bt_back_profile.setBounds(245, 250, 45, 45);
				
		
		layeredPane.add(north_img, 1);
		layeredPane.add(name, 2,1);
		layeredPane.add(bt_chat, 3,2);
		layeredPane.add(bt_manager, 4,3);
		layeredPane.add(la_chat, 4,3);
		layeredPane.add(la_manager, 4,3);
		layeredPane.add(bt_back_profile, 4,3);
		
		
		north_img.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				Object obj =e.getPoint();
				Point p = (Point)obj;
				//x�� ���� 116~172 y�� ������ 201~163
				int x= (int)p.getX();
				int y =(int)p.getY();
				System.out.println(p.getX()+","+p.getY());
				
				if(x>116 && x<172 && y>200&& y<260){
					System.out.println("�̹���Ŭ��");
					ProfileImage profileImage = new ProfileImage(real);
				}else{
					System.out.println("����۵�");
				}
			}
		});
		
		
		bt_manager.addActionListener(this);
		la_profile.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				System.out.println("Ŭ��");
				//EditProfile editProfile = new EditProfile(real);
			
			}
		});
		bt_back_profile.addActionListener(this);
		
		
		add(layeredPane);
		
		
		
		setBackground(Color.WHITE);
		setSize(310, 460);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==bt_manager){
			EditProfile editProfile = new EditProfile(this);
		}else if(obj==bt_back_profile){
			int result = chooser.showOpenDialog(this);
			if(result == JFileChooser.APPROVE_OPTION){
				File file = chooser.getSelectedFile();
				url=this.getClass().getResource("/"+file.getName()+""); //�����ʻ���
				
				north_img.repaint();
			}
		}
		
	}
	
	
	public void run() {
		while(true){
			north_img.repaint();
			south_img.repaint();
			
		}
		
	}
	
	public static void main(String[] args) {
		new Real();
	}
}
