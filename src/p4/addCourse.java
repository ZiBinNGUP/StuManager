package p4;

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
public class addCourse extends JPanel implements ActionListener{

	private Connection con = null;
	private Statement statement = null;
	private ResultSet res = null;
	
	
	private JLabel labCno = new JLabel("课程号：");
	private JTextField txtCno = new JTextField();
	
	private JLabel labCname = new JLabel("课程名：");
	private JTextField txtCname = new JTextField();
	
	private JLabel labCredit = new JLabel("课程学分：");
	private JTextField txtCredit = new JTextField();
	
	private JLabel labSpec_name = new JLabel("开设专业：");
	private JTextField txtSpec_name = new JTextField();
	
	private JLabel labTea_name = new JLabel("教师：");
	private JTextField txtTea_name = new JTextField();
	
	private JButton addc = new JButton("添加");
	
	public addCourse()
	{
		this.initialFrame();
		this.AddListener();
	}
	private void initialFrame() {
		int lw,lh,tw,th;
		int lx,ly,tx;
		int update = 50;
		lw = 200;
		lh = 30;
		th = lh;
		tw = 300;
		lx = 300;
		ly = 20;
		tx = 480;
		this.setLayout(null);
		labCno.setBounds(lx,ly + update * 0,lw,lh);
		this.add(labCno);
		txtCno.setBounds(tx,ly + update * 0,tw,th);
		this.add(txtCno);
		
		labCname.setBounds(lx,ly + update * 1,lw,lh);
		txtCname.setBounds(tx,ly + update * 1,tw,th);
		this.add(labCname);
		this.add(txtCname);
		
		labCredit.setBounds(lx,ly + update * 2,lw,lh);
		txtCredit.setBounds(tx,ly + update * 2,tw,th);
		this.add(labCredit);
		this.add(txtCredit);
		
		labSpec_name.setBounds(lx,ly + update * 3,lw,lh);
		txtSpec_name.setBounds(tx,ly + update * 3,tw,th);
		this.add(labSpec_name);
		this.add(txtSpec_name);
		
		labTea_name.setBounds(lx,ly + update * 4,lw,lh);
		txtTea_name.setBounds(tx,ly + update * 4,tw,th);
		this.add(labTea_name);
		this.add(txtTea_name);
		addc.setBounds((lw + tw + tx)/2,ly + update * 5,100,30);
		this.add(addc);
		
	}
	private void AddListener() {
		txtCno.addActionListener(this);
		txtCname.addActionListener(this);
		txtCredit.addActionListener(this);
		txtSpec_name.addActionListener(this);
		txtTea_name.addActionListener(this);
		addc.addActionListener(this);
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == addc)
		{
			this.newCourse();
		}
		
	}
	public void setFocus() {
		txtCno.requestFocus(true);
	}
	public void newCourse()
	{
		String Cno = txtCno.getText().trim();
		String Cname = txtCname.getText().trim();
		String Credit = txtCredit.getText().trim();
		String spec_name = txtSpec_name.getText().trim();
		String tea_name = txtTea_name.getText().trim();
		if(Cno.equals("")) {
			JOptionPane.showMessageDialog(this, "课程号不能为空！", "提示", JOptionPane.INFORMATION_MESSAGE);
			return ;
		}else if(Cname.equals("")) {
			JOptionPane.showMessageDialog(this, "课程名不能为空！", "提示", JOptionPane.INFORMATION_MESSAGE);
			return ;
		}else if(Credit.equals("")) {
			JOptionPane.showMessageDialog(this, "课程学分不能为空！", "提示", JOptionPane.INFORMATION_MESSAGE);
			return ;
		}else if(spec_name.equals("")) {
			JOptionPane.showMessageDialog(this, "专业不能为空！", "提示", JOptionPane.INFORMATION_MESSAGE);
			return ;
		}else if(tea_name.equals("")) {
			JOptionPane.showMessageDialog(this, "授课教师不能为空！", "提示", JOptionPane.INFORMATION_MESSAGE);
			return ;
		}
		try {
			con = new connection().getConnection();
			
			statement = con.createStatement();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try
		{
			String sql = "insert into course values("+"'"+Cno+"'"+","+"'"+Cname+"'"+","+Credit+","+"'"+spec_name+"'"+","+"'"+tea_name+"'"+")";
			String sql2 = "select * from spec_dept where spec_name = '"+spec_name+"'";
			
			con.setAutoCommit(false);
			res = statement.executeQuery(sql2);
			if(res.next())
			{
				int i = statement.executeUpdate(sql);
				if(i == 1)
				{
					con.commit();
					con.setAutoCommit(true);
					JOptionPane.showMessageDialog(this, "添加课程成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
					return ;
				}
				else {
					con.rollback();
					con.setAutoCommit(true);
					JOptionPane.showMessageDialog(this, "添加课程失败", "错误", JOptionPane.ERROR_MESSAGE);
					return ;
				}
			
			}
			else
			{
				JOptionPane.showMessageDialog(this, "无法找到此专业", "错误", JOptionPane.ERROR_MESSAGE);
			
			}
			if(res != null) {
				res.close();
			}if(statement != null) {
				statement.close();
			}if(con != null) {
				con.close();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
