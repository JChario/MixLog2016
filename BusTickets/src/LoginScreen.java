import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Canvas;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class LoginScreen extends JFrame {

	private JFrame loginframe;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField usernameField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen frame = new LoginScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Insert Password ");
		passwordField.setBounds(264, 146, 124, 20);
		contentPane.add(passwordField);
		
		JButton loginbutton = new JButton("Login");
		
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String thisUser = usernameField.getText().toString().trim().toLowerCase();
				String thisPassword = new String(passwordField.getPassword());
				thisPassword.trim().toLowerCase();
				//String thisPassword = passwordField.getPassword().toString().trim().toLowerCase();//NOT SAFE
					//loginframe.dispose();
					MySql.VerifyLogin(thisUser, thisPassword);
					if (MySql.LoggedIN()){
						closewindow();
					}
					
				
				
				
			}
		});
		
		loginbutton.setBounds(209, 187, 89, 23);
		contentPane.add(loginbutton);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(159, 118, 74, 20);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(159, 149, 74, 20);
		contentPane.add(lblPassword);
		
		usernameField = new JTextField();
		usernameField.setBounds(264, 115, 124, 20);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{passwordField, loginbutton}));
		

	}
	public void closewindow(){
		this.setVisible(false);
	}
}
