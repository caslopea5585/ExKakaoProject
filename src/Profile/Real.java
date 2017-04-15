package Profile;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Real extends JFrame implements ActionListener{
	Canvas north_img,south_img,can_profile;
	//ImageIcon profile;
	JLabel name,la_chat,la_manager,la_profile;
	URL url,url2,url3,url4;
	JPanel p_status;
	BufferedImage bg_north,bg_south,profile,p_background;
	JLayeredPane layeredPane;
	ImageIcon chat,manager;
	RoundButton bt_chat,bt_manager;
	Real real;
	String status_msg;
	
	public Real() {
		real = this;
		layeredPane = new JLayeredPane();
		url = this.getClass().getResource("/bg_north.png");	//상단배경
		url2=this.getClass().getResource("/bg_south.png");	//하단
		url3=this.getClass().getResource("/ryan1.png"); //프로필사진
		
		System.out.println("메인"+url3);
		try {
			bg_north = ImageIO.read(url);
			bg_south = ImageIO.read(url2);
			profile= ImageIO.read(url3);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		north_img = new Canvas(){
			public void paint(Graphics g) {
				   
		       																		//잘라내는 원의 크기를 결정
		        Ellipse2D.Double ellipse1 = new Ellipse2D.Double(99,181,100,98); 
		        Area circle = new Area(ellipse1);
		        
		        g.drawImage(bg_north, 0, 0, 300,250,this);  //백그라운드이미지
		        
		        g.setFont(new Font("돋움", Font.PLAIN, 25));
		        g.setColor(Color.BLACK);
		        status_msg="상태메시지";
		        g.drawString(status_msg, 85, 100);						//상태메시지
		        
		        
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
		};
		south_img = new Canvas(){
			public void paint(Graphics g) {
				g.drawImage((Image)bg_south, 0, 0, 300, 300,this);
			}
		};
		
		
		name = new JLabel("아이디명");
		name.setForeground(Color.black);
		
		ImageIcon chat = new ImageIcon("C:/java_workspace2/ExKakaoProject/res/chat.png");
		bt_chat = new RoundButton(chat);
		
		ImageIcon manager = new ImageIcon("C:/java_workspace2/ExKakaoProject/res/manager.png");
		bt_manager = new RoundButton(manager);
		
		
		la_chat = new JLabel("채팅하기");
		la_chat.setForeground(Color.BLACK);
		la_manager =new JLabel("수정하기");
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
		
				
		
		layeredPane.add(north_img, 1);
		layeredPane.add(name, 2,1);
		layeredPane.add(bt_chat, 3,2);
		layeredPane.add(bt_manager, 4,3);
		layeredPane.add(la_chat, 4,3);
		layeredPane.add(la_manager, 4,3);
		
		
		north_img.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				Object obj =e.getPoint();
				Point p = (Point)obj;
				//x의 범위 116~172 y의 ㅂ범위 201~163
				int x= (int)p.getX();
				int y =(int)p.getY();
				System.out.println(p.getX()+","+p.getY());
				
				if(x>116 && x<172 && y>200&& y<260){
					System.out.println("이미지클릭");
					ProfileImage profileImage = new ProfileImage(real);
				}else{
					System.out.println("노ㅓ작동");
				}
			}
		});
		bt_manager.addActionListener(this);
		la_profile.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				System.out.println("클릭");
				//EditProfile editProfile = new EditProfile(real);
			
			}
		});
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
		}
		
	}
	public static void main(String[] args) {
		new Real();
	}
}
