package page;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ChartPage extends JFrame{
	private final static int PaddingLeft = 150;
	private final static int PaddingTop = 50;
	private final static double PanelHeight = Main.SCREEN_HEIGHT * 1.4;
	
	//component
	private CategoryPanel c1 = new CategoryPanel();	//ī�װ� panel
	private JPanel jp = new JPanel();
	
	
	
	// size
	private Dimension size = new Dimension();// ����� �����ϱ� ���� ��ü ����
	
	JLabel jlGenre = new JLabel("�帣");
	String[] genre = {"����", "���", "�θǽ�", "������", "�ִϸ��̼�", "�׼�", "SF"};
	JComboBox jcbGenre = new JComboBox(genre);
	
	JButton jbtnRating = new JButton("����");
	JButton jbtnTaste = new JButton("����");
	
	JLabel[][] jlPoster = new JLabel[4][2];
	JButton[] jbtnTicket = new JButton[4];
	
	
	
	public ChartPage() {
		super("��ȭ ��Ʈ");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null); // ���׿��� ��������
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);	//���̾ƿ� null
		setVisible(true);
		
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
				
				jlPoster[i][j].setBounds(PaddingLeft + (i * 325), PaddingTop + 100 + (j * 500), 200, 300);
				jlPoster[i][j].setOpaque(true);
				jlPoster[i][j].setBackground(Color.GRAY);
				jp.add(jlPoster[i][j]);
			}
		}
		
		for(int i = 0; i < jbtnTicket.length; i++) {
			jbtnTicket[i] = new JButton("����");
				
			jbtnTicket[i].setBounds(PaddingLeft + (i * 325), PaddingTop + 415 /*(j * 350)*/, 200, 40);
			jbtnTicket[i].setOpaque(true);
			jbtnTicket[i].setBackground(Color.GREEN);
			jp.add(jbtnTicket[i]);
		}
		
		for(int i = 0; i < jbtnTicket.length; i++) {
			jbtnTicket[i] = new JButton("����");
				
			jbtnTicket[i].setBounds(PaddingLeft + (i * 325), PaddingTop + 915 /*(j * 350)*/, 200, 40);
			jbtnTicket[i].setOpaque(true);
			jbtnTicket[i].setBackground(Color.GREEN);
			jp.add(jbtnTicket[i]);
		}
		
		
		
		//ī�װ� Panel
		add(c1);
		
		
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
}