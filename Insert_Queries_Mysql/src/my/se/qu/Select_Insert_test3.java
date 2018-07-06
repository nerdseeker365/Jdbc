package my.se.qu;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.Scanner;
/*
 * mysql> desc test3;
+----------+-------------+------+-----+---------+-------+
| Field    | Type        | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| tid      | int(11)     | NO   | PRI | NULL    |       |
| tname    | varchar(45) | YES  |     | NULL    |       |
| taddress | varchar(45) | YES  |     | NULL    |       |
| tsal     | int(11)     | YES  |     | NULL    |       |
+----------+-------------+------+-----+---------+-------+
4 rows in set (0.00 sec)

 */
public class Select_Insert_test3 {

	
	public static void main(String[] args) throws SQLException {
		
		Scanner sc=null;
		
		int tid=0;
		
		String tname=null;
		
		String taddress=null;
		
		int tsal =0;
		
		String query=null;
		
		Connection con=null;
		
		Statement st=null;
		
		int result=0;
		
		try {
			
		     //read inputs
			
			 sc=new Scanner(System.in);
			 
	if(sc!=null) {
		
			System.out.print("Eneter Test3 id: ");
			
			tid=sc.nextInt();//gives id
			
			System.out.println("Enetre test3 name: ");
			
			tname=sc.next();//gives name
			
			System.out.println("Enter test3 address: ");
			
			taddress=sc.next();//gives address
			
			System.out.println("Enter test3 sal: ");
			
			tsal=sc.nextInt();//gives salary
			
	}//if
	
	
		//Convert input values as required for the MYSQL query
	
		tname="'"+tname+"'";//gives name
		
		taddress="'"+taddress+"'";//gives address
		
		//Register type4 MYSQL driver with database software
		
		Class.forName("com.mysql.jdbc.Driver");
		
		//Establish the Connection
		
		con=DriverManager.getConnection("jdbc:mysql:///dbjava", "root","root");
		
		//Create Statement object
		
		if(con!=null)
			
		st=con.createStatement();
		
		//prepare MYSQL query
		
		//insert into test3(tid,tname,taddress,tsal)values(101,'sankar','razole',2300);
		
		query="INSERT INTO TEST3(tid,tname,taddress,tsal)values("+tid+","+tname+","+taddress+","+tsal+")";
		
		System.out.println(query);
		
		//send and execute MYSQL query in database software
		
		if(st!=null)
			
			result=st.executeUpdate(query);
		
		//process the result
		
		if(result==0)
			
			System.out.println("Record Insertion failed ");
		
		else
			
			System.out.println("Record Insertion Succeded ");
		
		
		}//try
		
		catch(SQLException se) {//to handle known Exception
			
			se.printStackTrace();
			
			System.out.println("Record Insertion failed ");
			
		}
		
		catch(ClassNotFoundException cnf) {//To handle known Exception
			
			System.out.println("Record Insertion failed "); 
			
			cnf.printStackTrace();
			
		}
		
		catch(Exception e) {//To handle Unknown Exception
			
			System.out.println("Record Insertion failed ");
			
			e.printStackTrace();
			
		}

		finally{
			
			//close JDBC objects
		
			
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

