package ty.tr.dr;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;
/*
 
SQL> select * from student1;

       SNO SNAME                SADD
---------- -------------------- --------------------
         4 kumar                hyd
 */

public class Type3DriverConnectiontoDb {

	public static void main(String[] args) {
		
		Connection con=null;
		
		Statement st=null;
		
		ResultSet rs=null;
		
		try {
			
		//Register type3 JDBC driver
			
		Class.forName("ids.sql.IDSDriver");
		
		//Establishing Connection
		con=DriverManager.getConnection("jdbc:ids://localhost:12/conn?dsn='accdsn'&user='scott'&password='tiger'");
	 
		 /*
		 con=DriverManager.getConnection("jdbc:ids://localhost:12/conn?dsn='accdsn'"); */
	
		//create JDBC statement object
		st=con.createStatement();
		
		//Execute the SQL Query
		rs=st.executeQuery("SELECT * FROM STUDENT1");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		}//while
		
		
		}//try
		catch(SQLException se) {// To handle Known Exception 
			se.printStackTrace();
		}
		
		catch(ClassNotFoundException cnf) {//To handle Known Exception 
			cnf.printStackTrace();
		}
		
		catch(Exception e) {//To handle UnKnown Exception 
			e.printStackTrace();
		}
		
		finally {
			
			try {
				//close all JDBC Objects
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
			
		}//finally
	}//main method

}//class
