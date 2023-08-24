import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePanel extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePanel frame = new HomePanel();
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
	public HomePanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton AddStudentsButton = new JButton("Add Students");
		AddStudentsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					AddStudent frame = new AddStudent();
					frame.setVisible(true);
				} catch (Exception ea) {
					ea.printStackTrace();
				}
				
				
			}
		});
		AddStudentsButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		AddStudentsButton.setBounds(10, 64, 231, 173);
		contentPane.add(AddStudentsButton);
		
		JButton btnStudentsDetail = new JButton("Students Detail");
		btnStudentsDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					StudentsDetail frame = new StudentsDetail();
					frame.setVisible(true);
				} catch (Exception ed) {
					ed.printStackTrace();
				}
			}
		});
		btnStudentsDetail.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnStudentsDetail.setBounds(387, 64, 248, 173);
		contentPane.add(btnStudentsDetail);
		
		JButton LogoutButton = new JButton("Logout");
		LogoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					AdminLogin frame = new AdminLogin();					
					frame.setVisible(true);
				} catch (Exception elogout) {
					elogout.printStackTrace();
				}
			}
		});
		LogoutButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		LogoutButton.setBounds(213, 272, 213, 55);
		contentPane.add(LogoutButton);
	}

}
