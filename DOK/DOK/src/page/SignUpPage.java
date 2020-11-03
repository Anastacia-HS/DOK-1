package page;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import DB_User.DBuserInfo;

public class SignUpPage extends JFrame {

	// DB
	DBuserInfo coneection = new DBuserInfo();

	// ��ġ
	private final static int C_X = Main.SCREEN_WIDTH / 2 - 250;
	private final static int ID_Y = 150;
	private final static int PW_Y = ID_Y+150;
	private final static int PWCheck_Y = PW_Y+150;
	private final static int Name_Y = PWCheck_Y+150;
	private final static int Birth_Y = Name_Y+150;
	private final static int Gender_Y = Birth_Y+150;
	private final static int Phone_Y = Gender_Y+150;
	private final static int Taste_Y = Phone_Y+150;
	// private final static int TasteCB_Y = 1300;
	private final static int SignUP_Y = 1850;

	private final static int TopMargin_Y = 80;
	private final static int Taste_N = 6;

	private final static int PanelHeight = Main.SCREEN_HEIGHT * 2 ;

	// component
	private JScrollPane jscroll;
	private JPanel jp = new JPanel();
	private ImageIcon imgLogo = new ImageIcon("src/imges/dok.png"); // �ΰ� �̹���
	private JLabel jlLogo = new JLabel();

	private JLabel jlID = new JLabel("���̵�*");
	private JLabel jlPw = new JLabel("��й�ȣ*");
	private JLabel jlPwCheck = new JLabel("��й�ȣ ��Ȯ��*");
	private JLabel jlName = new JLabel("�̸�*");
	private JLabel jlBirth = new JLabel("�������(8�ڸ�)�� �Է����ּ���*");
	private JLabel jlGender = new JLabel("������ �Է����ּ���*");
	private JLabel jlPhone = new JLabel("��ȭ��ȣ�� �Է����ּ���*");
	private JLabel jlTaste = new JLabel("������ �������ּ���(�ִ�2��)");

	//private String[] hint = {"�̸�","�������(8�ڸ�)"};
	
	private JTextField jtID = new JTextField();
	private JPasswordField jtPw = new JPasswordField();
	private JPasswordField jtPwCheck = new JPasswordField();
	private JTextField jtName = new JTextField();
	private JTextField jtBirth = new JTextField();
	private ButtonGroup groundGender = new ButtonGroup();
	private JRadioButton jrw = new JRadioButton("����");
	private JRadioButton jrm = new JRadioButton("����");
	private JTextField jtPhone = new JTextField();
	private JCheckBox[] jcTaste = new JCheckBox[Taste_N];
	private JButtonT jbtnSignUP = new JButtonT();

	// ����
	private String[] taste = new String[] { "�׼�", "�θǽ�", "����", "��Ÿ��", "SF-�������", "������" };

	private int n = 0;
	// ������ ����
	private String userID, userPassword, userPasswordCheck, userName,useryymmdd,userGender="", userPhone,userTaste1, userTaste2;

	// size
	private Dimension size = new Dimension();// ����� �����ϱ� ���� ��ü ����

	// font
	private Font font1 = new Font(null, Font.BOLD, 20);
	private Font font2 = new Font(null, Font.PLAIN, 20);

	public SignUpPage() {

		super("ȸ������");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null); // ���׿��� ��������
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null); // ���̾ƿ� null
		setVisible(true);

		// Panel ����� ����
		size.setSize(Main.SCREEN_WIDTH, PanelHeight);

		// �г�
		// jp.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT*2);
		jp.setLayout(null);
		jp.setPreferredSize(size);
		jp.setBackground(Color.WHITE);

		// ��ũ�� �г�
		JScrollPane scrollPanel = new JScrollPane(jp, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.setBounds(0, 0, Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		add(scrollPanel);

		// �ΰ�
		jlLogo.setIcon(imgLogo);
		jlLogo.setBounds(Main.SCREEN_WIDTH / 2 - 100, 30, 200, 100);
		jp.add(jlLogo);

		// ���̵� label
		jlID.setBounds(C_X, ID_Y, 200, 100);
		jlID.setFont(font1);
		jp.add(jlID);

		// ���̵� textField
		jtID.setBounds(C_X, ID_Y + TopMargin_Y, 500, 50);
		jtID.setFont(font2);
		jp.add(jtID);

		// ��й�ȣ label
		jlPw.setBounds(C_X, PW_Y, 200, 100);
		jlPw.setFont(font1);
		jp.add(jlPw);

		// ��й�ȣ textField
		jtPw.setBounds(C_X, PW_Y + TopMargin_Y, 500, 50);
		jtPw.setFont(font2);
		jp.add(jtPw);

		// ��й�ȣ ��Ȯ�� label
		jlPwCheck.setBounds(C_X, PWCheck_Y, 200, 100);
		jlPwCheck.setFont(font1);
		jp.add(jlPwCheck);

		// ��й�ȣ ��Ȯ�� textField
		jtPwCheck.setBounds(C_X, PWCheck_Y + TopMargin_Y, 500, 50);
		jtPwCheck.setFont(font2);
		jp.add(jtPwCheck);

		// �̸� label
		jlName.setBounds(C_X, Name_Y, 200, 100);
		jlName.setFont(font1);
		jp.add(jlName);

		// �̸� textField
		jtName.setBounds(C_X, Name_Y + TopMargin_Y, 500, 50);
		jtName.setFont(font2);
		jp.add(jtName);

		// ������� label
		jlBirth.setBounds(C_X, Birth_Y, 500, 100);
		jlBirth.setFont(font1);
		jp.add(jlBirth);

		// ������� textField
		jtBirth.setBounds(C_X, Birth_Y + TopMargin_Y, 500, 50);
		jtBirth.setFont(font2);
		jp.add(jtBirth);
		
		
		//���� label
		jlGender.setBounds(C_X, Gender_Y,300,100);
		jlGender.setFont(font1);
		jp.add(jlGender);
		
		//����m radio
		jrm.setBounds(C_X,Gender_Y+TopMargin_Y,100,50);
		jrm.setFont(font2);
		jrm.addItemListener(new RadioButtonEvent());
		groundGender.add(jrm);
		jp.add(jrm);
		
		//����w radio
		jrw.setBounds(C_X+110,Gender_Y+TopMargin_Y,100,50);
		jrw.setFont(font2);
		jrw.addItemListener(new RadioButtonEvent());
		groundGender.add(jrw);
		jp.add(jrw);

		// ��ȭ��ȣ label
		jlPhone.setBounds(C_X, Phone_Y, 300, 100);
		jlPhone.setFont(font1);
		jp.add(jlPhone);

		// ��ȭ��ȣ textField
		jtPhone.setBounds(C_X, Phone_Y + TopMargin_Y, 500, 50);
		jtPhone.setFont(font2);
		jp.add(jtPhone);

		// ���� label
		jlTaste.setBounds(C_X, Taste_Y, 300, 100);
		jlTaste.setFont(font1);
		jp.add(jlTaste);

		// ���� checkbox
		for (int i = 0; i < Taste_N; i++) {
			jcTaste[i] = new JCheckBox();
			jcTaste[i].setText(taste[i]);
			jcTaste[i].setFont(font2);
			jcTaste[i].setFocusPainted(false);
			// setBorderPainted(false);
			jcTaste[i].setBackground(Color.PINK);
			jcTaste[i].setBounds(C_X, Taste_Y + (TopMargin_Y) * (i + 1), 150, 50);
			jp.add(jcTaste[i]);
			jcTaste[i].addItemListener(new CheckBoxEvent());
		}

		// ȸ������
		jbtnSignUP.setText("ȸ������");
		jbtnSignUP.setFont(font1);
		jbtnSignUP.setBounds(C_X, SignUP_Y, 500, 100);
		jp.add(jbtnSignUP);

		// ȸ������ ������
		jbtnSignUP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				userID = jtID.getText();
				userPassword = jtPw.getText();
				userPasswordCheck = jtPwCheck.getText();
				userName = jtName.getText();
				useryymmdd = jtBirth.getText();
				userPhone = jtPhone.getText();
				
				
				JOptionPane message =new JOptionPane();//�޽��� �ڽ� ��ü
				
				//�����Ͱ� ����ִ��� Ȯ��
				if(userID.isEmpty() || userPassword.isEmpty() || userPasswordCheck.isEmpty()|| userName.isEmpty() || useryymmdd.isEmpty()
						|| userGender.isEmpty() || userPhone.isEmpty()) {
					message.showMessageDialog(null, "�Էµ��� ���� ������ �ֽ��ϴ�.");			
				}else {//��� �����Ͱ� �ԷµǾ����� ����
					if(!(userPassword.equals(userPasswordCheck))) {
						message.showMessageDialog(null,"��й�ȣ�� ��ġ ���� �ʽ��ϴ�." );
					}else {
						boolean success = coneection.addUser(userID, userPassword, userName, useryymmdd, userGender,userPhone, userTaste1, userTaste2);
						if(success) {
							message.showMessageDialog(null,"ȸ�����Կ� �����߽��ϴ�!" );
							new LoginPage();
							dispose();
						}else {
							message.showMessageDialog(null,"��ġ�ϴ� ���̵� �ֽ��ϴ�." );
						}
						//System.out.println(coneection.addUser(userID, userPassword, userName, useryymmdd, userGender,userPhone, userTaste1, userTaste2));
					}
				}
				//
				
			}
		});

	}
	

	//������ư ������
	class RadioButtonEvent implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(jrm.isSelected()) {
				userGender = "����";
			}else {
				userGender = "����";
			}
		}
	
	}
	
	// üũ�ڽ� ������
	class CheckBoxEvent implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if (e.getStateChange() == ItemEvent.DESELECTED) {
				n -= 1;
			} else {
				if (n < 2) {
					if (n == 0) {
						for (int i = 0; i < Taste_N; i++) {
							if (e.getItem() == jcTaste[i]) {
								userTaste1 = taste[i];
							}
						}
					} else {
						for (int i = 0; i < Taste_N; i++) {
							if (e.getItem() == jcTaste[i]) {
								userTaste2 = taste[i];
							}
						}
					}
					n += 1;
				} else {
					for (int i = 0; i < Taste_N; i++) {
						if (e.getItem() == jcTaste[i]) {
							jcTaste[i].setSelected(false);
						}
					}
					n = 2;
				}
			}
		}

	}
}
