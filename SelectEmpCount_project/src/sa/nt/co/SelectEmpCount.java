package sa.nt.co;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectEmpCount {
	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		int count=0;
		try {
			//register type4 JDBC  driver
			Class.forName("oracle.jdbc.driver.OracleDriver");//this is optional 
			//Establish the Connection between JDBC type4 driver to database software
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
			//create Statement object
			if(con!=null) 
			st=con.createStatement();//send and execute SQL Query in database software
			if(st!=null)
				// select count(*)from emp;
				rs=st.executeQuery("SELECT COUNT(*)FROM EMP");
			//process the ResultSet
			if(rs!=null) {
				if(rs.next()) {
					count=rs.getInt(1);
				}//if
			}//if
			System.out.println("Record count "+count);
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
			if(st!=null)
			st.close();
	
	}
	catch(Exception se) {//Known Exception
			se.printStackTrace();
	}

        }//finally
		}//main method 
	}//class
