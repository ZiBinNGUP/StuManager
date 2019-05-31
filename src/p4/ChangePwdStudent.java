package p4;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class ChangePwdStudent extends JPanel implements ActionListener{
	private Connection con = null;
	private Statement statement = null;
	private ResultSet res = null;
	private JLabel[] jlArray = {new JLabel("�û�����"), new JLabel("�����룺"),
			new JLabel("�����룺"), new JLabel("ȷ�������룺"),};
	private JLabel labusername = new JLabel();
	private String username;
	private JPasswordField[] jpfArray = {new JPasswordField(), new JPasswordField(),
			new JPasswordField()};
	private JButton[] jbArray = {new JButton("ȷ��"), new JButton("����")};
	public ChangePwdStudent(String username) {
		this.username = username;
		this.initialFrame();
		this.addListener();
	}
	private void addListener() {
		jpfArray[0].addActionListener(this);
		jpfArray[1].addActionListener(this);
		jpfArray[2].addActionListener(this);
		jbArray[0].addActionListener(this);
		jbArray[1].addActionListener(this);
	}
	private void initialFrame() {
		this.setLayout(null);
		Font font = new Font("����",Font.BOLD,16);
		//���ؼ�������Ӧ��λ��
		for(int i = 0; i < jlArray.length; i++) {
			jlArray[i].setBounds(200, 120+70*i, 150, 30);
			this.add(jlArray[i]);
			if(i == 0) {
				labusername.setBounds(300, 120+70*i, 150, 30);
				labusername.setFont(font);
				labusername.setText(username);
				this.add(labusername);
			}
			else {
				jpfArray[i-1].setBounds(300, 120+70*i, 150, 30);
				this.add(jpfArray[i-1]);
			}
		}
		jbArray[0].setBounds(200, 420, 100, 30);
		jbArray[1].setBounds(350, 420, 100, 30);
		this.add(jbArray[0]);
		this.add(jbArray[1]);	
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jpfArray[0]) {
			jpfArray[1].requestFocus(true);
		}
		else if(e.getSource() == jpfArray[1]) {
			jpfArray[2].requestFocus(true);
		}
		else if(e.getSource() == jpfArray[2]) {
			jbArray[0].requestFocus(true);
		}
		else if(e.getSource() == jbArray[1]) {
			jpfArray[0].setText("");
			jpfArray[1].setText("");
			jpfArray[2].setText("");
		}
		else if(e.getSource() == jbArray[0]) {
			String zzbds = "[0-9a-zA-Z]{6,15}";
			char[] a= jpfArray[0].getPassword();
			String pw1 = String.valueOf(a).trim();
			char[] b= jpfArray[1].getPassword();
			String pw2 = String.valueOf(b).trim();
			char[] c= jpfArray[2].getPassword();
			String pw3 = String.valueOf(c).trim();
			if(pw1.equals("")) {
				JOptionPane.showMessageDialog(this, "����������룡","����",JOptionPane.ERROR_MESSAGE);
				return ;
			}
			if(pw2.equals("")) {
				JOptionPane.showMessageDialog(this, "�����������룡","����",JOptionPane.ERROR_MESSAGE);
				return ;
			}
			if(pw3.equals("")) {
				JOptionPane.showMessageDialog(this, "���ٴ����������룡","����",JOptionPane.ERROR_MESSAGE);
				return ;
			}
			if(!pw2.matches(zzbds)) {
				JOptionPane.showMessageDialog(this, "�����ʽ����ȷ������ֻ����6-15Ϊ�����ֻ���ĸ��","����",JOptionPane.ERROR_MESSAGE);
				return ;
			}
			if(!pw2.equals(pw3)) {
				JOptionPane.showMessageDialog(this, "��������������벻һ�£�","����",JOptionPane.ERROR_MESSAGE);
				return ;
			}
			try {
				con = new connection().getConnection();
				statement = con.createStatement();
				
				String sql = "update stuuser set password_stu='"+pw2+"'"+
							"where Sno='"+username+"'"+"and password_stu='"+pw1+"'";
				int i = statement.executeUpdate(sql);
				if(i == 0) {
					JOptionPane.showMessageDialog(this, "�޸�ʧ�ܣ���������û������������Ƿ����","����",JOptionPane.ERROR_MESSAGE);
				}
				else if(i == 1) {
					JOptionPane.showMessageDialog(this, "�����޸ĳɹ���","��ʾ",JOptionPane.INFORMATION_MESSAGE);
					jpfArray[0].setText("");
					jpfArray[1].setText("");
					jpfArray[2].setText("");
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
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public void setFocus() {
		jpfArray[0].requestFocus(true);
	}
}
