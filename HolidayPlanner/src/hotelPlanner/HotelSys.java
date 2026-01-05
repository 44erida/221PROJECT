package hotelPlanner;

import java.util.*;

public class HotelSys {
	public static ArrayList<Hotel> hotels = new ArrayList<>();
	

	public static void addHotel() {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many hotels do you plan on staying at?");
		int cnt = sc.nextInt();
		sc.skip("\\R");
		String type;
		for(int i = 0; i < cnt; i++) {
			System.out.println("Choose Hotel "+(i+1)+": \nStandard (Sky Hill)\nFour Star (Hilton)\nFive Star (Calisto)");
			type = sc.nextLine();
			while(!(type.equalsIgnoreCase("Standard") || type.equalsIgnoreCase("Four Star") 
				 || type.equalsIgnoreCase("Five Star"))) {
				System.out.println("Hotel type must be Standard, Four Star or Five Star!\nEnter Hotel Type");
				type = sc.nextLine();
			}
			if(type.equalsIgnoreCase("Standard")) {
				Hotel hot = new Hotel();
				hot.setName("Sky Hill");
				hot.getInput();
				hotels.add(hot);
			}
			else if(type.equalsIgnoreCase("Four Star")) {
				FourStar hot = new FourStar();
				hot.setName("Hilton");
				hot.getInput();
				hotels.add(hot);
			}
			else if(type.equalsIgnoreCase("Five Star")) {
				FiveStar hot = new FiveStar();
				hot.setName("Calisto");
				hot.getInput();
				hotels.add(hot);
			}
		}
	}
	
	public static void addHot(Hotel h) {
		hotels.add(h);
	}
	
	public static double totalPriceOfAllHotels() {
		double total=0;
		for (Hotel hotel : hotels) {
			total+=hotel.getPrice();
		}
		return total;
	}
	
	public static void display() {
		for (Hotel hotel : hotels) {
			System.out.println(hotel.toString());
		}
	}
}
