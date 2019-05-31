package p4;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
@SuppressWarnings("serial")
public class Alter_Stu_grade extends JPanel implements ActionListener{
	private Connection con = null;
	private Statement statement = null;
	private ResultSet res = null;
	private JLabel labSno = new JLabel("请输入要修改的学生学号：");
	private JLabel[] lab = {
			new JLabel("学号："), new JLabel("姓名："), new JLabel("课程名："),
			new JLabel("成绩："),new JLabel("(此处不允许修改)"),new JLabel("(此处不允许修改)"),
			new JLabel("(此处不允许修改)")
	};
	private JTextField labsno = new JTextField();
	private JTextField labname = new JTextField();
	private JTextField labcourse = new JTextField();
	private JTextField txtSno = new JTextField();
	private JTextField txtgrade = new JTextField();
	private JButton query = new JButton("确定");
	private JButton alter = new JButton("修改");
	private String[] gradeinfo = new String[3];
	private String sno = "";
	public Alter_Stu_grade() {
		this.initialFrame();
		this.addListener();
	}
	private void addListener() {
		txtSno.addActionListener(this);
		query.addActionListener(this);
		alter.addActionListener(this);
	}
	private void initialFrame() {
		this.setLayout(null);
		labSno.setBounds(300, 20, 200, 30);
		this.add(labSno);
		txtSno.setBounds(480, 20, 150, 30);
		this.add(txtSno);
		query.setBounds(670, 20, 100, 30);
		this.add(query);
		lab[0].setBounds(400, 100, 150, 25);  //学号
		this.add(lab[0]);
		lab[1].setBounds(400, 150, 150, 25);  //姓名
		this.add(lab[1]);
		lab[2].setBounds(400, 200, 150, 25);  //课程
		this.add(lab[2]);
		lab[3].setBounds(400, 250, 150, 25);  //成绩
		this.add(lab[3]);
		txtgrade.setText("");
		txtgrade.setBounds(510, 250, 150, 25);
		this.add(txtgrade);
		alter.setBounds(500, 320, 150, 30);
		this.add(alter);
		labsno.setText("");
		labsno.setBounds(510, 100, 150, 25);
		this.add(labsno);
		labsno.setEditable(false);
		lab[4].setBounds(665, 100, 150, 25);
		this.add(lab[4]);
		labname.setText("");
		labname.setBounds(510,150,150,25);
		this.add(labname);
		labname.setEditable(false);
		lab[5].setBounds(665, 150, 150, 25);
		this.add(lab[5]);
		labcourse.setText("");
		labcourse.setBounds(510, 200, 150, 25);
		this.add(labcourse);
		labcourse.setEditable(false);
		lab[6].setBounds(665, 200, 150, 25);
		this.add(lab[6]);
	}
	int i = 0;
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == txtSno||e.getSource() == query) {
			sno = txtSno.getText();
			if(sno.equals("")) {
				JOptionPane.showMessageDialog(this, "请输入学生学号！", "错误", JOptionPane.ERROR_MESSAGE);
				return ;
			}
			else {
				int score;
				try {
					con = new connection().getConnection();
					statement = con.createStatement();
					String sql1 = "select * from T_g where Sno='"+sno+"'";
					res = statement.executeQuery(sql1);
					if(res.next()) {
						gradeinfo[0] = res.getString(1);
						gradeinfo[1] = res.getString(2);
						gradeinfo[2] = res.getString(3);
						score = res.getInt(4);				
						labsno.setText(gradeinfo[0]);	
						labname.setText(gradeinfo[1]);			
						labcourse.setText(gradeinfo[2]);
						txtgrade.setText(score+"");
					}else {
						JOptionPane.showMessageDialog(this, "查无此人！", "错误", JOptionPane.ERROR_MESSAGE);
						return ;
					}
					if(res != null) {
					res.close();
					}
					if(statement != null) {
						statement.close();
					}
					if(con != null) {
						con.close();
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}
		}else if(e.getSource() == alter) {
			String newScore = txtgrade.getText().trim();
			int a = Integer.parseInt(newScore);
			
				try {
					con = new connection().getConnection();
					statement = con.createStatement();
					String sql1 = "update sc set grade='"+a+"' where sno='"+sno+"'";
					int i=statement.executeUpdate(sql1);
					System.out.println(i);
					if(i==1) {
						JOptionPane.showMessageDialog(this, "修改学生信息成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
						return ;
					}
					else
					{ 
						JOptionPane.showMessageDialog(this, "修改学生信息失败", "错误", JOptionPane.ERROR_MESSAGE);
						return ;
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
		}
	}
			
	public void setFocus() {
		txtSno.requestFocus(true);
	}
}
