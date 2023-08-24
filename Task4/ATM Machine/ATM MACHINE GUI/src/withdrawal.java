import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class withdrawal extends JFrame {

	private JPanel contentPane;
	private JTextField withdrawalField;
	private JButton btnCancel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel accNum;

	/**
	 * Launch the application.
	 */
	
	private void clear()
	{
		
		withdrawalField.setText ("") ;		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					withdrawal frame = new withdrawal();
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
	public withdrawal() {
		setTitle("Withdrawal Pannel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		withdrawalField = new JTextField();
		withdrawalField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e11) {
				char ch = e11.getKeyChar();
				if(!Character.isDigit(ch)) {
//				loginAccno.setEditable(false);	
					e11.consume();
				}
			}
		});
		withdrawalField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		withdrawalField.setBounds(139, 77, 209, 51);
		contentPane.add(withdrawalField);
		withdrawalField.setColumns(10);
		
		JButton withdrawalButton = new JButton("Confirm");
		withdrawalButton.setBackground(new Color(192, 192, 192));
		withdrawalButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		withdrawalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						int WithdrawalBalance = Integer.parseInt(withdrawalField.getText());
						if( withdrawalField.getText().isEmpty())			
						{
							JOptionPane.showMessageDialog(withdrawalButton, "Please Add Money");
						}
						else 
						{
							String Query = "select balance from adminpannel where AccNo = '"+ Integer.parseInt(atmMachine.loginAccno.getText()) +"' " ;
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
									
									int currentBalance = rs.getInt("balance");
									
									if(currentBalance>= WithdrawalBalance) 
									{
									
										currentBalance = currentBalance - WithdrawalBalance;
										
	//									String updateQuery = "UPDATE accounts SET balance = ? WHERE account_number = ?";
										String updateQuery = " UPDATE adminpannel SET balance = '" + currentBalance + "'  WHERE AccNo = '"+ Integer.parseInt(atmMachine.loginAccno.getText()) +"'";
										PreparedStatement updateStatement = con.prepareStatement(updateQuery);
										
										int rowsAffected = updateStatement.executeUpdate();
	
							            if (rowsAffected > 0) {
							                JOptionPane.showMessageDialog(withdrawalButton, "Balance Withdrawal successfully.");
							                try {
												Balance frame = new Balance();
												frame.setVisible(true);
											} catch (Exception ew1) {
												ew1.printStackTrace();
											}
											con.close();
											clear();
											
											withdrawal.this.dispose();
							            } else {
							                JOptionPane.showMessageDialog(withdrawalButton, "Failed to update balance.");
							            }
									}
									else {
										JOptionPane.showMessageDialog(withdrawalButton, "Insufficient balance");
									}
						        }
								else 
								{
						            JOptionPane.showMessageDialog(withdrawalButton, "Account number not found.");
						            
						        }
				
								
							}
							catch (Exception eaw1) 					
							{
//								ea.printStackTrace();
								JOptionPane.showMessageDialog(withdrawalButton, eaw1);	
							}
						}
			}
		});
		withdrawalButton.setBounds(244, 170, 104, 36);
		contentPane.add(withdrawalButton);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					atmMachine frame = new atmMachine();
					frame.setVisible(true);
				} catch (Exception ew) {
					ew.printStackTrace();
				}
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBackground(Color.GRAY);
		btnCancel.setBounds(124, 170, 90, 36);
		contentPane.add(btnCancel);
		
		lblNewLabel = new JLabel("Withdrawal Money");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 77, 126, 51);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Account No.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(49, 11, 89, 26);
		contentPane.add(lblNewLabel_1);
		
		accNum = new JLabel("accNum");
		accNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		accNum.setBounds(148, 11, 200, 26);
		contentPane.add(accNum);
	}
}
