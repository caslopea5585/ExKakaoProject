package sample;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class OneRing3 extends JFrame{

    OneRing3(BufferedImage imageBG, BufferedImage imageFG) {
        // presumes the images are identical in size BNI
        int w = imageBG.getWidth();
       int h = imageBG.getHeight();
       
        Ellipse2D.Double ellipse1 = new Ellipse2D.Double(0,0,100,100); 
        Area circle = new Area(ellipse1);
     

        Graphics2D g = imageBG.createGraphics();
       g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       g.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
       g.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        g.setClip(circle);
        
        
        g.drawImage(imageFG, 0, 0, null);
        
        g.setClip(null);
        Stroke s = new BasicStroke(2);
        g.setStroke(s);
        g.setColor(Color.BLACK);
        g.draw(circle);
        g.dispose();

        JLabel l = new JLabel(new ImageIcon(imageBG));
        l.setPreferredSize(new Dimension(900, 900));
        add(l);
        //JOptionPane.showMessageDialog(null, l);
        
        pack();
        setVisible(true);
        
    }

    public static void main(String[] args) throws Exception {
       
       URL urlBG = new URL("file:C:/java_workspace2/ExKakaoProject/res/block.png");
        URL urlFG = new URL("file:C:/java_workspace2/ExKakaoProject/res/duck1.png");
        BufferedImage biFG = ImageIO.read(urlFG);
        BufferedImage biBG = ImageIO.read(urlBG);
       
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new OneRing3(biBG, biFG);
            }
        });
    }
}