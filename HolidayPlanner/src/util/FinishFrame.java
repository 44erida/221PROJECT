package util;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hotelPlanner.HotelSys;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FinishFrame extends JFrame {

	private JPanel contentPane;
	private JTextField ownerTF;
	private JTextField cardTF;
	private JTextField expTF;
	private JPasswordField cvvTF;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public FinishFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		setContentPane(contentPane);
		
		ImageIcon icon = new ImageIcon(
			    MainFrame.class.getResource("/H.jpeg")
			);
			contentPane.setLayout(null);


			JLabel lblImage = new JLabel(icon);
			lblImage.setBounds(150, 18, 500, 162);

			getContentPane().add(lblImage);
			
			JLabel lblNewLabel = new JLabel("Payment ");
			lblNewLabel.setBounds(37, 208, 68, 16);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Credit Card Information");
			lblNewLabel_1.setBounds(183, 208, 180, 16);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Card Owner");
			lblNewLabel_2.setBounds(97, 249, 81, 16);
			contentPane.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Card number");
			lblNewLabel_3.setBounds(97, 294, 81, 16);
			contentPane.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Expiration date");
			lblNewLabel_4.setBounds(97, 340, 98, 16);
			contentPane.add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel("CVV");
			lblNewLabel_5.setBounds(97, 388, 61, 16);
			contentPane.add(lblNewLabel_5);
			
			ownerTF = new JTextField();
			ownerTF.setBounds(207, 244, 130, 26);
			contentPane.add(ownerTF);
			ownerTF.setColumns(10);
			
			cardTF = new JTextField();
			cardTF.setBounds(207, 289, 130, 26);
			contentPane.add(cardTF);
			cardTF.setColumns(10);
			
			expTF = new JTextField();
			expTF.setBounds(207, 335, 130, 26);
			contentPane.add(expTF);
			expTF.setColumns(10);
			
			cvvTF = new JPasswordField();
			cvvTF.setBounds(207, 383, 130, 26);
			contentPane.add(cvvTF);
			
			
			JButton downloadBtn = new JButton("Download");
			downloadBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					    try {
					        File file = new File("information.txt"); // relative to project root
					        Desktop.getDesktop().open(file);
					    } catch (IOException ex) {
					       
					    }

				}
			});
			downloadBtn.setBounds(246, 513, 117, 29);
			contentPane.add(downloadBtn);
			
			JLabel downLbl = new JLabel("Download Holiday Information");
			downLbl.setBounds(28, 518, 206, 16);
			contentPane.add(downLbl);
			downLbl.setVisible(false);
			downloadBtn.setVisible(false);
			
			JLabel lblNewLabel_8 = new JLabel("Total Price");
			lblNewLabel_8.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
			lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_8.setBounds(524, 224, 110, 41);
			contentPane.add(lblNewLabel_8);
			
			JLabel priceLbl = new JLabel(TotalPrice.returnTotal()+" TL");
			priceLbl.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			priceLbl.setHorizontalAlignment(SwingConstants.CENTER);
			priceLbl.setBounds(524, 294, 110, 21);
			contentPane.add(priceLbl);
			
			
			JButton payBtn = new JButton("Pay");
			payBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(ownerTF.getText().isEmpty()||cardTF.getText().isEmpty()||cvvTF.getPassword().length==0||expTF.getText().isEmpty()) {
						textArea.setText("Please fill all necessary fields");
					}
					else {
						LocalDate today = LocalDate.now();
						
					downLbl.setVisible(true);
					downloadBtn.setVisible(true);
					priceLbl.setText("0.00 TL");
					try (PrintWriter pw = new PrintWriter(new FileWriter("information.txt", true))) {
						pw.println("\nPayment information: ");
						pw.println(TotalPrice.returnTotal()+" TL");
						pw.println("Payed by: "+ownerTF.getText());
						pw.println("Date payed: "+today);
			            pw.println("\nWe hope you enjoy your holiday!\n Thank you for choosing us.");
			        } catch (IOException e1) {
			            e1.printStackTrace();
			        }}
				}
			});
			payBtn.setBounds(37, 453, 117, 29);
			contentPane.add(payBtn);
			
			
			
		    textArea = new JTextArea();
		    textArea.addKeyListener(new KeyAdapter() {
		    	@Override
		    	public void keyPressed(KeyEvent e) {
		    		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
		    			textArea.setText("THANK YOU FOR YOUR FEEDBACK");
		    		}
		    	}
		    });
			textArea.setBounds(400, 388, 353, 140);
			contentPane.add(textArea);
			
			JLabel feedbackLbl = new JLabel("Please Give Us FeedBack");
			feedbackLbl.setBounds(498, 360, 152, 16);
			contentPane.add(feedbackLbl);
			
			JButton cancelBtn = new JButton("Cancel");
			cancelBtn.setBackground(new Color(204, 0, 0));
			cancelBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					payBtn.setEnabled(false);
					ownerTF.setEnabled(false);
					cardTF.setEnabled(false);
					expTF.setEnabled(false);
					cvvTF.setEnabled(false);
					textArea.setText("We are sad to see you go :(");
					feedbackLbl.setVisible(false);
				}
			});
			cancelBtn.setBounds(244, 453, 117, 29);
			contentPane.add(cancelBtn);
			
			
			
			
			
	}
}
