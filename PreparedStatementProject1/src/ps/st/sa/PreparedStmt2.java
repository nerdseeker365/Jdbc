package ps.st.sa;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import java.util.Scanner;

/*
 
SQL> desc student;
 Name                                                  Null?    Type
 ----------------------------------------------------- -------- ------------------------------------
 SID                                                            NUMBER(10)
 SNAME                                                          VARCHAR2(20)
 SDOJ                                                           DATE
 SADDRESS                                                       VARCHAR2(20)
 SPHN                                                           NUMBER(10)
 Enter Student Count: 
1

Enter 1 Student Detals 

Enter Number: 
106
Enter Name: 
srinu
Enter Joining Date:
23-jan-16
Enter Address:
razole
Enter Phone Number:
9666780916
1
 Student Details are Inserted
 
 
SQL> select * from student;

       SID SNAME                SDOJ      SADDRESS                   SPHN
---------- -------------------- --------- -------------------- ----------
       105 kumar                17-JUN-18 razol                   8979690
       101 sankar               13-JUN-18 razole               9494624217
       102 raju                 14-JUN-18 hyd                  9666780916
       106 srinu                23-JAN-16 razole               9666780916



 */
public class PreparedStmt2 {

	public static void main(String[] args) {
		
		Scanner sc=null;
		
		int count=0;
		
		Connection con=null;
		
		String query=null;
		
		PreparedStatement ps=null;
		
		int sno=0;
		
		String sname=null;
		
		String  sdoj=null;
		
		String saddress=null;
		
		long sphn=0;
		
		int result=0;
		
		try {
			
			//Read Inputs
			
			sc=new Scanner(System.in);
			
			System.out.println("Enter Student Count: ");
			
			if(sc!=null)
				
				count=sc.nextInt();
			
				//Register JDBC type4 Driver
			
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//Establishing Connection
				
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
				
				//Prepare SQl Query
				
				query="INSERT INTO STUDENT VALUES(?,?,?,?,?)";
				
				if(con!=null)
					
					ps=con.prepareStatement(query);
				
				//Read multiple sets input values from End user 
				
				if(sc!=null) {
					
					for(int i=1;i<=count;i++) {
						
						System.out.println("\nEnter "+i+" Student Detals \n");
						
						System.out.println("Enter Number: ");
						
						sno=sc.nextInt();
						
						System.out.println("Enter Name: ");
						
						sname=sc.next();
						
						System.out.println("Enter Joining Date:"); 
						
						sdoj=sc.next();
						
						System.out.println("Enter Address:");
						
						saddress=sc.next();
						
						System.out.println("Enter Phone Number:");
						
						sphn=sc.nextLong();
						
						//Set the Input values Read from End User to Query Parameter
						
						ps.setInt(1,sno);
						
						ps.setString(2,sname);
						
						ps.setString(3,sdoj);
						
						ps.setString(4,saddress);
						
						ps.setLong(5,sphn);
						
						//Execute the Query
						
						result=ps.executeUpdate();
						
						if(result==0)
							
							System.out.println(i+"\n Student Details are Not Inserted"); 
					
					else
						
						System.out.println(i+"\n Student Details are Inserted"); 
						
					}//for
					
				}//if
				
			}//try
		
		catch(SQLException se) {//To Handle Known Exception
			
			se.printStackTrace();
			
		}
		
		catch(ClassNotFoundException cnf) {//To Handle Known Exception
			
			cnf.printStackTrace();
			
		}
		
		catch(Exception e) {//To Handle UnKnown Exception
			
			e.printStackTrace();
			
		}
		
		finally {
			
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


