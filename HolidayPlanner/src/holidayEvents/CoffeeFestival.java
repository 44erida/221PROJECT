package holidayEvents;

import java.util.Scanner;

public class CoffeeFestival extends Festival{
	private String brand;
	private int numOfCoupons;

	
	
	public CoffeeFestival() {
		super();
	}

	public CoffeeFestival(int duration,String date, String typeOfTicket,String brand, int numOfCoupons) {
		super(duration,date,typeOfTicket);
		this.brand = brand;
		this.numOfCoupons = numOfCoupons;
	}
	
	@Override
	public void getInput() {
		// TODO Auto-generated method stub
		super.getInput();
		Scanner input= new Scanner(System.in);
		if (typeOfTicket.equalsIgnoreCase("vip")) {
			System.out.println("Since you chose VIP TICKET you have 3 coupons with which you can get FREE coffee from your favorite coffee brand.");
			numOfCoupons=3;

			System.out.println("Enter the coffee brand you most like: ");
			brand=input.nextLine();
		}
		else if (typeOfTicket.equalsIgnoreCase("normal")){
			System.out.println("Since you chose NORMAL TICKET you do NOT get any free coupon. You can buy a coupon for 40 TL. How many coupons do you want to buy? ");
			numOfCoupons=input.nextInt();

			input.skip("\\R");
			System.out.println("Enter the coffee brand you most like: ");
			brand=input.nextLine();
		}
		
		
		
	}
	
	
	
	@Override
	public String giveInformation() {
		// TODO Auto-generated method stub
		return super.giveInformation()+"\nIn this festival you can buy coffee from the coffee stands\n and take part in fun competitions\n or take beautiful pictures in the photobooth\n"
				+ "\nThe stand of "+ brand +" Coffee is right near the entrance! \nEnjoy!";
	}
	@Override
	public String toString() {
		return  "\nCoffee Festival\n"+
	             super.toString()
				+ "\nBrand: " + brand;
				
	}
	@Override
	public double calculatePrice() {
		if (typeOfTicket.equalsIgnoreCase("vip"))
			return super.calculatePrice();
		else if (typeOfTicket.equalsIgnoreCase("normal")) {
			return super.calculatePrice()+numOfCoupons*40;
		}
		else
			return super.calculatePrice();
		
	}
	
	

}
