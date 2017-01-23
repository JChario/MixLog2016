
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
public class AdminScreen {

	private JFrame frame;
	private JTextField UserUsername;
	private JTextField UserPassword;
	private JTextField AdminUsername;
	private JTextField AdminPassword;
	private JTable table;
	public DefaultTableModel model = new DefaultTableModel(new String[]{"ID","Username", "Password", "Access Level"}, 0);

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
		table.repaint();
		model.fireTableDataChanged();
		MySql.PrintTableDB(model);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 673, 391);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeAdmin = new JLabel("Welcome Admin");
		lblWelcomeAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeAdmin.setBounds(10, 11, 637, 22);
		frame.getContentPane().add(lblWelcomeAdmin);
		
		JButton AddUsr = new JButton("Add");
		AddUsr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String thisUsername = UserUsername.getText().toString().trim().toLowerCase();
				String thisPassword = UserPassword.getText().toString().trim().toLowerCase();
				MySql.UpdateDB(thisUsername, thisPassword,0);
				if (MySql.success()){
					UserUsername.setText("");
					UserPassword.setText("");
					JOptionPane.showMessageDialog(null, "Cashier: {"+thisUsername+"} was added successfully !!");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Something Went Wrong\nPlease try again!");
				}
				
				refreshTable();
			}
		});
		AddUsr.setBounds(187, 86, 89, 52);
		frame.getContentPane().add(AddUsr);
		
		JLabel AddaCashier = new JLabel("Add a Cashier");
		AddaCashier.setBounds(23, 62, 83, 14);
		frame.getContentPane().add(AddaCashier);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(0, 29, 657, 22);
		frame.getContentPane().add(horizontalStrut);
		
		UserUsername = new JTextField();
		UserUsername.setBounds(91, 87, 86, 20);
		frame.getContentPane().add(UserUsername);
		UserUsername.setBorder(new LineBorder(Color.CYAN, 2, true));
		UserUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(23, 86, 68, 21);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(23, 118, 68, 20);
		frame.getContentPane().add(lblPassword);
		
		UserPassword = new JTextField();
		UserPassword.setBounds(91, 118, 86, 20);
		frame.getContentPane().add(UserPassword);
		UserPassword.setBorder(new LineBorder(Color.CYAN, 2, true));
		UserPassword.setColumns(10);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalGlue.setBounds(0, 149, 276, 12);
		frame.getContentPane().add(horizontalGlue);
		
		JButton AddAdmin = new JButton("Add");
		AddAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String thisUsername = AdminUsername.getText().toString().trim().toLowerCase();
				String thisPassword = AdminPassword.getText().toString().trim().toLowerCase();
				MySql.UpdateDB(thisUsername, thisPassword, 1);
				if (MySql.success()){
					AdminUsername.setText("");
					AdminPassword.setText("");
					JOptionPane.showMessageDialog(null, "Admin: {"+thisUsername+"} was added successfully !!");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Something Went Wrong\nPlease try again!");
				}
				
				refreshTable();
			}
		});
		AddAdmin.setBounds(187, 196, 89, 52);
		frame.getContentPane().add(AddAdmin);
		
		JLabel lblAddAnAdmin = new JLabel("Add an Admin");
		lblAddAnAdmin.setBounds(23, 172, 83, 14);
		frame.getContentPane().add(lblAddAnAdmin);
		
		AdminUsername = new JTextField();
		AdminUsername.setColumns(10);
		AdminUsername.setBounds(91, 197, 86, 20);
		AdminUsername.setBorder(new LineBorder(Color.CYAN, 2, true));
		frame.getContentPane().add(AdminUsername);
		
		JLabel label_1 = new JLabel("Username");
		label_1.setBounds(23, 196, 68, 21);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Password");
		label_2.setBounds(23, 228, 68, 20);
		frame.getContentPane().add(label_2);
		
		AdminPassword = new JTextField();
		AdminPassword.setColumns(10);
		AdminPassword.setBounds(91, 228, 86, 20);
		AdminPassword.setBorder(new LineBorder(Color.CYAN, 2, true));
		frame.getContentPane().add(AdminPassword);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				LoginScreen login = new LoginScreen();
				login.setVisible(true);
			}
		});
		btnLogOut.setBounds(558, 318, 89, 23);
		frame.getContentPane().add(btnLogOut);
		
		JLabel lblExistingUsers = new JLabel("Existing Users");
		lblExistingUsers.setBounds(294, 62, 83, 14);
		frame.getContentPane().add(lblExistingUsers);
		
		
		
		
		model = MySql.PrintTableDB(model);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(294, 86, 353, 162);
		frame.getContentPane().add(scrollPane);
		
		//create table with model in mind :D 
		table = new JTable(model);
		scrollPane.setViewportView(table);
		
		table.setColumnSelectionAllowed(true);
		table.setRowSelectionAllowed(true);
		table.setCellSelectionEnabled(false);
		
		JLabel lblaccessLevel = new JLabel("*Access Level = 0  > Cashier");
		lblaccessLevel.setBounds(23, 291, 253, 14);
		frame.getContentPane().add(lblaccessLevel);
		
		JLabel lblaccessLevel_1 = new JLabel("*Access Level = 1  > Admin\r\n");
		lblaccessLevel_1.setBounds(23, 316, 253, 14);
		frame.getContentPane().add(lblaccessLevel_1);
		//JScrollPane scrollPane = new JScrollPane(table);
		
	}
}


