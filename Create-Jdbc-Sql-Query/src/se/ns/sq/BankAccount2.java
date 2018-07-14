package se.ns.sq;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;
import java.util.Scanner;

public class BankAccount2 {

	public static void main(String[] args)throws Exception  {
		Scanner sc=null;
		sc=new Scanner(System.in);
		String query=null;
		Connection con=null;
		Statement st=null;
	
		int result=0;
		System.out.println("Enter the SQL Query: ");
		query=sc.nextLine();
		//register type4 JDBC driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Establishing the Connection
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
		//create Statement object
		st=con.createStatement();
		//execute the Query
		result=st.executeUpdate(query);
		if(result==0) {
			System.out.println("Query is Executed ");
		}
		else {
			System.out.println("Query is not executed");
		}
		//close sc
		sc.close();
	}//main method
	

}//class
