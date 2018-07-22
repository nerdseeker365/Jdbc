package com.nt.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * 								TYPE4 DRIVER FOR EXCEL(http://www.hxtt.com/excel.htmt)
 * 
 HXTT Excel Driver details for(type4 driver)----->here Hxtt means Heng Xing Tian Tai Lab of Beijing City (abbr, HXTT)  provies driver 
 
 * DriverClassName:Class.forName("com.hxtt.sql.excel.ExcelDriver");
 * 
 * JdbcUrl:con=DriverManager.getConnection("jdbc:excel:///E:\\java\\ms_access");--> E:\java\ms_access-->The directory where work book is available

download in HXTT -->http://www.hxtt.com/excel.htmt
										---->Download directly JDBC 3.0 trial version
														---->Extract 
																--> exel\lib\Excel_JDBC30.jar
																	---> jar file name:Excel_JDBC30.jar
		SELECT * FROM student.sheet1
		
 					Above:student.sheet1-->student is file name and sheet1 sheet name

ECLIPSE:buildpath:
				-->configure buildpath
							---->add external jar files
							 			--->Excel_JDBC30.jar
EXCEL:open ms-excel 
					---->enter data means column names and rows ...here each value is a cell.
 */
public class ExcelSelect {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try{
			//register jdbc driver
			Class.forName("com.hxtt.sql.excel.ExcelDriver");
			//establish the connection
			con=DriverManager.getConnection("jdbc:excel:///E:\\java\\ms_access");
			//create Statement obj
			if(con!=null)
				st=con.createStatement();
			//send execute Query
			if(st!=null)
				rs=st.executeQuery("SELECT * FROM student.sheet1");
			//process the ResultSet obj
			if(rs!=null){
				while(rs.next()){
					System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
				}
			}
		}//try
		catch (SQLException se) {
			se.printStackTrace();
		}
		catch(ClassNotFoundException  cnf){
			cnf.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			//close jdbc objs
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
