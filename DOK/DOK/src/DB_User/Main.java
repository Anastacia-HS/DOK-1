package DB_User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DBuserInfo connection = new DBuserInfo();
		//System.out.println(connection.addUser("asdfa", "123", "�迵��", "19920506", "����", "010123456", null, null));
		//System.out.println(connection.isUser("kny030303", "kny12345"));
		System.out.println(connection.getUserInfo("kny030303").getUserID());
		//System.out.println("������ ����:"+coneection.addUser("qwersdru", "555", "�ǳ׼�", 030307, "12346589", "������", "�θǽ�"));
		
	}

}
