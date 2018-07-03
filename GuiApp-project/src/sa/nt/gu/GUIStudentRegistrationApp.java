package sa.nt.gu;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
/*SQL> create sequence sno_seq start with 1 increment by 1; 

SQL> desc student1;
Name                                      Null?    Type
----------------------------------------- -------- ----------------------------
SNO                                       NOT NULL NUMBER(5)
SNAME                                              VARCHAR2(20)
SADD                                               VARCHAR2(20)

* */
import javax.swing.JLabel;
import javax.swing.JTextField;
public class GUIStudentRegistrationApp extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String  INSERT_QUERY="INSERT INTO STUDENT1 VALUES(SNO_SEQ.NEXTVAL,?,?)";
	 private JLabel  lname,laddrs,lresult;
	 private JButton register;
	 private JTextField tfname,taddrs;
	 private Connection con;
	 private PreparedStatement ps;
	 
	 //constructor
	 public GUIStudentRegistrationApp() {
		 System.out.println("constructor");
		 //super("Registration App")
		 setTitle("Registration App");
		 setSize(400,400);
		 setLayout(new FlowLayout());
		 //add comps
		 lname=new JLabel("Student name::");
		 add(lname);
		 tfname=new JTextField(10);
		 add(tfname);
		 
		 laddrs=new JLabel("Student addres::");
		 add(laddrs);
		 
		 taddrs=new JTextField(10);
		 add(taddrs);
		 
		 register=new JButton("register");
		 register.addActionListener(this);
		  add(register);
		  
		  lresult=new JLabel("Result is::");
		 add(lresult);
		 
		 setVisible(true);
		 //initialize JDBC objects
		 makeConnection();
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
	}//constructor
	 
	 private  void  makeConnection(){
		 System.out.println("makeConnection()");
		 try{
			 //register driver
			 Class.forName("oracle.jdbc.driver.OracleDriver");
			 //establish the connection
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","scott","tiger");
			 //create PreparedStatement object
			 ps=con.prepareStatement(INSERT_QUERY);
		 }//try
		 catch(SQLException se){
			 se.printStackTrace();
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
	 }//makeConnection()
	 
	 
	 public static void main(String[] args) {
		 System.out.println("main(-) method");
		 new GUIStudentRegistrationApp(); //Anonymous object
	}//main

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String name=null,addrs=null;
		System.out.println("actionPerformed(-)");
		try{
			//read text box values
			name=tfname.getText();
			addrs=taddrs.getText();
			//set values to Query parameters(?)
			ps.setString(1,name);
			ps.setString(2,addrs);
			//execute the Query
			int result=ps.executeUpdate();
			if(result==1){
				lresult.setForeground(Color.GREEN);
				lresult.setText("Registration Succeded");
				tfname.setText("");
				taddrs.setText("");
			}
			else{
				lresult.setForeground(Color.RED);
				lresult.setText("Registration failed");
				tfname.setText("");
				taddrs.setText("");

			}
			
		}
		catch(SQLException se){
			lresult.setForeground(Color.RED);
			lresult.setText("Registration failed"+se.getMessage());
			tfname.setText("");
			taddrs.setText("");

		}
		catch(Exception e){
			lresult.setForeground(Color.RED);
			lresult.setText("Registration failed"+e.getMessage());
			tfname.setText("");
			taddrs.setText("");

		}
	}//actionPerformed(-)
}//class 

	


