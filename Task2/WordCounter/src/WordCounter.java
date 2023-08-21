import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.io.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WordCounter extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;
	private JTextField WordField;
	private JTextField charField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WordCounter frame = new WordCounter();
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
	public WordCounter() {
		setResizable(false);
		setTitle("Word Counter (Gaurav Jain)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 414, 144); // Set the bounds for the scroll pane

        contentPane.add(scrollPane);
        
        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
//		textArea.setBounds(10, 35, 205, 189);
//		contentPane.add(textArea);
		
		JButton openbtn = new JButton("Select File");
		openbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		openbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		});
		openbtn.setBounds(306, 193, 118, 23);
		contentPane.add(openbtn);
		
		JLabel lblNewLabel = new JLabel("WORD COUNTER");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(101, 11, 238, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Total Words :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 193, 91, 15);
		contentPane.add(lblNewLabel_1);
		
		WordField = new JTextField();
		WordField.setColumns(10);
		WordField.setBounds(101, 190, 109, 26);
		contentPane.add(WordField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Total Char :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 224, 91, 15);
		contentPane.add(lblNewLabel_1_1);
		
		charField = new JTextField();
		charField.setColumns(10);
		charField.setBounds(101, 220, 109, 27);
		contentPane.add(charField);
		
		JButton COUNTButton = new JButton("COUNT");
		COUNTButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String para = textArea.getText();
				String arr [] = para.split("\\s+");
				
				int count = arr.length;
				int count1 = para.replaceAll("\\s+", "").length();
				WordField.setText(String.valueOf(count));
				charField.setText(String.valueOf(count1));
			}
		});
		COUNTButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		COUNTButton.setBounds(306, 222, 118, 32);
		contentPane.add(COUNTButton);
	}
	

    private void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(this);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
                StringBuilder content = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }

                reader.close();
                textArea.setText(content.toString());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error reading file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


}
