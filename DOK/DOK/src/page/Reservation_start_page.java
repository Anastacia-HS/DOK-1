package page;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Reservation_start_page extends JFrame{
	
	//component
	private CategoryPanel c1 = new CategoryPanel();	//ī�װ� panel
	private JPanel jp = new JPanel();
	
	public Reservation_start_page() {
		
		super("����");
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
		
	}
}
