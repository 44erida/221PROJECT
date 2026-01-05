package util;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hotelPlanner.*;


import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Panel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.Cursor;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JScrollPane;

public class HotelFrame extends JFrame {

	private JPanel contentPane;
	private JTextField bedsTF;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private ArrayList<Room> rooms=new ArrayList<>();
	private int roomQuantity;
	private JLabel breakfastLbl;
	private JComboBox breakfastTypes;
	private JTextArea infoHotel;
	/**
	 * Launch the application.

	/**
	 * Create the frame.
	 */
	public HotelFrame() {
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

			lblImage.setBounds(10, 10, 170, 129);
			
			JLabel lblNewLabel = new JLabel("Hotel Selection");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
			lblNewLabel.setBounds(369, 21, 196, 31);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Hotel Type");
			lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(273, 88, 85, 31);
			contentPane.add(lblNewLabel_1);
			
			
			JLabel hotelName = new JLabel("Hotel ");
			hotelName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			hotelName.setHorizontalAlignment(SwingConstants.CENTER);
			hotelName.setBounds(66, 167, 205, 16);
			contentPane.add(hotelName);
			
			JLabel lblNewLabel_6 = new JLabel("Room Quantity");
			lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			lblNewLabel_6.setBounds(23, 205, 122, 16);
			contentPane.add(lblNewLabel_6);
			
			JLabel spaOrBreakfast = new JLabel("Do you want breakfast?");
			spaOrBreakfast.setHorizontalAlignment(SwingConstants.CENTER);
			spaOrBreakfast.setBounds(97, 254, 159, 16);
			contentPane.add(spaOrBreakfast);
			
			JRadioButton yesRadio = new JRadioButton("Yes");
			yesRadio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					breakfastLbl.setEnabled(true);
					breakfastTypes.setEnabled(true);	
				}
			});
			yesRadio.setSelected(true);
			buttonGroup.add(yesRadio);
			yesRadio.setBounds(66, 282, 109, 23);
			contentPane.add(yesRadio);
			
			JRadioButton noRadio = new JRadioButton("No");
			noRadio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					breakfastLbl.setEnabled(false);
					breakfastTypes.setEnabled(false);	
				}
			});
			buttonGroup.add(noRadio);
			noRadio.setBounds(201, 282, 109, 23);
			contentPane.add(noRadio);
			
			breakfastLbl = new JLabel("Breakfast Type");
			breakfastLbl.setBounds(23, 328, 122, 16);
			contentPane.add(breakfastLbl);
			
		    breakfastTypes = new JComboBox(new String[] {"Room Service","A la Carte","Open Buffet"});
			breakfastTypes.setBounds(135, 324, 205, 27);
			contentPane.add(breakfastTypes);
			
			
		 
			
			JComboBox comboBox = new JComboBox(new String[] {"Standard","Four Star","Five Star"});
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (comboBox.getSelectedIndex()==0) {
						hotelName.setText("Hotel Sky Hill");
						spaOrBreakfast.setEnabled(false);
						yesRadio.setEnabled(false);
						noRadio.setEnabled(false);
						breakfastLbl.setEnabled(false);
						breakfastTypes.setEnabled(false);
					}
					else if (comboBox.getSelectedIndex()==1) {
						hotelName.setText("Hotel Hilton");
						spaOrBreakfast.setEnabled(true);
						yesRadio.setEnabled(true);
						noRadio.setEnabled(true);
						breakfastLbl.setEnabled(true);
						breakfastTypes.setEnabled(true);
						spaOrBreakfast.setText("Do you want breakfast?");
					}
					else {
						hotelName.setText("Hotel Calisto");
						spaOrBreakfast.setEnabled(true);
						yesRadio.setEnabled(true);
						noRadio.setEnabled(true);
						spaOrBreakfast.setText("Do you want spa?");
						breakfastLbl.setEnabled(false);
						breakfastTypes.setEnabled(false);
					}
				}
			});
			comboBox.setBounds(468, 92, 217, 27);
			contentPane.add(comboBox);
			
		
			 
			Panel roomPanel = new Panel();
			roomPanel.setBackground(new Color(255, 153, 204));
			roomPanel.setBounds(369, 190, 406, 329);
			contentPane.add(roomPanel);
			roomPanel.setLayout(null);
			
			JLabel lblNewLabel_3 = new JLabel("Type");
			lblNewLabel_3.setBounds(38, 51, 61, 16);
			roomPanel.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Number of beds");
			lblNewLabel_4.setBounds(38, 110, 112, 16);
			roomPanel.add(lblNewLabel_4);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(26, 192, 361, 118);
			roomPanel.add(scrollPane_1);
			
		
			JTextArea textArea = new JTextArea();
			scrollPane_1.setViewportView(textArea);
			
			JComboBox comboBox_1 = new JComboBox(new String[] {"Standard","Gold++","Honeymoon Suite"});
			comboBox_1.setBounds(188, 47, 178, 27);
			roomPanel.add(comboBox_1);
			
			bedsTF = new JTextField();
			bedsTF.setText("2");
			bedsTF.setBounds(188, 105, 178, 26);
			roomPanel.add(bedsTF);
			bedsTF.setColumns(10);
			
			
			JButton addBtn = new JButton("Add Room");
			addBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (bedsTF.getText().isEmpty()) {
						 textArea.setText("Please fill all necessary fields");
					}
					else {
					if(roomQuantity>0) {
					int bedNo=Integer.parseInt(bedsTF.getText());
					Room r=new Room(comboBox_1.getSelectedItem().toString(),bedNo);
				    rooms.add(r);
				    textArea.setText("");
				    textArea.setText("Room added");
				    }
					else {
						textArea.setText("Room limit reached. Room Did Not Get Added.");
					}
				 	roomQuantity-=1;
				   }
		
			}
			});
			addBtn.setBounds(38, 154, 117, 29);
			roomPanel.add(addBtn);
			

			
			JButton dispBtn = new JButton("Display Room Info");
			dispBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String roomInfo="";
					for (Room room : rooms) {
						roomInfo+=room.toString();
					}
					textArea.setText(roomInfo);
				}
			});
			dispBtn.setBounds(198, 154, 168, 29);
			roomPanel.add(dispBtn);
			
			roomPanel.setEnabled(false);
			
			JLabel lblNewLabel_2 = new JLabel("Room Type (Please select number of rooms first)");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(385, 168, 358, 16);
			contentPane.add(lblNewLabel_2);
			
			JSlider slider = new JSlider(1, 4);
			slider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					roomPanel.setEnabled(true);
					roomQuantity=slider.getValue();
				}
			});
			slider.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

			slider.setPaintTicks(true);
			slider.setPaintLabels(true);
			slider.setMajorTickSpacing(1);
			
			slider.setBounds(150, 198, 190, 44);
			contentPane.add(slider);
			
			roomQuantity=slider.getValue();
			
			JButton eventBtn = new JButton("Start planning events");
			eventBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TotalPrice.addToPrice(HotelSys.totalPriceOfAllHotels());
					EventFrame ef=new EventFrame();
					ef.setVisible(true);
					dispose();
				}
			});
			eventBtn.setBounds(369, 525, 205, 29);
			contentPane.add(eventBtn);
			
			JButton finishBtn = new JButton("Finish your planning");
			finishBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TotalPrice.addToPrice(HotelSys.totalPriceOfAllHotels());
					FinishFrame ff=new FinishFrame();
					ff.setVisible(true);
					dispose();
				}
				
			});
			finishBtn.setBounds(586, 525, 189, 29);
			contentPane.add(finishBtn);
		
			JButton addHotel = new JButton("Add");
			addHotel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Hotel h;
					if(rooms.size()==0) {
						h=null;
						infoHotel.setText("Enter room information first");
					}
					else if(comboBox.getSelectedIndex()==0) {
						h=new Hotel("Sky Hill",rooms);
						
					}
					else if(comboBox.getSelectedIndex()==1) {
						boolean bf;
						if(yesRadio.isSelected())
							bf=true;
						else
							bf=false;
						h=new FourStar("Hilton",rooms,bf,breakfastTypes.getSelectedItem().toString());
					}
					else {
						
						boolean hasSpa;
						if(yesRadio.isSelected())
							hasSpa=true;
						else
							hasSpa=false;
						h=new FiveStar("Calisto",rooms,hasSpa);
					}
				h.calculatePrice();
				HotelSys.addHot(h);
				
				infoHotel.setText(h.toString());
				  try (PrintWriter pw = new PrintWriter(new FileWriter("information.txt", true))) {
			            pw.println("Hotel information: \n"+h.toString());
			        } catch (IOException exc) {
			            exc.printStackTrace();
			        }
				  rooms.clear();
				}
				
			});
			addHotel.setBounds(23, 356, 117, 29);
			contentPane.add(addHotel);
			
			JButton clearBtn = new JButton("Clear");
			clearBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					yesRadio.setSelected(true);
					slider.setValue(2);
					comboBox.setSelectedIndex(0);
					breakfastTypes.setSelectedIndex(0);
					infoHotel.setText("");
				}
			});
			clearBtn.setBounds(201, 356, 117, 29);
			contentPane.add(clearBtn);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(23, 420, 316, 129);
			contentPane.add(scrollPane);
			
		    infoHotel = new JTextArea();
			scrollPane.setViewportView(infoHotel);
			
		
			
	}
}
