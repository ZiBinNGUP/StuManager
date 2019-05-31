package p4;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
public class TeacherClient extends JFrame{
	private static final long serialVersionUID = 1L;
	String spec_name;
	private DefaultMutableTreeNode dmtnRoot =
			new DefaultMutableTreeNode(new MyNode("操作选项","0"));
	private DefaultMutableTreeNode dmtn1 = 
			new DefaultMutableTreeNode(new MyNode("系统选项","1"));
	private DefaultMutableTreeNode dmtn2 = 
			new DefaultMutableTreeNode(new MyNode("学生基本信息管理","2"));
	private DefaultMutableTreeNode dmtn3 = 
			new DefaultMutableTreeNode(new MyNode("学生课程信息管理","3"));
	private DefaultMutableTreeNode dmtn4 = 
			new DefaultMutableTreeNode(new MyNode("学生成绩信息管理","4"));
	private DefaultMutableTreeNode dmtn11 = 
			new DefaultMutableTreeNode(new MyNode("退出","11"));
	private DefaultMutableTreeNode dmtn13 = 
			new DefaultMutableTreeNode(new MyNode("修改密码","13"));
	private DefaultMutableTreeNode dmtn21 = 
			new DefaultMutableTreeNode(new MyNode("基本信息添加","21"));
	private DefaultMutableTreeNode dmtn22 = 
			new DefaultMutableTreeNode(new MyNode("基本信息查询","22"));
	private DefaultMutableTreeNode dmtn23 = 
			new DefaultMutableTreeNode(new MyNode("修改学生基本信息","23"));
	private DefaultMutableTreeNode dmtn24 = 
			new DefaultMutableTreeNode(new MyNode("删除学生信息","24"));
	private DefaultMutableTreeNode dmtn221 = 
			new DefaultMutableTreeNode(new MyNode("按学号查询","221"));
	private DefaultMutableTreeNode dmtn222 = 
			new DefaultMutableTreeNode(new MyNode("按专业查询","222"));
	private DefaultMutableTreeNode dmtn223 = 
			new DefaultMutableTreeNode(new MyNode("按省/直辖市查询","223"));
	private DefaultMutableTreeNode dmtn31 = 
			new DefaultMutableTreeNode(new MyNode("添加课程","31"));
	private DefaultMutableTreeNode dmtn32 = 
			new DefaultMutableTreeNode(new MyNode("删除课程","32"));
	private DefaultMutableTreeNode dmtn33 = 
			new DefaultMutableTreeNode(new MyNode("更改课程信息","33"));
	private DefaultMutableTreeNode dmtn34 = 
			new DefaultMutableTreeNode(new MyNode("查询专业课程信息","34"));
	private DefaultMutableTreeNode dmtn41 = 
			new DefaultMutableTreeNode(new MyNode("添加学生成绩","41"));
	private DefaultMutableTreeNode dmtn42 = 
			new DefaultMutableTreeNode(new MyNode("查询学生成绩","42"));
	private DefaultMutableTreeNode dmtn421 = 
			new DefaultMutableTreeNode(new MyNode("按学号查询","421"));
	private DefaultMutableTreeNode dmtn422 = 
			new DefaultMutableTreeNode(new MyNode("按专业查询","422"));
	private DefaultMutableTreeNode dmtn43 = 
			new DefaultMutableTreeNode(new MyNode("查询某课程平均成绩","43"));
	private DefaultMutableTreeNode dmtn44 = 
			new DefaultMutableTreeNode(new MyNode("修改学生成绩","44"));
	private DefaultTreeModel dtm = new DefaultTreeModel(dmtnRoot);
	private JTree jt = new JTree(dtm);
	private JScrollPane jspz = new JScrollPane(jt);
	private JPanel jpy = new JPanel();
	private JSplitPane jsp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jspz,jpy);
	private Welcome1 welcome1;
	private ChangePwdTeacher changepwdteacher;
	private NewStudent newstudent;
	private BySnoQuery bysnoquery;
	private ByDeptQuery bydeptquery;
	private ByProQuery byproquery;
	private DelStuInfo delstuinfo;
	private AlterStuInfo alterstuinfo;
	private Alter_Stu_grade alter_stu_grade;
	private addCourse addcourse;
	private UpdateCourse updatecourse;
	private DeleteCourse deletecourse;
	private Se_Avg_grade se_avg_grade;
	private UpdateGrades update_grades;
	CardLayout cl;
	public TeacherClient(String spec_name) {
		this.spec_name = spec_name;
		this.initialTree();
		this.initialPanel();
		this.addListener();
		this.initialJpy();
		this.initialFrame();
		
	}
	public void initialPanel() {
		/*初始化代码将在后面各模块开发的过程中逐一添加*/
		changepwdteacher = new ChangePwdTeacher();
		welcome1 = new Welcome1("欢迎使用！");
		newstudent = new NewStudent(spec_name);
		bysnoquery = new BySnoQuery();
		bydeptquery = new ByDeptQuery();
		byproquery = new ByProQuery();
		delstuinfo = new DelStuInfo();
		alterstuinfo = new AlterStuInfo();
		alter_stu_grade = new Alter_Stu_grade();
		addcourse = new addCourse();
		updatecourse = new UpdateCourse();
		deletecourse = new DeleteCourse();
		se_avg_grade = new Se_Avg_grade();
		update_grades = new UpdateGrades(spec_name);
	}
	
	public void initialTree() {
		dmtnRoot.add(dmtn1);
		dmtnRoot.add(dmtn2);
		dmtnRoot.add(dmtn3);
		dmtnRoot.add(dmtn4);
		dmtn1.add(dmtn11);
		dmtn1.add(dmtn13);
		dmtn2.add(dmtn22);
		dmtn2.add(dmtn21);
		dmtn2.add(dmtn24);
		dmtn2.add(dmtn23);
		dmtn22.add(dmtn221);
		dmtn22.add(dmtn222);
		dmtn22.add(dmtn223);
		dmtn3.add(dmtn31);
		dmtn3.add(dmtn32);
		dmtn3.add(dmtn33);
		dmtn3.add(dmtn34);
		dmtn4.add(dmtn41);
		dmtn4.add(dmtn42);
		dmtn42.add(dmtn421);
		dmtn42.add(dmtn422);
		dmtn4.add(dmtn43);
		dmtn4.add(dmtn44);
	}
	public void initialJpy() {
		jpy.setLayout(new CardLayout());
		cl = (CardLayout)jpy.getLayout();
		jpy.add(welcome1,"welcome1",0);
		jpy.add(changepwdteacher,"changepwdteacher",1);
		jpy.add(newstudent,"newstudent");
		jpy.add(bysnoquery, "bysnoquery");
		jpy.add(bydeptquery, "bydeptquery");
		jpy.add(byproquery, "byproquery");
		jpy.add(delstuinfo, "delstuinfo");
		jpy.add(alterstuinfo, "alterstuinfo");
		jpy.add(alter_stu_grade,"alter_stu_grade");
		jpy.add(addcourse, "addcourse");
		jpy.add(updatecourse, "updatecourse");
		jpy.add(deletecourse, "deletecourse");
		jpy.add(se_avg_grade,"se_avg_grade");
		jpy.add(update_grades,"update_grades");
		/*各功能模块将在后面各模块开发的过程中逐一添加*/
		
	}
	public void initialFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(jsp1);
		jsp1.setDividerLocation(180);
		jsp1.setDividerSize(4);
//		Image image = new ImageIcon("").getImage();
//		this.setIconImage(image);
		this.setTitle("教师客户端");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = screenSize.width/2;
		int centerY = screenSize.height/2;
		int w = 900;
		int h = 650;
		this.setBounds(centerX-w/2, centerY-h/2-30, w, h);
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); //窗体全屏
	}
	public void addListener() {
		jt.addMouseListener(
				new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						DefaultMutableTreeNode dmtntemp = //得到当前选中的节点对象
								(DefaultMutableTreeNode)jt.getLastSelectedPathComponent();
						MyNode mynode = (MyNode)dmtntemp.getUserObject();  //得到自定义节点对象
						String id = mynode.getId();
						//根据id来判断应该显示哪个页面
						if(id.equals("0")) {     //欢迎界面
							
						}
						else if(id.equals("11")) {   //退出系统
							int i = JOptionPane.showConfirmDialog(jpy, "您确认要退出系统吗？","询问",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
							if(i == 0) {
								System.exit(0);
							}
						}
						else if(id.equals("13")) {  //更改密码
						
							cl.show(jpy, "changepwdteacher");
							changepwdteacher.setFocus();
							
						}
						else if(id.equals("21")) {  //添加学生页面
							cl.show(jpy, "newstudent");
							newstudent.setFocus();
						}
						else if(id.equals("23")) {   //修改学生基本信息
							cl.show(jpy, "alterstuinfo");
							alterstuinfo.setFocus();
						}
						else if(id.equals("24")) {   //删除学生
							cl.show(jpy, "delstuinfo");
							delstuinfo.setFocus();
						}
						else if(id.equals("221")) {   //学生信息查询业面1
							cl.show(jpy, "bysnoquery");
							bysnoquery.setFocus();
						}
						else if(id.equals("222")) {   //学生信息查询业面2
							cl.show(jpy, "bydeptquery");
							bydeptquery.setFocus();
							
						}
						else if(id.equals("223")) {   //按省或直辖市查询
							cl.show(jpy, "byproquery");
							byproquery.setFocus();
							
						}
						else if(id.equals("31")) {    //添加课程
							cl.show(jpy, "addcourse");
							addcourse.setFocus();
						}
						else if(id.equals("32")) {    //删除课程
							cl.show(jpy, "deletecourse");
							deletecourse.setFocus();
						}
						else if(id.equals("33")) {    //更改课程信息
							cl.show(jpy, "updatecourse");
							updatecourse.setFocus();
							
						}
						else if(id.equals("34")) {    //查询专业课程信息
							
						}
						else if(id.equals("41")) {    //添加学生成绩
							cl.show(jpy, "update_grades");
						}
						else if(id.equals("421")) {   //按学号查询学生成绩
							
						}
						else if(id.equals("422")) {   //按专业查询
							
						}
						else if(id.equals("43")) {   //查询某课程平均成绩
							cl.show(jpy, "se_avg_grade");
							se_avg_grade.setFocus();
						}
						else if(id.equals("44")) {   //修改学生成绩
							cl.show(jpy, "alter_stu_grade");
							alter_stu_grade.setFocus();
						}
					}
				});
		jt.setToggleClickCount(1);
	}
}
