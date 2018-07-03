package jd.or.ba;

import java.sql.Connection;
import java.sql.DriverManager;
/*
 * here user-name and password are sqlplus user-name and password
Enter user-name: scott
Enter password:tiger

SQL> select * from global_name;

GLOBAL_NAME
--------------------------------------------------------------------------------
ORCL.168.0.3

you type orcl,ORCL,ORCL.168.0.3 ok fine

 * 
 */

public class BasicTesting {

	public static void main(String[] args)throws Exception {
		
		Connection con=null;
		
		//Register typwe4 JDBC driver with database  software.....It is optional
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//Establishing the Connection with database software
		
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "scott", "tiger");
		
		if(con==null) {
			
			System.out.println("Connection is not Established ");
			
		}
		
		else {
			
			System.out.println("Connection is Established ");
			
		}
		
	}//main method
	

}//class
