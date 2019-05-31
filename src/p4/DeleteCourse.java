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
public class DeleteCourse extends JPanel implements ActionListener{
	private Connection con = null;
	private Statement statement = null;
	private ResultSet res = null;
	private JLabel labSno = new JLabel("请输入要删除的课程名：");
	private JTextField txtSno = new JTextField();
	private JButton delete = new JButton("删除");
	public DeleteCourse() {
		this.AddListener();
		this.initialFrame();
	}
	private void initialFrame() {
		this.setLayout(null);
		labSno.setBounds(300, 20, 200, 30);
		this.add(labSno);
		txtSno.setBounds(480, 20, 150, 30);
		this.add(txtSno);
		delete.setBounds(670, 20, 100, 30);
		this.add(delete);	
	}
	private void AddListener() {
		txtSno.addActionListener(this);
		delete.addActionListener(this);	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == txtSno||e.getSource() == delete) {
			String s = txtSno.getText();
			if(s.equals("")) {
				JOptionPane.showMessageDialog(this, "请输入课程名！", "提示", JOptionPane.INFORMATION_MESSAGE);
				return ;
			}else {
				
				try {
					con = new connection().getConnection();
					statement = con.createStatement();
					String sql1 = "select * from course where Cname='"+s+"'";
					String sql2 = "delete from course where Cname='"+s+"'";
					res = statement.executeQuery(sql1);
					if(res.next()) {
						int i = JOptionPane.showConfirmDialog(this, "您确认要删除此课程吗","询问",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if(i == 0) {
							int j = statement.executeUpdate(sql2);
							if(j == 1) {
								JOptionPane.showMessageDialog(this, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
								return ;
							}else {
								JOptionPane.showMessageDialog(this, "删除失败！", "错误", JOptionPane.ERROR_MESSAGE);
								return ;
							}
						}
					}else {
						JOptionPane.showMessageDialog(this, "课程不存在！", "错误", JOptionPane.ERROR_MESSAGE);
						return ;
					}
					if(res != null) {
						res.close();
					}if(statement != null) {
						statement.close();
					}if(con != null) {
						con.close();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	public void setFocus() {
		txtSno.requestFocus(true);
	}
}
