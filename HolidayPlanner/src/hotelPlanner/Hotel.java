package hotelPlanner;
import java.util.*;

import util.AccommodationPrice;


public class Hotel implements AccommodationPrice{
	protected String name;
	protected double price;
	protected int[] roomNumber=new int[4];
	protected final int HOTELSIZE = 1000; 
	protected double BASEPRICE = 750;
	protected ArrayList<Room> roomL=new ArrayList<>();
	
	
	public Hotel() {
		
		roomNumber[0] = (int)((Math.random() + 1) * HOTELSIZE);
		for(int i=1;i<4;i++) {
			roomNumber[i]=roomNumber[i-1]/10+10;
		}
		
	}
	
	
	public Hotel(String name, ArrayList<Room> roomL) {
		this();
		this.roomL = roomL;
		this.name = name;
		
	}


	

	
	public ArrayList<Room> getRoomL() {
		return roomL;
	}


	public void setRoomL(ArrayList<Room> roomL) {
		this.roomL = roomL;
	}


	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int[] getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int[] roomNumber) {
		this.roomNumber = roomNumber;
	}

	
	

	public void getInput() {
		Scanner sc = new Scanner(System.in);
		
		price = calculatePrice();
	}
	
	public double calculatePrice() {
		price=0;
		for (Room room : roomL) {
			if(room.getType().equalsIgnoreCase("Gold++"))
			{
				price+= BASEPRICE + BASEPRICE * 25/100;
			}
			else if(room.getType().equalsIgnoreCase("Honeymoon Suite"))
			{
				price+= BASEPRICE + BASEPRICE * 80/100;
			}
			else
				price += BASEPRICE;
		}
		return price;
		
	}
	@Override
	public String toString() {
		String roomStr="";
		for (Room room : roomL) {
			roomStr+=room.toString();
		}
		String roomNums="";
		for(int i=0;i<roomL.size();i++) {
			roomNums+=roomNumber[i]+" ";
		}
		return "Hotel "+name
				+ "\nPrice: " + Math.round(price * 100) /100 +" TL"
				+ "\nRoom Number(s) "+ roomNums 
				+ "\n" + roomStr;
	}
	
	
}
