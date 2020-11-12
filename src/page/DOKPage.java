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

import Movie.DB_MovieInfo;
import Movie.Movie;
import User.User;

public class DOKPage extends CategoryFrame {
	
	
	//pos
	private final static int movieN = 4;
	
	//component
	private JPanel panel = new JPanel();
	private JLabel boxoffice = new JLabel();
	private JButtonT btn_plusMovie = new JButtonT();
	private JButton[] btn_Movies = new JButton[movieN];
	private ImageIcon[] imgPoster = new ImageIcon[movieN];
	private DB_MovieInfo moive_connect = new DB_MovieInfo();
	private Movie[] movies;
	
	//Design
	Font font1 = new Font("�����ٸ����", Font.PLAIN, 20); 
	Font font2 = new Font("�����ٸ����", Font.PLAIN, 35);
	
	public DOKPage(User user) {
		super("DOK");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);//���̾ƿ� null
		setVisible(true);
		
		
		this.user = user;
		
		
		//Panel
		panel.setBackground(Color.WHITE);
		panel.setBounds(0,(int) (Main.SCREEN_HEIGHT*0.25),Main.SCREEN_WIDTH,(int)(Main.SCREEN_HEIGHT*0.75));
		panel.setLayout(null);
		add(panel);
		
		//�ڽ� ���ǽ� Label
		boxoffice.setText("�ڽ����ǽ�");
		boxoffice.setFont(font2);
		boxoffice.setBounds(Main.SCREEN_WIDTH/2-(110/2),100,200,50);
		panel.add(boxoffice);
		
		//�� ���� ��ȭ ���� Lable
		btn_plusMovie.setText("�� ���� ��ȭ����");
		btn_plusMovie.setFont(font1);
		btn_plusMovie.setBounds(Main.SCREEN_WIDTH-300,120,200,50);
		panel.add(btn_plusMovie);
		
		
		movies = moive_connect.getMovieInfoAll("open_day");
		
		//��ȭ ��Ʈ ��ư
		for(int i=0; i<movieN; i++) {
			int x = 300*(i)+ 180;
			String src = "src/imges/"+movies[i].getM_name()+".jpg";
			//System.out.println(src);
			imgPoster[i] = new ImageIcon(src);
			//imgPoster[i] = new ImageIcon("src/imges/�ܿ� �ձ�.jpg");
			btn_Movies[i] = new JButton(imgPoster[i]);
			btn_Movies[i].setIcon(imgPoster[i]);
			btn_Movies[i].setBounds(x, 225, 250, 400);
			panel.add(btn_Movies[i]);
			
		}
			
	}
	
	

}
