package User;

import java.sql.Statement;

import javax.jws.soap.SOAPBinding.Use;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DB_userInfo {
	Connection con;
	Statement st;
	ResultSet rs;
	User user = new User();
	
	//������
	public DB_userInfo() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/DOK?serverTimezone=Asia/Seoul","root","mirim2");
			st = con.createStatement();
		}catch (Exception e) {
			System.out.println("������ ���̽� ���� ����:"+e.getMessage());
		}
	}
	
	
	//������ ���̽��� user���� �߰�
	public boolean addUser(String userID, String userPassword, String userName, String useryymmdd, String userGender, String userPhone , String userTaste1, String userTaste2 ) {
		try {
			String SQL = "INSERT INTO USER (userID, userPassword, userName, useryymmdd, userGender,userPhone, userTaste1, userTaste2) "
					+ "VALUES(\""+userID+"\"," +"\""+ userPassword+"\"," + "\""+userName+"\",\"" + useryymmdd+"\",\""+userGender +"\","+ "\""+userPhone +"\","+ "\""+userTaste1+"\"," +  "\""+userTaste2+"\""+");";
			
			int success = st.executeUpdate(SQL);
				
			//����
			if(success == 1) {
				return true;
			//����
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
		}
		return false;
	}
	
	//�����ͺ��̽��� �ִ� user���� ��������
	public User getUserInfo(String userID) {
		try {
			String SQL = " SELECT* FROM user WHERE userID =" +"\""+userID+"\"";
					   
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
				System.out.println("����");
			}
		}catch(Exception e) {
			System.out.println("getUserInfo�����ͺ��̽� �˻� ����:"+ e.getMessage());
		}
		return user;
		
	}
	
	//������Ʈ ���� ����
	public void updateUserInfo(String userID,String userPassword, String userPhone) {
		try {
			String SQL = "UPDATE user SET userPassword = \"" + userPassword + "\" , userPhone = \"" + userPhone + "\" WHERE userID = \""+userID+"\";";
			System.out.println(SQL);
			int success = st.executeUpdate(SQL);
			
			if(success==1) {
				this.user = getUserInfo(userID);
				System.out.println("����");
			}else {
				System.out.println("����");
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}