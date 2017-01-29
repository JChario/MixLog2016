

import javax.swing.JComboBox;
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

public class Busses 
{
	
	   public static boolean check = true;
	   public static int count;
	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String connectionURL="jdbc:mysql://localhost/busticketproject";

	   //  Database credentials
	   static final String usernamefordatabase = "root";
	   static final String passwordfordatabase = "";
	   
	   
	   
	 //print table inside admin panel.
	 		public static DefaultTableModel PrintTableBusses(DefaultTableModel model)
	 		{
	 			Connection conn = null;
	 			Statement stmt = null;
	 			try {
	 				conn = DriverManager.getConnection(connectionURL,usernamefordatabase,passwordfordatabase);
	 				stmt = conn.createStatement();
	 				ResultSet  rs = stmt.executeQuery("SELECT * FROM busses");
	 				while(rs.next())
	 				{
	 					String id = rs.getString("BusNumber");
	 				    String d = rs.getString("Seats");
	 				    String e = rs.getString("Schedule");
	 				    model.addRow(new Object[]{id,d, e});
	 				    
	 				}
	 				
	 			} catch (SQLException e1) {
	 				// TODO Auto-generated catch block
	 				e1.printStackTrace();
	 			}
	 			return model;
	 			
	 		}



			public static boolean DeleteBus(Object selectedID) {
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
					String sql = "DELETE FROM busses WHERE ID="+selectedID+"";
					int count = stmt.executeUpdate(sql);
					check = (count>0);
					
					//reset auto increment so in the next add we set it back to the original number;
					String incrToZero = "ALTER TABLE busses AUTO_INCREMENT = 1";
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



			public static void UpdateDB(JFrame frame,String thisbusNumber, String thisbusSeats, String thisDestination) 
				{
					try{
						Class.forName("com.mysql.jdbc.Driver");
						
						Connection conn = null;
						Statement stmt = null;
						System.out.println(thisDestination);
						conn = DriverManager.getConnection(connectionURL,usernamefordatabase,passwordfordatabase);
						stmt = conn.createStatement();
						boolean isINT = StringUtils.isStrictlyNumeric(thisbusNumber);
						boolean isINT1 = StringUtils.isStrictlyNumeric(thisbusSeats);
						
						if(!isINT){
							JOptionPane.showMessageDialog(frame, "Bus Number is not an integer!\nTry again..","Bus Number Error", JOptionPane.ERROR_MESSAGE);
							return;
						}
						else if(!isINT1){
							JOptionPane.showMessageDialog(frame, "Bus Seats is not an integer!\nTry again..","Bus Seats Error", JOptionPane.ERROR_MESSAGE);
							return;
						}
						else
						{
							int busnumber = Integer.parseInt(thisbusNumber);
							int busSeats = Integer.parseInt(thisbusSeats);
							String sql = "INSERT INTO busses " +
					                   "VALUES (NULL, "+busnumber+","+busSeats+",'"+thisDestination+"')";
							count = stmt.executeUpdate(sql);
						}
						
						
					}catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}



			public static boolean success() {
				boolean success1 = false;
				if (count>0){
					boolean success11 = true;
					return success11;
				}
				else{
					return success1;
				}
				
			}



			public static void ViewBussesDropdown(JComboBox comboBox)
			{
	 			Connection conn = null;
	 			Statement stmt = null;
	 			try {
	 				conn = DriverManager.getConnection(connectionURL,usernamefordatabase,passwordfordatabase);
	 				stmt = conn.createStatement();
	 				ResultSet  rs = stmt.executeQuery("SELECT * FROM busses");
	 				while(rs.next())
	 				{
	 					String id = rs.getString("BusNumber");
	 				    String d = rs.getString("Seats");
	 				    String e = rs.getString("Schedule");
	 				    comboBox.addItem(id +" - "+ e);
	 				    
	 				}
	 				
	 			} catch (SQLException e1) {
	 				// TODO Auto-generated catch block
	 				e1.printStackTrace();
	 			}
	 			
	 			
	 		}



			public static int maxValue(int givenSeatNumber,int BusNumber) 
			{
				int MaxSeatsAvailable = 0;
	 			Connection conn = null;
	 			Statement stmt = null;
	 			try {
	 				conn = DriverManager.getConnection(connectionURL,usernamefordatabase,passwordfordatabase);
	 				stmt = conn.createStatement();
	 				ResultSet  rs = stmt.executeQuery("SELECT Seats FROM busses WHERE BusNumber = " +BusNumber );
	 				while(rs.next())
	 				{
	 					
 						MaxSeatsAvailable =  rs.getInt("Seats");
	 				    
	 				}
	 				
	 			} catch (SQLException e1) {
	 				// TODO Auto-generated catch block
	 				e1.printStackTrace();
	 			}
				return MaxSeatsAvailable;
	 			
	 		}




			
	  


	
	
}
