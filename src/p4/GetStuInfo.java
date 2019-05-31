package p4;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class GetStuInfo {
	private Connection con = null;
	private Statement statement = null;
	private ResultSet res = null;
	public String[] getBaseInfo(String Sno) {
		String[] info = new String[15];
		try {
			con = new connection().getConnection();
			statement = con.createStatement();
			String sql = "select * from v_student where Sno='"+Sno+"'";
			res = statement.executeQuery(sql);
			if(res.next()) {
				info[0] = res.getString(1);  //学号
				info[1] = res.getString(2);  //姓名
				info[2] = res.getString(3);  //性别
				info[3] = res.getString(4);  //民族
				info[4] = res.getString(5);  //学院
				info[5] = res.getString(6);  //专业
				info[6] = res.getString(7);  //班级
				Date cometime = res.getDate(8); //入学时间
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String s = format.format(cometime);
				info[7] = s.substring(0, 4);
				info[8] = s.substring(5, 7);
				info[9] = s.substring(8);
				
				info[10] = res.getString(9);  //籍贯
				Date birth = res.getDate(10);   //出生日期
				DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
				String s1 = format1.format(birth);
				info[11] = s1.substring(0, 4);
				info[12] = s1.substring(5, 7);
				info[13] = s1.substring(8);
				info[14] = res.getString(11);  //联系方式
				
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
		}catch(Exception e) {
			e.printStackTrace();
		}
		return info;
	}
}
