import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class TransactionPannel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransactionPannel frame = new TransactionPannel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

//	int AccountNumber;
//	public TransactionPannel(int myAccountNum) {
//		AccountNumber = myAccountNum;	
//	}

	/**
	 * Create the frame.
	 */
//	public static TransactionPannel Instance;
//	public JLabel lbl;
	

	public JLabel accNum ;
	
	public TransactionPannel() {
		setTitle("Transaction Pannel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Balance");
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Balance frame = new Balance();
					frame.setVisible(true);
				} catch (Exception eb1) {
					eb1.printStackTrace();
				}				
				
			}
		});
		btnNewButton.setBounds(279, 64, 145, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("withdrawal");
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
					withdrawal frame = new withdrawal();
					frame.setVisible(true);
					TransactionPannel.this.dispose();
					
				} 
				catch (Exception ex) 
				{
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(279, 118, 145, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Fast Cash Withdrawal");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					fastCash frame = new fastCash();
					frame.setVisible(true);
					TransactionPannel.this.dispose();
				} catch (Exception ef) {
					ef.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBackground(new Color(128, 128, 128));
		btnNewButton_2.setBounds(279, 174, 145, 33);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Cancel");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					atmMachine frame = new atmMachine();
					frame.setVisible(true);
				} catch (Exception ez) {
					ez.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBackground(new Color(128, 128, 128));
		btnNewButton_3.setBounds(161, 217, 114, 33);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("Account Information");
		btnNewButton_3_1.setBackground(new Color(128, 128, 128));
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AccountInformation frame = new AccountInformation();
					frame.setVisible(true);
				} catch (Exception eI) {
					eI.printStackTrace();
				}
			}
		});
		btnNewButton_3_1.setBounds(10, 64, 145, 33);
		contentPane.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_3 = new JButton("Deposit");
		btnNewButton_3_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Deposite frame = new Deposite();
					frame.setVisible(true);
					TransactionPannel.this.dispose();
				} catch (Exception ed) {
					ed.printStackTrace();
				}
			}
		});
		btnNewButton_3_3.setBackground(new Color(128, 128, 128));
		btnNewButton_3_3.setBounds(10, 118, 145, 33);
		contentPane.add(btnNewButton_3_3);
		
		JButton btnNewButton_3_4 = new JButton("Pin Change");
		btnNewButton_3_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pinChange frame = new pinChange();
					frame.setVisible(true);
					TransactionPannel.this.dispose();
				} catch (Exception ep) {
					ep.printStackTrace();
				}
			}
		});
		btnNewButton_3_4.setBackground(new Color(128, 128, 128));
		btnNewButton_3_4.setBounds(10, 174, 145, 33);
		contentPane.add(btnNewButton_3_4);
		
		JLabel lblNewLabel_1 = new JLabel("Account No.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(66, 11, 89, 26);
		contentPane.add(lblNewLabel_1);
		
		
		
		JLabel accNum = new JLabel("");
		accNum.setForeground(Color.BLUE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				String Query = "select AccNo from adminpannel where AccNo = '"+ Integer.parseInt(atmMachine.loginAccno.getText()) +"' " ;
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
						int AccountNum = rs.getInt("AccNo");
						accNum.setText(""+ AccountNum );

//						totalBalanceLabel.setText( Integer.toString (500) );
						con.close();
						
					}
					else{
						accNum.setText("N/A ");
					}
					
				}
				catch (Exception et) 					
				{
					et.printStackTrace();
//					JOptionPane.showInputDialog("", eab);	
				}
			}
		});

		
		accNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		accNum.setBounds(154, 11, 200, 26);
		contentPane.add(accNum);
//		Instance = this;
//		lbl = accNum ;
	}

}
