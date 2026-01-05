package holidayEvents;

import java.util.Scanner;
import util.*;

public class Museum extends Event {
	private final int childTicket=20,adultTicket=35;
	private int adultNo,childNo;
	
	public Museum() {
		super();
	}
	
	

	public Museum(int duration,String date,int adultNo, int childNo) {
		super(duration,date);
		this.adultNo = adultNo;
		this.childNo = childNo;
	}





	public String giveInformation() {
		String res="";
		res="\nInformation for Museum event: \n"
				+ "The museum is a walking-distance of 10 minutes from the hotel"
				+ "\nThe group who is going to the museum will leave the hotel at 9am and come back at 7pm"
				+ "\nYou can spend a day at the museum by walking through different exhibits and learning new things. "
				+ "\nYou can look at paintings, old objects, and interactive displays.";
		
		return res;
				
	}
	
	
	
	@Override
	public void getInput() {
		// TODO Auto-generated method stub
		super.getInput();

		Scanner input=new Scanner(System.in);
		if (super.getDuration()==3) {
			
		}
		System.out.println("Enter how many adult tickets there are: ");
		adultNo=input.nextInt();
		
		System.out.println("Enter how many child tickets there are: ");
		childNo=input.nextInt();
		
	}

	@Override
	public String toString() {
		return  "Museum "
				+ super.toString()
				+"\nNumber of tickets: "+(adultNo+childNo);
	}

	@Override
	public double calculatePrice() {
		ticketPrice = adultNo*35 + childNo * 20;
		return ticketPrice;
	}

	

}
