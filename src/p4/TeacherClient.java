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
			new DefaultMutableTreeNode(new MyNode("����ѡ��","0"));
	private DefaultMutableTreeNode dmtn1 = 
			new DefaultMutableTreeNode(new MyNode("ϵͳѡ��","1"));
	private DefaultMutableTreeNode dmtn2 = 
			new DefaultMutableTreeNode(new MyNode("ѧ��������Ϣ����","2"));
	private DefaultMutableTreeNode dmtn3 = 
			new DefaultMutableTreeNode(new MyNode("ѧ���γ���Ϣ����","3"));
	private DefaultMutableTreeNode dmtn4 = 
			new DefaultMutableTreeNode(new MyNode("ѧ���ɼ���Ϣ����","4"));
	private DefaultMutableTreeNode dmtn11 = 
			new DefaultMutableTreeNode(new MyNode("�˳�","11"));
	private DefaultMutableTreeNode dmtn13 = 
			new DefaultMutableTreeNode(new MyNode("�޸�����","13"));
	private DefaultMutableTreeNode dmtn21 = 
			new DefaultMutableTreeNode(new MyNode("������Ϣ���","21"));
	private DefaultMutableTreeNode dmtn22 = 
			new DefaultMutableTreeNode(new MyNode("������Ϣ��ѯ","22"));
	private DefaultMutableTreeNode dmtn23 = 
			new DefaultMutableTreeNode(new MyNode("�޸�ѧ��������Ϣ","23"));
	private DefaultMutableTreeNode dmtn24 = 
			new DefaultMutableTreeNode(new MyNode("ɾ��ѧ����Ϣ","24"));
	private DefaultMutableTreeNode dmtn221 = 
			new DefaultMutableTreeNode(new MyNode("��ѧ�Ų�ѯ","221"));
	private DefaultMutableTreeNode dmtn222 = 
			new DefaultMutableTreeNode(new MyNode("��רҵ��ѯ","222"));
	private DefaultMutableTreeNode dmtn223 = 
			new DefaultMutableTreeNode(new MyNode("��ʡ/ֱϽ�в�ѯ","223"));
	private DefaultMutableTreeNode dmtn31 = 
			new DefaultMutableTreeNode(new MyNode("��ӿγ�","31"));
	private DefaultMutableTreeNode dmtn32 = 
			new DefaultMutableTreeNode(new MyNode("ɾ���γ�","32"));
	private DefaultMutableTreeNode dmtn33 = 
			new DefaultMutableTreeNode(new MyNode("���Ŀγ���Ϣ","33"));
	private DefaultMutableTreeNode dmtn34 = 
			new DefaultMutableTreeNode(new MyNode("��ѯרҵ�γ���Ϣ","34"));
	private DefaultMutableTreeNode dmtn41 = 
			new DefaultMutableTreeNode(new MyNode("���ѧ���ɼ�","41"));
	private DefaultMutableTreeNode dmtn42 = 
			new DefaultMutableTreeNode(new MyNode("��ѯѧ���ɼ�","42"));
	private DefaultMutableTreeNode dmtn421 = 
			new DefaultMutableTreeNode(new MyNode("��ѧ�Ų�ѯ","421"));
	private DefaultMutableTreeNode dmtn422 = 
			new DefaultMutableTreeNode(new MyNode("��רҵ��ѯ","422"));
	private DefaultMutableTreeNode dmtn43 = 
			new DefaultMutableTreeNode(new MyNode("��ѯĳ�γ�ƽ���ɼ�","43"));
	private DefaultMutableTreeNode dmtn44 = 
			new DefaultMutableTreeNode(new MyNode("�޸�ѧ���ɼ�","44"));
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
		/*��ʼ�����뽫�ں����ģ�鿪���Ĺ�������һ���*/
		changepwdteacher = new ChangePwdTeacher();
		welcome1 = new Welcome1("��ӭʹ�ã�");
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
		/*������ģ�齫�ں����ģ�鿪���Ĺ�������һ���*/
		
	}
	public void initialFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(jsp1);
		jsp1.setDividerLocation(180);
		jsp1.setDividerSize(4);
//		Image image = new ImageIcon("").getImage();
//		this.setIconImage(image);
		this.setTitle("��ʦ�ͻ���");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = screenSize.width/2;
		int centerY = screenSize.height/2;
		int w = 900;
		int h = 650;
		this.setBounds(centerX-w/2, centerY-h/2-30, w, h);
		this.setVisible(true);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); //����ȫ��
	}
	public void addListener() {
		jt.addMouseListener(
				new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						DefaultMutableTreeNode dmtntemp = //�õ���ǰѡ�еĽڵ����
								(DefaultMutableTreeNode)jt.getLastSelectedPathComponent();
						MyNode mynode = (MyNode)dmtntemp.getUserObject();  //�õ��Զ���ڵ����
						String id = mynode.getId();
						//����id���ж�Ӧ����ʾ�ĸ�ҳ��
						if(id.equals("0")) {     //��ӭ����
							
						}
						else if(id.equals("11")) {   //�˳�ϵͳ
							int i = JOptionPane.showConfirmDialog(jpy, "��ȷ��Ҫ�˳�ϵͳ��","ѯ��",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
							if(i == 0) {
								System.exit(0);
							}
						}
						else if(id.equals("13")) {  //��������
						
							cl.show(jpy, "changepwdteacher");
							changepwdteacher.setFocus();
							
						}
						else if(id.equals("21")) {  //���ѧ��ҳ��
							cl.show(jpy, "newstudent");
							newstudent.setFocus();
						}
						else if(id.equals("23")) {   //�޸�ѧ��������Ϣ
							cl.show(jpy, "alterstuinfo");
							alterstuinfo.setFocus();
						}
						else if(id.equals("24")) {   //ɾ��ѧ��
							cl.show(jpy, "delstuinfo");
							delstuinfo.setFocus();
						}
						else if(id.equals("221")) {   //ѧ����Ϣ��ѯҵ��1
							cl.show(jpy, "bysnoquery");
							bysnoquery.setFocus();
						}
						else if(id.equals("222")) {   //ѧ����Ϣ��ѯҵ��2
							cl.show(jpy, "bydeptquery");
							bydeptquery.setFocus();
							
						}
						else if(id.equals("223")) {   //��ʡ��ֱϽ�в�ѯ
							cl.show(jpy, "byproquery");
							byproquery.setFocus();
							
						}
						else if(id.equals("31")) {    //��ӿγ�
							cl.show(jpy, "addcourse");
							addcourse.setFocus();
						}
						else if(id.equals("32")) {    //ɾ���γ�
							cl.show(jpy, "deletecourse");
							deletecourse.setFocus();
						}
						else if(id.equals("33")) {    //���Ŀγ���Ϣ
							cl.show(jpy, "updatecourse");
							updatecourse.setFocus();
							
						}
						else if(id.equals("34")) {    //��ѯרҵ�γ���Ϣ
							
						}
						else if(id.equals("41")) {    //���ѧ���ɼ�
							cl.show(jpy, "update_grades");
						}
						else if(id.equals("421")) {   //��ѧ�Ų�ѯѧ���ɼ�
							
						}
						else if(id.equals("422")) {   //��רҵ��ѯ
							
						}
						else if(id.equals("43")) {   //��ѯĳ�γ�ƽ���ɼ�
							cl.show(jpy, "se_avg_grade");
							se_avg_grade.setFocus();
						}
						else if(id.equals("44")) {   //�޸�ѧ���ɼ�
							cl.show(jpy, "alter_stu_grade");
							alter_stu_grade.setFocus();
						}
					}
				});
		jt.setToggleClickCount(1);
	}
}
