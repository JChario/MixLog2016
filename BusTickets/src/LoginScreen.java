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
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.DropMode;



public class LoginScreen extends JFrame {

	private JFrame loginframe;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField usernameField;
	private JTextArea textArea_2;

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
		setBounds(100, 100, 690, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Insert Password ");
		passwordField.setBounds(327, 306, 124, 20);
		contentPane.add(passwordField);
		
		JButton loginbutton = new JButton("Login");
		
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//get values from textfields and send them to MySql.VerifyLogin(user,password);
				//for small security check we must trim & trostring & tolowercase ;
				//MUST APPLY BETTER SECURITY :D
				String thisUser = usernameField.getText().toString().trim().toLowerCase();
				String thisPassword = new String(passwordField.getPassword());
				thisPassword.trim().toLowerCase();
				
					Users.VerifyLogin(thisUser, thisPassword);
					if (Users.LoggedIN()){
						closewindow();
					}
					
				
				
				
			}
		});
		
		loginbutton.setBounds(222, 358, 229, 23);
		contentPane.add(loginbutton);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(222, 278, 74, 20);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(222, 309, 74, 20);
		contentPane.add(lblPassword);
		
		usernameField = new JTextField();
		usernameField.setBounds(327, 275, 124, 20);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("\u03A7\u03B1\u03C1\u03B9\u03C4\u03BF\u03C2 \u0399\u03C9\u03AC\u03BD\u03BD\u03B7\u03C2:42625///\r\n\u0391\u03BD\u03B4\u03C1\u03AD\u03B1\u03C2 \u039C\u03AD\u03C1\u03B1\u03C2:41803///\r\n\u039D\u03C4\u03BF\u03C5\u03BD\u03C4\u03BF\u03CD\u03BC\u03B7\u03C2 \u039A\u03CE\u03BD/\u03BD\u03BF\u03C2:41795");
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.BLACK, Color.GRAY, Color.BLACK));
		panel.setBounds(42, 23, 596, 225);
		contentPane.add(panel);
		
		textArea_2 = new JTextArea();
		textArea_2.setWrapStyleWord(true);
		textArea_2.setToolTipText("");
		textArea_2.setText("\u03A4\u0395\u0399 \u03A0\u0395\u0399\u03A1\u0391\u0399\u0391");
		textArea_2.setLineWrap(true);
		textArea_2.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 55));
		textArea_2.setEditable(false);
		textArea_2.setColumns(12);
		textArea_2.setBackground(new Color(0, 0, 0, 0));
		panel.add(textArea_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setColumns(12);
		textArea.setBackground(new Color(0,0,0,0));
		textArea.setEditable(false);
		textArea.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 55));
		textArea.setToolTipText("\u03A7\u03B1\u03C1\u03B9\u03C4\u03BF\u03C2 \u0399\u03C9\u03AC\u03BD\u03BD\u03B7\u03C2:42625///\r\n\u0391\u03BD\u03B4\u03C1\u03AD\u03B1\u03C2 \u039C\u03AD\u03C1\u03B1\u03C2:41803///\r\n\u039D\u03C4\u03BF\u03C5\u03BD\u03C4\u03BF\u03CD\u03BC\u03B7\u03C2 \u039A\u03CE\u03BD/\u03BD\u03BF\u03C2:41795");
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setText("\u039C\u03B7\u03C7\u03B1\u03BD\u03B9\u03BA\u03AE \u039B\u03BF\u03B3\u03B9\u03C3\u03BC\u03B9\u03BA\u03BF\u03CD");
		panel.add(textArea);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{passwordField, loginbutton}));
		

	}
	public void closewindow(){
		this.setVisible(false);
	}
}
