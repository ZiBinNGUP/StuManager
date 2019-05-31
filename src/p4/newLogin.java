package p4;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class newLogin extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private Connection con = null;
	private Statement statement = null;
	private ResultSet res = null;
	private ButtonGroup buttongroup = new ButtonGroup();
	private MyPanel jp = new MyPanel();
	private JLabel ul = new JLabel("用户名：");
	private JLabel pl = new JLabel("密    码：");
	private JLabel ts = new JLabel("");
	private JTextField uname = new JTextField();
	private JPasswordField pword = new JPasswordField();
	private JRadioButton[] butArray = {
			new JRadioButton("学生",true),
			new JRadioButton("教师")
	};
	private JButton login = new JButton("登陆");
	private JButton reset = new JButton("重置");
	public newLogin() {
		addListener();
		initialFrame();
		
	}
	private void initialFrame() {
		Font font = new Font("宋体",Font.BOLD,12);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("登陆");
		jp.setLayout(null);
		ul.setBounds(100, 30, 60, 30);
		jp.add(ul);
		uname.setBounds(170, 30, 140, 30);
		jp.add(uname);
		pl.setBounds(100, 80, 60, 30);
		pword.setBounds(170, 80, 140, 30);
		jp.add(pl);
		jp.add(pword);
		ts.setBounds(100, 160, 200, 50);
		jp.add(ts);
		ts.setFont(font);
		login.setBounds(100, 220, 70, 30);
		jp.add(login);
		login.setFont(font);
		reset.setBounds(220, 220, 70, 30);
		jp.add(reset);
		reset.setFont(font);
		add(jp);
		setResizable(false);
		buttongroup.add(butArray[0]);
		buttongroup.add(butArray[1]);
		butArray[0].setBounds(120, 130, 100, 50);
		jp.add(butArray[0]);
		butArray[1].setBounds(220, 130, 100, 50);
		jp.add(butArray[1]);
		butArray[0].setContentAreaFilled(false);
		butArray[1].setContentAreaFilled(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = screenSize.width/2;
		int centerY = screenSize.height/2;
		int w = 427;
		int h = 331;
		setBounds(centerX-w/2, centerY-h/2, w, h);
		setVisible(true);
		uname.requestFocus(true);
		getContentPane().add(jp);
		jp.getRootPane().setDefaultButton(login);
	}
	private void addListener() {
		this.login.addActionListener(this);
		this.uname.addActionListener(this);
		this.pword.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == uname) {
			pword.requestFocus();
		}
		if(e.getSource() == pword) {
			butArray[0].requestFocus();
		}
		if(e.getSource() == butArray[0]||e.getSource() == butArray[1]||e.getSource() == login) {
//			this.ts.setText("正在为您努力加载，请稍等......");
			
			int type = this.butArray[0].isSelected()?0:1;
			String username = this.uname.getText().trim();
			char[] p = this.pword.getPassword();
			String password = String.valueOf(p).trim();
			if(username.equals("")) {
				JOptionPane.showMessageDialog(this, "请输入用户名！","错误",JOptionPane.ERROR_MESSAGE);
				ts.setText("");
				return ;
			}
			if(password.equals("")) {
				JOptionPane.showMessageDialog(this, "请输入密码！","错误",JOptionPane.ERROR_MESSAGE);
				ts.setText("");
				return ;
			}
			try {
				con = new connection().getConnection();
				statement = con.createStatement();
				if(type == 0) {
					String sql = "select * from stuuser where "+
						"Sno='"+username+"'and password_stu='"+password+"'";
					res = statement.executeQuery(sql);
					if(res.next()) {
						new StudentClient(username);
						this.dispose();
					}
					else {
						JOptionPane.showMessageDialog(this, "用户名或密码错误！","错误",JOptionPane.ERROR_MESSAGE);
						ts.setText("");
						uname.setText("");
						pword.setText("");
					}
					//关闭数据库连接
					if(res != null) {
						res.close();
					}
					if(statement != null) {
						statement.close();
					}
					if(con != null) {
						con.close();
					}
				}
				else {
					String sql = "select spec_name from teauser where "+
							"username='"+username+"'and password='"+password+"'";
						res = statement.executeQuery(sql);
						if(res.next()) {
							String spec_name = res.getString(1);
							new TeacherClient(spec_name);
							this.dispose();
						}
						else {
							JOptionPane.showMessageDialog(this, "用户名或密码错误！","错误",JOptionPane.ERROR_MESSAGE);
							ts.setText("");
							uname.setText("");
							pword.setText("");
						}
						//关闭数据库连接
						if(res != null) {
							res.close();
						}
						if(statement != null) {
							statement.close();
						}
						if(con != null) {
							con.close();
						}
				}
			}catch(SQLException ea) {
				ea.printStackTrace();
			}
		}
		else if(e.getSource() == reset) {
			uname.setText("");
			pword.setText("");
		}
	}
}
