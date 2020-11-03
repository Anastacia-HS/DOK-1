package page;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPage extends JFrame implements ActionListener {
	private final static int PaddingLeft = 150;
	private final static int PaddingTop = 100;
	
	//component
	private CategoryPanel c1 = new CategoryPanel();	//ī�װ� panel
	private JPanel jp = new JPanel();
	
	JLabel jlProfile = new JLabel("����");
	JLabel jlName = new JLabel("�̸�");
	
	JLabel jlId = new JLabel("���̵�");
	JLabel jlBirthday = new JLabel("�������");
	JLabel jlP_number = new JLabel("��ȭ��ȣ");
	JLabel jlTaste = new JLabel("��ȭ ����");
	JButton jbtnCorrection = new JButton("������������");
	
	JLabel jlRecord_movie = new JLabel("�ֱ� ������ ��ȭ");
	JLabel jlRecord_movie_info = new JLabel();
	
	public MyPage() {
		super("���� ������");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null); // ���׿��� ��������
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);	//���̾ƿ� null
		setVisible(true);
		
		//������ ����
		jlProfile.setBounds(PaddingLeft, PaddingTop, 200, 200);
		jlProfile.setOpaque(true);
		jlProfile.setBackground(Color.RED);
		jp.add(jlProfile);
		
		//����� �̸�
		jlName.setBounds(PaddingLeft, PaddingTop + 215, 200, 50);
		jlName.setOpaque(true);
		jlName.setBackground(Color.GREEN);
		jp.add(jlName);
		
		//���̵�
		jlId.setBounds(PaddingLeft + 350, PaddingTop, 250, 40);
		jlId.setOpaque(true);
		jlId.setBackground(Color.BLUE);
		jp.add(jlId);
		
		//������� : yyyy-mm-dd
		jlBirthday.setBounds(PaddingLeft + 350, PaddingTop + 50, 250, 40);
		jlBirthday.setOpaque(true);
		jlBirthday.setBackground(Color.BLUE);
		jp.add(jlBirthday);
		
		//��ȭ��ȣ
		jlP_number.setBounds(PaddingLeft + 350, PaddingTop + 100, 250, 40);
		jlP_number.setOpaque(true);
		jlP_number.setBackground(Color.BLUE);
		jp.add(jlP_number);
		
		//��ȭ ����
		jlTaste.setBounds(PaddingLeft + 350, PaddingTop + 150, 250, 40);
		jlTaste.setOpaque(true);
		jlTaste.setBackground(Color.BLUE);
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

		//ī�װ� Panel
		add(c1);
		
		//Panel
		jp.setBackground(Color.WHITE);
		jp.setBounds(0,(int) (Main.SCREEN_HEIGHT*0.25),Main.SCREEN_WIDTH,(int)(Main.SCREEN_HEIGHT*0.75));
		jp.setLayout(null);
		add(jp);
	}

	//�׼� ������ ���� 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbtnCorrection) {
			
		}
	}
}
