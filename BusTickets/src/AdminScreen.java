
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ListModel;

import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.AbstractListModel;
import java.awt.List;
import java.awt.Choice;
import java.awt.TextField;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.DropMode;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JSeparator;
public class AdminScreen {

	private JFrame frame;
	private JTextField UserUsername;
	private JTextField UserPassword;
	private JTextField AdminUsername;
	private JTextField AdminPassword;
	private JTable table;
	public DefaultTableModel model = new DefaultTableModel(new String[]{"ID","Username", "Password", "Access Level"}, 0);
	public DefaultTableModel BusModel = new DefaultTableModel(new String[]{"BusNumber","Seats", "Destination"}, 0);
	private JTextField busNumberField;
	private JTextField busSeatsField;
	private JTextField destinationBusField;
	private JTable busTable;

	/**
	 * Launch the application.
	 */
	public static void AdminScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminScreen window = new AdminScreen();
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
	public AdminScreen() {
		initialize();
	}

	public void refreshTable(){
		model.setRowCount(0);
		Users.PrintTableUsers(model);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 687, 541);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 654, 447);
		frame.getContentPane().add(tabbedPane);
		
		JPanel Users12 = new JPanel();
		tabbedPane.addTab("Users", null, Users12, null);
		Users12.setLayout(null);
		
		JButton AddUsr = new JButton("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7");
		AddUsr.setBounds(96, 367, 91, 20);
		Users12.add(AddUsr);
		
		JLabel AddaCashier = new JLabel("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u03A4\u03B1\u03BC\u03AF\u03B1");
		AddaCashier.setBounds(96, 258, 83, 14);
		Users12.add(AddaCashier);
		
		UserUsername = new JTextField();
		UserUsername.setBounds(163, 296, 86, 20);
		Users12.add(UserUsername);
		UserUsername.setBorder(new LineBorder(Color.CYAN, 2, true));
		UserUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(96, 294, 68, 21);
		Users12.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(96, 326, 68, 20);
		Users12.add(lblPassword);
		
		UserPassword = new JTextField();
		UserPassword.setBounds(163, 327, 86, 20);
		Users12.add(UserPassword);
		UserPassword.setBorder(new LineBorder(Color.CYAN, 2, true));
		UserPassword.setColumns(10);
		
		JButton AddAdmin = new JButton("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7");
		AddAdmin.setBounds(350, 367, 91, 20);
		Users12.add(AddAdmin);
		
		JLabel lblAddAnAdmin = new JLabel("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 Admin");
		lblAddAnAdmin.setBounds(350, 258, 83, 14);
		Users12.add(lblAddAnAdmin);
		
		AdminUsername = new JTextField();
		AdminUsername.setBounds(418, 296, 86, 20);
		Users12.add(AdminUsername);
		AdminUsername.setColumns(10);
		AdminUsername.setBorder(new LineBorder(Color.CYAN, 2, true));
		
		JLabel label_1 = new JLabel("Username");
		label_1.setBounds(350, 295, 68, 21);
		Users12.add(label_1);
		
		JLabel label_2 = new JLabel("Password");
		label_2.setBounds(350, 327, 68, 20);
		Users12.add(label_2);
		
		AdminPassword = new JTextField();
		AdminPassword.setBounds(418, 327, 86, 20);
		Users12.add(AdminPassword);
		AdminPassword.setColumns(10);
		AdminPassword.setBorder(new LineBorder(Color.CYAN, 2, true));
		
		JLabel lblExistingUsers = new JLabel("Existing Users");
		lblExistingUsers.setBounds(284, 27, 83, 14);
		Users12.add(lblExistingUsers);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 51, 629, 162);
		Users12.add(scrollPane);
		scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		
		//create table with model in mind :D 
		table = new JTable(model);
		table.setShowVerticalLines(false);
		table.setToolTipText("Select a row and press delete to delete it!! ");
		table.setCellSelectionEnabled(false);
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JButton btnDelete = new JButton("\u0394\u03B9\u03B1\u03B3\u03C1\u03B1\u03C6\u03AE");
		btnDelete.setBounds(10, 224, 89, 23);
		Users12.add(btnDelete);
		btnDelete.setToolTipText("*Select a row and press delete to delete the selected user");
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(96, 283, 158, 2);
		Users12.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(346, 283, 158, 2);
		Users12.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(295, 224, 2, 184);
		Users12.add(separator_3);
		
		JPanel Busses = new JPanel();
		Busses.setLayout(null);
		tabbedPane.addTab("Busses", null, Busses, null);
		
		JScrollPane busScrollPane = new JScrollPane();
		busScrollPane.setBounds(10, 48, 629, 86);
		Busses.add(busScrollPane);
		
		busTable = new JTable(BusModel);
		busScrollPane.setViewportView(busTable);
		busTable.setToolTipText("Select a row and press delete to delete it!! ");
		busTable.setShowVerticalLines(false);
		busTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		busTable.setRowSelectionAllowed(true);
		busTable.setFillsViewportHeight(true);
		busTable.setCellSelectionEnabled(false);
		
		JLabel label_9 = new JLabel("\u039B\u03B5\u03C9\u03C6\u03BF\u03C1\u03B5\u03AF\u03B1");
		label_9.setBounds(10, 23, 68, 14);
		Busses.add(label_9);
		
		
		
		JButton BusDelete = new JButton("\u0394\u03B9\u03B1\u03B3\u03C1\u03B1\u03C6\u03AE");
		BusDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		BusDelete.setToolTipText("*Select a row and press delete to delete the selected user");
		BusDelete.setBounds(10, 146, 89, 23);
		Busses.add(BusDelete);
		
		JLabel label_3 = new JLabel("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7 \u039B\u03B5\u03C9\u03C6\u03BF\u03C1\u03B5\u03AF\u03BF\u03C5");
		label_3.setBounds(10, 207, 138, 14);
		Busses.add(label_3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 232, 629, 2);
		Busses.add(separator);
		
		busNumberField = new JTextField();
		busNumberField.setBounds(132, 265, 86, 22);
		Busses.add(busNumberField);
		busNumberField.setColumns(10);
		
		JLabel label_4 = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u03BB\u03B5\u03C9\u03C6\u03BF\u03C1\u03B5\u03AF\u03BF\u03C5");
		label_4.setBounds(10, 269, 112, 14);
		Busses.add(label_4);
		
		busSeatsField = new JTextField();
		busSeatsField.setColumns(10);
		busSeatsField.setBounds(132, 298, 86, 22);
		Busses.add(busSeatsField);
		
		JLabel label_5 = new JLabel("\u0398\u03AD\u03C3\u03B5\u03B9\u03C2");
		label_5.setBounds(10, 302, 112, 14);
		Busses.add(label_5);
		
		destinationBusField = new JTextField();
		destinationBusField.setColumns(10);
		destinationBusField.setBounds(132, 335, 173, 22);
		Busses.add(destinationBusField);
		
		JLabel label_6 = new JLabel("\u0394\u03B9\u03B1\u03B4\u03C1\u03BF\u03BC\u03AE");
		label_6.setBounds(10, 339, 112, 14);
		Busses.add(label_6);
		
		JButton AddBus = new JButton("\u03A0\u03C1\u03BF\u03C3\u03B8\u03AE\u03BA\u03B7");
		AddBus.setBounds(10, 385, 126, 23);
		Busses.add(AddBus);
		
		
		
		JLabel lblWelcomeAdmin = new JLabel("Welcome Admin");
		lblWelcomeAdmin.setBounds(10, 0, 637, 22);
		frame.getContentPane().add(lblWelcomeAdmin);
		lblWelcomeAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setBounds(570, 469, 91, 23);
		frame.getContentPane().add(btnLogOut);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				LoginScreen login = new LoginScreen();
				login.setVisible(true);
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				//get selected row
				int row = table.getSelectedRow();
				//if administrator selected a row then proceed
				if (table.isRowSelected(row)){
					//get the first value(id) so we can delete the selected user.
					Object selectedID = GetDataFromTable(row,0);
					Object selectedName = GetDataFromTable(row,1);
					//show messages(error/success)
					if (Users.DeleteUser(selectedID)){
						int modelRow = table.convertRowIndexToModel( row );
						model.removeRow( modelRow );
						JOptionPane.showMessageDialog(frame, "~USER~\nId: " + selectedID + "\nUsername:"+selectedName+"\nHas been removed successfully!!", "Success!!", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(frame, "Couldn't delete the user with username: "+selectedName+".\nSomething went wrong.\nContact info@bustickets.gr","Error..", JOptionPane.ERROR_MESSAGE);
					}
					
				}
					
			}
		});
		AddAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String thisUsername = AdminUsername.getText().toString().trim().toLowerCase();
				String thisPassword = AdminPassword.getText().toString().trim().toLowerCase();
				Users.UpdateDB(thisUsername, thisPassword, 1);
				if (Users.success()){
					AdminUsername.setText("");
					AdminPassword.setText("");
					JOptionPane.showMessageDialog(frame, "Admin: .: "+thisUsername+" :. was added successfully !!");
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Something Went Wrong\nPlease try again!");
				}
				
				refreshTable();
			}
		});
		AddUsr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String thisUsername = UserUsername.getText().toString().trim().toLowerCase();
				String thisPassword = UserPassword.getText().toString().trim().toLowerCase();
				Users.UpdateDB(thisUsername, thisPassword,0);
				if (Users.success()){
					UserUsername.setText("");
					UserPassword.setText("");
					JOptionPane.showMessageDialog(frame, "Cashier: .: "+thisUsername+" :. was added successfully !!");
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Something Went Wrong\nPlease try again!");
				}
				
				refreshTable();
			}
		});
		
		
		
		
		model = Users.PrintTableUsers(model);
		
		//JScrollPane scrollPane = new JScrollPane(table);
		
	}
	public Object GetDataFromTable(int row_index, int col_index){
		
		return table.getModel().getValueAt(row_index, col_index);
		
	}
}


