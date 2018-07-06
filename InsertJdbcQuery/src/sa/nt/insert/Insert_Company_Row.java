package sa.nt.insert;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.Scanner;

/*
 SQL> insert into company values(101,'tcs','hitech_city',34000);

1 row created.
 */

public class Insert_Company_Row {
	
public static void main(String[] args) {
		
		Scanner sc=null;
		
		int cid=0;
		
		String company=null;
		
		String address=null;
		
				
		int anual_income=0;
		
		Connection con=null;
		
		Statement st=null;
		
		int result=0;
		
		String query=null;
		
	try {
		
		//reap inputs
		
		sc= new Scanner(System.in);
		
		if(sc!=null) {
			
			System.out.println("Enetre company cID: "); 
			
			cid=sc.nextInt();//gives id
			
			System.out.println("Enter  company name: : ");
			
			company=sc.next();//gives company
			
			System.out.println("Enter company Address: ");
			
			address=sc.next();//gives address
			
					
			System.out.println("Enter company anual_income: : ");
			
			anual_income=sc.nextInt();//gives anual_income
			
		}//if
		
		//Convert input values as required for the SQL query
		
		company="'"+company+"'";
		
		address="'"+address+"'";
		
		// Register JDBC type4 driver
		
		Class.forName("oracle.jdbc.driver.OracleDriver");//optional
		
		//Establishing the Connection
		
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
		
		//Create Statement Object
		
		if(con!=null)
			
		st=con.createStatement();
		
		//prepare SQL Query
		
		query="INSERT INTO COMPANY VALUES("+cid+","+company+","+address+","+anual_income+")";
		
		System.out.println("query");
		
		//send and Execute SQL Query in Database Software
		
		if(st!=null)
			
			result=st.executeUpdate(query);
		
		//process the result
		
		if(result==0)
			
			System.out.println("Record insertion failed");
		
		else
			
			System.out.println("Record insertion succeded");
		
	}//try
	
	catch(SQLException se) {//To handle known Exception
		
		se.printStackTrace();
		
	}
	
	catch(ClassNotFoundException cnf) {///To handle known Exception
		
		cnf.printStackTrace();
		
	}
	
	catch(Exception e) {//To handle UnKnown Exception
		
		e.printStackTrace();
		
	}
	
	finally {
		
		//close all JDBC objects
		
		try {
			
			if(con!=null)
				
				con.close();
			
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
			
			if(sc!=null)
				
			sc.close();
			
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}//finally
	
  }//main method

}//class
