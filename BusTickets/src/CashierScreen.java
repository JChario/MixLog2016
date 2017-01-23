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


public class CashierScreen {
	public static final JCalendar calendar = new JCalendar();
	public static final JCalendar calendar1 = new JCalendar();
	public static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH);
	public static final JCheckBox invoice = new JCheckBox("\u03A4\u03B9\u03BC\u03BF\u03BB\u03CC\u03B3\u03B9\u03BF");
	private JFrame frame;
	private JTextField returnDateField;
	private JTextField departureDateField;
	private JTextField NameField;
	private JTextField LastNameField;
	private JTextField CertificateField;
	private JTextField ticketNO;

	/**
	 * Launch the application.
	 */
	public static void CashierScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CashierScreen window = new CashierScreen();
					window.frame.setVisible(true);
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
		frame.getContentPane().add(lblH);
		
		JLabel lblH_1 = new JLabel("H\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03AF\u03B1 \u0395\u03C0\u03B9\u03C3\u03C4\u03C1\u03BF\u03C6\u03AE\u03C2");
		lblH_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblH_1.setBounds(383, 238, 177, 14);
		frame.getContentPane().add(lblH_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setBounds(0, 0, 97, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu menu = new JMenu("\u0391\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7");
		menu.setBackground(Color.LIGHT_GRAY);
		menuBar.add(menu);
		
		JMenuItem nameSearch = new JMenuItem("\u038C\u03BD\u03BF\u03BC\u03B1");
		nameSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = "Selected : "+nameSearch.getText();
				JOptionPane.showConfirmDialog(frame, message);
				JOptionPane.showInputDialog(message);
			}
		});
		nameSearch.setIcon(null);
		nameSearch.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		menu.add(nameSearch);
		
		JMenuItem lastNameSearch = new JMenuItem("\u0395\u03C0\u03AF\u03B8\u03B5\u03C4\u03BF");
		lastNameSearch.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		menu.add(lastNameSearch);
		
		JMenuItem certificateSearch = new JMenuItem("\u0391.\u03A4.");
		certificateSearch.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		menu.add(certificateSearch);
		
		JMenuItem ticketNumberSearch = new JMenuItem("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u0395\u03B9\u03C3\u03B7\u03C4\u03B7\u03C1\u03AF\u03BF\u03C5");
		ticketNumberSearch.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		menu.add(ticketNumberSearch);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	void loadDates(){
		
		//get date of return
		//Date retdate = calendar1.getDate();
		//String returnDate = df.format(retdate);
		//returnDateField.setText(returnDate);
		
		Date departdate = calendar.getDate();
		String departureDate = df.format(departdate);
		departureDateField.setText(departureDate);
		
	}
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(176, 196, 222));
		frame.setBounds(100, 100, 596, 493);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeCashier = new JLabel("Welcome Cashier");
		lblWelcomeCashier.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeCashier.setBounds(10, 11, 577, 27);
		frame.getContentPane().add(lblWelcomeCashier);
		
		
		
		
		
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
		frame.getContentPane().add(calendar);
		
		JLabel label = new JLabel("");
		label.setBounds(20, 49, 46, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u0391\u03BD\u03B1\u03C7\u03CE\u03C1\u03B7\u03C3\u03B7");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(21, 49, 177, 27);
		frame.getContentPane().add(label_1);
		
		returnDateField = new JTextField();
		returnDateField.setHorizontalAlignment(SwingConstants.CENTER);
		returnDateField.setEditable(false);
		returnDateField.setEnabled(false);
		returnDateField.setBounds(383, 261, 177, 20);
		frame.getContentPane().add(returnDateField);
		returnDateField.setColumns(10);
		
		departureDateField = new JTextField();
		departureDateField.setHorizontalAlignment(SwingConstants.CENTER);
		departureDateField.setEditable(false);
		departureDateField.setBounds(20, 261, 178, 20);
		frame.getContentPane().add(departureDateField);
		departureDateField.setColumns(10);
		
		
		
		JLabel label_2 = new JLabel("\u0395\u03C0\u03B9\u03C3\u03C4\u03C1\u03BF\u03C6\u03AE");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(386, 49, 177, 27);
		frame.getContentPane().add(label_2);
		calendar1.getMonthChooser().getComboBox().setEnabled(false);
		calendar1.getYearChooser().getSpinner().setEnabled(false);
		calendar1.getDayChooser().setWeekOfYearVisible(false);
		calendar1.getDayChooser().setDayBordersVisible(true);
		calendar1.setBackground(Color.BLACK);
		
		
		calendar1.setBounds(386, 74, 177, 153);
		frame.getContentPane().add(calendar1);
		
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
		chckbxNewCheckBox.setBounds(383, 288, 105, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				LoginScreen login = new LoginScreen();
				login.setVisible(true);
			}
		});
		btnLogOut.setBounds(471, 422, 89, 23);
		frame.getContentPane().add(btnLogOut);
		
		JButton btnE = new JButton("E\u03BA\u03C4\u03CD\u03C0\u03C9\u03C3\u03B7");
		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrinterJob pj = PrinterJob.getPrinterJob();
				PageFormat pf = pj.pageDialog(pj.defaultPage());
			}
		});
		btnE.setBounds(138, 422, 116, 23);
		frame.getContentPane().add(btnE);
		
		JCheckBox receipt = new JCheckBox("\u0391\u03C0\u03CC\u03B4\u03B5\u03B9\u03BE\u03B7");
		receipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				invoice.setSelected(false);
				receipt.setSelected(true);
			}
		});
		receipt.setBounds(490, 372, 84, 23);
		frame.getContentPane().add(receipt);
		receipt.setSelected(true);
		
		
		
		invoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				receipt.setSelected(false);
				invoice.setSelected(true);
				
			}
		});
		invoice.setBounds(391, 372, 97, 23);
		frame.getContentPane().add(invoice);
		
		NameField = new JTextField();
		NameField.setBounds(85, 314, 113, 20);
		frame.getContentPane().add(NameField);
		NameField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u03A3\u03C4\u03BF\u03B9\u03C7\u03B5\u03AF\u03B1 \u03A0\u03B5\u03BB\u03AC\u03C4\u03B7");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Yu Gothic UI Light", Font.BOLD, 13));
		label_3.setBounds(21, 292, 177, 14);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u038C\u03BD\u03BF\u03BC\u03B1:");
		label_4.setBounds(21, 317, 56, 14);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u0395\u03C0\u03AF\u03B8\u03B5\u03C4\u03BF:");
		label_5.setBounds(21, 342, 46, 14);
		frame.getContentPane().add(label_5);
		
		LastNameField = new JTextField();
		LastNameField.setColumns(10);
		LastNameField.setBounds(85, 339, 113, 20);
		frame.getContentPane().add(LastNameField);
		
		JLabel label_6 = new JLabel("\u0391.\u03A4.:");
		label_6.setBounds(21, 376, 46, 14);
		frame.getContentPane().add(label_6);
		
		CertificateField = new JTextField();
		CertificateField.setBounds(85, 373, 113, 20);
		frame.getContentPane().add(CertificateField);
		CertificateField.setColumns(10);
		
		ticketNO = new JTextField();
		ticketNO.setFont(new Font("Charlemagne Std", Font.BOLD | Font.ITALIC, 16));
		ticketNO.setHorizontalAlignment(SwingConstants.CENTER);
		ticketNO.setEditable(false);
		ticketNO.setBounds(437, 339, 116, 20);
		frame.getContentPane().add(ticketNO);
		ticketNO.setColumns(10);
		
		int lastNumber = last();
		ticketNO.setText(String.valueOf(lastNumber+1));
		
		JLabel label_7 = new JLabel("\u0391\u03C1.\u0395\u03B9\u03C3.");
		label_7.setBounds(383, 342, 46, 14);
		
		
		frame.getContentPane().add(label_7);
		JButton save = new JButton("\u0391\u03C0\u03BF\u03B8\u03AE\u03BA\u03B5\u03C5\u03C3\u03B7");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String name = NameField.getText().trim().toLowerCase().toString();
				String lastname = LastNameField.getText().trim().toLowerCase().toString();
				String cert = CertificateField.getText().trim().toLowerCase().toString();
				
				//get return date/departure date/ticketnumber && receiptValue to store them in db
				int ticketnumber = Integer.parseInt(ticketNO.getText());
				String retDate = returnDateField.getText().toString();
				String departDate = departureDateField.getText().toString();
				boolean receiptValue = receipt.isSelected();
				
				//start trascoding string to sql.date morph to be ready to be inserted to db
		        Date parsed = null;
				try {
					parsed = df.parse(retDate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        java.sql.Date returnDate = new java.sql.Date(parsed.getTime());
		        

				
		        Date parsed1 = null;
				try {
					parsed1 = df.parse(departDate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		        java.sql.Date departureDate = new java.sql.Date(parsed1.getTime());
		   
		        
		        
		        //save to db
				MySql.saveTickets(name,lastname,cert,ticketnumber,returnDate,departureDate, receiptValue);
				
				//reset all values to defaults so the cashier can select new ticket.
				int lastNumber = last();
				ticketNO.setText(String.valueOf(lastNumber+1));
				NameField.setText(null);
				LastNameField.setText(null);
				CertificateField.setText(null);
				returnDateField.setText(null);
				departureDateField.setText(null);
				
				
			};
		});
		save.setBounds(21, 422, 117, 23);
		frame.getContentPane().add(save);
	}
	int last(){
		int lastNumber = MySql.getnextTicketNo();
		return lastNumber;
	}
}

