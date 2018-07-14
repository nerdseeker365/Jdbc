package se.ns.sq;

import java.sql.Connection;

import java.sql.DriverManager;

public class Connect {
	
	public static void main(String[] args)throws Exception {
		
		Connection con=null;
		
		//Register type4 JDBC driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//Establishing the Connection
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		
		if(con!=null) {
			
		System.out.println("Connection is  established");
		
		}
		
		else {
			System.out.println("Connection is not  established");
	
		}
		con.close();
}//main method
	
}//class