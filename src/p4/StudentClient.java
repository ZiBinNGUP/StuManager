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
			new DefaultMutableTreeNode(new MyNode("����ѡ��","0"));
	private DefaultMutableTreeNode dmtn1 = 
			new DefaultMutableTreeNode(new MyNode("ϵͳѡ��","1"));
	private DefaultMutableTreeNode dmtn2 = 
			new DefaultMutableTreeNode(new MyNode("ѧ��������Ϣ","2"));
	private DefaultMutableTreeNode dmtn3 = 
			new DefaultMutableTreeNode(new MyNode("ѧ���γ���Ϣ","3"));
	private DefaultMutableTreeNode dmtn4 = 
			new DefaultMutableTreeNode(new MyNode("ѧ���ɼ���Ϣ","4"));
	private DefaultMutableTreeNode dmtn11 = 
			new DefaultMutableTreeNode(new MyNode("�˳�","11"));
	private DefaultMutableTreeNode dmtn13 = 
			new DefaultMutableTreeNode(new MyNode("�޸�����","13"));
	private DefaultMutableTreeNode dmtn21 = 
			new DefaultMutableTreeNode(new MyNode("������Ϣ�޸�","21"));
	private DefaultMutableTreeNode dmtn22 = 
			new DefaultMutableTreeNode(new MyNode("������Ϣ��ѯ","22"));
	private DefaultMutableTreeNode dmtn31 = 
			new DefaultMutableTreeNode(new MyNode("�γ���Ϣ��ѯ","31"));
	private DefaultMutableTreeNode dmtn32 = 
			new DefaultMutableTreeNode(new MyNode("�γ����","32"));
//	private DefaultMutableTreeNode dmtn34 = 
//			new DefaultMutableTreeNode(new MyNode("��ӿγ�","34"));
	private DefaultMutableTreeNode dmtn42 = 
			new DefaultMutableTreeNode(new MyNode("�ɼ���Ϣ��ѯ","42"));
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
		/*��ʼ�����뽫�ں����ģ�鿪���Ĺ�������һ���*/
		welcome2 = new Welcome2("��ӭʹ�ã�");
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
		/*������ģ�齫�ں����ģ�鿪���Ĺ�������һ���*/
		
	}
	public void initialFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(jsp1);
		jsp1.setDividerLocation(200);
		jsp1.setDividerSize(4);
		this.setTitle("ѧ���ͻ���");
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
							cl.show(jpy, "changepwdstudent");
							changepwdstudent.setFocus();
							
						}
						else if(id.equals("21")) {  //ѧ��������Ϣ�޸�
							
						}
						else if(id.equals("22")) {  //ѧ��������Ϣ�鿴
							cl.show(jpy, "stuquery1");
						}
						else if(id.equals("31")) {    //�γ���Ϣ��ѯ
							
						}
						else if(id.equals("32")) {    //�γ����
							
						}
//						else if(id.equals("34")) {    
//							
//						}
						else if(id.equals("42")) {    //�ɼ���Ϣ��ѯ
							
						}
					}
				});
		jt.setToggleClickCount(1);
	}
}
