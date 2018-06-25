package sa.se.em;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmpDetails {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		String desg1=null;
		String desg2=null;
		String desg3=null;
		String query=null;
		String cond=null;
		boolean flag=false;
		try {
			//read inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.print("Enetr Designination1: ");
				desg1=sc.next().toUpperCase(); //gives CLERK 
				System.out.print("Enetr Designination2: ");
				desg2=sc.next().toUpperCase(); //gives MANAGER
				System.out.print("Enetr Designination3: ");
				desg3=sc.next().toUpperCase(); //gives SALESMAN 
				
			}//if
			//Frame Condition('CLERK','MANAGER','SALESMAN')
			cond="('"+desg1+"','"+desg2+"','"+desg3+"')";
			//gives ('CLERK','MANAGER','SALESMAN')
			//register JDBC type4 driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//establish the Connection with Database Software
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
			//create Statement object
			if(con!=null) 
				st=con.createStatement();
			//from the SQL Query
			// select empno,ename,job,sal from emp where job in('CLERK','MANAGER','SALESMAN')order by job;
			query="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN "+cond+"ORDER BY JOB";
			System.out.println(query);
			//Send and execute SQL Query in database s/w
			if(st!=null)
			rs=st.executeQuery(query);
			//process the ResultSet
			if(rs!=null) {
				
				while(rs.next()) {
					flag=true;
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
				}//while
				if(flag==false)
					System.out.println("No records found");
			}//if
			
			}//try
			catch(SQLException se) {//Known Exception
				       se.printStackTrace();
				}
		    catch(ClassNotFoundException cnf) {//Known Exception
		    		cnf.printStackTrace();
			}
			catch(Exception e) {//UnKnown Exception
				e.printStackTrace();
			
			}
		finally {
			//close objects
				try {
						if(rs!=null)
						rs.close();
					}
					catch(SQLException se) {//Known Exception
							se.printStackTrace();
					}
				try{
						if(st!=null)
						st.close();
				
					}
					catch(SQLException se) {//Known Exception
						se.printStackTrace();
					}
				try{
						if(con!=null)
						con.close();
				
				}
				catch(SQLException se) {//Known Exception
						se.printStackTrace();
				}
				try{
						if(sc!=null)
						sc.close();
				
				}
				catch(Exception se) {//Known Exception
						se.printStackTrace();
				}
			
		}//finally
		
	}//main

}//class
