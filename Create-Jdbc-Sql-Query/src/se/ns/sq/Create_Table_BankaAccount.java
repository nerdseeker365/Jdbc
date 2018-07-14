package se.ns.sq;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.Statement;

/*
 CREATE TABLE BANKACCOUNT1(BNAME VARCHAR2(20),BAHNAME VARCHAR2(20),BADDRESS VARCHAR2(20), BAN NUMBER(12))
 */

public class Create_Table_BankaAccount {

	public static void main(String[] args)throws Exception {
		
		Connection con=null;
		
		Statement st=null;
		
		int result=0;
		
		//register type4 driver
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//Establishing the Connection
		
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
		
		//Create Statement object
		
		st=con.createStatement();
		
		//execute the SQL Query
		
		result=st.executeUpdate("CREATE TABLE BANKACCOUNT1(BNAME VARCHAR2(20),BAHNAME VARCHAR2(20),BADDRESS VARCHAR2(20), BAN NUMBER(12))");
		
		if(result!=0) {
			
			System.out.println("Table is not Created");
			
		}
		
		else {
			
			System.out.println("Table is created");
			
		}
		
		/*
		 if(result==0) {
		 
			System.out.println("Table is Created");
			
		}
		
		else {
		
			System.out.println("Table is not created");
			
		}
		
		 */
		

	}//main method
	

}//class
