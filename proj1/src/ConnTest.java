import java.sql.Connection;
import java.sql.DriverManager;

public class ConnTest {

	public static void main(String[] args)throws Exception {
		Connection con=null;
		//register type4 driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//establish the JDBC connection
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
		if(con==null) {
			System.out.println("Connection is not esatblished");
		}
		else {
			System.out.println("Connection is  esatblished");
		}
	}

}
