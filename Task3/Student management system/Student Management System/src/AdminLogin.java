import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AdminLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	protected Object con;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setResizable(false);
		setTitle("Login Pannel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usernameLabel = new JLabel("User Name :");
		usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		usernameLabel.setBounds(83, 104, 112, 34);
		contentPane.add(usernameLabel);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usernameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent eun) {
				char ch = eun.getKeyChar();
				if(!Character.isAlphabetic(ch) && ch!= ' ') {
//				loginAccno.setEditable(false);	
					eun.consume();
				}
			}
		});
		usernameField.setBounds(205, 106, 241, 34);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(83, 174, 112, 34);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBounds(205, 174, 241, 34);
		contentPane.add(passwordField);
		
		JButton LoginButton = new JButton("Login");
		LoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(usernameField.getText ().isEmpty () || passwordField.getPassword().length==0)
				{
					JOptionPane.showMessageDialog(LoginButton, "Enter Username and Password");
				}
				else {
					String Query = "select * from admin_login where username = '"+ usernameField.getText() +"' and password = '" + passwordField.getText() + "' ";
					try 
					{
						Connection con = null;
						PreparedStatement pst = null;
						ResultSet rs = null;
						Statement st = null;
						
						con = DriverManager.getConnection("jdbc:mysql://localhost:3307/student_management","root","");
						st= con.createStatement();
						rs = st.executeQuery(Query);
						if(rs.next())
						{	
							JOptionPane.showMessageDialog(LoginButton, "Successfully Login" );
							new HomePanel().setVisible(true);
							con.close();
							AdminLogin.this.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(LoginButton, "wrong Username and Password" );	
						}
						
					} 
					catch (Exception ea1) 					
					{
//						ea.printStackTrace();
						JOptionPane.showMessageDialog(LoginButton, ea1);	
					}
					
				}				
			}
		});
		LoginButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LoginButton.setBounds(259, 244, 105, 34);
		contentPane.add(LoginButton);
		
		JLabel lblNewLabel = new JLabel("STUDENT MANAGEMENT SYSTEM");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(99, 38, 442, 34);
		contentPane.add(lblNewLabel);
	}
}
