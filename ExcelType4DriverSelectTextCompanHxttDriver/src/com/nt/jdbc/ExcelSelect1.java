package com.nt.jdbc;
/*control shift+o------>this shortcut for import packages automatically......
 note:1.type4 Driver is auto loading is possible.
 	  2.query is not case sensitive.
 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExcelSelect1 {

	public static void main(String[] args)throws Exception  {
		Connection con=DriverManager.getConnection("jdbc:excel:///e:\\java\\ms_access");//connection
		Statement st=con.createStatement();//create Statement object
		ResultSet rs=st.executeQuery("SELECT SNO,SNAME,SADDRESS FROM STUDENT.SHEET1");//Send Execute query
		while(rs.next()){
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)); 
		}
	
	}//main method

}//class
