package holidayEvents;

import java.util.Scanner;

public class Festival extends Event {
	protected String typeOfTicket;
	protected double ticket=150;
	
	
	public Festival() {
		
	}
	public Festival(int duration,String date,String typeOfTicket) {
		super(duration,date);
		this.typeOfTicket=typeOfTicket;
	}

	@Override
	public void getInput() {
		// TODO Auto-generated method stub
		super.getInput();
		Scanner input=new Scanner(System.in);
		System.out.println("Choose type of ticket (VIP (+100TL), NORMAL): ");
		typeOfTicket=input.next();
		while (!(typeOfTicket.equalsIgnoreCase("normal")||typeOfTicket.equalsIgnoreCase("vip"))) {
			System.out.println("WRONG TICKET TYPE\nChoose type of ticket (VIP (+100TL), NORMAL): ");
			typeOfTicket=input.next();
		}
		
	}

	
	
	@Override
	public double getTicketPrice() {
		// TODO Auto-generated method stub
		return super.getTicketPrice();
	}

	@Override
	public void setTicketPrice(double ticket) {
		// TODO Auto-generated method stub
		super.setTicketPrice(ticket);
	}

	public String getTypeOfTicket() {
		return typeOfTicket;
	}
	@Override
	public String giveInformation() {
		String res="";
		res="Information for Festival event: \n"
				+ "Festival can be before noon or after noon"
				+ "\nKids are NOT allowed as it can be dangerous for them and they may get lost"
				+ "\nGet ready for a lot of fun!!";
				
		
		return res;
	}

	@Override
	public String toString() {
		return super.toString() 
				+ "\nType Of Ticket:" + typeOfTicket;
	}

	@Override
	public double calculatePrice() {
		if (typeOfTicket.equalsIgnoreCase("vip"))
			return ticket+100;
		else
			return ticket;
	}

	
	
	
}
