package sa.nt.se;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectMinSal {

	public static void main(String[] args)throws Exception {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		//register type4 driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//establish the JDBC connection
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
		//create Statement object
		st=con.createStatement();
		//process the Query and execute the query
		// select max(sal) from emp;
		rs=st.executeQuery("SELECT MIN(SAL) FROM EMP");
		//gathering SQL Query result
		while(rs.next()) {
			System.out.println(rs.getInt(1));
		}
		//close all JDBC objects
		con.close();
		st.close();
		rs.close();
		
	}//main method

}//class

