package sa.nt.se;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BlobInsertTest {
	 private static final  String  PHOTO_INSERT_QUERY="INSERT INTO HERO VALUES(EID_SEQ.NEXTVAL,?,?,?,?)";
		public static void main(String[] args) {
			Scanner sc=null;
			int hid=0;
			String hname=null;
			double hsal=0.0;
			String hphoto=null;
			Connection con=null;
			PreparedStatement ps=null;
			File file=null;
			InputStream  is=null;
			long length=0;
			int result=0;
			
		    try{
		    	//read inputs
		    	sc=new Scanner(System.in);
		    	if(sc!=null){
		    		System.out.println("Enter hero hid::");
		    		hid=sc.nextInt();
		    		System.out.println("Enter hero hname::");
		    		hname=sc.next();
		    		System.out.println("Enter hero hSal::");
		    		hsal=sc.nextDouble();
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
		    	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		    	//create PreparedStatement object
		    	if(con!=null)
		    		ps=con.prepareStatement(PHOTO_INSERT_QUERY);
		    	//set values to query parameters
		    	if(ps!=null){
		    		ps.setInt(1,hid);
		    	
		    		ps.setString(2,hname);
		    		ps.setDouble(3,hsal);
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
		    }//try
		    catch(SQLException se){
		    	se.printStackTrace();
		    }
		    catch(ClassNotFoundException cnf){
		    	cnf.printStackTrace();
		    }
		    catch(Exception e){
		    	e.printStackTrace();
		    }
		    finally{
			try{
				if(ps!=null)
					ps.close();
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
			
			try{
				if(is!=null)
					is.close();
			}
			catch(IOException ioe){
				ioe.printStackTrace();
			}
			
			try{
				if(sc!=null)
					sc.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}//finally
		}//main method 
}//class
