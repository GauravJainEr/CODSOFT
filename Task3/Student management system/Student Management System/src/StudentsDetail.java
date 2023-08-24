import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.Font;

public class StudentsDetail extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table_1;
	
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	Statement st = null;
	private JButton deleteButton;
	private JTextField searchField;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentsDetail frame = new StudentsDetail();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * 
	 * 
	 * 
	 */
	public StudentsDetail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table_1 = new JTable();
        table_1.setModel(new DefaultTableModel());
        JScrollPane scrollPane = new JScrollPane(table_1);
        scrollPane.setBounds(10, 11, 625, 256);
        contentPane.add(scrollPane);
        
        deleteButton = new JButton("Delete");
        deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        deleteButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		deleteSelectedRow();
        	}
        });
        deleteButton.setBounds(292, 296, 111, 29);
        contentPane.add(deleteButton);
        
        searchField = new JTextField();
        searchField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        searchField.setBounds(10, 296, 120, 29);
        contentPane.add(searchField);
        searchField.setColumns(10);
        
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String search = searchField.getText();
                searchStudents(search);
        	}
        });
        searchButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        searchButton.setBounds(148, 296, 102, 29);
        contentPane.add(searchButton);
        
        btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					AddStudent frame = new AddStudent();
					frame.setVisible(true);
				} catch (Exception eba1) {
					eba1.printStackTrace();
				}
        	}
        });
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnBack.setBounds(524, 296, 111, 29);
        contentPane.add(btnBack);


        ShowDataInTable();
	}
	
	private void ShowDataInTable() {
        String Query = "SELECT * FROM add_students";
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/student_management", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Query);

            ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();
            int colCount = metaData.getColumnCount();


            String[] columnNames = new String[colCount];
            for (int i = 1; i <= colCount; i++) {
                columnNames[i - 1] = metaData.getColumnName(i);
            }

            DefaultTableModel model = (DefaultTableModel) table_1.getModel();
            model.setColumnIdentifiers(columnNames);

            while (rs.next()) {
                Object[] rowData = new Object[colCount];
                for (int i = 1; i <= colCount; i++) {
                    rowData[i - 1] = rs.getObject(i);
                }
                model.addRow(rowData);
            }

            rs.close();
            st.close();
            con.close();
        } catch (SQLException e11) {
            e11.printStackTrace();
        }
    }
	
	private void deleteSelectedRow() {
	    DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		int selectedRowIndex = table_1.getSelectedRow();
        
        if (selectedRowIndex >= 0) {
            int studentId = Integer.parseInt(table_1.getValueAt(selectedRowIndex, 0).toString());
            String Query = "DELETE FROM add_students WHERE id = ?";
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/student_management", "root", "");
                 PreparedStatement pst = con.prepareStatement(Query)) {

                pst.setInt(1, studentId);
                pst.executeUpdate();
                
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            model.removeRow(selectedRowIndex);
            
        } else {
            JOptionPane.showMessageDialog(StudentsDetail.this, "Please select a row to delete.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
        }
	}
	
	private void searchStudents(String search) {
	    DefaultTableModel model = (DefaultTableModel) table_1.getModel();
	    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
	    table_1.setRowSorter(sorter);

	    if (search.trim().length() == 0) {
	        sorter.setRowFilter(null);
	    } else {
	        try {
	            RowFilter<DefaultTableModel, Object> rf = RowFilter.regexFilter("(?i)" + search);
	            sorter.setRowFilter(rf);
	        } catch (java.util.regex.PatternSyntaxException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
}
