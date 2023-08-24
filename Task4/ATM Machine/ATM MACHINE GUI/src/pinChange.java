import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class pinChange extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JPasswordField pwdEnterNewPin;
	private JPasswordField pwdEnterNewPin_1;
	private JPasswordField pwdConfirmNewPin;
	private JLabel lblNewLabel_1;
	private JLabel accNum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pinChange frame = new pinChange();
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
	public pinChange() {
		setTitle("Pin Change");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Change Pin");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(25, 103, 103, 40);
		contentPane.add(lblNewLabel);
		
		pwdEnterNewPin_1 = new JPasswordField();
		pwdEnterNewPin_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e21) {
				char ch = e21.getKeyChar();
				if(!Character.isDigit(ch)) {
//				loginAccno.setEditable(false);	
					e21.consume();
				}
			}
		});
		pwdEnterNewPin_1.setText("Enter New Pin no");
		pwdEnterNewPin_1.setEchoChar((char)0);
		pwdEnterNewPin_1.setBounds(178, 81, 221, 31);
		contentPane.add(pwdEnterNewPin_1);
		pwdEnterNewPin_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (pwdEnterNewPin_1.getText().equals("Enter New Pin no")) {
					pwdEnterNewPin_1.setText("");								
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (pwdEnterNewPin_1.getText().equals("")) {
					pwdEnterNewPin_1.setText("Enter New Pin no");
			    }				
			}
		});
		
		
		
		pwdConfirmNewPin = new JPasswordField();
		pwdConfirmNewPin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e22) {
				char ch = e22.getKeyChar();
				if(!Character.isDigit(ch)) {
//				loginAccno.setEditable(false);	
					e22.consume();
				}
			}
		});
		pwdConfirmNewPin.setText("Confirm New Pin no");
		pwdConfirmNewPin.setEchoChar((char)0);
		pwdConfirmNewPin.setBounds(178, 135, 221, 31);
		contentPane.add(pwdConfirmNewPin);
		
		JButton ChangePwd = new JButton("Submit");
		ChangePwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				if(passwordField.getPassword().length == -1|| pwdEnterNewPin_1.getText().length() == 0 || pwdConfirmNewPin.getText().length() == 0 )
//				if(passwordField.getText().equals("Enter Old Pin no") || pwdEnterNewPin_1.getText().equals("Enter New Pin no") || pwdConfirmNewPin.getText().equals("Confirm New Pin no") )
				if(pwdEnterNewPin_1.getText().equals("Enter New Pin no") || pwdConfirmNewPin.getText().equals("Confirm New Pin no") )
				{
					JOptionPane.showMessageDialog(ChangePwd, "Please Enter Pin");
				}
				
				else if(!pwdEnterNewPin_1.getText().equals(pwdConfirmNewPin.getText())) {
					JOptionPane.showMessageDialog(ChangePwd, "Confirm Pin is not Matched ");
					
				}
				else {
					String Query = " UPDATE adminpannel SET Pin_no = ' " + pwdEnterNewPin_1.getText() + " ' WHERE AccNo = '"+ Integer.parseInt(atmMachine.loginAccno.getText()) +"' and Pin_no = '" + atmMachine.passwordField.getText() + "'";
					try 
					{
						Connection con = null;
						PreparedStatement pst = null;
						ResultSet rs = null;
						Statement st = null;
						
						con = DriverManager.getConnection("jdbc:mysql://localhost:3307/atm_db","root","");
						st= con.createStatement();
						
						pst = (PreparedStatement) con
		                        .prepareStatement(Query);
						pst.executeUpdate(Query);
						JOptionPane.showMessageDialog(ChangePwd, "Successfully Pin Changed" );
						
						con.close();
						
						try {
							TransactionPannel frame = new TransactionPannel();
							frame.setVisible(true);
						} catch (Exception ez) {
							ez.printStackTrace();
						}
						pinChange.this.dispose();					
						
						
//						if(pst.execute())
//						{	
//							
//							JOptionPane.showMessageDialog(ChangePwd, "wow Successfully Pin Changed" );
////							new Accounting().setVisible(true); 						
//						}
//						else
//						{
//							JOptionPane.showMessageDialog(ChangePwd, " Pin not Changed " );	
//						}
//						
					} 
					catch (Exception ea1) 					
					{
//						ea.printStackTrace();
						JOptionPane.showMessageDialog(ChangePwd, " Pin not Changed " );
						JOptionPane.showMessageDialog(ChangePwd, ea1);	
					}
					
				}				
			}
		});
		
		
		ChangePwd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ChangePwd.setBounds(226, 215, 91, 23);
		contentPane.add(ChangePwd);
		
		lblNewLabel_1 = new JLabel("Account No.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(53, 11, 89, 26);
		contentPane.add(lblNewLabel_1);
		
		accNum = new JLabel("accNum");
		accNum.setForeground(Color.BLUE);
		accNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		accNum.setBounds(146, 11, 200, 26);
		contentPane.add(accNum);
		pwdConfirmNewPin.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e3) {
				if (pwdConfirmNewPin.getText().equals("Confirm New Pin no")) {
					pwdConfirmNewPin.setText("");								
				}
			}
			@Override
			public void focusLost(FocusEvent e3) {
				if (pwdConfirmNewPin.getText().equals("")) {
					pwdConfirmNewPin.setText("Confirm New Pin no");
			    }
			}
		});
		
	}
}
