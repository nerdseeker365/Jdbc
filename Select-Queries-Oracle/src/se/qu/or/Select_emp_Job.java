package se.qu.or;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
/*
 * SQL> select ename,job,sal from emp where job='CLERK';
 */
public class Select_emp_Job {
	public static void main(String[] args)throws Exception {
		
		Scanner sc=null;
		sc=new Scanner(System.in);
		Connection con=null;
		
		Statement st=null;
		
		ResultSet rs=null;
		String job=null;
		//Reading inputs
		System.out.println("Enter Job Name:");
		job=sc.next();
		job="'"+job+"'";
		//Register type4 JDBC driver
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//Establish the database Connection 
		
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
		
		//create Statement Object
		
		st=con.createStatement();
		
		//Execute the Query and process the Query
		
		//select ename,job,sal  from  emp where job='CLERK';
		
		//rs=st.executeQuery("SELECT * FROM EMP");
		
		rs=st.executeQuery("SELECT ENAME,JOB,SAL FROM EMP WHERE JOB="+job);//NOTE: ENTER JOB .....CAPITAL LETTERS ONLY.
		
		System.out.println("JOB DETAILS OF EMPLOYEE:");
		
		System.out.println();
		
		
		while(rs.next()) {
			
			System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
		}
		//close all JDBC objects
		sc.close();
		con.close();
		st.close();
		rs.close();
	}//main method 
}//class
