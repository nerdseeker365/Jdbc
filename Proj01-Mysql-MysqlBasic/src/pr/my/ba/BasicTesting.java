package pr.my.ba;

import java.sql.Connection;
import java.sql.DriverManager;
/*user-name: root
 * password: root 
 * 
 */
public class BasicTesting {

	public static void main(String[] args)throws Exception {
		
		Connection con=null;
		
		//Register type4 MYSQL driver with database software
		
		Class.forName("com.mysql.jdbc.Driver");
		
		//Establishing the Connection with Database software
		
		con=DriverManager.getConnection("jdbc:mysql:///dbjava", "root", "root");
		
		if(con==null) {
			
			System.out.println("Connection is not Established ");
			
		}
		
		else {
			
			System.out.println("Connection sis Established");
			
		}
		
	}//main method 

}//class
