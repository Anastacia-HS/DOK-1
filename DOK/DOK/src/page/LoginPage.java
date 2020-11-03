package page;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DB_User.DBSelectUserInfo;

public class LoginPage extends JFrame{
	//��ġ 
	private final static int C_X = Main.SCREEN_WIDTH/2+200;
	private final static int IDLable_Y = 200;
	private final static int IDTextF_Y = 300;
	private final static int PWLable_Y = 400;
	private final static int PWTextF_Y = 500;
	private final static int LoginBtn_Y = 700;
	
	//component
	private JPanel jp = new JPanel();
	private JLabel jlId = new JLabel("ID");
	private JTextField jtId = new JTextField();
	private JLabel jlPw = new JLabel("PassWord");
	private JPasswordField jtPw = new JPasswordField();
	private JButtonT jbtnLogin = new JButtonT();
	private JButtonT jbtnSingUp = new JButtonT();
	private ImageIcon imgLogo = new ImageIcon("src/imges/dok.png");
	private JLabel jlLogo = new JLabel();
	
	
	
	private DBSelectUserInfo connection = new DBSelectUserInfo();	//DB���� Ŭ����
	private String userID,userPassword;
	
	//font
	private Font font1 = new Font(null,Font.BOLD,30);
	private Font font2 = new Font(null,Font.PLAIN,20);
	
	public LoginPage() {
		super("Login");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null); // ���׿��� ��������
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);	//���̾ƿ� null
		setVisible(true);	
		
		//�г�
		jp.setBounds(0,0,Main.SCREEN_WIDTH,Main.SCREEN_HEIGHT);
		jp.setBackground(Color.WHITE);
		jp.setLayout(null);
		add(jp);
		
		//�ΰ� �̹��� label
		jlLogo.setIcon(imgLogo);
		jlLogo.setBounds(0,0,200,100);
		jp.add(jlLogo);
		
		
		//���̵� label
		jlId.setBounds(C_X,IDLable_Y,200,100);
		jlId.setFont(font1);
		jp.add(jlId);
		
		//���̵� textField
		jtId.setBounds(C_X, IDTextF_Y, 250, 50);
		jtId.setFont(font2);
		jp.add(jtId);
		
		//�н����� label
		jlPw.setBounds(C_X,PWLable_Y,200,100);
		jlPw.setFont(font1);
		jp.add(jlPw);
		
		//�н����� textField
		jtPw.setBounds(C_X,PWTextF_Y,250,50);
		jtPw.setFont(font2);
		jp.add(jtPw);
		
		//�α��� ��ư
		jbtnLogin.setText("�α���");
		jbtnLogin.setFont(font2);
		jbtnLogin.setBounds(C_X,LoginBtn_Y,300,80);
		jp.add(jbtnLogin);
		
		//ȸ������ ��ư
		jbtnSingUp.setText("ȸ������");
		jbtnSingUp.setBounds(C_X,LoginBtn_Y+100,300,80);
		jbtnSingUp.setFont(font2);
		jp.add(jbtnSingUp);
		
		jbtnLogin.addActionListener(new EventHandler());
		jbtnSingUp.addActionListener(new EventHandler());
			
	}
	class EventHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==jbtnLogin) {//�α��� ��ư
				
				userID = jtId.getText();
				userPassword = jtPw.getText();
				
				boolean success = connection.isUser(userID, userPassword);
				if(success) {//����
					new DOKPage();
					setVisible(false);
				}else {
					JOptionPane message =new JOptionPane();//�޽��� �ڽ� ��ü
					message.showMessageDialog(null,"���̵� �Ǵ� �н����尡 ���� �ʽ��ϴ�. Ȯ�� ��  �Է����ּ���" );
				}
				
				
			}else if(e.getSource() == jbtnSingUp) {//ȸ������ ��ư
				new SignUpPage();
				setVisible(false);
			}
			
		}
	}
}

