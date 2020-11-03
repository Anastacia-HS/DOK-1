package page;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import DB_User.User;

public class DOKPage extends JFrame {
	
	
	//pos
	private final static int movieN = 4;
	
	private User user;
	
	//component
	private CategoryPanel c1 = new CategoryPanel();
	
	
	private JPanel jp = new JPanel();
	private JLabel jlBoxoffice = new JLabel();	//�ڽ����ǽ�
	private JButtonT jbtnPlusMovie = new JButtonT();	//�� ���� ��ȭ����
	private JButtonT[] jbtnMovies = new JButtonT[movieN];
	private ImageIcon[] imgLogo = new ImageIcon[movieN];	//�ΰ� �̹���
	
	public DOKPage() {
		
	}
	
	public DOKPage(User user) {
		super("DOK");
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
		
		//Panel
		jp.setBackground(Color.WHITE);
		jp.setBounds(0,(int) (Main.SCREEN_HEIGHT*0.25),Main.SCREEN_WIDTH,(int)(Main.SCREEN_HEIGHT*0.75));
		jp.setLayout(null);
		add(jp);
		
		//�ڽ� ���ǽ� Label
		jlBoxoffice.setText("�ڽ����ǽ�");
		jlBoxoffice.setFont(new Font(null,Font.BOLD,20));
		jlBoxoffice.setBackground(Color.GREEN);
		jlBoxoffice.setOpaque(true);
		//jlBoxoffice.setOpaque(false);
		jlBoxoffice.setBounds(Main.SCREEN_WIDTH/2-(110/2),70,110,50);
		jp.add(jlBoxoffice);
		
		//�� ���� ��ȭ ���� Lable
		jbtnPlusMovie.setText("�� ���� ��ȭ����");
		jbtnPlusMovie.setFont(new Font(null,Font.PLAIN,20));
		jbtnPlusMovie.setBackground(Color.GREEN);
		jbtnPlusMovie.setOpaque(true);
		//jbtnPlusMovie.setOpaque(false);
		jbtnPlusMovie.setBounds(Main.SCREEN_WIDTH-300,70,200,50);
		jp.add(jbtnPlusMovie);
		
		
		
		//��ȭ ��Ʈ ��ư
		for(int i=0; i<movieN; i++) {
			int x = 300*(i)+ 180;
			jbtnMovies[i] = new JButtonT();
			jbtnMovies[i].setText("test");
			jbtnMovies[i].setBounds(x, 150, 250, 400);
			jp.add(jbtnMovies[i]);
			
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
