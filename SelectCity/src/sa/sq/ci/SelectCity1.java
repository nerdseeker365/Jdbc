package sa.sq.ci;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectCity1 {

	public static void main(String[] args)throws Exception {
		//reading input values
		Scanner sc=null;
		String pcity=null;
		sc=new Scanner(System.in);
		System.out.print("Enter city name: ");
		pcity=sc.nextLine();//gives pcity name
		pcity="'"+pcity+"'";
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		//register TYPE4 jdbc driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//establish the Connection with Database Software
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
        //create JDBC Statement object
		st=con.createStatement();
		//execute the Query and process the Query
		rs=st.executeQuery("SELECT * FROM PERSON WHERE PCITY="+pcity);
		//print Database table records	
		while(rs.next()) {
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		}
		//close JDBC streams objects
		con.close();
		st.close();
		rs.close();
		sc.close();
	}//main method

}//class
