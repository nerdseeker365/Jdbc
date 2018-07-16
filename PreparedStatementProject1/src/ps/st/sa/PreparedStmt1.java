package ps.st.sa;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.util.Scanner;

/*
 
SQL> create table student2(sno number(10),sname varchar2(20),saddress varchar2(20));
 

SQL> select * from student2;

       SNO SNAME                SADDRESS
---------- -------------------- --------------------
 101 sankar               razole
*/

public class PreparedStmt1 {

	public static void main(String[] args)throws Exception {
		
		Scanner sc=null;
		
		int count=0;
		
		int number=0;
		
		String name=null;
		
		String address=null;
		
		Connection con=null;
		
		String query=null;
		
		PreparedStatement ps=null;
		
		int result=0;
		
		sc=new Scanner(System.in);
		
		System.out.println("Eneter Count: ");
		
		count=sc.nextInt();
		
		//register JDBC driver
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//Establishing Connection
		
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "scott", "tiger");
		
		//prepare SQl Query
		
		query="INSERT INTO STUDENT2 VALUES(?,?,?)";
		
		ps=con.prepareStatement(query);
		
		//Read multiple sets of input values from end user
		
		for(int i=1;i<=count;i++) {
			
			System.out.println("Enter "+1+" Student2 Details");
			
			System.out.println(); 
			 
			System.out.print("Enter number: ");
			
			number=sc.nextInt();
			
			System.out.print("Enter Name: ");
			
			name=sc.next();
			
			System.out.print("Enter Address: ");
			
			address=sc.next();
			
			//Set input values Read from End User to Query Parameter
			
			ps.setInt(1,number);
			
			ps.setString(2,name);
			
			ps.setString(3,address);
			
			//Execute the Query
			
			result=ps.executeUpdate();
			
			if(result==0) {
				
				System.out.println(i+"Student2 Details are not Inserted"); 
				
			}
			
			else {
				
				System.out.println(i+"\nStudent2 Details are Inserted\n"); 
				
			}
			
		}//for
		
		//close JDBC objects
		
		ps.close();
		
		con.close();
		
		sc.close();
		
	}//main method

}//class
