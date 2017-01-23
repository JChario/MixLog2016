
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
public class CashierSearchAndDelete {

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
					CashierSearchAndDelete window = new CashierSearchAndDelete();
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
	public CashierSearchAndDelete() {
		initialize();
	}

	public void refreshTable(){
		model.setRowCount(0);
		MySql.PrintTableDB(model);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 690, 510);
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
					JOptionPane.showMessageDialog(frame, "Cashier: .: "+thisUsername+" :. was added successfully !!");
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Something Went Wrong\nPlease try again!");
				}
				
				refreshTable();
			}
		});
		AddUsr.setBounds(174, 325, 89, 52);
		frame.getContentPane().add(AddUsr);
		
		JLabel AddaCashier = new JLabel("Add a Cashier");
		AddaCashier.setBounds(10, 301, 83, 14);
		frame.getContentPane().add(AddaCashier);
		
		UserUsername = new JTextField();
		UserUsername.setBounds(78, 326, 86, 20);
		frame.getContentPane().add(UserUsername);
		UserUsername.setBorder(new LineBorder(Color.CYAN, 2, true));
		UserUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 325, 68, 21);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 357, 68, 20);
		frame.getContentPane().add(lblPassword);
		
		UserPassword = new JTextField();
		UserPassword.setBounds(78, 357, 86, 20);
		frame.getContentPane().add(UserPassword);
		UserPassword.setBorder(new LineBorder(Color.CYAN, 2, true));
		UserPassword.setColumns(10);
		
		JButton AddAdmin = new JButton("Add");
		AddAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String thisUsername = AdminUsername.getText().toString().trim().toLowerCase();
				String thisPassword = AdminPassword.getText().toString().trim().toLowerCase();
				MySql.UpdateDB(thisUsername, thisPassword, 1);
				if (MySql.success()){
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
		AddAdmin.setBounds(575, 325, 89, 52);
		frame.getContentPane().add(AddAdmin);
		
		JLabel lblAddAnAdmin = new JLabel("Add an Admin");
		lblAddAnAdmin.setBounds(411, 301, 83, 14);
		frame.getContentPane().add(lblAddAnAdmin);
		
		AdminUsername = new JTextField();
		AdminUsername.setColumns(10);
		AdminUsername.setBounds(479, 326, 86, 20);
		AdminUsername.setBorder(new LineBorder(Color.CYAN, 2, true));
		frame.getContentPane().add(AdminUsername);
		
		JLabel label_1 = new JLabel("Username");
		label_1.setBounds(411, 325, 68, 21);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Password");
		label_2.setBounds(411, 357, 68, 20);
		frame.getContentPane().add(label_2);
		
		AdminPassword = new JTextField();
		AdminPassword.setColumns(10);
		AdminPassword.setBounds(479, 357, 86, 20);
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
		btnLogOut.setBounds(575, 435, 89, 23);
		frame.getContentPane().add(btnLogOut);
		
		JLabel lblExistingUsers = new JLabel("Existing Users");
		lblExistingUsers.setBounds(294, 62, 83, 14);
		frame.getContentPane().add(lblExistingUsers);
		
		
		
		
		model = MySql.PrintTableDB(model);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		scrollPane.setBounds(10, 86, 654, 162);
		frame.getContentPane().add(scrollPane);
		
		//create table with model in mind :D 
		table = new JTable(model);
		table.setShowVerticalLines(false);
		table.setToolTipText("Select a row and press delete to delete it!! ");
		table.setCellSelectionEnabled(false);
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		JLabel lblaccessLevel = new JLabel("*Access Level = 0  > Cashier");
		lblaccessLevel.setBounds(23, 414, 253, 14);
		frame.getContentPane().add(lblaccessLevel);
		
		JLabel lblaccessLevel_1 = new JLabel("*Access Level = 1  > Admin\r\n");
		lblaccessLevel_1.setBounds(23, 439, 253, 14);
		frame.getContentPane().add(lblaccessLevel_1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setToolTipText("*Select a row and press delete to delete the selected user");
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
					if (MySql.DeleteUser(selectedID)){
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
		btnDelete.setBounds(10, 253, 89, 23);
		frame.getContentPane().add(btnDelete);
		//JScrollPane scrollPane = new JScrollPane(table);
		
	}
	public Object GetDataFromTable(int row_index, int col_index){
		
		return table.getModel().getValueAt(row_index, col_index);
		
	}
}


