package p4;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Welcome2 extends JLabel{
	String str;
	static Icon icon = new ImageIcon("welcome2.jpg");
	public Welcome2(String str) {
		this.str = str;
		this.initialFrame();
	}
	public void initialFrame() {
		this.setIcon(icon);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setVerticalAlignment(JLabel.CENTER);
	}
}
