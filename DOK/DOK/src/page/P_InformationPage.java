package page;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class P_InformationPage extends JFrame {
	private final static int PaddingLeft = 50;
	private final static int PaddingTop = 200;
	
	//component
	private JPanel jp = new JPanel();
	
	JLabel jlProfile = new JLabel("������");
	JLabel jlName = new JLabel("�̸�");
	JButton jbtnChange = new JButton("+");
	
	JLabel jlId = new JLabel("���̵�");
	JLabel jlBirthday = new JLabel("�������");
	JButton jbtnP_number = new JButton("��ȭ��ȣ");
	
	JLabel jlTaste = new JLabel("��ȭ ����");
	String[] Taste = {"����", "���", "�θǽ�", "������", "�ִϸ��̼�", "�׼�", "SF"};
	JCheckBox[] jcTaste = new JCheckBox[7];
	
	JButton jbtnFinish = new JButton("�Ϸ�");
	
	public P_InformationPage() {
		jlProfile.setBounds(PaddingLeft, PaddingTop, 200, 200);
		jlProfile.setOpaque(true);
		jlProfile.setBackground(Color.RED);
		jp.add(jlProfile);
		
		jlName.setBounds(PaddingLeft, PaddingTop + 210, 200, 50);
		jlName.setOpaque(true);
		jlName.setBackground(Color.GREEN);
		jp.add(jlName);
		
		//���̵�
		jlId.setBounds(PaddingLeft + 285, PaddingTop + 50, 200, 50);
		jlId.setOpaque(true);
		jlId.setBackground(Color.BLUE);
		jp.add(jlId);
		
		//������� : yyyy-mm-dd
		jlBirthday.setBounds(PaddingLeft + 285, PaddingTop + 115, 200, 50);
		jlBirthday.setOpaque(true);
		jlBirthday.setBackground(Color.BLUE);
		jp.add(jlBirthday);
		
		//��ȭ��ȣ
		jbtnP_number.setBounds(PaddingLeft + 285, PaddingTop + 180, 200, 50);
		jbtnP_number.setOpaque(true);
		jbtnP_number.setBackground(Color.BLUE);
		jp.add(jbtnP_number);
			
		//��ȭ ����
		jlTaste.setBounds(PaddingLeft + 15, PaddingTop + 280, 100, 50);
		jlTaste.setOpaque(true);
		jlTaste.setBackground(Color.BLUE);
		jp.add(jlTaste);
		
		for(int i = 0; i < jcTaste.length; i++) {
			jcTaste[i] = new JCheckBox(Taste[i]);
			
			if(i > 3) {
				jcTaste[i].setBounds(PaddingLeft + 300, PaddingTop + 190 + (i * 45), 100, 30);
			}else {
				jcTaste[i].setBounds(PaddingLeft + 100, PaddingTop + 370 + (i * 45), 100, 30);
			}
			
			
			jcTaste[i].setOpaque(true);
			jcTaste[i].setBackground(Color.LIGHT_GRAY);
			jp.add(jcTaste[i]);
		}
		
		//�Ϸ�
		jbtnFinish.setBounds(PaddingLeft + 200, PaddingTop + 575, 100, 50);
		jbtnFinish.setOpaque(true);
		jbtnFinish.setBackground(Color.YELLOW);
		jp.add(jbtnFinish);
		
		add(jp);
		
		jp.setLayout(null);
		jp.setBackground(Color.WHITE);
		
		setSize(600, 900);
		setVisible(true);
	}
}
