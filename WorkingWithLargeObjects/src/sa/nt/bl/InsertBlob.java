package sa.nt.bl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertBlob {

	public static void main(String[] args) {
		Scanner sc=null;
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		String hname=null;
		String hphoto=null;
		int hid=0;
		float hsal=0.0f;
		File file=null;
		InputStream is=null;
		try {
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enetr hid:");
				hid=sc.nextInt();
				System.out.println("Enter hName:  ");
				hname=sc.next();
				System.out.println("Enter hSalary: ");
				hsal=sc.nextFloat();
				System.out.println("Eneter hPhotopath: ");
				hphoto=sc.next();
				
			}//if
			//Create InputStream by locating file based on hphoto
			file=new File(hphoto);
			is=new FileInputStream(file);
			//register MYSQL Driver
			Class.forName("com.mysql.jdbc.Driver");
			//Establish the Connection
			con=DriverManager.getConnection("jdbc:mysql:///dbjava","root","root");
			//Create PreparedStatement Object
			if(con!=null)
			ps=con.prepareStatement("INSERT INTO HERO VALUES(?,?,?,?)");
			//set values to Query parameter
			if(ps!=null) {
				ps.setInt(1,hid);
				ps.setString(2,hname);
				ps.setFloat(3,hsal);
				ps.setBinaryStream(4,is,file.length());
			}
			//Execute the MYSQL Query
			if(ps!=null) 
				result=ps.executeUpdate();
			//process the result
			if(result==0)
				System.out.println("Record not Inserted");
			else
				System.out.println("Record  Inserted");
				
		}//try
		catch(SQLException se) {//To handle known Exception
			se.printStackTrace();
			System.out.println("FRecord insertion Failed");
		}
			catch(ClassNotFoundException cnf) {//To handle known Exception
				System.out.println("Record insertion failed");
				cnf.printStackTrace();
		
		}
			catch(Exception e) {// To handle unknown Exception
				System.out.println("Record  Insertion failed");
				e.printStackTrace();
			}
		finally {
			//close MYSQL objects
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				
				se.printStackTrace();
		}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				
				se.printStackTrace();
		}
			try {
				if(sc!=null)
					sc.close();
			}
			catch(Exception e) {
				
				e.printStackTrace();
		}
			
		}//finally	

	}//main method

}//class
