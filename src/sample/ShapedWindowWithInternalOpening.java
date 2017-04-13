package sample;

 import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

class ShapedWindowWithInternalOpening extends JFrame implements ActionListener
{
JButton   exit = new JButton("Exit");

public ShapedWindowWithInternalOpening() {
super("Shaped Window");
this.setUndecorated(true);

exit.addActionListener(this);

JPanel p1 = new JPanel(new FlowLayout());
p1.add(exit);
this.getContentPane().add(p1, BorderLayout.NORTH);

this.setSize(40,40);
Dimension d = this.getToolkit().getScreenSize();
this.setLocation(d.width/2-250, d.height/2-150);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setVisible(true);
}

@Override
public void paint(Graphics g) {
Path2D p = new Path2D.Double();

p.append(new RoundRectangle2D.Double(0,0, getWidth(), getHeight(), 200, 200), false);

//Creates a circular hole at the centre of window
int radius =getWidth()/2+15, leftX = getWidth()/2-radius, topY = getHeight()/2-radius;
p.append(new Ellipse2D.Double(leftX, topY,2*radius, 2*radius), false);
System.out.println(leftX);
setShape(p);
super.paint(g);
}


public void actionPerformed(ActionEvent ae) {
String com = ae.getActionCommand();
if(com.equals("Exit"))
System.exit(0);
}

public static void main(String arg[]) {
GraphicsDevice gd = GraphicsEnvironment.
getLocalGraphicsEnvironment().getDefaultScreenDevice();
if(!gd.isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.PERPIXEL_TRANSPARENT)) {
JOptionPane.showMessageDialog(null, "No support for shaped window!");
System.exit(0);
}
new ShapedWindowWithInternalOpening();
}
}