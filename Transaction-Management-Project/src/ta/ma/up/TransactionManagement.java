package ta.ma.up;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
/*
 
SQL> select * from account;

AH                         SANO       DANO     AMOUNT
-------------------- ---------- ---------- ----------
sankar                   110234     110897       1000
mounika                  110543     110988        100

SQL> desc account;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 AH                                                 VARCHAR2(20)
 SANO                                               NUMBER(10)
 DANO                                               NUMBER(10)
 AMOUNT                                             NUMBER(10)

 */

public class TransactionManagement {

	public static void main(String[] args) {
		Scanner sc=null;
		int sano=0;
		int dano=0;
		int amount=0;
		Connection con=null;
		Statement st=null;
		int result[]=null;
		boolean flag=false;
		try {
			//Read Inputs
			sc=new Scanner(System.in);
			if(sc!=null) {
				System.out.println("Enter Source Account No: ");
				sano=sc.nextInt();
				System.out.println("Enter Destination Account No: ");
				dano=sc.nextInt();
				System.out.println("Enter Amount to Transfer: ");
				amount=sc.nextInt();
			}//if
			//Register TYPE4 JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Establishing the Connection
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
			//Begin Transaction
			if(con!=null) {
				con.setAutoCommit(false);
				//Create Statement Object
				st=con.createStatement();
			}
			if(st!=null) {
				//add Queries to the batch
				//withdraw amount from source account(sano)
				st.addBatch("UPDATE ACCOUNT SET BAL=BAL-"+amount+"WHERE SANO="+sano);
				//Deposite amount into dest account
				st.addBatch("UPDATE ACCOUNT SET BAL=BAL+"+amount+"WHERE SANO="+sano);
				//execute batch
				result=st.executeBatch();
			}//if
			//perform tx management(commit or rollback)
			if(result!=null) {
				for(int i=0;i<result.length;i++) {
					if(result[i]==0) {
						flag=true;
						break;
						
						
					}//if
					
				}//for
				if(flag==true) {
				con.rollback();
				System.out.println("Tx--rolledback--Money not Transfered"); 
				}
				else {
					con.commit();
					System.out.println("Tx Committed--Money Transfered"); 
				}//else
			}//if
			
		}//try
		catch(SQLException se) {//To handle known Exceptipon
			se.printStackTrace();
		}
		catch(ClassNotFoundException cnf) {//To handle known Exceptipon
			cnf.printStackTrace();
		}
		catch(Exception e) {//To handle Unknown Exceptipon
			e.printStackTrace();
		}
		finally {
			try {
				//close all jdbc objects
				if(st!=null)
					st.close();
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
				//close all jdbc objects
				if(sc!=null)
					sc.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

	}

}
