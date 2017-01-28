

import javax.swing.JOptionPane;
import javax.annotation.processing.Messager;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Tickets 
{
	
	   public static boolean check = true;
	   public static int count;
	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String connectionURL="jdbc:mysql://localhost/busticketproject";

	   //  Database credentials
	   static final String usernamefordatabase = "root";
	   static final String passwordfordatabase = "";
	   
	  

		//print tickets based on number given of textfield
		public static DefaultTableModel PrintTableTickets(DefaultTableModel model,int id)
		{
			Connection conn = null;
			Statement stmt = null;
			try {
				conn = DriverManager.getConnection(connectionURL,usernamefordatabase,passwordfordatabase);
				stmt = conn.createStatement();
				ResultSet  rs = stmt.executeQuery("SELECT * FROM tickets where ID ="+id+"");
				while(rs.next())
				{
					String tno = rs.getString("ID");
					String n = rs.getString("customerName");
				    String d = rs.getString("customerLastName");
				    String e = rs.getString("customerIDCertificate");
				    String f = rs.getString("departureDate");
				    String h = rs.getString("returnDate");
				    String p = rs.getString("receipt");
				    int rec = Integer.parseInt(p);
				    if (rec == 0){
				    	model.addRow(new Object[]{tno,n,d, e, f, h, "Απόδειξη"});
				    }
				    else
				    {
				    	model.addRow(new Object[]{tno,n,d, e, f, h, "Τιμολόγιο"});
				    }
				    
				    
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return model;
			
		}

		
		
		
		//save a ticket to the database
		public static void saveTickets(String Name, String lastName, String certificate, int ticketNumber,Date retDate, Date departDate,boolean receiptValue){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = null;
				Statement stmt = null;
				conn = DriverManager.getConnection(connectionURL,usernamefordatabase,passwordfordatabase);
				stmt = conn.createStatement();
				if (retDate == null){
					String sql2 = "INSERT INTO tickets " +
			                   "VALUES (NULL, '"+Name+"','"+lastName+"','"+certificate+"',"+ticketNumber+",'"+departDate+"',"+null+","+receiptValue+")";
					count = stmt.executeUpdate(sql2);
				}
				else{
					String sql2 = "INSERT INTO tickets " +
			                   "VALUES (NULL, '"+Name+"','"+lastName+"','"+certificate+"',"+ticketNumber+",'"+departDate+"','"+retDate+"',"+receiptValue+")";
					count = stmt.executeUpdate(sql2);
				}
				
				
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		
		

		   //get the next id number 
		public static int getnextTicketNo() {
			int lastNumber = 0;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn = null;
				Statement stmt = null;
				
				conn = DriverManager.getConnection(connectionURL,usernamefordatabase,passwordfordatabase);
				stmt = conn.createStatement();
				ResultSet  rs = stmt.executeQuery("SELECT ID FROM tickets ORDER BY ID DESC LIMIT 1");
				if (rs.next()){
					lastNumber = rs.getInt("ID");
					return lastNumber;
				}
			}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lastNumber;
			
		}


	
	
}
