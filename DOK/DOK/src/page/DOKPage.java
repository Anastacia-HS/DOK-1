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

public class DOKPage extends JFrame {
	
	
	//
	private final static int movieN = 4;
	
	//component
	private CategoryPanel c1 = new CategoryPanel();	//ī�װ� panel
	private JPanel jp = new JPanel();
	private JLabel jlBoxoffice = new JLabel();	//�ڽ����ǽ�
	private JButtonT jbtnPlusMovie = new JButtonT();	//�� ���� ��ȭ����
	private JButtonT[] jbtnMovies = new JButtonT[movieN];
	private ImageIcon[] imgLogo = new ImageIcon[movieN];	//�ΰ� �̹���
	
	public DOKPage() {
		super("DOK");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null); // ���׿��� ��������
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);	//���̾ƿ� null
		setVisible(true);
		
		//ī�װ� Panel
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

}
