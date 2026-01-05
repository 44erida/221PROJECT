package hotelPlanner;
import java.util.*;

public class FourStar extends Hotel {
	private boolean hasBreakfast;
	private String breakfastType;
	

	public FourStar() {
		BASEPRICE = 120;
		breakfastType = "Open Buffet";
		hasBreakfast = true;
	}
	

	public FourStar(String name, ArrayList<Room> roomL,boolean hasBreakfast, String breakfastType) {
		super(name,roomL);
		this.hasBreakfast = hasBreakfast;
		this.breakfastType = breakfastType;
	}


	public boolean isHasBreakfast() {
		return hasBreakfast;
	}

	public void setHasBreakfast(boolean hasBreakfast) {
		this.hasBreakfast = hasBreakfast;
	}

	public String getBreakfastType() {
		return breakfastType;
	}

	public void setBreakfastType(String breakfastType) {
		this.breakfastType = breakfastType;
	}

	public void getInput() {
		super.getInput();
		Scanner sc = new Scanner(System.in);
		
		String temp;
		
		System.out.println("Do you want Breakfast(Yes/No)?");
		temp = sc.nextLine();
		
		while(!(temp.equalsIgnoreCase("Yes") || temp.equalsIgnoreCase("No")))
		{
			System.out.println("Enter Yes or No, Do you want breakfast?");
			temp = sc.nextLine();
		}
		if(temp.equalsIgnoreCase("No")) {
			hasBreakfast = false;
		}else 
		{
			hasBreakfast = true;
			System.out.println("What type of breakfast would you like?(Room Service, A la Carte, Open Buffet)");
			breakfastType = sc.nextLine();
			while(!(breakfastType.equalsIgnoreCase("Room Service") || breakfastType.equalsIgnoreCase("A la Carte") ||
					breakfastType.equalsIgnoreCase("Open Buffet")))
			{
				System.out.println("Enter Room Service/ A la Carte/ Open Buffet, Do you want breakfast?");
				breakfastType = sc.nextLine();
			}
		}
		
		
	}
	
	public double calculatePrice() {
		if(hasBreakfast) 
		{
		if(breakfastType.equalsIgnoreCase("A la Carte"))
			return super.calculatePrice() * 1.1;
		else if(breakfastType.equalsIgnoreCase("Open Buffet"))
			return super.calculatePrice() * 1.15;
		else if(breakfastType.equalsIgnoreCase("Room Service"))
			return super.calculatePrice() * 1.20;
		}
		return super.calculatePrice();
	}
	@Override
	public String toString() {
		if(hasBreakfast)
			return super.toString() + 
				"Hotel Type: Four Star"
				+ "\nBreakfast included"
				+ "\nBreakfast Type: " + breakfastType + "\n";
		else
			return super.toString() + 
					"\nHotel Type: Four Star"
					+ "\nBreakfast not included\n";
	}
	
	
}
