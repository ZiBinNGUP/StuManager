package p4;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class GetStudentData {
	private Connection con = null;
	private Statement statement = null;
	private ResultSet res = null;
	@SuppressWarnings("rawtypes")
	private Vector<Vector> v=new Vector<Vector>();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getAllStudent(String txtdept) {
		v.removeAllElements();
		String[] info = new String[15];
		try {
			con = new connection().getConnection();
			statement = con.createStatement();
			String sql = "select * from v_student where spec_name='"+txtdept+"'";
			res = statement.executeQuery(sql);
			while(res.next()) {
				Vector temp = new Vector();
				info[0] = res.getString(1);  //学号
				info[1] = res.getString(2);  //姓名
				info[2] = res.getString(3);  //性别
				info[3] = res.getString(4);  //民族
				info[4] = res.getString(5);  //学院
				info[5] = res.getString(6);  //专业
				info[6] = res.getString(7);  //班级
				for(int k = 0;k<7; k++) {
					temp.add(info[k]);
				}
				Date cometime = res.getDate(8); //入学时间
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String s = format.format(cometime);
				info[7] = s.substring(0, 4);
				info[8] = s.substring(5, 7);
				info[9] = s.substring(8);
				String ss1 = info[7] + "年" + info[8] + "月" +info[9] + "日";
				temp.add(ss1);
				info[10] = res.getString(9);  //籍贯
				temp.add(info[10]);
				Date birth = res.getDate(10);   //出生日期
				DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
				String s1 = format1.format(birth);
				info[11] = s1.substring(0, 4);
				info[12] = s1.substring(5, 7);
				info[13] = s1.substring(8);
				String ss2 = info[11] + "年" + info[12] + "月" +info[13] + "日";
				temp.add(ss2);
				info[14] = res.getString(11);  //联系方式
				temp.add(info[14]);
				v.add(temp);
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
		return v;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector getAllStudent2(String txtPro) {
		v.removeAllElements();
		String[] info = new String[15];
		try {
			con = new connection().getConnection();
			statement = con.createStatement();
			String sql = "select * from v_student where Saddress like '"+txtPro+"%'";
			res = statement.executeQuery(sql);
			while(res.next()) {
				Vector temp = new Vector();
				info[0] = res.getString(1);  //学号
				info[1] = res.getString(2);  //姓名
				info[2] = res.getString(3);  //性别
				info[3] = res.getString(4);  //民族
				info[4] = res.getString(5);  //学院
				info[5] = res.getString(6);  //专业
				info[6] = res.getString(7);  //班级
				for(int k = 0;k<7; k++) {
					temp.add(info[k]);
				}
				Date cometime = res.getDate(8); //入学时间
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String s = format.format(cometime);
				info[7] = s.substring(0, 4);
				info[8] = s.substring(5, 7);
				info[9] = s.substring(8);
				String ss1 = info[7] + "年" + info[8] + "月" +info[9] + "日";
				temp.add(ss1);
				info[10] = res.getString(9);  //籍贯
				temp.add(info[10]);
				Date birth = res.getDate(10);   //出生日期
				DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
				String s1 = format1.format(birth);
				info[11] = s1.substring(0, 4);
				info[12] = s1.substring(5, 7);
				info[13] = s1.substring(8);
				String ss2 = info[11] + "年" + info[12] + "月" +info[13] + "日";
				temp.add(ss2);
				info[14] = res.getString(11);  //联系方式
				temp.add(info[14]);
				v.add(temp);
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
		return v;
	}
}
