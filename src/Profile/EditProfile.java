package Profile;

import javax.swing.JDialog;

public class EditProfile extends JDialog{
	Real real;
	
	
	public EditProfile(Real real) {
		this.real = real;
		
		
		
		
		
		setVisible(true);
		setLocationRelativeTo(real);
		setSize(500,500);
		
		
	}
}
