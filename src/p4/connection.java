package p4;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

public class connection {
	private Connection con = null;
//	private Statement statement = null;
//	private ResultSet res = null;
	String driver = "com.mysql.cj.jdbc.Driver";
	String url  = "jdbc:mysql://localhost:3306/stu_manager?serverTimezone=Asia/Shanghai";
	String name = "root";
	String passwd = "123456";
	public connection() {
		
	}
	public Connection getConnection() {
		try{
			Class.forName(driver).newInstance();
			con = DriverManager.getConnection(url,name,passwd);
			System.out.println("���ݿ����ӳɹ���");
			}catch(ClassNotFoundException e){
				System.out.println("�Բ����Ҳ������Driver");
				e.printStackTrace();
			}catch(SQLException e){
				
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
		return con;
	}
}
