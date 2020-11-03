package DB_User;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBuserInfo {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	private User user = new User();
	
	//������
	public DBuserInfo() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/userInfo_DOK?serverTimezone=Asia/Seoul","root","mirim2");
			st = con.createStatement();
		}catch (Exception e) {
			System.out.println("������ ���̽� ���� ����:"+e.getMessage());
		}
	}
	
	
	//������ ���̽��� user���� �߰�
	public boolean addUser(String userID, String userPassword, String userName, String useryymmdd, String userGender, String userPhone , String userTaste1, String userTaste2 ) {
		try {
			//String SQL = "SELECT * FROM ADMIN WHERE adminID = '" + adminID+ "' and adminPassword = '" +adminPassword+"'";
			String SQL = "INSERT INTO USER (userID, userPassword, userName, useryymmdd, userGender,userPhone, userTaste1, userTaste2) "
					+ "VALUES(\""+userID+"\"," +"\""+ userPassword+"\"," + "\""+userName+"\",\"" + useryymmdd+"\",\""+userGender +"\","+ "\""+userPhone +"\","+ "\""+userTaste1+"\"," +  "\""+userTaste2+"\""+");";
			
			int success = st.executeUpdate(SQL);
				
			//����
			if(success == 1) {
				return true;
			//����
			}else {
				return false;
			}
					
				
		}catch(Exception e) {
			System.out.println("�����ͺ��̽� �˻� ����:"+ e.getMessage());
		}
		return false;
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
		}finally {
			/*
			 * if(st!=null)try {st.close();}catch(SQLException sqle) {} if(con!=null)try
			 * {st.close();}catch(SQLException sqle) {}
			 */
		}
		return false;
	}
	
	//�����ͺ��̽��� �ִ� user���� ��������
	public User getUserInfo(String userID) {
		try {
			String SQL = " select* from user where userID =" +"\""+userID+"\"";
					   
			rs = st.executeQuery(SQL);
			//��ġ
			if(rs.next()) {
				
				user.setUserID(rs.getString("userID"));
				user.setUserPassword(rs.getString("userPassword"));
				user.setUserName(rs.getString("userName"));
				user.setUseryymmdd(rs.getString("useryymmdd"));
				user.setUserGender(rs.getString("userGender"));
				user.setUserPhone(rs.getString("userPhone"));
				user.setUserTaste1(rs.getString("userTaste1"));
				user.setUserTaste2(rs.getString("userTaste2"));
			//����ġ
			}else {
				
			}
		}catch(Exception e) {
			System.out.println("getUserInfo�����ͺ��̽� �˻� ����:"+ e.getMessage());
		}finally {
			/*
			 * if(st!=null)try {st.close();}catch(SQLException sqle) {} if(con!=null)try
			 * {st.close();}catch(SQLException sqle) {}
			 */
		}
		//System.out.println(user.getUserID());
		return user;
		
	}
}
