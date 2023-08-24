import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Balance extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Balance frame = new Balance();
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
	
//	public static Balance Instance;
//	public JLabel lbl;
	public JLabel totalBalLabel ;
	
	public Balance() {
		//////
		
		
		setTitle("Balance Enquery");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Totalbalance_btn = new JButton("OK");
		Totalbalance_btn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Totalbalance_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					atmMachine frame = new atmMachine();
					frame.setVisible(true);
				} catch (Exception eb) {
					eb.printStackTrace();
				}
			}
		});
		Totalbalance_btn.setBounds(146, 181, 153, 35);
		contentPane.add(Totalbalance_btn);
		
		JLabel lblNewLabel = new JLabel("Balance :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(37, 97, 78, 27);
		contentPane.add(lblNewLabel);
		

		JLabel totalBalLabel = new JLabel("");
//		Instance = this;
		totalBalLabel.setForeground(new Color(255, 0, 0));
//		totalBalLabel.setText(""+ 500);
//		*****************************
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
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
//						JOptionPane.showInputDialog(this);
						
//						Balance.Instance.totalBalanceLabel.setText("500"+ currentBalance );
//						Balance frame = new Balance();
//						frame.setVisible(true);
						int currentBalance = rs.getInt("balance");
						totalBalLabel.setText(""+ currentBalance );

//						totalBalanceLabel.setText( Integer.toString (500) );
						con.close();
						
					}
					else{
//						JOptionPane.showMessageDialog(btnNewButton, "Sorry " );
//						Balance.Instance.totalBalanceLabel.setText("N/A ");
						totalBalLabel.setText("N/A ");
					}
					
				}
				catch (Exception eab) 					
				{
					eab.printStackTrace();
//					JOptionPane.showInputDialog("", eab);	
				}
			}
		});
		
//		*****************************

		totalBalLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		totalBalLabel.setBounds(174, 98, 153, 27);
		contentPane.add(totalBalLabel);
		
		
		
		
		JLabel lblRs = new JLabel("Rs.");
		lblRs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRs.setBounds(137, 97, 24, 27);
		contentPane.add(lblRs);
	}
}
