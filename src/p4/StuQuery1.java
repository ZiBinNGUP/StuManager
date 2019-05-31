package p4;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StuQuery1 extends JPanel{
	private JLabel[] label ={new JLabel("学号："), new JLabel("姓名："), new JLabel("性别："),
			new JLabel("民族："), new JLabel("入学时间："), new JLabel("学院："), new JLabel("专业："),
			new JLabel("班级："), new JLabel("籍贯："), new JLabel("出生日期："), 
			new JLabel("联系方式：")
	};
	private JLabel[] date = {
		new JLabel("年"), new JLabel("月"), new JLabel("日"),
		new JLabel("年"), new JLabel("月"), new JLabel("日")
	};
	private JLabel[] display = new JLabel[15];
	private GetStuInfo getInfo;
	private String Sno;
	public StuQuery1(String Sno) {
		this.Sno = Sno;
		getInfo = new GetStuInfo();
		this.initialFrame();
	}
	private void initialFrame() {
		this.setLayout(null);
		String[] stuinfo = getInfo.getBaseInfo(Sno);
		if(stuinfo[0] == null) {
			JOptionPane.showMessageDialog(this, "无此人信息！", "错误", JOptionPane.ERROR_MESSAGE);
			return ;
		}else {
			this.removeAll();
			label[0].setBounds(200, 40, 150, 25);  //学号
			this.add(label[0]);
			display[0] = new JLabel(stuinfo[0]);
			display[0].setBounds(260, 40, 200, 25);
			this.add(display[0]);
			label[1].setBounds(200, 80, 150, 25);  //姓名
			this.add(label[1]);
			display[1] = new JLabel(stuinfo[1]);
			display[1].setBounds(260,80,200,25);
			this.add(display[1]);
			label[2].setBounds(200, 120, 150, 25);  //性别
			this.add(label[2]);
			display[2] = new JLabel(stuinfo[2]);
			display[2].setBounds(260, 120, 100, 25);
			this.add(display[2]);
			label[3].setBounds(200, 160, 150, 25);  //民族
			this.add(label[3]);
			display[3] = new JLabel(stuinfo[3]);
			display[3].setBounds(260, 160, 200, 25);
			this.add(display[3]);
			label[5].setBounds(200, 200, 150, 25);  //学院
			this.add(label[5]);
			display[4] = new JLabel(stuinfo[4]);
			display[4].setBounds(260, 200, 200, 25);
			this.add(display[4]);
			label[6].setBounds(200, 240, 150, 25);  //专业
			this.add(label[6]);
			display[5] = new JLabel(stuinfo[5]);
			display[5].setBounds(260, 240, 200, 25);
			this.add(display[5]);
			label[7].setBounds(200, 280, 150, 25);  //班级
			this.add(label[7]);
			display[6] = new JLabel(stuinfo[6]);
			display[6].setBounds(260, 280, 200, 25);
			this.add(display[6]);
			label[4].setBounds(200, 320, 150, 25);  //入学时间
			this.add(label[4]);
			display[9] = new JLabel(stuinfo[7]);
			display[9].setBounds(280, 320, 60, 25);
			this.add(display[9]);
			date[0].setBounds(325, 320, 50, 25);
			this.add(date[0]);
			display[10] = new JLabel(stuinfo[8]);
			display[10].setBounds(380, 320, 60, 25);
			this.add(display[10]);
			date[1].setBounds(415, 320, 50, 25);
			this.add(date[1]);
			display[11] = new JLabel(stuinfo[9]);
			display[11].setBounds(470, 320, 60, 25);
			this.add(display[11]);
			date[2].setBounds(505, 320, 50, 25);
			this.add(date[2]);
			label[8].setBounds(200, 360, 150, 25);  //籍贯
			this.add(label[8]);
			display[7] = new JLabel(stuinfo[10]);
			display[7].setBounds(260, 360, 200, 25);
			this.add(display[7]);
			label[9].setBounds(200, 400, 150, 25);  //出生日期
			this.add(label[9]);
			display[12] = new JLabel(stuinfo[11]);
			display[12].setBounds(280, 400, 60, 25);
			this.add(display[12]);
			date[3].setBounds(325, 400, 50, 25);
			this.add(date[3]);
			display[13] = new JLabel(stuinfo[12]);
			display[13].setBounds(380, 400, 60, 25);
			this.add(display[13]);
			date[4].setBounds(415, 400, 50, 25);
			this.add(date[4]);
			display[14] = new JLabel(stuinfo[13]);
			display[14].setBounds(470, 400, 60, 25);
			this.add(display[14]);
			date[5].setBounds(505, 400, 50, 25);
			this.add(date[5]);
			label[10].setBounds(200, 440, 150, 25);  //联系方式
			this.add(label[10]);
			display[8] = new JLabel(stuinfo[14]);
			display[8].setBounds(260, 440, 200, 25);
			this.add(display[8]);	
			this.repaint();
		}
	}
}
