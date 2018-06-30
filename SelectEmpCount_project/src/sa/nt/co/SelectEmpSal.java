package sa.nt.co;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectEmpSal {

	public static void main(String[] args)throws Exception {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		//Register type4 JDBC driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establish the database Connection 
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
		//create Statement Object
		st=con.createStatement();
		//Execute the Query and process the Query
		//select sal from emp;
		rs=st.executeQuery("SELECT SAL FROM EMP");
		System.out.println("salary");
		System.out.println();
		while(rs.next()) {
			
			System.out.println(rs.getInt(1));
		}
		//close all JDBC objects
		con.close();
		st.close();
		rs.close();
	}

}
