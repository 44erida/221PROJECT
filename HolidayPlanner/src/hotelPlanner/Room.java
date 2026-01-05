package hotelPlanner;
import java.util.*;

public class Room {
	private String type;
	private int beds;
	
	
	
	public Room() {
		super();
	}
	
	
	public Room(String type, int beds) {
		super();
		this.type = type;
		this.beds = beds;
	}



	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getBeds() {
		return beds;
	}
	public void setBeds(int beds) {
		this.beds = beds;
	}

	public void getInput() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter how many beds you want: ");
		beds = sc.nextInt();
		
		System.out.println("Enter which type of room you want (Standard, Gold++, Honeymoon Suite)");
		sc.nextLine();
		type = sc.nextLine();
		while(!(type.equalsIgnoreCase("Standard") || type.equalsIgnoreCase("Gold++") || type.equalsIgnoreCase("Honeymoon Suite")))
		{
			System.out.println("Invalid Room Type!! Enter again (Standard, Gold++, Honeymoon Suite)");
			type = sc.nextLine();
		}
	}

	@Override
	public String toString() {
		return  "Room Type: " + type
				+ "\nBeds: " + beds + "\n";
	}
	
	
}
