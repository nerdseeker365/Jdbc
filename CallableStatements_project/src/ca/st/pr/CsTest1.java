/*
 * SQL> create or replace procedure p2(a in number,r out number)
  2  as
  3  begin
  4  r:=r*r;
  5  end;
  6  /

Procedure created.
 */
package ca.st.pr;

import java.sql.CallableStatement;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.Types;

import java.util.Scanner;

public class CsTest1 {


	public static void main(String[] args) {
		
		 Scanner sc=null;
		 
		 int a=0;
		 
		 Connection con=null;
		 
		 String query=null;
		 
		 CallableStatement cs=null;
		 
		 int r=0;
		 
		try {
			
			//Read inputs
			
			sc=new Scanner(System.in);
			
			if(sc!=null) {
				
				System.out.print("Enter a value: ");
				
				a=sc.nextInt();
				
			}//if
			
			//Register type4 JDBC driver 
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Establish the Connection
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott", "tiger");
			
			//prepare SQL Query call in PL/SQL procedure
			
			query= "{CALL  p2(?,?)}";
			
			//Create Callable Statement object
			
			if(con!=null)
				
				cs=con.prepareCall(query);
			
			if(sc!=null) {
				
				//register OUT parameter with JDBC types
				
				cs.registerOutParameter(2, Types.INTEGER);
				
				//set values to IN parameter
				
				cs.setInt(1,a );
				
				//execute PL/SQL procedure
				
				cs.execute();
				
				//gather result from OUT parameter
				
				r=cs.getInt(2);
				
				System.out.println("SQUARE VALUE "+r);
				
			}//if
			
		}//try
		
		catch(SQLException se) {//To handle knows Exception
			
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
				
				if(cs!=null)
					
					cs.close();
				
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
