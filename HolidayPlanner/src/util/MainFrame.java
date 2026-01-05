package util;

import java.awt.EventQueue;
import holidayEvents.*;
import hotelPlanner.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nameTxt;
	private JTextField surnameTxt;
	private JTextField bdayTxt;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon icon = new ImageIcon(
			    MainFrame.class.getResource("/H.jpeg")
			);


			JLabel lblImage = new JLabel(icon);

			getContentPane().add(lblImage);

			lblImage.setBounds(150, 30, icon.getIconWidth(), icon.getIconHeight());
			
			JLabel lblNewLabel = new JLabel("Customer Name");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lblNewLabel.setBounds(27, 295, 197, 16);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Customer Surname");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lblNewLabel_1.setBounds(302, 295, 202, 16);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Customer age");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lblNewLabel_2.setBounds(582, 291, 154, 26);
			contentPane.add(lblNewLabel_2);
			
			nameTxt = new JTextField();
			nameTxt.setBounds(59, 337, 130, 26);
			contentPane.add(nameTxt);
			nameTxt.setColumns(10);
			
			surnameTxt = new JTextField();
			surnameTxt.setBounds(337, 337, 130, 26);
			contentPane.add(surnameTxt);
			surnameTxt.setColumns(10);
			
			bdayTxt = new JTextField();
			bdayTxt.setBounds(596, 337, 130, 26);
			contentPane.add(bdayTxt);
			bdayTxt.setColumns(10);
			

			JLabel under18 = new JLabel("");
			under18.setHorizontalAlignment(SwingConstants.CENTER);
			under18.setBounds(235, 488, 300, 16);
			contentPane.add(under18);
			
			
			
			JLabel lblNewLabel_3 = new JLabel("City");
			lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lblNewLabel_3.setBounds(250, 430, 61, 23);
			contentPane.add(lblNewLabel_3);
			
			JComboBox comboBox = new JComboBox(new String[] {"Rome","Barcelona","Antalya","Paris","Tirana","London"});
			comboBox.setBounds(362, 431, 182, 27);
			contentPane.add(comboBox);
			
			
			
			JButton startBtn = new JButton("Start planning your holiday");
			startBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (bdayTxt.getText().isEmpty()||surnameTxt.getText().isEmpty()||nameTxt.getText().isEmpty()) {
						under18.setText("Please fill all the necessary fields");
					}
					else if (Integer.parseInt(bdayTxt.getText())<18)
						under18.setText("Customer can not be under 18");
					else {
						HotelFrame hf=new HotelFrame();
						hf.setVisible(true);
						TotalPrice p;
						try {
							  PrintWriter pw=new PrintWriter("information.txt");
							  pw.println("Name: "+nameTxt.getText());
							  pw.println("Surname: "+surnameTxt.getText());
							  pw.println("Age: "+bdayTxt.getText());
							  pw.println("City: "+ comboBox.getSelectedItem().toString());
							  pw.close();
							   
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						

					}
				}
			});
			startBtn.setBackground(new Color(102, 0, 204));
			startBtn.setBounds(235, 520, 300, 29);
			contentPane.add(startBtn);
	

			
	}
}
