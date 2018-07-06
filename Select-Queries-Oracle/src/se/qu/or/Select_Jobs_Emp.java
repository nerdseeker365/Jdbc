package se.qu.or;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.Scanner;

/*
 * SQL> select empno,ename,job,sal from emp where job in('CLERK','MANAGER','SALESMAN')order by job;

     EMPNO ENAME      JOB              SAL
---------- ---------- --------- ----------
      7934 MILLER     CLERK           1300
      7900 JAMES      CLERK            950
      7876 ADAMS      CLERK           1100
      7369 SMITH      CLERK            800
      7566 JONES      MANAGER         2975
      7698 BLAKE      MANAGER         2850
      7782 CLARK      MANAGER         2450
      7844 TURNER     SALESMAN        1500
      7521 WARD       SALESMAN        1250
      7499 ALLEN      SALESMAN        1600
      7654 MARTIN     SALESMAN        1250

11 rows selected.
 */

public class Select_Jobs_Emp {
	
	public static void main(String[] args) {
		
	Scanner sc=null;
	
	String job1=null;
	
	String job2=null;
	
	String job3=null;
	
	String enter=null;
	
	Connection con=null;
	
	Statement st=null;
	
	String query=null;
	
	ResultSet rs=null;
	
	boolean flag=false;
	
try {
	
	sc=new Scanner(System.in);
	
	if(sc!=null) {
		
		System.out.print("enter job1: ");
		
		job1=sc.next();
		
		System.out.print("enter job2: ");
		
		job2=sc.next();
		
		System.out.print("enter job3: ");
		
		job3=sc.next();
		
		//Frame  Condition
		
		 enter="('"+job1+"','"+job2+"','"+job3+"')";
		 
		//Register JDBC driver software
		 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//Establish the Connection
		
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "scott", "tiger");
		
		//Create Statement object	
		
		if(con!=null) 
			
			st=con.createStatement();
		
		//Frame the SQL Query
		
	//select empno,ename,job,sal from emp where job in('CLERK','MANAGER','SALESMAN')order by job;
		
		
		query="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN"+enter+"ORDER BY JOB";
		
		System.out.println(query);
		
		//send and execute SQL query in database software
		
		if(st!=null)
			
			rs=st.executeQuery(query);
		
		//process the ResultSet
		
		if(rs!=null) {
			
			while(rs.next()) {
				
				flag=true;
				
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
				
			}//while
			
			if(flag==false)
				
				System.out.println("No Records Found ");
			
		}//if
			
		
		
	}//try
}
	
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
			
			if(rs!=null)
				
				rs.close();
			
		}
		
		catch(SQLException se){
			
			se.printStackTrace();
			
		}
		
		
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
		try{
			
			if(sc!=null)
				
				sc.close();
			
		}
		
		catch(Exception e){
			
			e.printStackTrace();
			
		}
		
	}//finally
}//main method
	
}//class
	
	
