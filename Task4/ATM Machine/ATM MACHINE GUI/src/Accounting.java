import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTextField;

public class Accounting extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accounting frame = new Accounting();
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
	public Accounting() {
		setTitle("Welcome Account Pannel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
//		contentPane.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//					
//				}
//								
//		});
		
		
		JButton saving_btn = new JButton("Saving");
		saving_btn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		saving_btn.setBackground(new Color(128, 128, 128));
		saving_btn.setBounds(268, 139, 156, 36);
		contentPane.add(saving_btn);
		
		String SavingButtonValue = saving_btn.getText();
		saving_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String Query = "select * from adminpannel where Acc_type = '"+ saving_btn +"' ";
//				String Query = "select Acc_Type from adminpannel where '"+ Integer.parseInt(atmMachine.loginAccno.getText()) +"' and Acc_type = '" + saving_btn.getText() +"' " ;
				String Query = "select Acc_Type from adminpannel where AccNo = '"+ Integer.parseInt(atmMachine.loginAccno.getText()) +"' " ;
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
						String AccountTypes =  rs.getString("Acc_Type");
						if(AccountTypes.equalsIgnoreCase(SavingButtonValue))
							try {
								TransactionPannel frame = new TransactionPannel();
								frame.setVisible(true);
								con.close();
								Accounting.this.dispose();
							} catch (Exception es) {
								es.printStackTrace();
							}
						else {
							JOptionPane.showMessageDialog(saving_btn, "You are selected wrong Account type " );
						}						
						
					} else
					{
						JOptionPane.showMessageDialog(saving_btn, "wrong Account type" );	
					}
					
				} 
				catch (Exception ea1) 					
				{
//					ea.printStackTrace();
					JOptionPane.showMessageDialog(saving_btn, ea1);	
				}			
				
			}
		});
		
		
		JButton current_btn = new JButton("Current");
		String CurrentButtonValue = current_btn.getText();
		current_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Query = "select Acc_Type from adminpannel where AccNo = '"+ Integer.parseInt(atmMachine.loginAccno.getText()) +"' " ;
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
						String AccountTypes =  rs.getString("Acc_Type");
						if(AccountTypes.equalsIgnoreCase(CurrentButtonValue))
							try {
							TransactionPannel frame = new TransactionPannel();
							frame.setVisible(true);
							con.close();
							Accounting.this.dispose();
						} catch (Exception es) {
							es.printStackTrace();
						}
						else {
							JOptionPane.showMessageDialog(current_btn, "You are selected wrong Account type2 " );
						}
					}
					else 
					{
						JOptionPane.showMessageDialog(current_btn, "You are selected wrong Account type " );
					}
					 
				}
				catch (Exception ea11) 					
				{
					ea11.printStackTrace();
//					JOptionPane.showMessageDialog(current_btn, ea11);	
				}
			}
		});
		current_btn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		current_btn.setBackground(new Color(128, 128, 128));
		current_btn.setBounds(268, 193, 156, 36);
		contentPane.add(current_btn);
		
		JButton btnNewButton_1_1 = new JButton("Cancel");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					atmMachine frame = new atmMachine();
					frame.setVisible(true);
				} catch (Exception ec) {
					ec.printStackTrace();
				}
			}
		});
		btnNewButton_1_1.setBackground(Color.GRAY);
		btnNewButton_1_1.setBounds(10, 163, 156, 36);
		contentPane.add(btnNewButton_1_1);
	}
}
