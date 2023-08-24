import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class fastCash extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fastCash frame = new fastCash();
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
	public fastCash() {
		setTitle("Fast Cash Withdrawal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("$ 100");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
							
				int FastcashConfirm = JOptionPane.showConfirmDialog(btnNewButton,"Sure? You want to Withdrawal $ 100 ?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(FastcashConfirm == JOptionPane.YES_OPTION)
				{
					String Query = "select balance from adminpannel where AccNo = '"+ Integer.parseInt(atmMachine.loginAccno.getText()) +"' ";
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
							
							if(currentBalance>=100) 
							{							
								currentBalance = currentBalance - 100;
								
	//							String updateQuery = "UPDATE accounts SET balance = ? WHERE account_number = ?";
								String updateQuery = " UPDATE adminpannel SET balance = '" + currentBalance + "'  WHERE AccNo = '"+ Integer.parseInt(atmMachine.loginAccno.getText()) +"'";
								PreparedStatement updateStatement = con.prepareStatement(updateQuery);
								
								int rowsAffected = updateStatement.executeUpdate();
	
					            if (rowsAffected > 0) {
					                JOptionPane.showMessageDialog(btnNewButton, " $ 100 Withdrawal successfully");
					                try {
										Balance frame = new Balance();
										frame.setVisible(true);
									} catch (Exception ew1) {
										ew1.printStackTrace();
									}
									con.close();
					            } 
					            else {
					                JOptionPane.showMessageDialog(btnNewButton, "Failed to Withdrwal $ 100");
					            }
							}
							else {
								JOptionPane.showMessageDialog(btnNewButton, "Insuffucient Account balance");
							}
				            
						}
						else {
							JOptionPane.showMessageDialog(btnNewButton, "Account number not found");
							con.close();
						}
					}
					catch (Exception eaf1) 					
					{
//						ea.printStackTrace();
						JOptionPane.showMessageDialog(btnNewButton, eaf1);	
					}
				}						
				else if (FastcashConfirm == JOptionPane.NO_OPTION)
				{
					try 
					{
						fastCash frame = new fastCash();
						frame.setVisible(true);
					} 
					catch (Exception ef) 
					{
						ef.printStackTrace();
					}		            
				}				
			}
		});
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(308, 51, 116, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("$ 500");
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {									
						int FastcashConfirm = JOptionPane.showConfirmDialog(btnNewButton,"Sure? You want to Withdrawal $ 100 ?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if(FastcashConfirm == JOptionPane.YES_OPTION)
						{
							String Query = "select balance from adminpannel where AccNo = '"+ Integer.parseInt(atmMachine.loginAccno.getText()) +"' ";
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
									if(currentBalance>=500)
									{										
										currentBalance = currentBalance - 500;
										
	//									String updateQuery = "UPDATE accounts SET balance = ? WHERE account_number = ?";
										String updateQuery = " UPDATE adminpannel SET balance = '" + currentBalance + "'  WHERE AccNo = '"+ Integer.parseInt(atmMachine.loginAccno.getText()) +"'";
										PreparedStatement updateStatement = con.prepareStatement(updateQuery);
										
										int rowsAffected = updateStatement.executeUpdate();
	
							            if (rowsAffected > 0) {
							                JOptionPane.showMessageDialog(btnNewButton_1, " $ 500 Withdrawal successfully.");
							                try {
												Balance frame = new Balance();
												frame.setVisible(true);
											} catch (Exception ew1) {
												ew1.printStackTrace();
											}
											con.close();
							            } 
							            else {
							                JOptionPane.showMessageDialog(btnNewButton_1, "Failed to Withdrwal $ 500");
							                con.close();
							            }
									}
									else {
										JOptionPane.showMessageDialog(btnNewButton_1, "Insuffucient Account balance");
										con.close();
									}
							            
								}
								else {
									JOptionPane.showMessageDialog(btnNewButton_1, "Account number not found.");
									con.close();
								}
							}
							catch (Exception eaf2) 					
							{
//								ea.printStackTrace();
								JOptionPane.showMessageDialog(btnNewButton_1, eaf2);	
							}
						}						
						else if (FastcashConfirm == JOptionPane.NO_OPTION)
						{
							try 
							{
								fastCash frame = new fastCash();
								frame.setVisible(true);
							} 
							catch (Exception ef2) 
							{
								ef2.printStackTrace();
							}		            
						}					
				}
			});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(308, 112, 116, 36);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("$ 1000");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int FastcashConfirm = JOptionPane.showConfirmDialog(btnNewButton,"Sure? You want to Withdrawal $ 100 ?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(FastcashConfirm == JOptionPane.YES_OPTION)
				{
					String Query = "select balance from adminpannel where AccNo = '"+ Integer.parseInt(atmMachine.loginAccno.getText()) +"' ";
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
							
							if(currentBalance>=1000) 
							{							
								currentBalance = currentBalance - 1000;
								
	//							String updateQuery = "UPDATE accounts SET balance = ? WHERE account_number = ?";
								String updateQuery = " UPDATE adminpannel SET balance = '" + currentBalance + "'  WHERE AccNo = '"+ Integer.parseInt(atmMachine.loginAccno.getText()) +"'";
								PreparedStatement updateStatement = con.prepareStatement(updateQuery);
								
								int rowsAffected = updateStatement.executeUpdate();
	
					            if (rowsAffected > 0) {
					                JOptionPane.showMessageDialog(btnNewButton_1_1, " $ 1000 Withdrawal successfully.");
					                try {
										Balance frame = new Balance();
										frame.setVisible(true);
									} catch (Exception ew1) {
										ew1.printStackTrace();
									}
									con.close();
					            } 
					            else {
					                JOptionPane.showMessageDialog(btnNewButton_1_1, "Failed to Withdrwal $ 1000");
					            }
							}
							else {
								JOptionPane.showMessageDialog(btnNewButton_1_1, "Insuffucient Account balance");
							}
				            
						}
						else {
							JOptionPane.showMessageDialog(btnNewButton_1_1, "Account number not found.");
						}
					}
					catch (Exception eaf3) 					
					{
//						ea.printStackTrace();
						JOptionPane.showMessageDialog(btnNewButton_1_1, eaf3);	
					}
				}						
				else if (FastcashConfirm == JOptionPane.NO_OPTION)
				{
					try 
					{
						fastCash frame = new fastCash();
						frame.setVisible(true);
					} 
					catch (Exception ef3) 
					{
						ef3.printStackTrace();
					}		            
				}
				
			}
		});
		
		btnNewButton_1_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(308, 175, 116, 36);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("$ 2000");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int FastcashConfirm = JOptionPane.showConfirmDialog(btnNewButton,"Sure? You want to Withdrawal $ 100 ?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(FastcashConfirm == JOptionPane.YES_OPTION)
				{
					String Query = "select balance from adminpannel where AccNo = '"+ Integer.parseInt(atmMachine.loginAccno.getText()) +"' ";
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
							
							if(currentBalance>=2000) 
							{
							
								currentBalance = currentBalance - 2000;
								
	//							String updateQuery = "UPDATE accounts SET balance = ? WHERE account_number = ?";
								String updateQuery = " UPDATE adminpannel SET balance = '" + currentBalance + "'  WHERE AccNo = '"+ Integer.parseInt(atmMachine.loginAccno.getText()) +"'";
								PreparedStatement updateStatement = con.prepareStatement(updateQuery);
								
								int rowsAffected = updateStatement.executeUpdate();
	
					            if (rowsAffected > 0) {
					                JOptionPane.showMessageDialog(btnNewButton_1_1, " $ 2000 Withdrawal successfully.");
					                try {
										Balance frame = new Balance();
										frame.setVisible(true);
									} catch (Exception ew1) {
										ew1.printStackTrace();
									}
									con.close();
					            } 
					            else {
					                JOptionPane.showMessageDialog(btnNewButton_1_1, "Failed to Withdrwal $ 2000");
					            }
							}
							else {
								JOptionPane.showMessageDialog(btnNewButton_1_1, "Insuffucient Account balance");
							}
				            
				            
						}
						else {
							JOptionPane.showMessageDialog(btnNewButton_1_1, "Account number not found.");
						}
					}
					catch (Exception eaf4) 					
					{
//						ea.printStackTrace();
						JOptionPane.showMessageDialog(btnNewButton_1_1, eaf4);	
					}
				}						
				else if (FastcashConfirm == JOptionPane.NO_OPTION)
				{
					try 
					{
						fastCash frame = new fastCash();
						frame.setVisible(true);
					} 
					catch (Exception ef4) 
					{
						ef4.printStackTrace();
					}		            
				}				
			}
		});
		btnNewButton_1_1_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1_1.setBounds(10, 51, 116, 36);
		contentPane.add(btnNewButton_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("$ 5000");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int FastcashConfirm = JOptionPane.showConfirmDialog(btnNewButton,"Sure? You want to Withdrawal $ 100 ?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(FastcashConfirm == JOptionPane.YES_OPTION)
				{
					String Query = "select balance from adminpannel where AccNo = '"+ Integer.parseInt(atmMachine.loginAccno.getText()) +"' ";
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
							if(currentBalance>=5000) 
							{
							
								currentBalance = currentBalance - 5000;
								
	//							String updateQuery = "UPDATE accounts SET balance = ? WHERE account_number = ?";
								String updateQuery = " UPDATE adminpannel SET balance = '" + currentBalance + "'  WHERE AccNo = '"+ Integer.parseInt(atmMachine.loginAccno.getText()) +"'";
								PreparedStatement updateStatement = con.prepareStatement(updateQuery);
								
								int rowsAffected = updateStatement.executeUpdate();
	
					            if (rowsAffected > 0) {
					                JOptionPane.showMessageDialog(btnNewButton_1_1_1_1, " $ 5000 Withdrawal successfully.");
					                try {
										Balance frame = new Balance();
										frame.setVisible(true);
									} catch (Exception ew1) {
										ew1.printStackTrace();
									}
									con.close();
					            } 
					            else {
					                JOptionPane.showMessageDialog(btnNewButton_1_1_1_1, "Failed to Withdrwal $ 5000");
					            }
							}
							else {
								JOptionPane.showMessageDialog(btnNewButton_1_1_1_1, "Insuffucient Account balance");
							}
						}
						else {
							JOptionPane.showMessageDialog(btnNewButton_1_1_1_1, "Account number not found.");
						}
					}
					catch (Exception eaf5) 					
					{
//						ea.printStackTrace();
						JOptionPane.showMessageDialog(btnNewButton_1_1_1_1, eaf5);	
					}
				}						
				else if (FastcashConfirm == JOptionPane.NO_OPTION)
				{
					try 
					{
						fastCash frame = new fastCash();
						frame.setVisible(true);
					} 
					catch (Exception ef5) 
					{
						ef5.printStackTrace();
					}		            
				}
			}
		});
		
		btnNewButton_1_1_1_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1_1_1.setBounds(10, 112, 116, 36);
		contentPane.add(btnNewButton_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("$ 10,000");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int FastcashConfirm = JOptionPane.showConfirmDialog(btnNewButton,"Sure? You want to Withdrawal $ 100 ?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if(FastcashConfirm == JOptionPane.YES_OPTION)
				{
					String Query = "select balance from adminpannel where AccNo = '"+ Integer.parseInt(atmMachine.loginAccno.getText()) +"' ";
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
							
							if(currentBalance>=10000) 
							{
							
								currentBalance = currentBalance - 10000;
								
	//							String updateQuery = "UPDATE accounts SET balance = ? WHERE account_number = ?";
								String updateQuery = " UPDATE adminpannel SET balance = '" + currentBalance + "'  WHERE AccNo = '"+ Integer.parseInt(atmMachine.loginAccno.getText()) +"'";
								PreparedStatement updateStatement = con.prepareStatement(updateQuery);
								
								int rowsAffected = updateStatement.executeUpdate();
	
					            if (rowsAffected > 0) {
					                JOptionPane.showMessageDialog(btnNewButton_1_1_1_1_1, " $ 10000 Withdrawal successfully.");
					                try {
										Balance frame = new Balance();
										frame.setVisible(true);
									} catch (Exception ew1) {
										ew1.printStackTrace();
									}
									con.close();
					            } 
					            else {
					                JOptionPane.showMessageDialog(btnNewButton_1_1_1_1_1, "Failed to Withdrwal $ 10000");
					            }
							}
							else {
								JOptionPane.showMessageDialog(btnNewButton_1_1_1_1_1, "Insuffucient Account balance");
							}
				            
						}
						else {
							JOptionPane.showMessageDialog(btnNewButton_1_1_1_1_1, "Account number not found.");
						}
					}
					catch (Exception eaf6) 					
					{
//						ea.printStackTrace();
						JOptionPane.showMessageDialog(btnNewButton_1_1_1_1, eaf6);	
					}
				}						
				else if (FastcashConfirm == JOptionPane.NO_OPTION)
				{
					try 
					{
						fastCash frame = new fastCash();
						frame.setVisible(true);
					} 
					catch (Exception ef6) 
					{
						ef6.printStackTrace();
					}		            
				}
			}
		});
		
		btnNewButton_1_1_1_1_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1_1_1_1.setBounds(10, 175, 116, 36);
		contentPane.add(btnNewButton_1_1_1_1_1);
	}

}
