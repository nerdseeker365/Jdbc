package ty.jd.dr;

import java.sql.Connection;

import java.sql.DriverManager;
/*
 
SQL> select * from global_name;

GLOBAL_NAME
--------------------------------------------------------------------------------
ORCL.168.0.3

 */

public class ConnTest {
public static void main(String[] args)throws Exception {
		
		Connection con=null;
		
		//Register type5 JDBC driver with database  software.....It is optional
		
		//Class.forName("com.ddtek.jdbc.oracle.OracleDriver");
		
		//Establishing the Connection with database software
		
		con=DriverManager.getConnection("jdbc:datadirect:oracle://localhost:1521;ServiceName=ORCL.168.0.3", "scott", "tiger");
		
		if(con==null) {
			
			System.out.println("Connection is not Established ");
			
		}
		
		else {
			
			System.out.println("Connection is Established ");
			
		}
		
	}//main method

}
