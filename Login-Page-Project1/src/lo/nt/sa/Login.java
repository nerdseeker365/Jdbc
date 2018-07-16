package lo.nt.sa;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.Scanner;

/*
 SQL> insert into login_page values('kumar','1234');

1 row created.

SQL> select * from login_page where username='kumar' and password='1234';


  COUNT(*)
----------
         1
 */
public class Login {

	public static void main(String[] args) {
		
		Scanner sc=null;
		
		String user=null;
		
		String password = null;
		
		Connection con=null;
		
		Statement st=null;
		
		String query=null;
		
		ResultSet rs=null;
		
		int count=0;
		
		try {
			
			//Read Inputs
			
			sc=new Scanner(System.in);
			
			if(sc!=null) {
				
				System.out.println("Enter Username: ");
				
				user=sc.nextLine();// gives kumar
				
				System.out.println("Enter Password: ");
				
				password=sc.nextLine();//gives 1234
				
				
			}//if
			
			//Convert input values as Required for the SQl Query
			
			user="'"+user+"'"; //gives kumar
			
			password="'"+password+"'"; //gives 1234
			
			//register JDBC driver
			
				Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Establishing Connection
				
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
			
			//Create Statement object
			
			if(con!=null)
				
				st=con.createStatement();
			
			//Prepare SQL Query
			
			// select count(*) from login_page where username ='kumar' and password='1234';
			
			query= "SELECT COUNT(*)  FROM LOGIN_PAGE WHERE USERNAME="+user+"AND PASSWORD="+password;
			
			System.out.println(query);
			
			//Execute the Query
			
			if(st!=null)
				
				rs=st.executeQuery(query);
			
			//Process the ResultSet
			
			if(rs!=null) {
				
			if(rs.next())
				
				count=rs.getInt(1);
			
			System.out.println(count);
			
			}//if
			
			if(count==0)
				
				System.out.println("InValid Credentials ");
			
			else
				
				System.out.println("Valid Credentials ");
			
		}//try
		
		catch(SQLException se) {// To Handle Known Exception
			
			se.printStackTrace();
			
		}
		
		catch(ClassNotFoundException cnf) {// To Handle Known Exception
			
			cnf.printStackTrace();
			
		}
		
		catch(Exception e) {// To Handle UnKnown Exception
			
			e.printStackTrace();
			
		}
		
		finally {
			
			try {
				
				if(rs!=null)
					
					rs.close();
				
			}
			
			catch(SQLException se) {
				
				se.printStackTrace();
				
			}
			
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
			
		}//finally
	
	}//main method 

}//class
