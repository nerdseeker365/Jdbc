package sa.nt.insert;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.Scanner;

/*
 * SQL> desc test1;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 TID                                                NUMBER(10)
 TNAME                                              VARCHAR2(20)
 TADDRESS                                           VARCHAR2(20)
 TDATE                                              DATE
 TFEE                                               NUMBER(4,2)
 insertion:
 
SQL> insert into test1 values(101,'sankar','hyd','05-jun-18',23.00);

1 row created.
 */
public class Insert_Test1 {
	
	public static void main(String[] args) {
		
		Scanner sc=null;
		
		int id=0;
		
		String name=null;
		
		String address=null;
		
		String date=null;
		
		double fee=0.0;
		
		Connection con=null;
		
		Statement st=null;
		
		int result=0;
		
		String query=null;
		
	try {
		
		//reap inputs
		
		sc= new Scanner(System.in);
		
		if(sc!=null) {
			
			System.out.println("Enetre Test ID: "); 
			
			id=sc.nextInt();//gives id
			
			System.out.println("Enter Test Name: ");
			
			name=sc.next();//gives name
			
			System.out.println("Enter Test Address: ");
			
			address=sc.next();//gives address
			
			System.out.println("Enter Test Date: ");
			
			date=sc.next();//gives Date
			
			System.out.println("Enter Test fee: : ");
			
			fee=sc.nextDouble();//gives fee
			
		}//if
		
		//Convert input values as required for the SQL query
		
		name="'"+name+"'";
		
		address="'"+address+"'";
		
		date="'"+date+"'";
		
		// Register JDBC type4 driver
		
		Class.forName("oracle.jdbc.driver.OracleDriver");//optional
		
		//Establishing the Connection
		
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
		
		//Create Statement Object
		
		if(con!=null)
			
		st=con.createStatement();
		
		//prepare SQL Query
		
		query="INSERT INTO TEST1 VALUES("+id+","+name+","+address+","+date+","+fee+")";
		
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
