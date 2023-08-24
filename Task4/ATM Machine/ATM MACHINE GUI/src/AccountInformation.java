import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
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

public class AccountInformation extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountInformation frame = new AccountInformation();
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
	public JLabel accNumberLabel ;
	public JLabel accNameLabel ;
	public JLabel accFNameLabel ;
	public JLabel accMobileLabel ;
	public JLabel accTypeLabel ;
	public JLabel accBalanceLabel ;
	public JLabel accAddressLabel ;
	
	
	public AccountInformation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel accountName = new JLabel("NAME :");
		accountName.setFont(new Font("Sitka Subheading", Font.PLAIN, 12));
		accountName.setBounds(30, 46, 102, 22);
		contentPane.add(accountName);
		
		JLabel accountFName = new JLabel("F_NAME :");		
		accountFName.setFont(new Font("Sitka Subheading", Font.PLAIN, 12));
		accountFName.setBounds(30, 79, 102, 22);
		contentPane.add(accountFName);
		
		JLabel accMoNum = new JLabel("Mobile :");
		accMoNum.setFont(new Font("Sitka Subheading", Font.PLAIN, 12));
		accMoNum.setBounds(30, 112, 102, 22);
		contentPane.add(accMoNum);
		
		JLabel accTypes = new JLabel("Type :");
		accTypes.setFont(new Font("Sitka Subheading", Font.PLAIN, 12));
		accTypes.setBounds(30, 145, 41, 22);
		contentPane.add(accTypes);
		
		JLabel accBalanceDetail = new JLabel("Balance :");
		accBalanceDetail.setFont(new Font("Sitka Subheading", Font.PLAIN, 12));
		accBalanceDetail.setBounds(237, 145, 56, 22);
		contentPane.add(accBalanceDetail);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TransactionPannel frame = new TransactionPannel();
					frame.setVisible(true);
					AccountInformation.this.dispose();
//					con.close();
				} catch (Exception eii) {
					eii.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(303, 211, 102, 33);
		contentPane.add(btnNewButton);
		
		JLabel accAddress = new JLabel("Address :");
		accAddress.setFont(new Font("Sitka Subheading", Font.PLAIN, 12));
		accAddress.setBounds(30, 178, 72, 22);
		contentPane.add(accAddress);
		
		JLabel accNumber = new JLabel("Account Number :");
		accNumber.setFont(new Font("Sitka Subheading", Font.PLAIN, 12));
		accNumber.setBounds(30, 11, 102, 22);
		contentPane.add(accNumber);
		
		JLabel accNumberLabel = new JLabel("");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				String Query = "select * from adminpannel where AccNo = '"+ Integer.parseInt(atmMachine.loginAccno.getText()) +"' " ;
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
						int accountNumber = rs.getInt("AccNo");
//						String accountName = rs.getString("Name");
						
						accNumberLabel.setText(""+ accountNumber );
//						totalBalanceLabel.setText( Integer.toString (500) );						
					}
					else{
						accNumberLabel.setText("N/A ");
					}					
				}
				catch (Exception et) 					
				{
					et.printStackTrace();	
				}
			}
		});
		
		accNumberLabel.setFont(new Font("Sitka Small", Font.PLAIN, 12));
		accNumberLabel.setBounds(142, 11, 244, 22);
		contentPane.add(accNumberLabel);
		
		JLabel accNameLabel = new JLabel("");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				String Query = "select * from adminpannel where AccNo = '"+ Integer.parseInt(atmMachine.loginAccno.getText()) +"' " ;
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
						String accountName = rs.getString("Name");
						
						accNameLabel.setText(""+ accountName );
//						totalBalanceLabel.setText( Integer.toString (500) );						
					}
					else{
						accNameLabel.setText("N/A ");
					}					
				}
				catch (Exception ei1) 					
				{
					ei1.printStackTrace();	
				}
			}
		});
		accNameLabel.setFont(new Font("Sitka Small", Font.PLAIN, 12));
		accNameLabel.setBounds(142, 46, 244, 22);
		contentPane.add(accNameLabel);
		
		JLabel accFNameLabel = new JLabel("");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				String Query = "select * from adminpannel where AccNo = '"+ Integer.parseInt(atmMachine.loginAccno.getText()) +"' " ;
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
						String accountFName = rs.getString("Father_name");
						
						accFNameLabel.setText(""+ accountFName );
//						totalBalanceLabel.setText( Integer.toString (500) );						
					}
					else{
						accFNameLabel.setText("N/A ");
					}					
				}
				catch (Exception ei2) 					
				{
					ei2.printStackTrace();	
				}
			}
		});
		accFNameLabel.setFont(new Font("Sitka Small", Font.PLAIN, 12));
		accFNameLabel.setBounds(142, 81, 244, 22);
		contentPane.add(accFNameLabel);
		
		JLabel accMobileLabel = new JLabel("");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				String Query = "select * from adminpannel where AccNo = '"+ Integer.parseInt(atmMachine.loginAccno.getText()) +"' " ;
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
						int accountMobileNo = rs.getInt("Mobile_No");
						
						accMobileLabel.setText(""+ accountMobileNo );
//						totalBalanceLabel.setText( Integer.toString (500) );						
					}
					else{
						accMobileLabel.setText("N/A ");
					}					
				}
				catch (Exception ei3) 					
				{
					ei3.printStackTrace();	
				}
			}
		});
		accMobileLabel.setFont(new Font("Sitka Small", Font.PLAIN, 12));
		accMobileLabel.setBounds(142, 114, 244, 22);
		contentPane.add(accMobileLabel);
		
		JLabel accTypeLabel = new JLabel("");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				String Query = "select * from adminpannel where AccNo = '"+ Integer.parseInt(atmMachine.loginAccno.getText()) +"' " ;
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
						String accountTypes = rs.getString("Acc_type");
						
						accTypeLabel.setText(""+ accountTypes );
//						totalBalanceLabel.setText( Integer.toString (500) );						
					}
					else{
						accTypeLabel.setText("N/A ");
					}					
				}
				catch (Exception ei4) 					
				{
					ei4.printStackTrace();	
				}
			}
		});
		accTypeLabel.setFont(new Font("Sitka Small", Font.PLAIN, 12));
		accTypeLabel.setBounds(142, 145, 82, 22);
		contentPane.add(accTypeLabel);
		
		JLabel accBalanceLabel = new JLabel("");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				String Query = "select * from adminpannel where AccNo = '"+ Integer.parseInt(atmMachine.loginAccno.getText()) +"' " ;
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
						int accountBal = rs.getInt("balance");
//						String accountName = rs.getString("Name");
						
						accBalanceLabel.setText(""+ accountBal );
//						totalBalanceLabel.setText( Integer.toString (500) );						
					}
					else{
						accBalanceLabel.setText("N/A ");
					}					
				}
				catch (Exception ei5) 					
				{
					ei5.printStackTrace();	
				}
			}
		});
		accBalanceLabel.setFont(new Font("Sitka Small", Font.PLAIN, 12));
		accBalanceLabel.setBounds(303, 145, 121, 22);
		contentPane.add(accBalanceLabel);
		
		JLabel accAddressLabel = new JLabel("");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				String Query = "select * from adminpannel where AccNo = '"+ Integer.parseInt(atmMachine.loginAccno.getText()) +"' " ;
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
						String accountAddresses = rs.getString("Address");
						
						accAddressLabel.setText(""+ accountAddresses );
//						totalBalanceLabel.setText( Integer.toString (500) );						
					}
					else{
						accAddressLabel.setText("N/A ");
					}					
				}
				catch (Exception ei6) 					
				{
					ei6.printStackTrace();	
				}
			}
		});
		accAddressLabel.setFont(new Font("Sitka Small", Font.PLAIN, 12));
		accAddressLabel.setBounds(142, 178, 244, 22);
		contentPane.add(accAddressLabel);
	}
}
