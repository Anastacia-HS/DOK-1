package DB_User;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DBSelectUserInfo {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public DBSelectUserInfo() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userInfo_DOK?serverTimezone=Asia/Seoul","root","mirim2");
			st = con.createStatement();
		}catch (Exception e) {
			System.out.println("������ ���̽� ���� ����:"+e.getMessage());
		}
	}
	//userID�� userPasswor�� ��ġ�ϴ��� Ȯ��
	public boolean isUser(String userID, String userPassword) {
		try {
			String SQL = "SELECT * FROM user WHERE userID = '" + userID+ "' and userPassword = '" +userPassword+"'";
					   
			rs = st.executeQuery(SQL);
			
			//��ġ
			if(rs.next()) {
				return true;
			//����ġ
			}else {
				return false;
			}
		}catch(Exception e) {
			System.out.println("�����ͺ��̽� �˻� ����:"+ e.getMessage());
		}
		return false;
	}
}
