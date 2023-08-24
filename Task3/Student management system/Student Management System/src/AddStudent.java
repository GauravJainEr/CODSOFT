import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDayChooser;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JYearChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class AddStudent extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField fnameField;
	private JTextField rollnoField;
	private JTextField moField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent frame = new AddStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void clear()
	{
		
		nameField.setText ("") ;
		fnameField.setText ("") ;
		rollnoField.setText ("") ;
		moField.setText ("") ;
		
	}

	/**
	 * Create the frame.
	 */
	public AddStudent() {
		setResizable(false);
		setTitle("Add Students");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel NameLabel = new JLabel("Full name  :");
		NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NameLabel.setBounds(28, 25, 79, 17);
		contentPane.add(NameLabel);
		
		JLabel lblFathersName = new JLabel("Father's name :");
		lblFathersName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFathersName.setBounds(28, 69, 111, 17);
		contentPane.add(lblFathersName);
		
		JLabel lblRollNo = new JLabel("Roll No.  :");
		lblRollNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRollNo.setBounds(28, 118, 91, 17);
		contentPane.add(lblRollNo);
		
		JLabel lblMoNo = new JLabel("Mo. No.  :");
		lblMoNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMoNo.setBounds(28, 165, 91, 17);
		contentPane.add(lblMoNo);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(468, 162, 98, 28);
		contentPane.add(dateChooser);
		
		JLabel lblDob = new JLabel("D.O.B.  :");
		lblDob.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDob.setBounds(357, 162, 91, 17);
		contentPane.add(lblDob);
		
		JTextArea addtextArea = new JTextArea();
		addtextArea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		addtextArea.setBounds(129, 215, 203, 51);
		contentPane.add(addtextArea);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(28, 228, 91, 17);
		contentPane.add(lblAddress);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent en) {
				char ch1 = en.getKeyChar();
				if(!Character.isAlphabetic(ch1) && ch1!= ' ') {
//				loginAccno.setEditable(false);	
					en.consume();
				}
			}
		});
		nameField.setBounds(129, 21, 203, 28);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblCourse = new JLabel("Course :");
		lblCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCourse.setBounds(357, 25, 72, 17);
		contentPane.add(lblCourse);
		
		JComboBox courseCombo = new JComboBox();
		courseCombo.setModel(new DefaultComboBoxModel(new String[] {"BTech"}));
		courseCombo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		courseCombo.setBounds(468, 24, 98, 28);
		contentPane.add(courseCombo);
		
		JLabel lblYear = new JLabel("Year :");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYear.setBounds(357, 118, 72, 17);
		contentPane.add(lblYear);
		
		JComboBox yearCombo = new JComboBox();
		yearCombo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		yearCombo.setModel(new DefaultComboBoxModel(new String[] {"First", "Second", "Third", "Fourth"}));
		yearCombo.setBounds(468, 114, 98, 28);
		contentPane.add(yearCombo);
		
		JLabel lblBranch = new JLabel("Branch :");
		lblBranch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBranch.setBounds(357, 72, 72, 17);
		contentPane.add(lblBranch);
		
		JComboBox branchCombo = new JComboBox();
		branchCombo.setModel(new DefaultComboBoxModel(new String[] {"CSE", "CIVIL", "ELECTRICAL", "MECHENICAL", "ELECTRONICS"}));
		branchCombo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		branchCombo.setBounds(468, 68, 98, 28);
		contentPane.add(branchCombo);
		
		JButton btnNewButton = new JButton("ADD STUDENT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if( nameField.getText ().isEmpty () || fnameField.getText ().isEmpty () || rollnoField.getText ().isEmpty () || moField.getText ().isEmpty () || addtextArea.getText ().isEmpty ())			
				{
					JOptionPane.showMessageDialog(btnNewButton, "Missing Information");
				}
				else {
					try {
						Connection con = null;
						PreparedStatement pst = null;
						ResultSet rs = null;
						Statement st = null;
						con = DriverManager.getConnection("jdbc:mysql://localhost:3307/student_management","root","");
						PreparedStatement add = con.prepareStatement("insert into add_students (std_name, std_fname, roll_no, mo_no, address, course, branch, year, dob) values(?,?,?,?,?,?,?,?,?)");
						
						add.setString(1, nameField.getText());
						add.setString(2, fnameField.getText());
						add.setInt(3, Integer.parseInt(rollnoField.getText()));
						add.setInt(4, Integer.parseInt( moField.getText()));
						add.setString(5, addtextArea.getText());
						add.setString(6, courseCombo.getSelectedItem().toString());
						add.setString(7, branchCombo.getSelectedItem().toString());
						add.setString(8, yearCombo.getSelectedItem().toString());
//						add.setString(9, dateChooser.getDate().toString());						
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
						String formattedDate = dateFormat.format(dateChooser.getDate());
						add.setString(9, formattedDate);
						
//						add.setInt(10, Integer.parseInt("0"));
						add.executeUpdate();
						JOptionPane.showMessageDialog(btnNewButton, "Successfully Student Added");
						
						con.close();
						clear();
						
						
					} catch (Exception e11) {
						JOptionPane.showMessageDialog(btnNewButton, e11);						
						
					}
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(344, 282, 136, 36);
		contentPane.add(btnNewButton);
		
		
		
		fnameField = new JTextField();
		fnameField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		fnameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent efn) {
				char ch2 = efn.getKeyChar();
				if(!Character.isAlphabetic(ch2) && ch2!= ' ') {
//				loginAccno.setEditable(false);	
					efn.consume();
				}
			}
		});
		fnameField.setColumns(10);
		fnameField.setBounds(129, 65, 203, 28);
		contentPane.add(fnameField);
		
		rollnoField = new JTextField();
		rollnoField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rollnoField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ern) {
				char n = ern.getKeyChar();
				if(!Character.isDigit(n)) {
//				loginAccno.setEditable(false);	
					ern.consume();
				}
			}
		});
		rollnoField.setColumns(10);
		rollnoField.setBounds(129, 115, 203, 28);
		contentPane.add(rollnoField);
		
		moField = new JTextField();
		moField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		moField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent erm) {
				char m = erm.getKeyChar();
				if(!Character.isDigit(m)) {
//				loginAccno.setEditable(false);	
					erm.consume();
				}
			}
		});
		moField.setColumns(10);
		moField.setBounds(129, 162, 203, 28);
		contentPane.add(moField);		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					HomePanel frame = new HomePanel();
					frame.setVisible(true);
				} catch (Exception eback) {
					eback.printStackTrace();
				}
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(499, 282, 136, 36);
		contentPane.add(btnBack);
		
	}
}
