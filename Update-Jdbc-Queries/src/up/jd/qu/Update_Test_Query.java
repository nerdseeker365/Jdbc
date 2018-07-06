package up.jd.qu;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.Scanner;

/*
 
SQL> update  test set tname='raju' where tid=104;
 */

public class Update_Test_Query {
	
public static void main(String[] args) {
	
	Scanner sc=null;
	
	String name=null;
	
	Connection con=null;
	
	Statement st=null;
	
	String query=null;
	
	int id=0;
	
	int result =0;
	
	try {
		
		//read inputs
		
		sc=new Scanner(System.in);
		
		if(sc!=null) {
			
			System.out.println("Enter test id to Update column :");
			
			id=sc.nextInt();
			
			
			System.out.println("Enter test name to Update:");
			
			name=sc.next();
			
			
		}
		
		//Convert input values as required for the SQL Query
		
		name="'"+name+"'";
		
		//register JDBC type4 Driver software
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//Establishing the JDBC Connection
		
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
		
		//Create Statement object
		
		if(con!=null)
			
		st=con.createStatement();
		
		//prepare SQL query
		
		//SQL> update  test set tname='raju' where tid=104;
		
		query="UPDATE TEST SET TNAME="+name+" WHERE TID="+id;
		
		//send and execute SQL query in database software
		
		if(st!=null)
			
		result=st.executeUpdate(query);	
		
		//process the result
		
		if(result==0)
			
			System.out.println("Record not Found to Update ");
		
		else
			
			System.out.println("Record Found to Update");
		
	}//try
	
	catch(SQLException se) {//To handle known Exception
		
		se.printStackTrace();
		
	}
	
	catch(ClassNotFoundException cnf) {//To handle known Exception
		
		cnf.printStackTrace();
		
	}
	
	catch(Exception e) {//To handle UnKnown Exception
		
		e.printStackTrace();
		
	}
	
	finally {
		
		//close JDBC objects
		
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
	
	}
	
}//main method

}//class
