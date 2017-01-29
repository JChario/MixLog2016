

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.annotation.processing.Messager;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.StringUtils;

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
		public static DefaultTableModel PrintTableTickets(JFrame frame,DefaultTableModel model,int id)
		{
			Connection conn = null;
			Statement stmt = null;
			int count = 0;
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
					    String l = rs.getString("BusNumber");
					    String k = rs.getString("SeatNumber");
					    String p = rs.getString("receipt");
					    int rec = Integer.parseInt(p);
					    if (rec == 0){
					    	model.addRow(new Object[]{tno,n,d, e, f, h,l,k, "Απόδειξη"});
					    }
					    else
					    {
					    	model.addRow(new Object[]{tno,n,d, e, f, h,l,k, "Τιμολόγιο"});
					    }
					    count++;
					 }
					if (count == 0)
					{
						JOptionPane.showMessageDialog(frame, "Δε βρέθηκε εισητήριο με αριθμό εισητηρίου: \nΑρ.Εισ.:"+ id,"No Ticket", JOptionPane.ERROR_MESSAGE);
					}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return model;
			
		}

		
		
		
		//save a ticket to the database
		public static void saveTickets(String Name, String lastName, String certificate,Date retDate, Date departDate,int busNumber, int SeatNumber,boolean receiptValue){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = null;
				Statement stmt = null;
				conn = DriverManager.getConnection(connectionURL,usernamefordatabase,passwordfordatabase);
				stmt = conn.createStatement();
				if (retDate == null){
					String sql2 = "INSERT INTO tickets " +
			                   "VALUES (NULL, '"+Name+"','"+lastName+"','"+certificate+"',"+null+",'"+departDate+"',"+busNumber+","+SeatNumber+","+receiptValue+")";
					count = stmt.executeUpdate(sql2);
				}
				else{
					String sql2 = "INSERT INTO tickets " +
			                   "VALUES (NULL, '"+Name+"','"+lastName+"','"+certificate+"','"+retDate+"','"+departDate+"',"+busNumber+","+SeatNumber+","+receiptValue+")";
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
		
		
		
		
		
		
		
		//check if there are available seats
		public static boolean checkAvailability(JFrame frame,int seat, int busNO) {
			
			Connection conn = null;
 			Statement stmt = null;
 			int SeatNumber =0;
 			try {
 				conn = DriverManager.getConnection(connectionURL,usernamefordatabase,passwordfordatabase);
 				stmt = conn.createStatement();
 				
				ResultSet  rs = stmt.executeQuery("SELECT * FROM tickets WHERE BusNumber = "+busNO+" AND SeatNumber = " + seat +"");
 				while(rs.next())
 				{
 					SeatNumber++;
 				}
 				if (SeatNumber > 0 ){
 					JOptionPane.showMessageDialog(frame, "Seat Not Available!\nPlease try another seat.","Seat Taken", JOptionPane.ERROR_MESSAGE);
					return false;
 				}
 				else{
 					return true;
 				}
 				
 				
 				
 			} catch (SQLException e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
			return false;
			
		}


		
		
		//Delete ticket from database
		public static boolean DeleteTicket(Object id) {
			boolean check = false;
			try{
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn = null;
				Statement stmt = null;
				Statement stmt1 = null;
				
				conn = DriverManager.getConnection(connectionURL,usernamefordatabase,passwordfordatabase);
				//create statements;
				stmt = conn.createStatement();
				stmt1 = conn.createStatement();
				
				//first delete the user and set boolean to true;
				String sql = "DELETE FROM tickets WHERE ID="+id+"";
				int count = stmt.executeUpdate(sql);
				check = (count>0);
				
				//reset auto increment so in the next add we set it back to the original number;
				String incrToZero = "ALTER TABLE tickets AUTO_INCREMENT = 1";
				stmt1.executeUpdate(incrToZero);
				
					
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return check;
		}
	  
	
	
}
