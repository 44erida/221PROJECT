package holidayEvents;

import java.util.*;
import java.util.Arrays;
import java.util.Scanner;

public class MusicFestival extends Festival{
	private String[] musician = new String[5];
	private boolean food,drink;
	private final int extraDrink = 50,campaign=170;
	
	public MusicFestival(int duration,String date, String typeOfTicket,String[] musician, boolean food,boolean drink) {
		super(duration,date,typeOfTicket);
		this.musician=musician;
	}

	public MusicFestival() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void getInput() {
		// TODO Auto-generated method stub
		String ans;
		super.getInput();
		Scanner input = new Scanner(System.in);
		if (typeOfTicket.equalsIgnoreCase("vip"))
		{
			System.out.println("Since you chose VIP ticket, you get 1 free meal from the food stand. Do you want to get drink as well for 50TL (yes/no)? ");
			do {
				ans=input.next();
				if (!ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("no"))
					System.out.println("Wrong input. Add again: ");
				
			}while(!ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("no"));
			
			if(ans.equalsIgnoreCase("yes"))
				drink=true;
			else
				drink=false;
			
			food=true;
		}
		else if (typeOfTicket.equalsIgnoreCase("normal")) {
			System.out.println("Since you chose NORMAL ticket, you do NOT get a free meal.\n There is a campaign 'food + drink' for 170 TL. Do you want it?");
			do {
				ans=input.next();
				if (!ans.equalsIgnoreCase("yes") && !ans.equalsIgnoreCase("no"))
					System.out.println("Wrong input. Add again: ");
				
			}while(!ans.equalsIgnoreCase("yes") && !ans.equalsIgnoreCase("no"));
			
			if(ans.equalsIgnoreCase("yes")) {
				drink=true;
				food=true;}
			else {
				drink=false;
				food=false;}
			
			
		}
		input.skip("\\R");
		System.out.println("You can choose up to 5 musicians. Add names below: ");
		
		for(int i=0;i<5;i++) {
			System.out.println("Musician name: ");
			musician[i]=input.nextLine();
		}
	}

	@Override
	public String giveInformation() {
		// TODO Auto-generated method stub
		return super.giveInformation()+"\nGet ready for MUSIC festival!";
	}

	@Override
	public String toString() {
		return   "\nMusicFestival "
				+ super.toString()+"\nMusician:" + Arrays.toString(musician);
	}

	@Override
	public double calculatePrice() {
		if (typeOfTicket.equalsIgnoreCase("vip")) {
			if (drink==true) {
				return super.calculatePrice()+extraDrink;
			}
			else
				return super.calculatePrice();
		}
		else {
			if (drink==true && food==true)
				return super.calculatePrice()+campaign;
			else
				return super.calculatePrice();
		}
		
	}
	
	
	

}
