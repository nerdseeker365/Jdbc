package ty.tr.dr;
/*
 * install IDS SERVER:
  http://www.idssoftware.com/download.html
  
 
 
  type3 JDBC  driver some important points:
  1.Talk with proxy server or Web server
  2. Not designed to talk with DB directly.
  3.Type3 Driver talk to IDS server,IDs server talk to JAVA application or app
  3.Java application passes dsn along with JDBC url to proxy server 
  //Register type3 JDBC driver 
		Class.forName("ids.sql.IDSDriver");
		//Establishing the Connection
		con=DriverManager.getConnection("jdbc:ids:///localhost:12/conn?dsn='accdsn'");
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnTest {

	public static void main(String[] args)throws Exception  {
		Connection con=null;
		//Register type3 JDBC driver 
		Class.forName("ids.sql.IDSDriver");
		//Establishing the Connection
		con=DriverManager.getConnection("jdbc:ids:///localhost:12/conn?dsn='accdsn'");
		if(con==null) {
			System.out.println("Connection is not Established");
		}
		else {
			System.out.println("Connection is Established");
		}

	}

}
