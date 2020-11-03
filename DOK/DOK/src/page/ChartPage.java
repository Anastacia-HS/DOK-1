package page;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import DB_User.User;
import page.DOKPage.EventHandler;

public class ChartPage extends JFrame{
	private final static int PaddingLeft = 150;
	private final static int PaddingTop = 50;
	private final static int PanelHeight = Main.SCREEN_HEIGHT * 2 ;
	
	
	private User user;
	
	//component
	private CategoryPanel c1 = new CategoryPanel();
	
	
	private JPanel jp = new JPanel();
	
	// size
	private Dimension size = new Dimension();// ����� �����ϱ� ���� ��ü ����
	
	JLabel jlGenre = new JLabel("�帣");
	String[] genre = {"����", "���", "�θǽ�", "������", "�ִϸ��̼�", "�׼�", "SF"};
	JComboBox jcbGenre = new JComboBox(genre);
	
	JButton jbtnRating = new JButton("����");
	JButton jbtnTaste = new JButton("����");
	
	JLabel[][] jlPoster = new JLabel[4][2];
	JButton[][] jbtnTicket = new JButton[4][2];
	
	public ChartPage() {
		
	}
	
	public ChartPage(User user) {
		super("��ȭ ��Ʈ");
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
	
		
		
		//�帣
		jlGenre.setBounds(PaddingLeft, PaddingTop, 75, 40);
		jlGenre.setOpaque(true);
		jlGenre.setBackground(Color.RED);
		jp.add(jlGenre);
		
		jcbGenre.setBounds(PaddingLeft + 75, PaddingTop, 200, 40);
		jp.add(jcbGenre);
		
		//����
		jbtnRating.setBounds(PaddingLeft + 375, PaddingTop, 100, 40);
		jbtnRating.setOpaque(true);
		jbtnRating.setBackground(Color.YELLOW);
		jp.add(jbtnRating);
		
		//����
		jbtnTaste.setBounds(PaddingLeft + 525, PaddingTop, 100, 40);
		jbtnTaste.setOpaque(true);
		jbtnTaste.setBackground(Color.BLUE);
		jp.add(jbtnTaste);
		
		for(int i = 0; i < jlPoster.length; i++) {
			for(int j = 0; j < jlPoster[i].length; j++) {
				jlPoster[i][j] = new JLabel();
				
				jlPoster[i][j].setBounds(PaddingLeft + (i * 325), PaddingTop + 100 + (j * 400), 200, 300);
				jlPoster[i][j].setOpaque(true);
				jlPoster[i][j].setBackground(Color.GRAY);
				jp.add(jlPoster[i][j]);
			}
		}
		
		for(int i = 0; i < jbtnTicket.length; i++) {
			for(int j = 0; j < jbtnTicket[i].length; j++) {
				jbtnTicket[i][j] = new JButton("����");
				
				jbtnTicket[i][j].setBounds(PaddingLeft + (i * 325), PaddingTop + 415 /*(j * 350)*/, 200, 40);
				jbtnTicket[i][j].setOpaque(true);
				jbtnTicket[i][j].setBackground(Color.GREEN);
				jp.add(jbtnTicket[i][j]);
			}
		}
		
		
		
		//Panel
		size.setSize(Main.SCREEN_WIDTH, PanelHeight);
		jp.setBackground(Color.WHITE);
		jp.setPreferredSize(size);
		//jp.setBounds(0,(int) (Main.SCREEN_HEIGHT*0.25),Main.SCREEN_WIDTH,(int)(Main.SCREEN_HEIGHT*0.75));
		jp.setLayout(null);
		
		JScrollPane sp = new JScrollPane(jp, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setBounds(0, (int) (Main.SCREEN_HEIGHT*0.25), Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		add(sp);
		
		
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
