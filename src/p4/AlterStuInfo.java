package p4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AlterStuInfo extends JPanel implements ActionListener{
	private Connection con = null;
	private Statement statement = null;
	private ResultSet res = null;
	private JLabel[] label ={new JLabel("学    号："), new JLabel("姓    名："), new JLabel("性    别："),
			new JLabel("民    族："), new JLabel("入学时间："), new JLabel("学    院："), new JLabel("专    业："),
			new JLabel("班    级："), new JLabel("籍    贯："), new JLabel("出生日期："), 
			new JLabel("联系方式：")
	};
	private JTextField[] txt = {new JTextField(), new JTextField(), new JTextField(), new JTextField(),
			new JTextField(), new JTextField(), new JTextField(), new JTextField(), new JTextField(),
			new JTextField(8), new JTextField(8), new JTextField(8), new JTextField(8), new JTextField(8),
			new JTextField(8)
	};
	private JLabel[] date = {
			new JLabel("年"), new JLabel("月"), new JLabel("日"),
			new JLabel("年"), new JLabel("月"), new JLabel("日")
		};
	private JLabel labSno = new JLabel("请输入要修改的学生学号：");
	private JLabel labsno = new JLabel("");
	private JTextField txtSno = new JTextField();
	private JButton query = new JButton("确定");
	private JButton alter = new JButton("修改");
	private GetStuInfo getInfo;
	private String sno = "";
	public AlterStuInfo() {
		getInfo = new GetStuInfo();
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
		label[0].setBounds(400, 100, 150, 25);  //学号
		this.add(label[0]);
		label[1].setBounds(400, 150, 150, 25);  //姓名
		this.add(label[1]);
		txt[1].setText("");
		txt[1].setBounds(510,150,200,25);
		this.add(txt[1]);
		label[2].setBounds(400, 200, 150, 25);  //性别
		this.add(label[2]);
		txt[2].setText("");
		txt[2].setBounds(510, 200, 100, 25);
		this.add(txt[2]);
		label[3].setBounds(400, 250, 150, 25);  //民族
		this.add(label[3]);
		txt[3].setText("");
		txt[3].setBounds(510, 250, 200, 25);
		this.add(txt[3]);
		label[5].setBounds(400, 300, 150, 25);  //学院
		this.add(label[5]);
		txt[4].setText("");
		txt[4].setBounds(510, 300, 300, 25);
		this.add(txt[4]);
		label[6].setBounds(400, 350, 150, 25);  //专业
		this.add(label[6]);
		txt[5].setText("");
		txt[5].setBounds(510, 350, 300, 25);
		this.add(txt[5]);
		label[7].setBounds(400, 400, 150, 25);  //班级
		this.add(label[7]);
		txt[6].setText("");
		txt[6].setBounds(510, 400, 300, 25);
		this.add(txt[6]);
		label[4].setBounds(400, 450, 150, 25);  //入学时间
		this.add(label[4]);
		txt[9].setText("");
		txt[9].setBounds(510, 450, 60, 25);
		this.add(txt[9]);
		date[0].setBounds(575, 450, 50, 25);
		this.add(date[0]);
		txt[10].setText("");;
		txt[10].setBounds(620, 450, 40, 25);
		this.add(txt[10]);
		date[1].setBounds(665, 450, 50, 25);
		this.add(date[1]);
		txt[11].setText("");;
		txt[11].setBounds(710, 450, 40, 25);
		this.add(txt[11]);
		date[2].setBounds(755, 450, 50, 25);
		this.add(date[2]);
		label[8].setBounds(400, 500, 150, 25);  //籍贯
		this.add(label[8]);
		txt[7].setText("");
		txt[7].setBounds(510, 500, 200, 25);
		this.add(txt[7]);
		label[9].setBounds(400, 550, 150, 25);  //出生日期
		this.add(label[9]);
		txt[12].setText("");
		txt[12].setBounds(510, 550, 60, 25);
		this.add(txt[12]);
		date[3].setBounds(575, 550, 50, 25);
		this.add(date[3]);
		txt[13].setText("");
		txt[13].setBounds(620, 550, 40, 25);
		this.add(txt[13]);
		date[4].setBounds(665, 550, 50, 25);
		this.add(date[4]);
		txt[14].setText("");
		txt[14].setBounds(710, 550, 40, 25);
		this.add(txt[14]);
		date[5].setBounds(755, 550, 50, 25);
		this.add(date[5]);
		label[10].setBounds(400, 600, 150, 25);  //联系方式
		this.add(label[10]);
		txt[8].setText("");
		txt[8].setBounds(510, 600, 200, 25);
		this.add(txt[8]);
		alter.setBounds(500, 650, 150, 30);
		this.add(alter);
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
				String[] stuinfo = getInfo.getBaseInfo(sno);
				if(stuinfo[0] == null) {
					JOptionPane.showMessageDialog(this, "查无此人！", "错误", JOptionPane.ERROR_MESSAGE);
					return ;
				}else {
					if(i>0) {
						for(int j = 0; j <15; j++) {
							txt[j].setText("");
						}
						this.remove(alter);
						this.remove(labsno);
					}
					this.add(query);
					for(int j = 1;j < 7;j++) {
						txt[j].setText(stuinfo[j]);
					}
					txt[7].setText(stuinfo[10]);
					txt[8].setText(stuinfo[14]);
					txt[9].setText(stuinfo[7]);
					txt[10].setText(stuinfo[8]);
					txt[11].setText(stuinfo[9]);
					txt[12].setText(stuinfo[11]);
					txt[13].setText(stuinfo[12]);
					txt[14].setText(stuinfo[13]);
					labsno.setText(sno);
					labsno.setBounds(510, 100, 200, 25);
					this.add(labsno);
					this.repaint();
					}
				}
			}
		if(e.getSource() == alter) {
//			String Sno = txt[0].getText().trim();
			String Sname = txt[1].getText().trim();
			String Ssex = txt[2].getText().trim();
			String Snation = txt[3].getText().trim();
			String Snativeplace = txt[7].getText().trim();
			String Sphone = txt[8].getText().trim();
			String deptname = txt[4].getText().trim();
			String spec_name = txt[5].getText().trim();
			String class_name = txt[6].getText().trim();
			String birthyear = txt[12].getText().trim();
			String birthmonth = txt[13].getText().trim();
			String birthday = txt[14].getText().trim();
			String birthdate = birthyear+"-"+birthmonth+"-"+birthday;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = null;
			try {
				date1 = sdf.parse(birthdate);
			} catch (ParseException e2) {
				e2.printStackTrace();
			}
			String comeyear = txt[9].getText().trim();
			String comemonth = txt[10].getText().trim();
			String comeday = txt[11].getText().trim();
			String comedate = comeyear+"-"+comemonth+"-"+comeday;
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			Date date2 = null;
			try {
				date2 = sdf1.parse(comedate);
			} catch (ParseException e2) {
				e2.printStackTrace();
			}
			//连接数据库
			try {
				con = new connection().getConnection();
				statement = con.createStatement();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			try {
				String sql1 = "select deptname from spec_dept where spec_name='"+spec_name+"'";
				res = statement.executeQuery(sql1);
				if(res.next()) {
					String sql2 = "select spec_name from spec_dept where deptname='"+deptname+"'";
					res = statement.executeQuery(sql2);
					if(res.next()) {
						con.setAutoCommit(false);
						String sql4 = "update student set Sname='"+Sname+"',Ssex='"+Ssex+"',"
								+ "Snation='"+Snation+"',Saddress='"+Snativeplace+"',"
										+ "Sphone='"+Sphone+"',Scometime='"+new java.sql.Date(date2.getTime())+"',"
												+ "Sbirth='"+new java.sql.Date(date1.getTime())+"',"
														+ "spec_name='"+spec_name+"',class='"+class_name+"' where Sno='"+sno+"'";
						int i = statement.executeUpdate(sql4);
						if(i == 1) {
							con.commit();
							con.setAutoCommit(true);
							JOptionPane.showMessageDialog(this, "修改学生信息成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
							}else {
								con.rollback();
								con.setAutoCommit(true);
								JOptionPane.showMessageDialog(this, "修改学生信息失败", "错误", JOptionPane.ERROR_MESSAGE);
								}
					}else {
						JOptionPane.showMessageDialog(this, "所修改的专业不存在", "错误", JOptionPane.ERROR_MESSAGE);
						return ;
					}
				}else {
					JOptionPane.showMessageDialog(this, "所修改的学院不存在", "错误", JOptionPane.ERROR_MESSAGE);
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
				
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
		}
	}
	public void setFocus() {
		txtSno.requestFocus(true);
	}
}
