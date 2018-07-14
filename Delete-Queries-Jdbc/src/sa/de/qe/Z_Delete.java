package sa.de.qe;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.Scanner;

/*
 *drop table temp11
table  is  dropped  

 */

public class Z_Delete {

	public static void main(String[] args) {
		
		Scanner sc=null;
		
		String query=null;
		
		Connection con=null;
		
		Statement st=null;
		
		int result=0;
		
		try {
			
			sc=new Scanner(System.in);
			
				System.out.println("Enter the Query to Delete");
				
				query=sc.nextLine();
		
			//Register the type4 JDBC driver with Database Software
				
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Establishing the Connection
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
			
			//create Statement object 
			
			st=con.createStatement();
			
			//Execute the Query
			
			result=st.executeUpdate(query);
			
			if(result==0) {
				
				System.out.println("table  is  dropped  ");
				
			}
			
			else {
				
				System.out.println("table is not dropped"); 
				
			}
			
			
		}//try
		
		catch(SQLException se) {//To handle known Exception
			
			se.printStackTrace();
			
		}
		
		catch(ClassNotFoundException cnf) {//To handle known Exception
			
			cnf.printStackTrace();
			
		}
		catch(Exception e) {//To handle unknown Exception
			
			e.printStackTrace();
			
		}
		
		finally {
			
			try {
				
				if(st!=null)
					
					st.close();
				
				
			}
			
			catch(SQLException se) {
				
				se.printStackTrace();
				
			}
			
			try {
				
				if(con!=null)
					
					con.close();
				
				
			}
			
			catch(SQLException se) {
				
				se.printStackTrace();
				
			}
			
			try {
				
				if(sc!=null)
					
					sc.close();
				
			}
			
			catch(Exception e) {
				
				e.printStackTrace();
				
			}
			
		}//Finally

	}//main method

}//class
