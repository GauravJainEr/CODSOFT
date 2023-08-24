import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Deposite extends JFrame {

	private JPanel contentPane;
	private JTextField addmoneyField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deposite frame = new Deposite();
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
	private void clear()
	{
		
		addmoneyField.setText ("") ;		
	}
	
	public static Deposite Instance;
	public JLabel lbl;
	
	
	public Deposite() {
		setTitle("Deposite Pannel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Money");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(26, 70, 88, 47);
		contentPane.add(lblNewLabel);
		
		addmoneyField = new JTextField();
		addmoneyField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e112) {
				char ch = e112.getKeyChar();
				if(!Character.isDigit(ch)) {
//				loginAccno.setEditable(false);	
					e112.consume();
				}
			}
		});
		addmoneyField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addmoneyField.setBounds(124, 70, 205, 47);
		contentPane.add(addmoneyField);
		addmoneyField.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int AddBalance = Integer.parseInt(addmoneyField.getText());
				if( addmoneyField.getText().isEmpty())			
				{
					JOptionPane.showMessageDialog(btnNewButton, "Please Add Money");
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
							
							currentBalance = currentBalance + AddBalance;
							
//							String updateQuery = "UPDATE accounts SET balance = ? WHERE account_number = ?";
							String updateQuery = " UPDATE adminpannel SET balance = '" + currentBalance + "'  WHERE AccNo = '"+ Integer.parseInt(atmMachine.loginAccno.getText()) +"'";
							PreparedStatement updateStatement = con.prepareStatement(updateQuery);
							
							int rowsAffected = updateStatement.executeUpdate();

				            if (rowsAffected > 0) {
				                JOptionPane.showMessageDialog(btnNewButton, "Balance Deposite successfully.");
				                Balance frame = new Balance();
								frame.setVisible(true);
								con.close();
								clear();
								Deposite.this.dispose();
				            } else {
				                JOptionPane.showMessageDialog(btnNewButton, "Failed to update balance.");
				            }
				        }
						else 
						{
				            JOptionPane.showMessageDialog(btnNewButton, "Account number not found.");
				        }
		
				//				try {
				//					Balance frame = new Balance();
				//					frame.setVisible(true);
				//				} catch (Exception ed) {
				//					ed.printStackTrace();
				//				}
					}
					catch (Exception ead1) 					
					{
//						ea.printStackTrace();
						JOptionPane.showMessageDialog(btnNewButton, ead1);	
					}
				}
			}
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setBounds(240, 163, 89, 35);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					atmMachine frame = new atmMachine();
					frame.setVisible(true);
				} catch (Exception edc) {
					edc.printStackTrace();
				}
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.setBackground(new Color(255, 0, 0));
		btnCancel.setBounds(124, 163, 89, 35);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_1 = new JLabel("Account No.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(26, 11, 89, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel accNum = new JLabel("accNum");
		accNum.setForeground(Color.BLUE);
		accNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		accNum.setBounds(124, 11, 200, 26);
		contentPane.add(accNum);
		
		Instance = this;
		lbl = accNum ;
		
		
	}

}
