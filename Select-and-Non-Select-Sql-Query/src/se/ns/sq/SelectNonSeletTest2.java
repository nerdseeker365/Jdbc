package se.ns.sq;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.Statement;

import java.util.Scanner;

/*
 create table s1(sid number(5)
 Non-Select Query is executed
 			or
 select * from test1
 Select Query is Executed			
 */
public class SelectNonSeletTest2 {

	public static void main(String[] args)throws Exception {
		
		Scanner sc=null;
		
		String query=null;
		
		Connection con=null;
		
		Statement st=null;
		
		boolean flag=false;
		
		ResultSet rs=null;
		
		int count=0;
		
		sc=new Scanner(System.in);
		
		System.out.println("Enter the Query");
		
		query=sc.nextLine();
		
		//Register type4 JDBC driver 
		Class.forName("oracle.jdbc.driver.OracleDriver");//optional
		
		//Establishing the Connection 
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
		
		//create Statement object
		st=con.createStatement();
		
		//send and execute SQL query
		flag=st.execute(query);
		
		if(flag==true) {
			
			System.out.println("Select Query is Executed"); 
			
			rs=st.getResultSet();
			
			//process the ResultSet 
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)); 
				
			}//while
			
		}//if
		
		else {
			
			System.out.println("Non-Select Query is Excecuted");
			count=st.getUpdateCount();
			System.out.println("Number of Records that are Effected: "+count);
			
		}//else
		
		//close all JDBC objects
		sc.close();
		con.close();
		st.close();
		rs.close();
		
		
	}//main method 
	

}//class
