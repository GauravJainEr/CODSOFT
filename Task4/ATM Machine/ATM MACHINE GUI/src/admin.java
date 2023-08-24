import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import java.awt.Button;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class admin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void clear()
	{
		
		textField.setText ("") ;
		textField_1.setText ("") ;
		textField_2.setText ("") ;
		textField_3.setText ("") ;
		textField_4.setText ("") ;
		textField_5.setText ("") ;
		
	}
	
	
	
	

	/**
	 * Create the frame.
	 */
	public admin() {
		setTitle("AdminPanel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setBounds(10, 64, 58, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Account No.");
		lblNewLabel_1.setBounds(10, 23, 74, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char ch = e.getKeyChar();
				if(!Character.isDigit(ch)) {
//				loginAccno.setEditable(false);	
					e.consume();
				}
			}
		});
		textField.setBounds(94, 20, 118, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent en) {
				char ch1 = en.getKeyChar();
				if(!Character.isAlphabetic(ch1) && ch1!= ' ') {
//				loginAccno.setEditable(false);	
					en.consume();
				}
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(94, 64, 118, 20);
		contentPane.add(textField_1);
		
		JLabel lblFatherName = new JLabel("Father Name :");
		lblFatherName.setBounds(10, 95, 74, 20);
		contentPane.add(lblFatherName);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ef) {
				char ch1 = ef.getKeyChar();
				if(!Character.isAlphabetic(ch1) && ch1!= ' ') {
//				loginAccno.setEditable(false);	
					ef.consume();
				}
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(94, 95, 118, 20);
		contentPane.add(textField_2);
		
		JLabel lblMoNo = new JLabel("Mobile No. :");
		lblMoNo.setBounds(10, 138, 74, 20);
		contentPane.add(lblMoNo);
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e13) {
				char ch = e13.getKeyChar();
				if(!Character.isDigit(ch)) {
//				loginAccno.setEditable(false);	
					e13.consume();
				}
			}
		});
		textField_3.setColumns(10);
		textField_3.setBounds(94, 138, 118, 20);
		contentPane.add(textField_3);
		
		JLabel lblAccountType = new JLabel("Account Type :");
		lblAccountType.setBounds(237, 20, 74, 20);
		contentPane.add(lblAccountType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Saving", "Current"}));
		comboBox.setBounds(321, 23, 88, 22);
		contentPane.add(comboBox);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(237, 95, 74, 20);
		contentPane.add(lblGender);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Transgender"}));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox_1.setBounds(321, 93, 88, 22);
		contentPane.add(comboBox_1);
		
		JLabel lblOccupation = new JLabel("Occupation :");
		lblOccupation.setBounds(237, 138, 74, 20);
		contentPane.add(lblOccupation);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(321, 138, 88, 20);
		contentPane.add(textField_4);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setBounds(10, 185, 74, 20);
		contentPane.add(lblAddress);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(94, 185, 118, 42);
		contentPane.add(textArea);
		
		JLabel lblDob = new JLabel("DOB :");
		lblDob.setBounds(237, 64, 58, 20);
		contentPane.add(lblDob);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(321, 64, 88, 20);
		contentPane.add(dateChooser);
		
//		Connection con = null;
//		PreparedStatement pst = null;
//		ResultSet rs = null;
//		Statement st = null;
		
		
		
		Button button = new Button("Create");
		button.setBounds(339, 229, 70, 22);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( textField.getText ().isEmpty () || textField_1.getText ().isEmpty () || textField_2.getText ().isEmpty () || textField_3.getText ().isEmpty () || textField_4.getText ().isEmpty () || textField_5.getText ().isEmpty () || textArea.getText ().isEmpty () )			
				{
					JOptionPane.showMessageDialog(button, "Missing Information");
				}
				else {
					try {
						Connection con = null;
						PreparedStatement pst = null;
						ResultSet rs = null;
						Statement st = null;
						con = DriverManager.getConnection("jdbc:mysql://localhost:3307/atm_db","root","");
						PreparedStatement add = con.prepareStatement("insert into adminpannel values(?,?,?,?,?,?,?,?,?,?,?)");
						add.setInt(1, Integer.parseInt(textField.getText()));
						add.setString(2, textField_1.getText());
						add.setString(3, textField_2.getText());
						add.setInt(4, Integer.parseInt(textField_3.getText()));
						add.setString(5, dateChooser.getDate().toString());
						add.setString(6, textArea.getText());
						add.setString(7, textField_4.getText());
						
						add.setString(8, comboBox.getSelectedItem().toString());										
						add.setString(9, comboBox_1.getSelectedItem().toString());
						add.setInt(10, Integer.parseInt(textField_5.getText()));
						add.setInt(11, Integer.parseInt("0"));
						add.executeUpdate();
						JOptionPane.showMessageDialog(button, "Successfully Create ATM Account");
						
						con.close();
						clear();
						
						
					} catch (Exception e11) {
						JOptionPane.showMessageDialog(button, e11);						
						
					}
				}
				
			}
		});
		
		
		
		Button button_1 = new Button("Cancel");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JOptionPane.showMessageDialog(button_1, "Thank You Admin");
					atmMachine frame = new atmMachine();
					frame.setVisible(true);
				} catch (Exception es) {
					es.printStackTrace();
				}
			}
		});
		button_1.setBounds(237, 229, 70, 22);
		contentPane.add(button_1);
		
		JLabel lblPincode = new JLabel("Pin No :");
		lblPincode.setBounds(237, 185, 74, 20);
		contentPane.add(lblPincode);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e14) {
				char ch = e14.getKeyChar();
				if(!Character.isDigit(ch)) {
//				loginAccno.setEditable(false);	
					e14.consume();
				}
			}
		});
		textField_5.setColumns(10);
		textField_5.setBounds(321, 185, 88, 20);
		contentPane.add(textField_5);
		
		JLabel footerlabel = new JLabel("© Gaurav Jain");
		footerlabel.setForeground(new Color(128, 0, 64));
		footerlabel.setFont(new Font("Sitka Subheading", Font.PLAIN, 12));
		footerlabel.setBounds(10, 247, 94, 14);
		contentPane.add(footerlabel);
		
	}
}
