package page;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DB_User.User;
import page.DOKPage.EventHandler;

public class MyPage extends JFrame implements ActionListener{
	private final static int PaddingLeft = 150;
	private final static int PaddingTop = 100;

	
	private User user = new User();
	
	//component
	private CategoryPanel c1 = new CategoryPanel();
	
	private JPanel jp = new JPanel();
	JLabel jlProfile = new JLabel("����");
	JLabel jlName = new JLabel();
	
	JLabel jlId = new JLabel("���̵�");
	JLabel jlBirthday = new JLabel("�������");
	JLabel jlP_number = new JLabel("��ȭ��ȣ");
	JLabel jlTaste = new JLabel("��ȭ ����");
	JButton jbtnCorrection = new JButton("������������");
	
	JLabel jlRecord_movie = new JLabel("�ֱ� ������ ��ȭ");
	JLabel jlRecord_movie_info = new JLabel();
	
	public MyPage() {}
	public MyPage(User user) {
		super("���� ������");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null); // ���׿��� ��������
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);	//���̾ƿ� null
		setVisible(true);
		
		this.user = user;
		//ī�װ� Panel
		c1 = new CategoryPanel(user);	//ī�װ� panel
		for(int i=0; i<c1.jbtnCategory.length; i++) {
			c1.jbtnCategory[i].addActionListener(new EventHandler());
		}
		add(c1);
		
		this.user = user;
		
		//������ ����
		jlProfile.setBounds(PaddingLeft, PaddingTop, 200, 200);
		jlProfile.setOpaque(true);
		jlProfile.setBackground(Color.RED);
		jp.add(jlProfile);
		
		//����� �̸�
		jlName.setBounds(PaddingLeft, PaddingTop + 215, 200, 50);
		jlName.setOpaque(true);
		jlName.setBackground(Color.GREEN);
		jlName.setText("�̸�: "+user.getUserName());
		jp.add(jlName);
		
		//���̵�
		jlId.setBounds(PaddingLeft + 350, PaddingTop, 250, 40);
		jlId.setOpaque(true);
		jlId.setBackground(Color.BLUE);
		jlId.setText("���̵�: "+user.getUserID());
		jp.add(jlId);
		
		//������� : yyyy-mm-dd
		jlBirthday.setBounds(PaddingLeft + 350, PaddingTop + 50, 250, 40);
		jlBirthday.setOpaque(true);
		jlBirthday.setBackground(Color.BLUE);
		jlBirthday.setText("�������: "+user.getUseryymmdd());
		jp.add(jlBirthday);
		
		//��ȭ��ȣ
		jlP_number.setBounds(PaddingLeft + 350, PaddingTop + 100, 250, 40);
		jlP_number.setOpaque(true);
		jlP_number.setBackground(Color.BLUE);
		jlP_number.setText("��ȭ��ȣ: "+user.getUserPhone());
		jp.add(jlP_number);
		
		//��ȭ ����
		jlTaste.setBounds(PaddingLeft + 350, PaddingTop + 150, 250, 40);
		jlTaste.setOpaque(true);
		jlTaste.setBackground(Color.BLUE);
		jlTaste.setText("��ȭ����-1: "+user.getUserTaste1());
		jp.add(jlTaste);
		
		//������������
		jbtnCorrection.setBounds(PaddingLeft + 350, PaddingTop + 225, 250, 40);
		jbtnCorrection.setOpaque(true);
		jbtnCorrection.setBackground(Color.GRAY);
		jbtnCorrection.addActionListener(this);
		jp.add(jbtnCorrection);
		
		//�ֱ� ������ ��ȭ
		jlRecord_movie.setBounds(PaddingLeft + 750, PaddingTop, 450, 40);
		jlRecord_movie.setOpaque(true);
		jlRecord_movie.setBackground(Color.YELLOW);
		jp.add(jlRecord_movie);
		
		//�ֱ� ������ ��ȭ
		jlRecord_movie_info.setBounds(PaddingLeft + 750, PaddingTop + 40, 450, 230);
		jlRecord_movie_info.setOpaque(true);
		jlRecord_movie_info.setBackground(Color.CYAN);
		jp.add(jlRecord_movie_info);

		
		
		//Panel
		jp.setBackground(Color.WHITE);
		jp.setBounds(0,(int) (Main.SCREEN_HEIGHT*0.25),Main.SCREEN_WIDTH,(int)(Main.SCREEN_HEIGHT*0.75));
		jp.setLayout(null);
		add(jp);
	}
	
	//���� ��ü
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbtnCorrection) {
			new P_InformationPage();
		}
		
	}
	class EventHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==c1.jbtnCategory[0]) {//Ȩ
				new DOKPage(user);
			}else if(e.getSource()==c1.jbtnCategory[1]) {//��ȭ
				new ChartPage(user);
			}else if(e.getSource()==c1.jbtnCategory[2]) {//����
				new Reservation_start_page(user);
			}else if(e.getSource()==c1.jbtnCategory[3]) {//���� ������
				new MyPage(user);
			}
			dispose();
			
		}
		
	}

	
}
