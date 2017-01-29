import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import org.eclipse.wb.swing.DateLabelFormatter;

import javafx.scene.control.DatePicker;

import javax.swing.JProgressBar;
import javax.swing.JEditorPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Label;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;

import com.mysql.jdbc.StringUtils;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JLocaleChooser;
import javax.swing.JCheckBox;
import javax.swing.JMenuBar;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;
import javax.swing.JMenu;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.InputEvent;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.JLayeredPane;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JSpinner;


public class CashierScreen {
	public static final JCalendar calendar = new JCalendar();
	public static final JCalendar calendar1 = new JCalendar();
	public static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
	public static final JCheckBox invoice = new JCheckBox("\u03A4\u03B9\u03BC\u03BF\u03BB\u03CC\u03B3\u03B9\u03BF");
	public static final JCheckBox receipt = new JCheckBox("\u0391\u03C0\u03CC\u03B4\u03B5\u03B9\u03BE\u03B7");
	private JFrame frmEztravel;
	private JTextField returnDateField;
	private JTextField departureDateField;
	private JTextField LastNameField;
	private JTextField CertificateField;
	private JTextField ticketNO;
	private JTextField NameField;
	private JTextField SeatChosenField;
	private JComboBox comboBox = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void CashierScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierScreen window = new CashierScreen();
					window.frmEztravel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CashierScreen() {
		initialize();
		loadDates();
		calendar1.getDayChooser().setEnabled(false);
		
		
		
		
		JLabel lblH = new JLabel("H\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1 \u0391\u03BD\u03B1\u03C7\u03CE\u03C1\u03B7\u03C3\u03B7\u03C2");
		lblH.setHorizontalAlignment(SwingConstants.CENTER);
		lblH.setBounds(21, 238, 177, 14);
		frmEztravel.getContentPane().add(lblH);
		
		JLabel lblH_1 = new JLabel("H\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1 \u0395\u03C0\u03B9\u03C3\u03C4\u03C1\u03BF\u03C6\u03AE\u03C2");
		lblH_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblH_1.setBounds(477, 238, 177, 14);
		frmEztravel.getContentPane().add(lblH_1);
		
		JButton btnNewButton = new JButton("\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7 - \u0394\u03B9\u03B1\u03B3\u03C1\u03B1\u03C6\u03AE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				closewindow();
				CashierSearchAndDelete.CashierSearchAndDelete();
				
			}
		});
		btnNewButton.setBounds(259, 437, 177, 23);
		frmEztravel.getContentPane().add(btnNewButton);
		
		NameField = new JTextField();
		NameField.setColumns(10);
		NameField.setBounds(85, 317, 113, 20);
		frmEztravel.getContentPane().add(NameField);
		
		JLabel label = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1:");
		label.setBounds(21, 320, 56, 14);
		frmEztravel.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("\u039B\u03B5\u03C9\u03C6\u03BF\u03C1\u03B5\u03B9\u03BF");
		lblNewLabel.setBounds(208, 74, 65, 14);
		frmEztravel.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(208, 99, 262, 2);
		frmEztravel.getContentPane().add(separator);
		
		
		comboBox.setBounds(208, 111, 262, 20);
		frmEztravel.getContentPane().add(comboBox);
		//view busses
		Busses.ViewBussesDropdown(comboBox);
		
		JLabel NumberOfSeats = new JLabel("");
		NumberOfSeats.setBounds(323, 142, 56, 14);
		frmEztravel.getContentPane().add(NumberOfSeats);
		
		JLabel label_1 = new JLabel("\u0398\u03AD\u03C3\u03B7");
		label_1.setBounds(208, 161, 65, 14);
		frmEztravel.getContentPane().add(label_1);
		
		SeatChosenField = new JTextField();
		SeatChosenField.setHorizontalAlignment(SwingConstants.CENTER);
		SeatChosenField.setBounds(208, 186, 86, 20);
		frmEztravel.getContentPane().add(SeatChosenField);
		SeatChosenField.setColumns(10);
		
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	void loadDates(){
		
		//get date of departure
		Date departdate = calendar.getDate();
		String departureDate = df.format(departdate);
		departureDateField.setText(departureDate);
		
	}
	private void initialize() {
		frmEztravel = new JFrame();
		frmEztravel.setTitle("EZTravel");
		frmEztravel.setBounds(100, 100,690, 510);
		frmEztravel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEztravel.getContentPane().setLayout(null);
		
		JLabel lblWelcomeCashier = new JLabel("Welcome Cashier");
		lblWelcomeCashier.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeCashier.setBounds(208, 11, 262, 27);
		frmEztravel.getContentPane().add(lblWelcomeCashier);
		
		
		
		
		
		calendar.getDayChooser().setDayBordersVisible(true);
		calendar.getDayChooser().setWeekOfYearVisible(false);
		calendar.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener(){
		    @Override
		    public void propertyChange(PropertyChangeEvent e) {
				Date departdate = calendar.getDate();
				String departureDate = df.format(departdate);
		    	//show departuredate on the textbox below when changes arrise :D
		        departureDateField.setText(departureDate);

		    }
		});
		
		
		
		calendar1.getDayChooser().setDayBordersVisible(true);
		calendar1.getDayChooser().setWeekOfYearVisible(false);
		calendar1.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener(){
		    @Override
		    public void propertyChange(PropertyChangeEvent e) {
				Date retdate = calendar1.getDate();
				String returnDate = df.format(retdate);
		    	//show return Date on the textbox below when changes arrise :D
		        returnDateField.setText(returnDate);

		    }
		});
		
		
		
		calendar.setBounds(21, 74, 177, 153);
		frmEztravel.getContentPane().add(calendar);
		
		JLabel label = new JLabel("");
		label.setBounds(20, 49, 46, 14);
		frmEztravel.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u0391\u03BD\u03B1\u03C7\u03CE\u03C1\u03B7\u03C3\u03B7");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(21, 49, 177, 27);
		frmEztravel.getContentPane().add(label_1);
		
		returnDateField = new JTextField();
		returnDateField.setHorizontalAlignment(SwingConstants.CENTER);
		returnDateField.setEditable(false);
		returnDateField.setEnabled(false);
		returnDateField.setBounds(477, 261, 177, 20);
		frmEztravel.getContentPane().add(returnDateField);
		returnDateField.setColumns(10);
		
		departureDateField = new JTextField();
		departureDateField.setHorizontalAlignment(SwingConstants.CENTER);
		departureDateField.setEditable(false);
		departureDateField.setBounds(20, 261, 178, 20);
		frmEztravel.getContentPane().add(departureDateField);
		departureDateField.setColumns(10);
		
		
		
		JLabel label_2 = new JLabel("\u0395\u03C0\u03B9\u03C3\u03C4\u03C1\u03BF\u03C6\u03AE");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(480, 49, 177, 27);
		frmEztravel.getContentPane().add(label_2);
		calendar1.getMonthChooser().getComboBox().setEnabled(false);
		calendar1.getYearChooser().getSpinner().setEnabled(false);
		calendar1.getDayChooser().setWeekOfYearVisible(false);
		calendar1.getDayChooser().setDayBordersVisible(true);
		calendar1.setBackground(Color.BLACK);
		
		
		calendar1.setBounds(480, 74, 177, 153);
		frmEztravel.getContentPane().add(calendar1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\u039C\u03B5 \u03B5\u03C0\u03B9\u03C3\u03C4\u03C1\u03BF\u03C6\u03AE");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean month = calendar1.getMonthChooser().isEnabled();
				boolean year = calendar1.getYearChooser().isEnabled();
				boolean day = calendar1.getDayChooser().isEnabled();
				if (month && year && day){
					calendar1.getMonthChooser().setEnabled(false);
					calendar1.getDayChooser().setEnabled(false);
					calendar1.getYearChooser().setEnabled(false);
					returnDateField.setEnabled(false);
					returnDateField.setText(null);
				}
				else
				{
					calendar1.getMonthChooser().setEnabled(true);
					calendar1.getDayChooser().setEnabled(true);
					calendar1.getYearChooser().setEnabled(true);
					returnDateField.setEnabled(true);
					Date chosendate = calendar1.getDate();
					String chosenDate = df.format(chosendate);
					returnDateField.setText(chosenDate);
				}
			}
		});
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox.setBounds(477, 288, 105, 23);
		frmEztravel.getContentPane().add(chckbxNewCheckBox);
		
		
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmEztravel.setVisible(false);
				LoginScreen login = new LoginScreen();
				login.setVisible(true);
			}
		});
		btnLogOut.setBounds(477, 437, 177, 23);
		frmEztravel.getContentPane().add(btnLogOut);
		
		JButton btnE = new JButton("\u0391\u03C0\u03BF\u03B8\u03AE\u03BA\u03B5\u03C5\u03C3\u03B7-E\u03BA\u03C4\u03CD\u03C0\u03C9\u03C3\u03B7 ");
		btnE.setToolTipText("\u03A0\u03B1\u03C4\u03CE\u03BD\u03C4\u03B1\u03C2 \u03B5\u03BA\u03C4\u03CD\u03C0\u03C9\u03C3\u03B7 \u03BA\u03B1\u03C4\u03B1\u03C7\u03C9\u03C1\u03BF\u03CD\u03BD\u03C4\u03B1\u03B9 \u03C3\u03C4\u03BF \u03C3\u03CD\u03C3\u03C4\u03B7\u03BC\u03B1 \u03C4\u03B1 \u03C3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03B1");
		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//initialize variable
				boolean available = false;
				//get Seat number inserted
				String seat = SeatChosenField.getText().toString().trim().toLowerCase();
				//get the whole string from dropdown
				//split the string to -
				//get first part and trim spaces
				//then check if available
				String bus = String.valueOf(comboBox.getSelectedItem());
				String[] parts = bus.split("-");
				String busNO = parts[0].trim(); 
				//check if they are ONLY int
				boolean isINTbusNO = StringUtils.isStrictlyNumeric(busNO);
				boolean isINTseat = StringUtils.isStrictlyNumeric(seat);
				if (isINTseat && isINTbusNO){
					//parse them to int
 					int busnumber = Integer.parseInt(busNO);
 					int busseat = Integer.parseInt(seat);
 					//check availability
 					available = Tickets.checkAvailability(frmEztravel,busseat,busnumber);
 					int MaxSeatsAvailable = Busses.maxValue(busseat,busnumber);
 					//if seat is available take the rest of the textfield and check them
 					if (busseat <= MaxSeatsAvailable )
 					{
 						if (available)
 	 					{	
 	 						String name = NameField.getText().trim().toLowerCase().toString();
 	 						String lastname = LastNameField.getText().trim().toLowerCase().toString();
 	 						String cert = CertificateField.getText().trim().toLowerCase().toString();
 	 						//check if all fields are filled
 	 						int countErrors=0;
 	 						if (NameField.getText().equals("")){
 	 							JOptionPane.showMessageDialog(frmEztravel, "You didn't filled a name.","Wrong Name", JOptionPane.ERROR_MESSAGE, null);
 	 							countErrors++;
 	 						}
 	 						if (LastNameField.getText().equals("")){
 	 							JOptionPane.showMessageDialog(frmEztravel, "You didn't filled a LastName.","Wrong LastName", JOptionPane.ERROR_MESSAGE, null);
 	 							countErrors++;
 	 						}
 	 						if (CertificateField.getText().equals("")){
 	 							JOptionPane.showMessageDialog(frmEztravel, "You didn't filled an ID Number.","Wrong ID Number", JOptionPane.ERROR_MESSAGE, null);
 	 							countErrors++;
 	 						}
 	 						//if they aren't return
 	 						if (countErrors > 0){
 	 							return;
 	 						}
 	 						else
 	 						{
 	 							//get return date/departure date && receiptValue to store them in db
 	 							String retDate = returnDateField.getText().toString();
 	 							String departDate = departureDateField.getText().toString();
 	 							boolean receiptValue = receipt.isSelected();
 	 							
 	 							//start trascoding string to sql.date morph to be ready to be inserted to db
 	 					        Date parsed = null;
 	 					        java.sql.Date returnDate = null;
 	 					        if (returnDateField.getText().toString().equals("")){
 	 					        	JOptionPane.showMessageDialog(frmEztravel, "The ticket is stored without a return date","Return Date = NULL", JOptionPane.WARNING_MESSAGE, null);
 	 					        }
 	 					        else
 	 					        {
 	 								try {
 	 									parsed = df.parse(retDate);
 	 								} catch (ParseException e1) {
 	 									// TODO Auto-generated catch block
 	 									e1.printStackTrace();
 	 								}
 	 								returnDate = new java.sql.Date(parsed.getTime());
 	 					        }
 	 					       
 	 					        
 	 			
 	 							
 	 					        Date parsed1 = null;
 	 							try {
 	 								parsed1 = df.parse(departDate);
 	 							} catch (ParseException e1) {
 	 								// TODO Auto-generated catch block
 	 								e1.printStackTrace();
 	 							}
 	 							java.sql.Date  departureDate = new java.sql.Date(parsed1.getTime());
 	 							
 	 							
 	 					   
 	 							 //save to db
 	 					        
 	 					        	Tickets.saveTickets(name, lastname, cert, returnDate, departureDate, busnumber, busseat, receiptValue);
 	 					       
 	 							
 	 							
 	 							//reset all values to defaults so the cashier can select new ticket.
 	 							int lastNumber = last();
 	 							
 	 							ticketNO.setText(String.valueOf(lastNumber+1));
 	 							NameField.setText(null);
 	 							LastNameField.setText(null);
 	 							CertificateField.setText(null);
 	 							returnDateField.setText(null);
 	 							SeatChosenField.setText(null);
 	 							
 	 							PrinterJob pj = PrinterJob.getPrinterJob();
 	 							PageFormat pf = pj.pageDialog(pj.defaultPage());
 	 						}
 	 					}
 	 					else
 	 					{
 	 						return;
 	 					}
 					}
 					else
 					{
 						JOptionPane.showMessageDialog(frmEztravel, "Max Number of Seats: "+ MaxSeatsAvailable ,"Available Seats", JOptionPane.ERROR_MESSAGE);
 						return;
 					}
 					
				}
				else
				{
					JOptionPane.showMessageDialog(frmEztravel, "Please insert a number on seat!\n","Seat is not a number!", JOptionPane.ERROR_MESSAGE);
					return;
				}

				
			}
		});
		btnE.setBounds(21, 437, 177, 23);
		frmEztravel.getContentPane().add(btnE);
		
		
		receipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invoice.setSelected(false);
				receipt.setSelected(true);
			}
		});
		receipt.setBounds(584, 372, 84, 23);
		frmEztravel.getContentPane().add(receipt);
		receipt.setSelected(true);
		
		
		
		invoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				receipt.setSelected(false);
				invoice.setSelected(true);
				
			}
		});
		invoice.setBounds(485, 372, 97, 23);
		frmEztravel.getContentPane().add(invoice);
		
		JLabel label_3 = new JLabel("\u03A3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03B1 \u03A0\u03B5\u03BB\u03AC\u03C4\u03B7");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		label_3.setBounds(21, 292, 177, 14);
		frmEztravel.getContentPane().add(label_3);
		
		JLabel label_5 = new JLabel("\u0395\u03C0\u03AF\u03B8\u03B5\u03C4\u03BF:");
		label_5.setBounds(21, 348, 46, 14);
		frmEztravel.getContentPane().add(label_5);
		
		LastNameField = new JTextField();
		LastNameField.setColumns(10);
		LastNameField.setBounds(85, 345, 113, 20);
		frmEztravel.getContentPane().add(LastNameField);
		
		JLabel label_6 = new JLabel("\u0391.\u03A4.:");
		label_6.setBounds(21, 382, 46, 14);
		frmEztravel.getContentPane().add(label_6);
		
		CertificateField = new JTextField();
		CertificateField.setBounds(85, 379, 113, 20);
		frmEztravel.getContentPane().add(CertificateField);
		CertificateField.setColumns(10);
		
		ticketNO = new JTextField();
		ticketNO.setFont(new Font("Charlemagne Std", Font.BOLD | Font.ITALIC, 16));
		ticketNO.setHorizontalAlignment(SwingConstants.CENTER);
		ticketNO.setEditable(false);
		ticketNO.setBounds(531, 339, 116, 20);
		frmEztravel.getContentPane().add(ticketNO);
		ticketNO.setColumns(10);
		
		int lastNumber = last();
		ticketNO.setText(String.valueOf(lastNumber+1));
		
		JLabel label_7 = new JLabel("\u0391\u03C1.\u0395\u03B9\u03C3.");
		label_7.setBounds(477, 342, 46, 14);
		
		
		frmEztravel.getContentPane().add(label_7);
		
		
		
		
		
	}
	int last(){
		int lastNumber = Tickets.getnextTicketNo();
		return lastNumber;
	}
	public void closewindow(){
		frmEztravel.setVisible(false);
	}
}

