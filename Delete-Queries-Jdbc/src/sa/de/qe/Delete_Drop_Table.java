package sa.de.qe;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.Statement;


public class Delete_Drop_Table {

	public static void main(String[] args) {
		
		Connection con=null;
		
		Statement st=null;
		
		int result=0;
		
	try {
		
		//register the type4 JDBC driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//Establishing the Connection
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		
		//create Statement object
		st=con.createStatement();
		
		//execute SQL query
		result=st.executeUpdate("DROP TABLE BANKACCOUNT");
		
		if(result==0) {
			System.out.println("table is Dropped");
		}
		else {
			System.out.println("table is not  Dropped");
		}
		
		
	}//try
	catch(SQLException se ) {//To handle known Exception
		se.printStackTrace();
	}
	catch(ClassNotFoundException cnf) {//To handle known Exception
		cnf.printStackTrace();
	}
	catch(Exception e) {//To  handle unknown Exception
		e.printStackTrace();
	}
	
	 finally {
		 
		 //close all JDBC objects
		 try {
			 if(st!=null)
				 st.close();
		 }
		 catch(SQLException se ) {
				se.printStackTrace();
			}
		 
		 try {
			 if(con!=null)
				 con.close();
		 }
		 catch(SQLException se ) {
				se.printStackTrace();
			}
		 
		 
	 }//finally
	
	}//main method
	

}//class
