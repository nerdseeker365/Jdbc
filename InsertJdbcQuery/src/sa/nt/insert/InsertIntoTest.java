package sa.nt.insert;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.Scanner;

/*
 * 
SQL> desc test;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 TID                                                NUMBER(10)
 TNAME                                              VARCHAR2(20)

 */

public class InsertIntoTest {
	
	public static void main(String[] args) {
		
	Scanner sc=null;
	
	int id=0;
	
	String name=null;
	
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
		
	}//if
	
	//Convert input values as required for the SQL query
	
	name="'"+name+"'";
	
	// Register JDBC type4 driver
	
	Class.forName("oracle.jdbc.driver.OracleDriver");//optional
	
	//Establishing the Connection
	
	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
	
	//Create Statement Object
	
	if(con!=null)
		
	st=con.createStatement();
	
	//prepare SQL Query
	
	query="INSERT INTO TEST VALUES("+id+","+name+")";
	
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
		
		if(st!=null)
			
			st.close();
		
	}
	
	catch(SQLException se){
		
		se.printStackTrace();
		
	}
	
	try{
		
		if(con!=null)
			
			con.close();
		
	}
	
	catch(SQLException se){
		
		se.printStackTrace();
		
	}
	
}//finally

}//main method
}// class
