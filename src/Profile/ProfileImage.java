package Profile;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JDialog;

public class ProfileImage extends JDialog{
	Real real;
	Canvas can;
	
	public ProfileImage(Real real) {
		this.real = real;
		can = new Canvas(){
			public void paint(Graphics g) {
				g.drawImage((Image)real.profile,0, 0, 300, 300, this);
			}
		};
		
		add(can);
		
		setVisible(true);
		setLocationRelativeTo(real);
		pack();
		setSize(400, 400);
	}
}
