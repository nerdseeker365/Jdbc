package se.qu.or;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

/*
 * select eid,ename,esal from employee;
 * (or)
SQL> select * from employee;

       EID ENAME                      ESAL
---------- -------------------- ----------
       101 sankar                       10				// IS A MINIMUM SALARY OF ALL .
       102 raju                         20
       103 kumar                        50				// IS A MAXIMUM SALARY OF ALL.
 */
public class Select_Employee_Sal_Max {
	
	public static void main(String[] args) {
		
		Connection con=null;
		
		Statement st=null;
		
	     String query=null;
	     
	     ResultSet rs=null;
	     
	     boolean flag=false;
	     
		try{
			
		//Load JDBC driver class to register JDBC driver
			
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  
		  //establish the connection
		  
		  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		  
		  //create JDBC STatement object
		  
		  if(con!=null)
			  
			  st=con.createStatement();
		  
		  //prepare Query
		  
		  query="SELECT EID,ENAME,ESAL FROM EMPLOYEE WHERE ESAL=(SELECT MIN(ESAL) FROM EMPLOYEE)";
		  
		 // query="SELECT EID,ENAME,ESAL FROM EMPLOYEE WHERE ESAL=(SELECT MAX(ESAL) FROM EMPLOYEE)";
		  
		   System.out.println(query);
		   
		   //send and execute SQL Query in Database s/w
		   
		   if(st!=null)
			   
			   rs=st.executeQuery(query);
		   
		   //process the ResultSEt 
		   
		   if(rs!=null){
			   
			   while(rs.next()){
				   
				   flag=true;
				   
				   System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
				   
			   }
			   
		   }
		   
		    if(flag==false)
		    	
		    	System.out.println("Records not found");
		    
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
		
	  }//main
	
}//class
