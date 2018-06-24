
/*import java.sql.Connection;
import java.sql.DriverManager;
//type1 driver jre1.7.0
public class ConnTestType1 {

	public static void main(String[] args)throws Exception  {
		Connection con=null;
		//register driver class object 
		sun.jdbc.odbc.JdbcOdbcDriver driver=new sun.jdbc.odbc.JdbcOdbcDriver();
		//register driver with driver manager service
		DriverManager.registerDriver(driver);
		//establish the connection
		con=DriverManager.getConnection("jdbc:odbc:oradsn","scott","tiger");
		if(con==null) {
			System.out.println("Connection is not esatblished");
		}
		else {
			System.out.println("Connection is  esatblished");
		}
	}//main method 
}//class*/
