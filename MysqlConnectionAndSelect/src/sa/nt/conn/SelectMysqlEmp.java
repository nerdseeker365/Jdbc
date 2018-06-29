package sa.nt.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SelectMysqlEmp {
	public static void main(String[] args)throws Exception {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		//register type4 driver MYSQL database
		Class.forName("com.mysql.jdbc.Driver");
		//establish the MYSQL connection
		con=DriverManager.getConnection("jdbc:mysql:///dbjava","root","root");
		//create Statement object
		st=con.createStatement();
		//process the query and execute the query
		//  select eid,ename,eaddress,esal from emp1;
		rs=st.executeQuery("SELECT EID,ENAME,EADDRESS,ESAL FROM EMP1");
		//gathering MYSQL query results
		while(rs.next()) {
		System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));//sysout->ctrl+space
		}
		//close all MYSQL objects
		con.close();
		st.close();
		rs.close();
}//main method
}//class
