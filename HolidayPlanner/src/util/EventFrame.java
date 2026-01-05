package util;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import holidayEvents.CoffeeFestival;
import holidayEvents.Event;
import holidayEvents.EventSys;
import holidayEvents.Museum;
import holidayEvents.MusicFestival;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EventFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup festivalGroup = new ButtonGroup();
	private final ButtonGroup ticketTypeGroup = new ButtonGroup();
	private JTextField dateField;
	private JTextField durationField;
	private JTextField adultField;
	private JTextField childField;
	private JTextField BrandField;
	private JTextField musicianField;
	private String ticketType_1;
	private JSlider slider_Coup;
	private String[] musicians;
	private JRadioButton vip,normal,musicBtn,coffeeBtn;
	private JLabel musician,couponAmount;
	private JCheckBox foodChk,drinkChk,campaign;
	private JTextArea inpandout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventFrame frame = new EventFrame();
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
	public EventFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		ImageIcon logo = new ImageIcon(
				MainFrame.class.getResource("/Image.jpeg")
				);
		contentPane.setLayout(null);


		JLabel lblImage = new JLabel(logo);

		getContentPane().add(lblImage);

		lblImage.setBounds(606, 386, 170, 129);

		JButton finishButton = new JButton("Finish your planning");
		finishButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TotalPrice.addToPrice(EventSys.totalPriceOfAllEvents());
				FinishFrame ff=new FinishFrame();
				ff.setVisible(true);
				dispose();
			}
		});
		finishButton.setBounds(606, 526, 170, 29);
		contentPane.add(finishButton);


		contentPane.setLayout(null);

		JLabel eventTypeLabel = new JLabel("Choose your event");
		eventTypeLabel.setBounds(22, 7, 133, 35);
		contentPane.add(eventTypeLabel);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Museum ", "Festival"}));
		comboBox.setBounds(191, 10, 144, 29);
		contentPane.add(comboBox);

		JLabel typeLabel = new JLabel("Museum");
		typeLabel.setBounds(22, 45, 187, 39);
		contentPane.add(typeLabel);

		JLabel date = new JLabel("Please enter the date:");
		date.setBounds(22, 81, 187, 35);
		contentPane.add(date);

		JLabel duration = new JLabel("Please enter duration (3/6hrs):");
		duration.setBounds(22, 127, 204, 35);
		contentPane.add(duration);

		JLabel adult = new JLabel("Adult Ticket :");
		adult.setBounds(378, 91, 85, 14);
		contentPane.add(adult);

		JLabel child = new JLabel("Child Ticket:");
		child.setBounds(378, 137, 85, 14);
		contentPane.add(child);

		JLabel brand = new JLabel("Please enter brand:");
		brand.setBounds(22, 173, 187, 35);
		contentPane.add(brand);

		dateField = new JTextField();
		dateField.setBounds(238, 81, 116, 35);
		contentPane.add(dateField);
		dateField.setColumns(10);

		durationField = new JTextField();
		durationField.setBounds(238, 127, 116, 35);
		contentPane.add(durationField);
		durationField.setColumns(10);

		adultField = new JTextField();
		adultField.setBounds(492, 81, 109, 35);
		contentPane.add(adultField);
		adultField.setColumns(10);

		childField = new JTextField();
		childField.setBounds(492, 127, 109, 35);
		contentPane.add(childField);
		childField.setColumns(10);

		BrandField = new JTextField();
		BrandField.setBounds(238, 171, 116, 38);
		contentPane.add(BrandField);
		BrandField.setColumns(10);

		JLabel ticketType = new JLabel("Please Choose Your Ticket Type");
		ticketType.setBounds(22, 219, 204, 17);
		contentPane.add(ticketType);

		campaign = new JCheckBox("Campaign Food + Drink 170 TL");
		campaign.setBounds(269, 323, 267, 35);
		contentPane.add(campaign);

		vip = new JRadioButton("VIP");
		vip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(musicBtn.isSelected()) {
					campaign.setEnabled(false);
					foodChk.setEnabled(true);
					drinkChk.setEnabled(true);
				}else {
					slider_Coup.setEnabled(false);
					couponAmount.setEnabled(false);
				}
				
			}
		});


		normal = new JRadioButton("Normal");
		normal.setSelected(true);
		normal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(musicBtn.isSelected()) {
					foodChk.setEnabled(false);
					drinkChk.setEnabled(false);
					campaign.setEnabled(true);
				}
				else {
					slider_Coup.setEnabled(true);
					campaign.setEnabled(true);
					
					
				}
			}
		});

	    musicBtn = new JRadioButton("Music Festival");
	    musicBtn.setSelected(true);
		musicBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				musician.setEnabled(true);
				musicianField.setEnabled(true);
				slider_Coup.setEnabled(false);
				couponAmount.setEnabled(false);
				brand.setEnabled(false);
				BrandField.setEnabled(false);
				campaign.setEnabled(true); 
				drinkChk.setEnabled(true);
				foodChk.setEnabled(true);
				
			}
		});

	    coffeeBtn = new JRadioButton("Coffee Festival");
		coffeeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				brand.setEnabled(true);
				BrandField.setEnabled(true);
				if(normal.isSelected())
				{
				couponAmount.setEnabled(true);
				slider_Coup.setEnabled(true);
				}
				else {
				couponAmount.setEnabled(false);
				slider_Coup.setEnabled(false);
				}
				
				foodChk.setEnabled(false);
				drinkChk.setEnabled(false);
				campaign.setEnabled(false);
				musician.setEnabled(false);
				musicianField.setEnabled(false);
				
			}
		});
		coffeeBtn.setVisible(false);
		festivalGroup.add(coffeeBtn);
		coffeeBtn.setBounds(602, 9, 126, 29);
		contentPane.add(coffeeBtn);

		festivalGroup.add(musicBtn);
		musicBtn.setBounds(453, 6, 126, 35);
		contentPane.add(musicBtn);
		musicBtn.setVisible(false);

		ticketTypeGroup.add(vip);
		vip.setBounds(22, 243, 67, 23);
		contentPane.add(vip);

		ticketTypeGroup.add(normal);
		normal.setBounds(121, 243, 109, 23);
		contentPane.add(normal);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 418, 540, 129);
		contentPane.add(scrollPane);
		
		inpandout = new JTextArea();
		scrollPane.setViewportView(inpandout);

		JLabel genelLabel = new JLabel("");
		genelLabel.setBounds(22, 386, 133, 22);
		contentPane.add(genelLabel);

		musicianField = new JTextField();
		musicianField.setBounds(464, 235, 299, 58);
		contentPane.add(musicianField);
		musicianField.setColumns(10);

		musician = new JLabel("Write Your Five Musicians Here(',' in between names)");
		musician.setHorizontalAlignment(SwingConstants.CENTER);
		musician.setBounds(418, 207, 376, 14);
		contentPane.add(musician);

		foodChk = new JCheckBox("Food");
		foodChk.setBounds(269, 243, 97, 23);
		contentPane.add(foodChk);

		drinkChk = new JCheckBox("Drink");
		drinkChk.setBounds(269, 288, 97, 23);
		contentPane.add(drinkChk);

		JButton addBtn = new JButton("ADD");
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = comboBox.getSelectedIndex();
				Event e1=null;

				if(index == 0) {
					if(dateField.getText().isEmpty() || durationField.getText().isEmpty()
							|| adultField.getText().isEmpty() || childField.getText().isEmpty())
					{
						inpandout.setText("Please fill all necessary fields");

					}
					else
						e1 = new Museum(Integer.parseInt(durationField.getText()), dateField.getText(), Integer.parseInt(adultField.getText()), Integer.parseInt(childField.getText()));

				}
				else {
					
					if (vip.isSelected())
						ticketType_1="vip";
					else
						ticketType_1="normal";

					if(coffeeBtn.isSelected()) {
						if(dateField.getText().isEmpty() || durationField.getText().isEmpty()||BrandField.getText().isEmpty()) {
							inpandout.setText("Please fill necessary fields");
						}
						else {
						int couponNo;
						if(ticketType_1.equalsIgnoreCase("vip"))
							couponNo=3;
						else
							couponNo=slider_Coup.getValue();
						e1 = new CoffeeFestival(Integer.parseInt(durationField.getText()), dateField.getText(), ticketType_1, BrandField.getText(), couponNo);

						}
						}
					else if(musicBtn.isSelected()){
					if (dateField.getText().isEmpty() || durationField.getText().isEmpty()||musicianField.getText().isEmpty())
						inpandout.setText("Please fill necessary fields");
					else {
						musicians=musicianField.getText().split(",");
						if (ticketType_1.equalsIgnoreCase("vip")) {
							e1 = new MusicFestival(Integer.parseInt(durationField.getText()), dateField.getText(), ticketType_1, musicians, true, drinkChk.isSelected());
						}
						else{
							if(campaign.isSelected())
								e1 = new MusicFestival(Integer.parseInt(durationField.getText()), dateField.getText(), ticketType_1, musicians, true, true);
							else
								e1 = new MusicFestival(Integer.parseInt(durationField.getText()), dateField.getText(), ticketType_1, musicians, false, false);
						}
					}
					}
				
				
					
				}
				e1.setTicketPrice(e1.calculatePrice());
				boolean ans = EventSys.addSingleEvent(e1);
				if(ans) {
					inpandout.setText("Event Added Successfully");
				}
				else inpandout.setText("There exists such event on the same date, event not added");

				try (PrintWriter pw = new PrintWriter(new FileWriter("information.txt", true))) {
					pw.println("Event information: \n"+e1.toString()+"\n"+e1.giveInformation());
				} catch (IOException exc) {
					exc.printStackTrace();
				}

			}
		});
		addBtn.setBounds(20, 386, 89, 23);
		contentPane.add(addBtn);

		JButton dispBtn = new JButton("DISPLAY");
		dispBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inpandout.setText(EventSys.displayEvent());

			}
		});
		dispBtn.setBounds(141, 386, 89, 23);
		contentPane.add(dispBtn);

		couponAmount = new JLabel("Coupon Amount:");
		couponAmount.setBounds(82, 292, 127, 16);
		contentPane.add(couponAmount);

		slider_Coup = new JSlider();
		slider_Coup.setValue(0);
		slider_Coup.setPaintTicks(true);
		slider_Coup.setPaintLabels(true);
		slider_Coup.setMaximum(5);
		slider_Coup.setMajorTickSpacing(1);
		slider_Coup.setBounds(36, 323, 190, 45);
		contentPane.add(slider_Coup);




		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int index = comboBox.getSelectedIndex();
				festivalGroup.clearSelection();
				ticketTypeGroup.clearSelection();
				slider_Coup.setVisible(false);
				campaign.setVisible(false);
				brand.setVisible(false);

				if(index==1)
				{
					musicBtn.setVisible(true);
					coffeeBtn.setVisible(true);
					adult.setVisible(false);
					adultField.setVisible(false);
					childField.setVisible(false);
					child.setVisible(false);
					typeLabel.setText("Festival");

					ticketType.setVisible(true);
					vip.setVisible(true);
					normal.setVisible(true);
					brand.setVisible(true);
					BrandField.setVisible(true);;
					campaign.setVisible(true);
					slider_Coup.setVisible(true);
					couponAmount.setVisible(true);
					foodChk.setVisible(true);
					drinkChk.setVisible(true);
					couponAmount.setVisible(true);
					musician.setVisible(true);
					musicianField.setVisible(true);

				}
				else {

					foodChk.setVisible(false);
					drinkChk.setVisible(false);
					couponAmount.setVisible(false);
					musician.setVisible(false);
					musicianField.setVisible(false);
					vip.setVisible(false);
					normal.setVisible(false);
					typeLabel.setText("Museum");
					ticketType.setVisible(false);
					musicBtn.setVisible(false);
					coffeeBtn.setVisible(false);
					brand.setVisible(false);
					BrandField.setVisible(false);
					date.setVisible(true);
					duration.setVisible(true);
					adult.setVisible(true);
					child.setVisible(true);
					adultField.setVisible(true);
					childField.setVisible(true);


				}
			}
		});
	}
}
