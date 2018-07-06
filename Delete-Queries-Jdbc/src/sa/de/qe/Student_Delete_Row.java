package sa.de.qe;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.Scanner;
/*
 SQL> select * from student;

       SID SNAME                SDOJ      SADDRESS                   SPHN
---------- -------------------- --------- -------------------- ----------
       103 sai                  19-JUN-18 vijayavada           9504984078
       104 sivaram              18-JUN-18 vizag                9504984098
       100 abc                  19-JUN-18 hyd                       97025
       105 kumar                17-JUN-18 razol                   8979690
       101 sankar               13-JUN-18 razole               9494624217
       102 raju                 14-JUN-18 hyd                  9666780916

6 rows selected.
 
 */
public class Student_Delete_Row {

	public static void main(String[] args) {
		
		int id=0;
		
		//String query=null;
		
		// query="DELETE FROM STUDENT WHERE SID="+id;//queries are top of the main main declare
		
		Scanner sc=null;
		
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
				
				result=st.executeUpdate("DELETE FROM STUDENT WHERE SID="+id);
				
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
