package p4;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyPanel extends JPanel{
	public void paintComponent(Graphics g){
        super.paintComponent(g);
        Image image = new ImageIcon("beijing.jpg").getImage();
        g.drawImage(image, 0, 0, this);
    }

}
