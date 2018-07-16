package sq.in.so;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.Scanner;

/*
 
SQL> select count(*) from login_page where username='kumar' and password='1234';

  COUNT(*)
----------
         1
 */
public class Login_page {

	public static void main(String[] args) {
		
		Scanner sc=null;
		
		String username=null;
		
		String password=null;
		
		Connection con=null;
		
		String query=null;
		
		PreparedStatement ps=null;
		
		ResultSet rs=null;
		
		int count=0;
		
		try {
			
			//Read inputs
			
			sc=new Scanner(System.in);
			
			if(sc!=null) {
				
				System.out.println("Enter username: ");
				
				username=sc.next();// gives kumar
				
				System.out.println("Enter Password");
				
				password=sc.next();//gives 1234
				
			}//if
			
			//Register type4 JDBC driver
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Establishing Connection 
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
			
			//Prepare SQL Query
			
			//select count(*) from login_page where username='kumar' and password='1234';
			
			query="SELECT COUNT(*) FROM LOGIN_PAGE WHERE USERNAME=?AND PASSWORD=?";
			
			if(con!=null) 
				
				ps=con.prepareStatement(query);
			
				 //Set Parameter Values
			
				if(ps!=null) {
					
					ps.setString(1, username);
					
					ps.setString(2, password);
					
				}
				
				//Send And Execute SQl Query
				
				if(ps!=null)
					
					rs=ps.executeQuery();
				
				if(rs!=null) {
					
					if(rs.next()) {
						
						count=rs.getInt(1);
						
					}
				}
				
				if(count==0)
					
					System.out.println("invalid Credetials");
				
				else
					
					System.out.println("Valid Credetials"); 
			
		}//try
		
			catch(SQLException se) {// To Handle known Exception 
				
				se.printStackTrace();
				
			}
		
		catch(ClassNotFoundException cnf) {// To Handle known Exception 
			
			cnf.printStackTrace();
			
		}
		
		catch(Exception e) {// To Handle Unknown Exception 
			
			e.printStackTrace();
			
		}
		
		finally {
			
			try {
				
				//close  JDBC objects
				
				if(rs!=null)
					
					rs.close();
				
			}
			
			catch(SQLException se) {
				
				se.printStackTrace();
				
			}
			
			try {
				
				if(ps!=null)
					
					ps.close();
				
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
			
		}//finally
	
	}//main method 

}//class 
