package p4;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ByDeptQuery extends JPanel implements ActionListener{
	private JLabel labDept = new JLabel("请输入要查询的专业：");
	private JTextField txtDept = new JTextField();
	private JButton query = new JButton("查询");
	private JTable jt;
	private JScrollPane jsp;
	@SuppressWarnings("rawtypes")
	private Vector v_head = new Vector();
	@SuppressWarnings("rawtypes")
	private Vector v_data = new Vector();

	private GetStudentData gsd;
	
	public ByDeptQuery() {
		gsd = new GetStudentData();
		this.initialFrame();
		this.AddListener();
		this.initialData();
	}
	
	
	@SuppressWarnings("unchecked")
	private void initialData() {
		v_head.add("学号");
		v_head.add("姓名");
		v_head.add("性别");
		v_head.add("民族");
		v_head.add("学院");
		v_head.add("专业");
		v_head.add("班级");
		v_head.add("入学时间");
		v_head.add("籍贯");
		v_head.add("出生日期");
		v_head.add("联系方式");
	}
	private void AddListener() {
		txtDept.addActionListener(this);
		query.addActionListener(this);
		
	}
	private void initialFrame() {
		this.setLayout(null);
		labDept.setBounds(300, 20, 200, 30);
		this.add(labDept);
		txtDept.setBounds(480, 20, 150, 30);
		this.add(txtDept);
		query.setBounds(670, 20, 100, 30);
		this.add(query);
//		this.getRootPane().setDefaultButton(query);
		DefaultTableModel dtm = new DefaultTableModel(v_data, v_head);
		jt = new JTable(dtm);
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
		jsp.setBounds(5, 70, 1175, 640); 
		this.add(jsp);	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == txtDept|| e.getSource() == query) {
			String txtdept = txtDept.getText().trim();
			if(txtdept.equals("")) {
				JOptionPane.showMessageDialog(this, "请输入专业名称！！", "错误", JOptionPane.ERROR_MESSAGE);
				return ;
			}
			else {
				v_data = gsd.getAllStudent(txtdept);
				if(v_data.isEmpty()) {
					JOptionPane.showMessageDialog(this, "专业不存在！！", "错误", JOptionPane.ERROR_MESSAGE);
					return ;
				}
				DefaultTableModel dtm = new DefaultTableModel(v_data, v_head);
				jt.setModel(dtm);
				((DefaultTableModel)jt.getModel()).fireTableStructureChanged();  //更新显示	
			}
		}
		
	}
	public void setFocus() {
		txtDept.requestFocus(true);
	}
}
