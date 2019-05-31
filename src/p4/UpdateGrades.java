package p4;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;

public class UpdateGrades extends JPanel implements ActionListener{
	private Connection con = null;
	private ResultSet res = null;
	private String spec_name;
	private Statement stmt;
	private Vector v_dept = new Vector();
	private JComboBox jcb = new JComboBox(v_dept);
	private JLabel j1 = new JLabel("请选择您要操作的课程");
	private Vector v_head = new Vector();
	private Vector v_data = new Vector();
	private JTable jt;
	private JScrollPane jsp;
	private JButton jb = new JButton("公布该科成绩");
	public UpdateGrades(String spec_name)
	{
		this.spec_name = spec_name;
		this.initialFrame();
		this.initialData();
		this.initialListener();
	}
	public  void initialFrame()
	{
		this.setLayout(null);
		j1.setBounds(30, 20, 150, 30);
		this.add(j1);
		jcb.setBounds(180, 20, 100, 30);this.add(jcb);
		jb.setBounds(350, 20, 150, 30);this.add(jb);
		DefaultTableModel dtm = new DefaultTableModel(v_data,v_head){
			@Override  
            public boolean isCellEditable(int row,int column){  
                if(column != 3)return false;
                else return true;
            }  
		};
		
		jt=new JTable(dtm);	
		jt.getTableHeader().setFont(new Font(null, Font.BOLD,13));
		jt.getTableHeader().setForeground(Color.blue);
		jt.getTableHeader().setResizingAllowed(false);
		jt.getTableHeader().setReorderingAllowed(false);
		
		jt.setRowHeight(30);
		jt.setForeground(Color.BLACK);
		jt.setFont(new Font(null,Font.PLAIN,13));
		jt.setSelectionForeground(Color.BLUE);
		jt.setSelectionBackground(Color.YELLOW);
		jt.setGridColor(Color.green);
		
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();//单元格渲染器
		tcr.setHorizontalAlignment(JLabel.CENTER);//居中显示
		jt.setDefaultRenderer(Object.class, tcr);//设置渲染器
		jsp = new JScrollPane(jt);
		jsp.setBounds(30, 70, 1500, 800);this.add(jsp);
	}
	public void initialListener()
	{
		jcb.addActionListener(this);
		jb.addActionListener(this);
		TableChangeListener tcl = new TableChangeListener(stmt,jt);
		jt.getSelectionModel().addListSelectionListener(tcl);
		jt.getColumnModel().addColumnModelListener(tcl);
		jt.getModel().addTableModelListener(tcl);
		
	}
	public void initialData()
	{
		v_head.add("课程号 ");v_head.add("学号");
		v_head.add("姓名");v_head.add("成绩");
		String sql = "select Cname from course where spec_name = '"+spec_name+"'";
		try
		{
			con = new connection().getConnection();
			stmt = con.createStatement();
			con.setAutoCommit(false);
			res = stmt.executeQuery(sql);
			while(res.next())
			{
				String course_name = res.getString(1);
				this.v_dept.add(course_name);
			}
			res.close();
			con.close();
		}catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jcb)
		{
			
			
			v_data.removeAllElements();
			String cur_cou_name = (String)jcb.getSelectedItem();
			String sql = "select sc.Cno,sc.Sno,Sname,Grade	from sc,course,student	where Cname='"+cur_cou_name+"' and sc.Cno ="+ "course.Cno and student.Sno = sc.Sno";
			
			try
			{
				con = new connection().getConnection();
				stmt = con.createStatement();
				con.setAutoCommit(false);
				res = stmt.executeQuery(sql);
				while(res.next())
				{
					Vector v = new Vector();
					String Cno = res.getString(1);
					String Sno = res.getString(2);
					String Sname = res.getString(3);
					String Grade = res.getDouble(4)+"";
					v.add(Cno);v.add(Sno);v.add(Sname);v.add(Grade);
					v_data.add(v);
				}
				res.close();
				con.close();
				DefaultTableModel temp1=(DefaultTableModel)jt.getModel();
				temp1.setDataVector(v_data, v_head);
				temp1.fireTableStructureChanged();
			}
			catch(Exception e1){
				e1.printStackTrace();
			}
		}
		else if(e.getSource() == jb)
		{
			int i = JOptionPane.showConfirmDialog(this, "您确认要保存该表的所有成绩","询问",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			
			if(i == 0)
			{
			try {
				
				int row_count = jt.getRowCount();
				con = new connection().getConnection();
//				con.setAutoCommit(false);
				stmt = con.createStatement();
			
			while(row_count-- != 0)
			{
				String cou_id = (String)jt.getValueAt(row_count, 0);
				String sno = (String)jt.getValueAt(row_count, 1);
				String grade = (String)jt.getValueAt(row_count, 3);
				String sql = "update sc set grade ='"+ grade +"' where sno = '"+sno+"' and cno= '"+cou_id+"'";
//				System.out.println(sql);
				stmt.executeUpdate(sql);
			}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
		}
		}
	}
	
}
class TableChangeListener implements ListSelectionListener,TableModelListener,TableColumnModelListener
{
	private Statement stmt;
	private Vector new_data;
	private JTable jt;
	int rowNum,colNum;
	public TableChangeListener(Statement stmt,JTable jt)
	{
		this.jt = jt;
		this.stmt = stmt;
	}
	
	@Override
	public void columnAdded(TableColumnModelEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void columnRemoved(TableColumnModelEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void columnMoved(TableColumnModelEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void columnMarginChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void columnSelectionChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		colNum = jt.getSelectedColumn();
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		if(colNum == 3)
		{
			String str = (String)jt.getValueAt(rowNum, colNum);
//			String cou_id = (String)jt.getValueAt(rowNum, 0);
			
			try
			{
				Double d = Double.parseDouble(str);
				if(d<0 || d>100){
					jt.setValueAt("0", rowNum, colNum);
				}
			}
			catch(Exception ea){
				jt.setValueAt("0", rowNum, colNum);
			}
//			Vector v = new Vector();
//			v.add(cou_id);v.add(str);
//			new_data.add(v);
//			System.out.println("cou_id="+cou_id+" str="+str);
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		rowNum = jt.getSelectedRow();
	}
}

