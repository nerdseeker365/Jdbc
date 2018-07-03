package se.qu.or;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/*
 * SQL> select * from emp;

     EMPNO ENAME      JOB              MGR HIREDATE         SAL       COMM     DEPTNO
---------- ---------- --------- ---------- --------- ---------- ---------- ----------
      7369 SMITH      CLERK           7902 17-DEC-80        800                    20
      7499 ALLEN      SALESMAN        7698 20-FEB-81       1600        300         30
      7521 WARD       SALESMAN        7698 22-FEB-81       1250        500         30
      7566 JONES      MANAGER         7839 02-APR-81       2975                    20
      7654 MARTIN     SALESMAN        7698 28-SEP-81       1250       1400         30
      7698 BLAKE      MANAGER         7839 01-MAY-81       2850                    30
      7782 CLARK      MANAGER         7839 09-JUN-81       2450                    10
      7788 SCOTT      ANALYST         7566 19-APR-87       3000                    20
      7839 KING       PRESIDENT            17-NOV-81       5000                    10
      7844 TURNER     SALESMAN        7698 08-SEP-81       1500          0         30
      7876 ADAMS      CLERK           7788 23-MAY-87       1100                    20
      7900 JAMES      CLERK           7698 03-DEC-81        950                    30
      7902 FORD       ANALYST         7566 03-DEC-81       3000                    20
      7934 MILLER     CLERK           7782 23-JAN-82       1300                    10

14 rows selected.
 */
public class Select_Emp_Table {

	public static void main(String[] args)throws Exception {
		
		Connection con=null;
		
		Statement st=null;
		
		ResultSet rs=null;
		
		//Register type4 JDBC driver
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//Establish the database Connection 
		
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
		
		//create Statement Object
		
		st=con.createStatement();
		
		//Execute the Query and process the Query
		
		//select * from emp;
		
		//rs=st.executeQuery("SELECT * FROM EMP");
		
		rs=st.executeQuery("SELECT EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO FROM EMP");
		
		System.out.println("EMP TABLE DETAILS:");
		
		System.out.println();
		
		while(rs.next()) {
			
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getDate(5)+"\t"+rs.getInt(6)+"\t"+rs.getInt(7)+"\t"+rs.getInt(8));
		}
		//close all JDBC objects
		con.close();
		st.close();
		rs.close();
	}//main method
	}//class


