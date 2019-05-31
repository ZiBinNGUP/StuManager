package p4;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class BySnoQuery extends JPanel implements ActionListener{
	private JLabel[] label ={new JLabel("ѧ    �ţ�"), new JLabel("��    ����"), new JLabel("��    ��"),
			new JLabel("��    �壺"), new JLabel("��ѧʱ�䣺"), new JLabel("ѧ    Ժ��"), new JLabel("ר    ҵ��"),
			new JLabel("��    ����"), new JLabel("��    �᣺"), new JLabel("�������ڣ�"), 
			new JLabel("��ϵ��ʽ��")
	};
	private JLabel[] date = {
		new JLabel("��"), new JLabel("��"), new JLabel("��"),
		new JLabel("��"), new JLabel("��"), new JLabel("��")
	};
	private JLabel labSno = new JLabel("������Ҫ��ѯѧ����ѧ�ţ�");
	private JTextField txtSno = new JTextField();
	private JButton query = new JButton("��ѯ");
	private JLabel[] display = new JLabel[15];
	private GetStuInfo getInfo;
	public BySnoQuery() {
		getInfo = new GetStuInfo();
		this.initialFrame();
		this.AddListener();
	}
	private void AddListener() {
		txtSno.addActionListener(this);
		query.addActionListener(this);
		
	}
	private void initialFrame() {
		this.setLayout(null);
		labSno.setBounds(300, 20, 200, 30);
		this.add(labSno);
		txtSno.setBounds(480, 20, 150, 30);
		this.add(txtSno);
		query.setBounds(670, 20, 100, 30);
		this.add(query);
//		this.getRootPane().setDefaultButton(query);
	}
	int i = 0;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == txtSno||e.getSource() == query) {
			String Sno = txtSno.getText();
			if(Sno.equals("")) {
				JOptionPane.showMessageDialog(this, "������ѧ��ѧ�ţ�", "����", JOptionPane.ERROR_MESSAGE);
				return ;
			}
			else {
				String[] stuinfo = getInfo.getBaseInfo(Sno);
				if(stuinfo[0] == null) {
					JOptionPane.showMessageDialog(this, "���޴��ˣ�", "����", JOptionPane.ERROR_MESSAGE);
					return ;
				}else {
					if(i>0) {
						for(int j = 0; j <15; j++) {
							this.remove(display[j]);
						}
					}
					i=i+1;
//					this.removeAll();
					Font font1 = new Font("����",Font.BOLD,20);
					Font font2 = new Font("����",Font.BOLD,25);
					for(int j = 0; j < 11; j++) {
						label[j].setFont(font1);
						label[j].setForeground(Color.BLUE);
					}
					for(int j = 0; j < 6; j++) {
						date[j].setFont(font1);
						date[j].setForeground(Color.green);
					}
					
					label[0].setBounds(400, 100, 150, 25);  //ѧ��
					this.add(label[0]);
					display[0] = new JLabel(stuinfo[0]);
					display[0].setBounds(510, 100, 200, 25);
					this.add(display[0]);
					label[1].setBounds(400, 150, 150, 25);  //����
					this.add(label[1]);
					display[1] = new JLabel(stuinfo[1]);
					display[1].setBounds(510,150,200,25);
					this.add(display[1]);
					label[2].setBounds(400, 200, 150, 25);  //�Ա�
					this.add(label[2]);
					display[2] = new JLabel(stuinfo[2]);
					display[2].setBounds(510, 200, 100, 25);
					this.add(display[2]);
					label[3].setBounds(400, 250, 150, 25);  //����
					this.add(label[3]);
					display[3] = new JLabel(stuinfo[3]);
					display[3].setBounds(510, 250, 200, 25);
					this.add(display[3]);
					label[5].setBounds(400, 300, 150, 25);  //ѧԺ
					this.add(label[5]);
					display[4] = new JLabel(stuinfo[4]);
					display[4].setBounds(510, 300, 300, 25);
					this.add(display[4]);
					label[6].setBounds(400, 350, 150, 25);  //רҵ
					this.add(label[6]);
					display[5] = new JLabel(stuinfo[5]);
					display[5].setBounds(510, 350, 300, 25);
					this.add(display[5]);
					label[7].setBounds(400, 400, 150, 25);  //�༶
					this.add(label[7]);
					display[6] = new JLabel(stuinfo[6]);
					display[6].setBounds(510, 400, 300, 25);
					this.add(display[6]);
					label[4].setBounds(400, 450, 150, 25);  //��ѧʱ��
					this.add(label[4]);
					display[9] = new JLabel(stuinfo[7]);
					display[9].setBounds(510, 450, 60, 25);
					this.add(display[9]);
					date[0].setBounds(575, 450, 50, 25);
					this.add(date[0]);
					display[10] = new JLabel(stuinfo[8]);
					display[10].setBounds(620, 450, 60, 25);
					this.add(display[10]);
					date[1].setBounds(665, 450, 50, 25);
					this.add(date[1]);
					display[11] = new JLabel(stuinfo[9]);
					display[11].setBounds(710, 450, 60, 25);
					this.add(display[11]);
					date[2].setBounds(755, 450, 50, 25);
					this.add(date[2]);
					label[8].setBounds(400, 500, 150, 25);  //����
					this.add(label[8]);
					display[7] = new JLabel(stuinfo[10]);
					display[7].setBounds(510, 500, 200, 25);
					this.add(display[7]);
					label[9].setBounds(400, 550, 150, 25);  //��������
					this.add(label[9]);
					display[12] = new JLabel(stuinfo[11]);
					display[12].setBounds(510, 550, 60, 25);
					this.add(display[12]);
					date[3].setBounds(575, 550, 50, 25);
					this.add(date[3]);
					display[13] = new JLabel(stuinfo[12]);
					display[13].setBounds(620, 550, 60, 25);
					this.add(display[13]);
					date[4].setBounds(665, 550, 50, 25);
					this.add(date[4]);
					display[14] = new JLabel(stuinfo[13]);
					display[14].setBounds(710, 550, 60, 25);
					this.add(display[14]);
					date[5].setBounds(755, 550, 50, 25);
					this.add(date[5]);
					label[10].setBounds(400, 600, 150, 25);  //��ϵ��ʽ
					this.add(label[10]);
					display[8] = new JLabel(stuinfo[14]);
					display[8].setBounds(510, 600, 200, 25);
					this.add(display[8]);
					for(int j = 0;j < 15; j++) {
						display[j].setFont(font2);
						display[j].setForeground(Color.RED);
					}
					this.repaint();
				}
			}
		}
	}
	public void setFocus() {
		txtSno.requestFocus(true);
	}
}
