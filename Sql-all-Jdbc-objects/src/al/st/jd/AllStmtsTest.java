package al.st.jd;

import java.awt.Color;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;

import java.awt.event.WindowEvent;

import java.sql.CallableStatement;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.sql.Types;

import javax.swing.JButton;

import javax.swing.JComboBox;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JTextField;

/*
  1  create or replace procedure find1_pass_fail(m1 in number,m2 in number,m3 in number, res out varchar)
  2  as
  3  begin
  4  if(m1<35 or m2<35 or m3<35)then
  5  res:='fail';
  6  else
  7  res:='pass';
  8  end if;
  9 end;
SQL> /

Procedure created.

SQL> desc student11;
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 SNO                                                NUMBER(10)
 SM1                                                VARCHAR2(20)
 SM2                                                VARCHAR2(20)
 SM3                                                VARCHAR2(20)

 */

@SuppressWarnings("serial")
public class AllStmtsTest extends JFrame implements ActionListener {
	
	private JLabel lno,lname,lm1,lm2,lm3,lres;
	
	private JTextField tname,tm1,tm2,tm3,tres;
	
	private JButton bdetails,bresult;
	
	private JComboBox<Integer> tno;
	
	private Connection con;
	
	private Statement st;
	
	private ResultSet rs1,rs2;
	
	private PreparedStatement ps;
	
	private CallableStatement cs;
	
	//Constructor
	public AllStmtsTest(){
		
	System.out.println("AllStmtsTest:0-param constructor");
	
	setTitle("mini poject");
	
	setSize(300,300);
	
	setLayout(new FlowLayout());
	
	setBackground(Color.gray);
	
	//add components
	lno=new JLabel("Student id");
	
	add(lno);
	
	tno=new JComboBox<Integer>();
	
	add(tno);
	
	bdetails=new JButton("details");
	
	bdetails.addActionListener(this);
	
	add(bdetails);
	
	lname=new JLabel("Name");
	
	add(lname);
	
	tname=new JTextField(10);
	
	add(tname);
	
	lm1=new JLabel("marks1");
	
	add(lm1);
	
	tm1=new JTextField(10);
	
	add(tm1);
	
	lm2=new JLabel("marks2");
	
	add(lm2);
	
	tm2=new JTextField(10);
	
	add(tm2);
	
	lm3=new JLabel("marks3");
	
	add(lm3);
	
	tm3=new JTextField(10);
	
	add(tm3);
	
	bresult=new JButton("Result");
	
	bresult.addActionListener(this);
	
	add(bresult);
	
	lres=new JLabel("result");
	
	add(lres);
	
	tres=new JTextField(10);
	
	add(tres);
	
	//disable editing of components
	
	tname.setEditable(false);
	
	tm1.setEditable(false);
	
	tm2.setEditable(false);
	
	tm3.setEditable(false);
	
	tres.setEditable(false);
	
	
	setVisible(true);
	
	this.addWindowListener(new MyWindowAdapter());
	
	loadItems();
	
	}//constructor
	
	private void loadItems() {
		
		System.out.println("load Items");
		
	try {
		
		//register driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//establish the connection 
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
		
		//create statement object
		if(con!=null)
			st=con.createStatement();
		
		//execute query
		if(st!=null)
			rs1=st.executeQuery("select sno from student11");
		
		//copy the result set SNO values to combo box
		
		if(rs1!=null) {
			
			while(rs1.next()) {
				
			tno.addItem(rs1.getInt(1));	
			
			}//while
		
			}//if
		
	//create preparedStatement object
	if(con!=null)
		ps=con.prepareStatement("select * from student11 where sno=?");
	
	////create CallableStatement object
	
	if(con!=null) {
	cs=con.prepareCall("{call FIND1_PASS_FAIL(?,?,?,?)}");
	cs.registerOutParameter(4, Types.VARCHAR);
	
	}//if
	
	}//try
	
	catch(SQLException se) {
		
		se.printStackTrace();
	}
		
	catch(ClassNotFoundException cnf) {	
	
		cnf.printStackTrace();
	}
	}//loadItems
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
	int m1=0,m2=0,m3=0;
	
	String result=null;
	
	System.out.println("Actionperformed(-)");
	
	if(ae.getSource()==bdetails) {
		
		System.out.println("Details btn is clicked");
		
		try {
			
			//get the selected value from combo box
			int no=(Integer)tno.getSelectedItem();
			
			//set value to query parameters 
			
			if(ps!=null) {
				
				ps.setInt(1, no);
				
				//execute query
				rs2=ps.executeQuery();
				
			}
			
			//set resultSet object record to text boxes
			
			if(rs2!=null)
				
			{
				
				if(rs2.next())
					
				{
					tname.setText(rs2.getString(2));
					
					tm1.setText(rs2.getString(3));
					
					tm2.setText(rs2.getString(4));
					
					tm3.setText(rs2.getString(5));
					
				}//if
				
		}//if
			
	}//try
		
		catch(SQLException se) {
			
			se.printStackTrace();
			
		}//catch	
			

		
	}//if
	
	else {
		
		System.out.println("result btn is clicked");
		
		try {
			
			//read text box values (m1,m2,m3)
			
			m1=Integer.parseInt(tm1.getText());
			
			m2=Integer.parseInt(tm2.getText());
			
			m3=Integer.parseInt(tm3.getText());
			
			//set values to in parameters 
			
			if(cs!=null) {
				
				cs.setInt(1,m1);
				
				cs.setInt(2, m2);
				
				cs.setInt(3, m3);
				
				//execute PL/SQL procedure
				
				cs.execute();
				
				//gather value from out parameter  and get results
				result=cs.getString(4);
				
				//set result to text box
				tres.setText(result);
				
			}//if
			
			}//try
		
		catch(SQLException se) {
			
			se.printStackTrace();
			
		}//catch
		
		}//else
	
	}//action performed(-)
	




public static void main(String[] args) {
	
	System.out.println("maim(-) method ");
	
	AllStmtsTest test=new AllStmtsTest();
	
}//main

private class MyWindowAdapter extends WindowAdapter{
	

	@Override
	public void windowClosing(WindowEvent e) {
		
		System.out.println("Window Closing");
		
		try {
			
			if(rs1!=null)
				
				rs1.close();
			
		}
			catch(SQLException se) {
				
				se.printStackTrace();
				
			}
		
		
			try {
				
				if(rs2!=null)
					
					rs2.close();
				
			}
				catch(SQLException se) {
					
					se.printStackTrace();
					
				}
			
				try {
					
					if(cs!=null)
						
						cs.close();
					
				}
					catch(SQLException se) {
						
						se.printStackTrace();
					}
				
					try {
						
						if(st!=null)
							
							st.close();
						
					}
						catch(SQLException se) {
							
							se.printStackTrace();
						}
					
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
			
		}//method 
	
	}//inner class

}//class