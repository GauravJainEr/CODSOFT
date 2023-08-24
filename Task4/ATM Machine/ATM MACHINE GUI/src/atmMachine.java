import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class atmMachine extends JFrame {

	private JPanel contentPane;
	static JTextField loginAccno;
	static JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					atmMachine frame = new atmMachine();
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
	
	
	
	public atmMachine() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		setTitle("ATM Login Pannel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(215, 247, 247));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(151, 163, 127, 42);
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(loginAccno.getText ().isEmpty () || passwordField.getPassword().length==0)
				{
					JOptionPane.showMessageDialog(btnNewButton, "Enter Accountno and Pin Number");
				}
//				else if(loginAccno.getText ().equals("999991234") || passwordField.getPassword().equals("8877990")){
				else if(loginAccno.getText ().equals("999991234") || passwordField.getPassword().length==0){	
					String Query = "select * from adminpannel where AccNo = '"+ Integer.parseInt(loginAccno.getText()) +"' and Pin_no = '" + passwordField.getText() + "' ";
					try {
						Connection con = null;
						PreparedStatement pst = null;
						ResultSet rs = null;
						Statement st = null;
						
						con = DriverManager.getConnection("jdbc:mysql://localhost:3307/atm_db","root","");
						st= con.createStatement();
						rs = st.executeQuery(Query);
						if(rs.next())
						{	
							int AdminAccount = rs.getInt("AccNo");
							int AdminPwd = rs.getInt("Pin_no");
							if(AdminAccount == 999991234 || AdminPwd==8877990) {
								JOptionPane.showMessageDialog(btnNewButton, "Hello Admin");
								admin frame = new admin();
								frame.setVisible(true);
								
//								con.close();
								atmMachine.this.dispose();
							}
							else {
								JOptionPane.showMessageDialog(btnNewButton, "Admin Account and Pin is not matched");
							}
							
												
						}
						else
						{
							JOptionPane.showMessageDialog(btnNewButton, "Please Enter Account No and Admin password" );	
						}
						
					} catch (Exception ez) {
						ez.printStackTrace();
					}
					
				}
				
				else {
					String Query = "select * from adminpannel where AccNo = '"+ Integer.parseInt(loginAccno.getText()) +"' and Pin_no = '" + passwordField.getText() + "' ";
					try 
					{
						Connection con = null;
						PreparedStatement pst = null;
						ResultSet rs = null;
						Statement st = null;
						
						con = DriverManager.getConnection("jdbc:mysql://localhost:3307/atm_db","root","");
						st= con.createStatement();
						rs = st.executeQuery(Query);
						if(rs.next())
						{	
							JOptionPane.showMessageDialog(btnNewButton, "Successfully Login" );
							new Accounting().setVisible(true);
							con.close();
							atmMachine.this.dispose();
							
//							TransactionPannel frame = new TransactionPannel();
//							frame.setVisible(true);							
//							TransactionPannel.Instance.lbl.setText(loginAccno.getText());
							
							atmMachine.this.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(btnNewButton, "wrong account no and Pin code" );	
						}
						
					} 
					catch (Exception ea1) 					
					{
//						ea.printStackTrace();
						JOptionPane.showMessageDialog(btnNewButton, ea1);	
					}
					
				}
				
			}
		});
		
		
		JLabel lblNewLabel = new JLabel("Account No.");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(15, 38, 89, 26);
		contentPane.add(lblNewLabel);
		
		loginAccno = new JTextField();
		loginAccno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char ch = e.getKeyChar();
				if(!Character.isDigit(ch)) {
//				loginAccno.setEditable(false);	
					e.consume();
				}
			}
		});
		
		loginAccno.setBounds(114, 43, 232, 20);
		contentPane.add(loginAccno);
		loginAccno.setColumns(10);
		
		JLabel lblPinNo = new JLabel("Pin No.");
		lblPinNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPinNo.setBounds(15, 90, 89, 26);
		contentPane.add(lblPinNo);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e12) {
				char ch = e12.getKeyChar();
				if(!Character.isDigit(ch)) {
//				loginAccno.setEditable(false);	
					e12.consume();
				}
			}
		});
		passwordField.setBounds(113, 95, 233, 21);
		contentPane.add(passwordField);
		
		JLabel footerlabel = new JLabel("\u00a9 Gaurav Jain");
		footerlabel.setForeground(new Color(128, 0, 64));
		footerlabel.setFont(new Font("Sitka Subheading", Font.PLAIN, 12));
		footerlabel.setBounds(10, 236, 94, 14);
		contentPane.add(footerlabel);
		
		JButton btnNewButton_1 = new JButton("Create Account");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					admin frame = new admin();
					frame.setVisible(true);
					atmMachine.this.dispose();
				} catch (Exception es) {
					es.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(151, 211, 127, 23);
		contentPane.add(btnNewButton_1);
	}
}
