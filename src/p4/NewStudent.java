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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewStudent extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	private Connection con = null;
	private Statement statement = null;
	private ResultSet res = null;
	private String spec_name = null;
	private String cla = null;
	@SuppressWarnings("deprecation")
	static int year = new Date().getYear()+1900;  
	private JLabel labSno = new JLabel("学号：");
	private JLabel labSname = new JLabel("姓名：");
	private JLabel labSsex = new JLabel("性别：");
	private JLabel labSnation = new JLabel("民族：");
	private JLabel labScoll = new JLabel("学院：");
	private JLabel labSdept = new JLabel("专业：");
	private JLabel labSclass = new JLabel("班级：");
	private JLabel labScometime = new JLabel("入学时间：");
	private JLabel labScomeyear = new JLabel("年");
	private JLabel labScomemonth = new JLabel("月");
	private JLabel labScomeday = new JLabel("日");
	private JLabel labSnativeplace = new JLabel("籍贯：");
	private JLabel labSbirth = new JLabel("出生日期：");
	private JLabel labSphone = new JLabel("联系方式：");
	private JLabel labdept = new JLabel("");
	private JLabel labspec = new JLabel("");
	
	private JTextField txtSno = new JTextField();
	private JTextField txtSname = new JTextField();
	private JTextField txtSnation = new JTextField();
	private JTextField txtSnativeplace = new JTextField();
	private JTextField txtSphone = new JTextField();
	
	JButton login = new JButton("提交");
	JButton reset = new JButton("重置");
	
	String[] Ssex = {"男","女"};
	static String[] year1 = new String[20];
	static {
		for(int i = 0; i < 20; i++) {
			year1[i] = year-i + "";
		}
	}
	static String[] year2 = new String[30];
	static {
		for(int i = 5; i<35; i++) {
			year2[i-5] = year-i+"";
		}
	}
	static String[] month = new String[12];
	static {
		for(int i=1;i<=12;i++) {
			month[i-1] = i+"";
		}
	}
	static String[] day = new String[31];
	static {
		for(int i=1;i<=31;i++) {
			day[i-1] = i+"";
		}
	}
	static String[] cls = new String[5];
	static {
		for(int i=0; i<5;i++) {
			cls[i]=i+1+"班";
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox[] box = {
			new JComboBox(Ssex), new JComboBox(year1), new JComboBox(month), 
			new JComboBox(day), new JComboBox(cls), new JComboBox(year2), new JComboBox(month), 
			new JComboBox(day)
	};
	JButton[] JbArray = {new JButton("提交"), new JButton("重置")};
	public NewStudent(String spec_name) {
		this.spec_name = spec_name;
		this.initialData();
		this.initialFrame();
		this.addListener();
	}
	public void initialData() {
		try {
			con = new connection().getConnection();
			statement = con.createStatement();
			String sql1 = "select deptname from spec_dept where spec_name='"+spec_name+"'";
			res = statement.executeQuery(sql1);
			if(res.next()) {
				String deptname = new String(res.getString(1));
				labdept.setText(deptname);
			}
			labspec.setText(spec_name);
			
			if(res != null) {
				res.close();
			}
			if(statement != null) {
				statement.close();
			}
			if(con != null) {
				con.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void initialFrame() {
		this.setLayout(null);
		labSno.setBounds(400, 40, 150, 25);
		this.add(labSno);
		txtSno.setBounds(510, 40, 200, 25);
		this.add(txtSno);
		labSname.setBounds(400, 80, 150, 25);
		this.add(labSname);
		txtSname.setBounds(510,80,200,25);
		this.add(txtSname);
		labSsex.setBounds(400, 120, 150, 25);
		this.add(labSsex);
		box[0].setBounds(510, 120, 100, 25);
		this.add(box[0]);
		labSnation.setBounds(400, 160, 150, 25);
		this.add(labSnation);
		txtSnation.setBounds(510, 160, 200, 25);
		this.add(txtSnation);
		labScoll.setBounds(400, 200, 150, 25);
		this.add(labScoll);
		labdept.setBounds(510, 200, 200, 25);
		this.add(labdept);
		labSdept.setBounds(400, 240, 150, 25);
		this.add(labSdept);
		labspec.setBounds(510, 240, 200, 25);
		this.add(labspec);
		labSclass.setBounds(400, 280, 150, 25);
		this.add(labSclass);
		box[4].setBounds(510, 280, 200, 25);
		this.add(box[4]);
		labScometime.setBounds(400, 320, 150, 25);
		this.add(labScometime);
		box[1].setBounds(510, 320, 60, 25);
		this.add(box[1]);
		labScomeyear.setBounds(575, 320, 50, 25);
		this.add(labScomeyear);
		box[2].setBounds(600, 320, 60, 25);
		this.add(box[2]);
		labScomemonth.setBounds(665, 320, 50, 25);
		this.add(labScomemonth);
		box[3].setBounds(690, 320, 60, 25);
		this.add(box[3]);
		labScomeday.setBounds(755, 320, 50, 25);
		this.add(labScomeday);
		labSnativeplace.setBounds(400, 360, 150, 25);
		this.add(labSnativeplace);
		txtSnativeplace.setBounds(510, 360, 200, 25);
		this.add(txtSnativeplace);
		labSbirth.setBounds(400, 400, 150, 25);
		this.add(labSbirth);
		box[5].setBounds(510, 400, 60, 25);
		this.add(box[5]);
		labScomeyear.setBounds(575, 400, 50, 25);
		this.add(labScomeyear);
		box[6].setBounds(600, 400, 60, 25);
		this.add(box[6]);
		labScomemonth.setBounds(665, 400, 50, 25);
		this.add(labScomemonth);
		box[7].setBounds(690, 400, 60, 25);
		this.add(box[7]);
		labScomeday.setBounds(755, 400, 50, 25);
		this.add(labScomeday);
		labSphone.setBounds(400, 440, 150, 25);
		this.add(labSphone);
		txtSphone.setBounds(510, 440, 200, 25);
		this.add(txtSphone);
		login.setBounds(400, 520, 80, 35);
		this.add(login);
		reset.setBounds(600, 520, 80, 35);
		this.add(reset);
	}
	public void addListener() {
		txtSno.addActionListener(this);
		txtSname.addActionListener(this);
		txtSnation.addActionListener(this);
		txtSnativeplace.addActionListener(this);
		txtSphone.addActionListener(this);
		box[5].addActionListener(this);
		login.addActionListener(this);
		reset.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == txtSno) {
			txtSname.requestFocus(true);
		}else if(e.getSource() == txtSname) {
			txtSnation.requestFocus(true);
		}else if(e.getSource() == txtSnation) {
			txtSnativeplace.requestFocus(true);
			
		}else if(e.getSource() == box[5]) {
			
		}else if(e.getSource() == login) {
				this.newStuSubmit(); 
			
		}else if(e.getSource() == reset) {
			txtSno.setText("");
			txtSname.setText("");
			txtSnation.setText("");
			txtSnativeplace.setText("");
			txtSphone.setText("");
		}
	}
	public void newStuSubmit() {
		String Sno = txtSno.getText().trim();
		String Sname = txtSname.getText().trim();
		String Snation = txtSnation.getText().trim();
		String Snativeplace = txtSnativeplace.getText().trim();
		String Sphone = txtSphone.getText().trim();
		String Ssex = ((String)box[0].getSelectedItem()).trim();
		String birthyear = ((String)box[1].getSelectedItem()).trim();
		String birthmonth = ((String)box[2].getSelectedItem()).trim();
		String birthday = ((String)box[3].getSelectedItem()).trim();
		String birthdate = birthyear+"-"+birthmonth+"-"+birthday;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = null;
		try {
			date1 = sdf.parse(birthdate);
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		
		String gs1 = "[0-9]{12}";
		String gs2 = "[0-9]{11}";
		if(Sno.equals("")) {
			JOptionPane.showMessageDialog(this, "请输入学号！","错误",JOptionPane.ERROR_MESSAGE);
			return ;
		}
		if(!Sno.matches(gs1)) {
			JOptionPane.showMessageDialog(this, "学号格式不正确！","错误",JOptionPane.ERROR_MESSAGE);
			return ;
		}
		if(Sname.equals("")) {
			JOptionPane.showMessageDialog(this, "请输入姓名！","错误",JOptionPane.ERROR_MESSAGE);
			return ;
		}
		if(Sname.length()>20) {
			JOptionPane.showMessageDialog(this, "姓名长度过长，请简写！", "错误", JOptionPane.ERROR_MESSAGE);
			return ;
		}
		if(Snation.equals("")) {
			JOptionPane.showMessageDialog(this, "请输入民族！","错误",JOptionPane.ERROR_MESSAGE);
			return ;
		}
		if(Snativeplace.equals("")) {
			JOptionPane.showMessageDialog(this, "请输入籍贯！", "错误", JOptionPane.ERROR_MESSAGE);
			return ;
		}
		if(Snativeplace.length()>20) {
			JOptionPane.showMessageDialog(this, "籍贯长度过长，请简写！", "错误", JOptionPane.ERROR_MESSAGE);
			return ;
		}
		if(Sphone.equals("")) {
			JOptionPane.showMessageDialog(this, "请输入联系方式！", "错误", JOptionPane.ERROR_MESSAGE);
			return ;
		}
		if(!Sphone.matches(gs2)) {
			JOptionPane.showMessageDialog(this, "联系方式格式错误！", "错误", JOptionPane.ERROR_MESSAGE);
			return ;
		}
//		String coll_id = this.coll_id;
//		String dept_id = map_dept.get((String)box[5].getSelectedItem());
//		String class_id = (String)(((HashMap)map_class.get(dept_id)).get(box[6].getSelectedItem()));
		cla = (String)box[4].getSelectedItem();
		String comeyear = ((String)box[5].getSelectedItem()).trim();
		String comemonth = ((String)box[6].getSelectedItem()).trim();
		String comeday = ((String)box[7].getSelectedItem()).trim();
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
			String sql4 = "insert into student values ('"+Sno+"','"+new String(Sname.getBytes())+"'"
					+ ",'"+new String(Ssex.getBytes())+"','"+Snation+"','"+spec_name+"','"+cla+"',"
							+ "'"+new java.sql.Date(date2.getTime())+"','"+Snativeplace+"','"+new java.sql.Date(date1.getTime())+"','"+Sphone+"')";
			con.setAutoCommit(false);
			int i = statement.executeUpdate(sql4);
			if(i == 1) {
				con.commit();
				con.setAutoCommit(true);
				JOptionPane.showMessageDialog(this, "添加学生成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
				
			}else {
				con.rollback();
				con.setAutoCommit(true);
				JOptionPane.showMessageDialog(this, "添加学生失败", "错误", JOptionPane.ERROR_MESSAGE);
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
			
			}catch(SQLException e) {
				e.printStackTrace();
			}
	}
	public void setFocus() {
		this.requestFocus(true);
	}
}
