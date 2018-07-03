package se.qu.or;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;
/*
 * 
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

SQL> select count(*) from student;

  COUNT(*)
----------
         6
 */
public class Select_Count_Student {
	
	public static void main(String[] args) {
		
	     Connection con=null;
	     
	     Statement st=null;
	     
	     String query=null;
	     
	     ResultSet rs=null;
	     
		try{
			
			//register JDBC driver
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//establish the connection
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
			
			//create STatement object
			
			if(con!=null)
				
				st=con.createStatement();
			
			//prepare SQL Query
			
			query="SELECT COUNT(*) FROM STUDENT";
			
			//send and execute SQL Query in Database Software
			
			if(st!=null)
				
				rs=st.executeQuery(query);
			
			//process the ResultSet
			
			if(rs!=null){
				
			   rs.next();
			   
			   //System.out.println("Count:::"+rs.getInt(1));
			   
			   System.out.println("Count:::"+rs.getInt("count(*)"));
			   
			}
			
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
			
		}//finally
		
	}//main method
	
}//class