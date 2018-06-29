package sa.nt.conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnTest {

	public static void main(String[] args)throws Exception {
		
			Connection con=null;
			
			//register type4 driver mysql database 
			//Class.forName("org.gjt.mm.mysql.Driver");
			Class.forName("com.mysql.jdbc.Driver");
			//establish the JDBC connection
				con=DriverManager.getConnection("jdbc:mysql:///dbjava","root","root");
			if(con==null) {
				System.out.println("Connection is not established");
			}
			else {
			System.out.println("Connection is established");
			}
			
		
		}//main method


	}//class


