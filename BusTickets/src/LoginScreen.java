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
import javax.swing.JRootPane;

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
import java.awt.Frame;

import javax.swing.DropMode;
import java.awt.FlowLayout;



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
		passwordField.setBounds(320, 348, 124, 20);
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
		
		loginbutton.setBounds(215, 400, 229, 23);
		contentPane.add(loginbutton);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(215, 320, 74, 20);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(215, 351, 74, 20);
		contentPane.add(lblPassword);
		
		usernameField = new JTextField();
		usernameField.setBounds(320, 317, 124, 20);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("\u03A7\u03B1\u03C1\u03B9\u03C4\u03BF\u03C2 \u0399\u03C9\u03AC\u03BD\u03BD\u03B7\u03C2:42625///\r\n\u0391\u03BD\u03B4\u03C1\u03AD\u03B1\u03C2 \u039C\u03AD\u03C1\u03B1\u03C2:41803///\r\n\u039D\u03C4\u03BF\u03C5\u03BD\u03C4\u03BF\u03CD\u03BC\u03B7\u03C2 \u039A\u03CE\u03BD/\u03BD\u03BF\u03C2:41795");
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.BLACK, Color.GRAY, Color.BLACK));
		panel.setBounds(42, 23, 597, 269);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textArea_2 = new JTextArea();
		textArea_2.setBounds(2, 7, 339, 72);
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
		textArea.setBounds(2, 90, 584, 72);
		textArea.setColumns(12);
		textArea.setBackground(new Color(0,0,0,0));
		textArea.setEditable(false);
		textArea.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 55));
		textArea.setToolTipText("\u03A7\u03B1\u03C1\u03B9\u03C4\u03BF\u03C2 \u0399\u03C9\u03AC\u03BD\u03BD\u03B7\u03C2:42625///\r\n\u0391\u03BD\u03B4\u03C1\u03AD\u03B1\u03C2 \u039C\u03AD\u03C1\u03B1\u03C2:41803///\r\n\u039D\u03C4\u03BF\u03C5\u03BD\u03C4\u03BF\u03CD\u03BC\u03B7\u03C2 \u039A\u03CE\u03BD/\u03BD\u03BF\u03C2:41795");
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setText("\u039C\u03B7\u03C7\u03B1\u03BD\u03B9\u03BA\u03AE \u039B\u03BF\u03B3\u03B9\u03C3\u03BC\u03B9\u03BA\u03BF\u03CD");
		panel.add(textArea);
		
		JLabel label = new JLabel("\u0399\u03C9\u03B1\u03BD\u03BD\u03B7\u03C2 \u03A7\u03B1\u03C1\u03B9\u03C4\u03BF\u03C2");
		label.setBounds(12, 178, 175, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u039D\u03C4\u03BF\u03C5\u03BD\u03C4\u03BF\u03CD\u03BC\u03B7\u03C2 \u039A\u03C9\u03BD/\u03BD\u03BF\u03C2");
		label_1.setBounds(12, 203, 175, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u0391\u03BD\u03B4\u03C1\u03AD\u03B1\u03C2 \u039C\u03AD\u03C1\u03B1\u03C2");
		label_2.setBounds(12, 228, 175, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("42625");
		label_3.setBounds(144, 178, 43, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("41803");
		label_4.setBounds(144, 203, 43, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("41795");
		label_5.setBounds(144, 228, 43, 14);
		panel.add(label_5);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{passwordField, loginbutton}));
		

	}
	public void closewindow(){
		this.setVisible(false);
	}
}
