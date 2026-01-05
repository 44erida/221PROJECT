package holidayEvents;
import holidayEvents.MusicFestival;
import java.util.*;

public class EventSys {
	
	static Scanner input = new Scanner(System.in);
		
	private static ArrayList<Event> events = new ArrayList<>();
		
	public static void addEvent() {
		String question;
		System.out.println("Do you want to add Event? (Yes/ No)");
		question = input.next(); 
		input.skip("\\R");
		while(!(question.equalsIgnoreCase("Yes")||question.equalsIgnoreCase("No")))
		{
			System.out.println("Invalid Answer! Do you want to add Event? (Yes/ No)");
			question = input.next(); 
			input.skip("\\R");
		}
		while(question.equalsIgnoreCase("yes"))
			
		{
			String date;
			System.out.println("Please enter the date you want to attend an event: ");
			date=input.nextLine();
			
			while(EventSys.checkEvent(date)) {
				System.out.println("You already have an event for that date, enter again: ");
				date=input.nextLine();
			}
		
			String type;
			System.out.println("Please enter the type of the event(Museum,Festival):");
			type = input.nextLine();
		
			if(type.equalsIgnoreCase("museum")) {
				Museum m1 = new Museum();
				m1.setDate(date);
				m1.getInput();
				events.add(m1);
			}
			else if(type.equalsIgnoreCase("festival")) {
				String festType;
				System.out.println("Which type of festival Coffee or Music?");
				festType = input.nextLine();
				if(festType.equalsIgnoreCase("coffee")||
						festType.equalsIgnoreCase("coffee festival"))
				{
					CoffeeFestival cf1 = new CoffeeFestival();
					cf1.setDate(date);
					cf1.getInput();
					events.add(cf1);
				}
				else if(festType.equalsIgnoreCase("music")||
						festType.equalsIgnoreCase("music festival")) {
					MusicFestival mf1 = new MusicFestival();
					mf1.setDate(date);
					mf1.getInput();
					events.add(mf1);
				}
				else {
					System.out.println("Invalid type!!");
				}	
			}
			else if(type.equalsIgnoreCase("coffee")||
					type.equalsIgnoreCase("coffee festival"))
			{
				CoffeeFestival cf1 = new CoffeeFestival();
				cf1.getInput();
				events.add(cf1);
			}
			else if(type.equalsIgnoreCase("music")||
					type.equalsIgnoreCase("music festival")) {
				MusicFestival mf1 = new MusicFestival();
				mf1.getInput();
				events.add(mf1);
			}
			else {
				System.out.println("Invalid type!!!");
			}
			System.out.println("Do you want to continue to add Event?");
			question = input.next();
			input.skip("\\R");
			while(!(question.equalsIgnoreCase("Yes")||question.equalsIgnoreCase("No")))
			{
				System.out.println("Invalid Answer! Do you want to add Event? (Yes/ No)");
				question = input.next(); 
				input.skip("\\R");
			}
		}
		
	}

	
	public static String displayEvent() {
		String ans="";
		for(Event value : events) {
			ans+=("\nEvent Information\n");
			ans+=(value.giveInformation()+"\n");
			ans+=(value.toString());
			
		}
		return ans;
	}
	

	
	public static boolean checkEvent(String date) {
		for (Event event : events) {
			if(event.checkThisEvent(date))
				return true;
		}
		
		return false;
	}
	
	
	public static Event searchEvent(String date) {
		Event e=null;
		for(Event value : events) {
			if(EventSys.checkEvent(date)) {
				e=value;
			}
		}
		
		return e;
	}
	public static void removeEvent(String date) {
		Event e = searchEvent(date);
		if (e!=null) {
			System.out.println("Event "+ e.toString()+" will be removed! ");
			events.remove(e);
			Event.setNumOfEvents(Event.getNumOfEvents()-1);
		}
		else {
			System.out.println("No such event!!");
		}
	}
	//NEW METHOD
	
	public static boolean addSingleEvent(Event e) {
		if(checkEvent(e.getDate()))
			return false;
		else {
			events.add(e);
			return true;
		}
			
	}
	
	public static ArrayList<Event> getEvents() {
		return events;
	}


	public static double totalPriceOfAllEvents() {
		double total=0;
		for (Event event : events) {
			total+=event.getTicketPrice();
		}
		return total;
	}
	public static void calculateFinalTicketPrice() {
		for (Event event : events) {
			event.setTicketPrice(event.calculatePrice());
		}
	}
}
