package hotelPlanner;

import java.util.ArrayList;
import java.util.Scanner;

public class FiveStar extends Hotel {
	private boolean hasSpa;
	private final int SPA_PRICE = 30;
	
	
	public FiveStar() {
		super();
	}
	
	
	public FiveStar(String name, ArrayList<Room> roomL, boolean hasSpa) {
		super(name, roomL);
		this.hasSpa = hasSpa;
	}


	public boolean isHasSpa() {
		return hasSpa;
	}
	public void setHasSpa(boolean hasSpa) {
		this.hasSpa = hasSpa;
	}
	
	public void getInput() {
		super.getInput();
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("Do you want spa?(Yes/No)");
		String temp = sc.nextLine();
		
		while(!(temp.equalsIgnoreCase("Yes") || temp.equalsIgnoreCase("No")))
		{
			System.out.println("Enter Yes or No, Do you want spa?");
			temp = sc.nextLine();
		}
		if(temp.equalsIgnoreCase("No")) {
			hasSpa = false;
		}else 
			hasSpa = true;
		
	}
	
	public double calculatePrice(){
		if(hasSpa)
			return super.calculatePrice() + SPA_PRICE;
		else
			return super.calculatePrice();
	}
	
	public String toString() {
		if(hasSpa)
			return super.toString() + 
					"Hotel Type: Five Star"
					 + "\nSpa Included\n";
		else
			return super.toString() + 
					"Hotel Type: Five Star"
					 + "\nSpa NOT Included\n";
	}
}
