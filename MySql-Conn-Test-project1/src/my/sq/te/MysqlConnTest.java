package my.sq.te;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

/*
 * use mysql database or create your own database ------>create database databasename ex: create database dbjava
 show databases------->all default and user defined databases are open
 wwww.mysql.com
 jar file:http//dev.mysql.com/downloads/connector/j/
 Here download mysql require jar
 */

public class MysqlConnTest {

	public static void main(String[] args) {
		
		Connection con=null;
		
		try {
			
			//register type4 MYSQL driver
			
			//Class.forName("java.sql.Driver");
			
			//Class.forName("com.mysql.cj.jdbc.Driver");
			
			Class.forName("com.mysql.jdbc.Driver");
			
			//Establishing MYSQL Connection
			
			con=DriverManager.getConnection("jdbc:mysql:///dbjava","root","root");
			
			//con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbjava","root","root");
			
			if(con!=null) {
				
				System.out.println("Connection is  Established");  
				
			}
			
			else {
				
				System.out.println("Connection is not Established");  
				
			}
			
		}//try
		
		catch(SQLException se) {//To Handle Known Exception
			
			se.printStackTrace();
			
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		
		
		
		catch(Exception e) {//To Handle UnKnown Exception
			
			e.printStackTrace();
			
		}
		
		finally {
			
			try {
				
				//close JDBC objects
				
				if(con!=null)
					
					con.close();
				
			}
			
			catch(SQLException se) {
				
				se.printStackTrace();
				
			}
			
		}//finally
		
	}//main  method

}//class
