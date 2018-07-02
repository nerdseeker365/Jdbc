package sa.nt.se;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/*SQL> create table EmpAll(hid number(5) primary key,hname varchar2(20),hsal number(10,2),hphoto blob);

SQL> create sequence hID_SEQ start with 1 increment by 1;
*/
import java.util.Scanner;

public class BlobInsertTest {
  private static final  String  PHOTO_INSERT_QUERY="INSERT INTO HERO VALUES(?,?,?,?)";
	public static void main(String[] args)throws Exception {
		Scanner sc=null;
		String hname=null;
		int hid=0;
		int hsal=0;
		String hphoto=null;
		Connection con=null;
		PreparedStatement ps=null;
		File file=null;
		InputStream  is=null;
		long length=0;
		int result=0;
		
	   
	    	//read inputs
	    	sc=new Scanner(System.in);
	    	if(sc!=null){
	    		System.out.println("Enter Employee hid::");
	    		hid=sc.nextInt();
	    		System.out.println("Enter Employee hname::");
	    		hname=sc.next();
	    		System.out.println("Enter Employee hSal::");
	    		hsal=sc.nextInt();
	    		System.out.println("Enter PhotoPath::");
	    		hphoto=sc.next();
	    	}
	    	//create Stream Locating given PhotoPath file
	    	file=new File(hphoto);
	    	is=new FileInputStream(file);
	    	//get the length of the file
	    	length=file.length();
	    	
	    	//register JDBC driver s/w
	    	Class.forName("oracle.jdbc.driver.OracleDriver");
	    	//establish the connection
	    	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
	    	//create PreparedStatement object
	    	if(con!=null)
	    		ps=con.prepareStatement(PHOTO_INSERT_QUERY);
	    	//set values to query parameters
	    	if(ps!=null){
	    		ps.setInt(1,hid);
	    		ps.setString(2,hname);
	    		ps.setFloat(3,hsal);
	    		ps.setBinaryStream(4,is,length);
	    	}
	    	//execute the Query
	    	if(ps!=null)
	    		result=ps.executeUpdate();
	    	//process the result
	    	if(result==0)
	    		System.out.println("Record not inserted");
	    	else
	    		System.out.println("Record  inserted");
	    

	}//main
}//class
