
package holidayEvents;

import java.util.Scanner;

import util.*;

public abstract class Event implements AccommodationPrice{
	

	
	protected int duration;
	protected double ticketPrice;
	protected String date;
	protected static int numOfEvents=0;
	
	public Event() {
		numOfEvents++;
	}
	
	
	
	public Event(int duration, String date) {
		super();
		this.duration = duration;
		this.date = date;
	}



	public boolean checkThisEvent(String date) {
		if(this.date.equalsIgnoreCase(date))
			return true;
	return false;
	}
	
	public void getInput() {
		
		Scanner input=new Scanner(System.in);
		System.out.println("Enter duration you would prefer in hours(3/6): ");
		duration=input.nextInt();
		
	}
	public int getDuration() {
		return duration;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticket) {
		this.ticketPrice = ticket;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	public static int getNumOfEvents() {
		return numOfEvents;
	}
	
	
	public static void setNumOfEvents(int numOfEvents) {
		Event.numOfEvents = numOfEvents;
	}
	
	public abstract String giveInformation();
	
	
	
	@Override

	public String toString() {
		return "\nDate: " + date +
				"\nDuration: " + duration +" hrs"
				+ "\nTicket: " + ticketPrice +" TL"
				+ "\n\n";
	}
	
	
	
}
