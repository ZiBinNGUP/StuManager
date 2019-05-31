package p4;

import java.awt.Color;
import java.awt.Font;
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
public class Se_Avg_grade  extends JPanel implements ActionListener{
	private Connection con = null;
	private Statement statement = null;
	private ResultSet res = null;
	private JLabel labna = new JLabel("请要查询的课程名：");
	private JTextField labname = new JTextField();
	private JButton query = new JButton("查询");
	private JLabel labvag=new JLabel("这门课的平均成绩是：");
	private JLabel labav_grade = new JLabel();
	private JLabel fen = new JLabel("分");
	private String Coursename;
	private String score;
	public Se_Avg_grade() {
		this.initialFrame();
		this.addListener();
	}
	private void initialFrame() {
		this.setLayout(null);
		Font font1 = new Font("宋体",Font.BOLD,20);
		labna.setBounds(300, 20, 200, 30);
		this.add(labna);
		labname.setBounds(480, 20, 150, 30);
		this.add(labname);
		query.setBounds(670, 20, 100, 30);
		this.add(query);
		labvag.setBounds(300, 200, 250, 25);  
		this.add(labvag);
		labvag.setFont(font1);
		labvag.setForeground(Color.orange);
		labav_grade.setBounds(560, 200, 100, 25);  
		this.add(labav_grade);
		labav_grade.setFont(font1);
		labav_grade.setForeground(Color.RED);
		fen.setBounds(710, 200, 150, 25);
		this.add(fen);
		fen.setFont(font1);
		fen.setForeground(Color.PINK);
	}
	private void addListener() {
		labname.addActionListener(this);
		query.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == labname||e.getSource() == query) {
			Coursename = labname.getText();
			if(Coursename.equals("")) {
				JOptionPane.showMessageDialog(this, "请输入课程名！", "错误", JOptionPane.ERROR_MESSAGE);
				return ;
			}
			else{
				try
					{
					con = new connection().getConnection();
					statement = con.createStatement();
					String sql1 = "select * from avg_course where Cname='"+ Coursename+"'";
					res = statement.executeQuery(sql1);
					if(res.next()) {
						score=res.getString(2);
						double a=Double.parseDouble(score);
						String c=String.format("%.2f", a);
						labav_grade.setText(c);
					}
				else {
						JOptionPane.showMessageDialog(this, "没有开设这门课！", "错误", JOptionPane.ERROR_MESSAGE);
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
					e1.printStackTrace();
				} catch (SQLException e1){
					e1.printStackTrace();
				}
			}
		}
	}
	public void setFocus() {
		labname.requestFocus(true);
	}
}
