package sa.de.qe;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.Scanner;

/*
 SQL> desc company;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 CID                                                NUMBER(10)
 CNAME                                              VARCHAR2(20)
 CADDRESS                                           VARCHAR2(20)
 CANUAL_INCOME                                      NUMBER(10)
 
SQL> select * from company;

       CID CNAME                CADDRESS             CANUAL_INCOME
---------- -------------------- -------------------- -------------
       101 tcs                  hitech_city                  34000
       102 tcs                  begum_pet                    39000
       103 tcs                  pune                         59000
       105 tcs                  banglore                     79000
 */
public class Company_Delete_Row {
	
	public static void main(String[] args) {
		
		String query="DELETE FROM COMPANY WHERE CID=";
		
	Scanner sc=null;
	
	int id=0;
	
	Connection con=null;
	
	Statement st=null;
	
	int result=0;
	
	try {
		
		//read inputs
		
		sc=new Scanner(System.in);
		
		System.out.println("Enter Student sid to delete:");
		
		id=sc.nextInt();
		
		//register JDBC type4 Driver software
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//Establishing JDBC connection
		
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott", "tiger");
		
		//create Statement object
		
		if(con!=null)
			
			st=con.createStatement();
		
		//send and execute SQL query in database software
		
		if(st!=null)
			
			result=st.executeUpdate(query+id);
			
		if(result==0)
			
			System.out.println("No Records Found for Deletion "); 
		
		else
			
			System.out.println(result+":  Number of records found for Deletion ");
			
		
	}//try
	
	catch(SQLException se) {//To handle known Exception
		
		se.printStackTrace();
		
	}
	
	catch(ClassNotFoundException cnf) {// To handle known Exception
		
		cnf.printStackTrace();
		
	}
	
	catch(Exception e) {// To handle UnKnown Exception
		
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
	}//finally
	
}//main method
	
}//class
