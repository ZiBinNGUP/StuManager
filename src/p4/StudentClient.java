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
public class StudentClient extends JFrame{
	private static final long serialVersionUID = 1L;
	String coll_id;
	String user;
	private DefaultMutableTreeNode dmtnRoot =
			new DefaultMutableTreeNode(new MyNode("操作选项","0"));
	private DefaultMutableTreeNode dmtn1 = 
			new DefaultMutableTreeNode(new MyNode("系统选项","1"));
	private DefaultMutableTreeNode dmtn2 = 
			new DefaultMutableTreeNode(new MyNode("学生基本信息","2"));
	private DefaultMutableTreeNode dmtn3 = 
			new DefaultMutableTreeNode(new MyNode("学生课程信息","3"));
	private DefaultMutableTreeNode dmtn4 = 
			new DefaultMutableTreeNode(new MyNode("学生成绩信息","4"));
	private DefaultMutableTreeNode dmtn11 = 
			new DefaultMutableTreeNode(new MyNode("退出","11"));
	private DefaultMutableTreeNode dmtn13 = 
			new DefaultMutableTreeNode(new MyNode("修改密码","13"));
	private DefaultMutableTreeNode dmtn21 = 
			new DefaultMutableTreeNode(new MyNode("基本信息修改","21"));
	private DefaultMutableTreeNode dmtn22 = 
			new DefaultMutableTreeNode(new MyNode("基本信息查询","22"));
	private DefaultMutableTreeNode dmtn31 = 
			new DefaultMutableTreeNode(new MyNode("课程信息查询","31"));
	private DefaultMutableTreeNode dmtn32 = 
			new DefaultMutableTreeNode(new MyNode("课程添加","32"));
//	private DefaultMutableTreeNode dmtn34 = 
//			new DefaultMutableTreeNode(new MyNode("添加课程","34"));
	private DefaultMutableTreeNode dmtn42 = 
			new DefaultMutableTreeNode(new MyNode("成绩信息查询","42"));
	private DefaultTreeModel dtm = new DefaultTreeModel(dmtnRoot);
	private JTree jt = new JTree(dtm);
	private JScrollPane jspz = new JScrollPane(jt);
	private JPanel jpy = new JPanel();
	private JSplitPane jsp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jspz,jpy);
	private Welcome2 welcome2;
	private ChangePwdStudent changepwdstudent;
	private StuQuery1 stuquery1;
	
	CardLayout cl;
	public StudentClient(String user) {
		this.user = user;
		this.initialTree();
		this.initialPanel();
		this.addListener();
		this.initialJpy();
		this.initialFrame();
		
	}
	public void initialPanel() {
		/*初始化代码将在后面各模块开发的过程中逐一添加*/
		welcome2 = new Welcome2("欢迎使用！");
		changepwdstudent = new ChangePwdStudent(user);
		stuquery1 = new StuQuery1(user);
		
	}
	
	public void initialTree() {
		dmtnRoot.add(dmtn1);
		dmtnRoot.add(dmtn2);
		dmtnRoot.add(dmtn3);
		dmtnRoot.add(dmtn4);
		dmtn1.add(dmtn11);
		dmtn1.add(dmtn13);
		dmtn2.add(dmtn21);
		dmtn2.add(dmtn22);
//		dmtn22.add(dmtn221);
//		dmtn22.add(dmtn222);
		dmtn3.add(dmtn31);
		dmtn3.add(dmtn32);
//		dmtn3.add(dmtn34);
		dmtn4.add(dmtn42);
	}
	public void initialJpy() {
		jpy.setLayout(new CardLayout());
		cl = (CardLayout)jpy.getLayout();
		jpy.add(welcome2,"welcome2",0);
		jpy.add(changepwdstudent,"changepwdstudent",1);
		jpy.add(stuquery1, "stuquery1",1);
		/*各功能模块将在后面各模块开发的过程中逐一添加*/
		
	}
	public void initialFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(jsp1);
		jsp1.setDividerLocation(200);
		jsp1.setDividerSize(4);
		this.setTitle("学生客户端");
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
							cl.show(jpy, "changepwdstudent");
							changepwdstudent.setFocus();
							
						}
						else if(id.equals("21")) {  //学生基本信息修改
							
						}
						else if(id.equals("22")) {  //学生基本信息查看
							cl.show(jpy, "stuquery1");
						}
						else if(id.equals("31")) {    //课程信息查询
							
						}
						else if(id.equals("32")) {    //课程添加
							
						}
//						else if(id.equals("34")) {    
//							
//						}
						else if(id.equals("42")) {    //成绩信息查询
							
						}
					}
				});
		jt.setToggleClickCount(1);
	}
}
