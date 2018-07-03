package se.qu.or;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BasicTest1 {
	
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


		public static void main(String[] args) {
			
			Connection con=null;
			
			//Register typwe4 JDBC driver with database  software.....It is optional
			try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Establishing the Connection with database software
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "scott", "tiger");
			
			if(con==null) {
				
				System.out.println("Connection is not Established ");
				
			}
			
			else {
				
				System.out.println("Connection is Established ");
				
			}
			}//try
			
			catch(SQLException se){  //known exception
				
				se.printStackTrace();
				
			}
			
			catch(ClassNotFoundException cnf){
				
				cnf.printStackTrace();  //known exception
				
			}
			
			catch(Exception e){   // unknown exception
				
				e.printStackTrace();
				
			}
			
			finally{
				
				//close JDBC objects
				try{
					
					if(con!=null)
						
						con.close();
					
				}
				
				catch(SQLException se){
					
					se.printStackTrace();
					
				}
				
			}//finally
			
		}//main method
		

	}//class

