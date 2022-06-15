package org.xtext.example.mydsl;

import java.util.Scanner;

public class CheeseShop {
	public static void main(String[] args) {
		double Humboldt, RedHawk, Teleme, list;
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("We have up to 3 options of cheese."); // establishing what there is 
		System.out.println("We have Humboldt Fog for $25.00 per pound."); // establishing what there is 
		System.out.println("Red Hawk for $40.50 per pound."); // establishing what there is 
		System.out.println("Lastely, there is Teleme for $17.25 per pound"); // establishing what there is 
		
		System.out.print("\n");
		
		
		

	System.out.println("Enter the amount of Humboldt Fog in lbs:");
	Humboldt = input.nextDouble(); 
	while (Humboldt < 0 || Humboldt % .5 != 0) 
	{ 
		if (Humboldt % 0.5 != 0) 
			System.out.println("Invalid input. Enter a value that's multiple of 0.5:"); 
		if (Humboldt < 0)  // the input can't be less than 0 
			System.out.println("Invalid Input. Enter a value >= 0:"); 
		Humboldt = input.nextDouble();
	} // re-input
	
	System.out.println("Enter the amount of Red Hawk Fog in lbs:");
	RedHawk = input.nextDouble(); 
	while (Humboldt < 0 || Humboldt % .5 != 0) { 
		if (RedHawk % 0.5 != 0)
	System.out.println("Invalid input. Enter a value that's multiple of 0.5:");
    if (RedHawk < 0) 
	System.out.println("Invalid Input. Enter a value >= 0:"); 
	RedHawk = input.nextDouble();}
	
	
	
	System.out.println("Enter the amount of Teleme Fog in lbs:");
	Teleme = input.nextDouble();
		while (Teleme < 0 || Teleme % .5 != 0) { 
			if (Teleme % 0.5 != 0)
			System.out.println("Invalid input. Enter a value that's multiple of 0.5:");
	    if (Teleme < 0) 
		System.out.println("Invalid Input. Enter a value >= 0:"); 
		Teleme = input.nextDouble();}
	    
	    // the math to get each variable 
	    double Hans = Humboldt / 0.5; 
	    int RHfree = (int) RedHawk; // since it is an int it brings the decimal down 
	    double RH = RedHawk + (RHfree*.5);
	    double HansTotal = Hans * 25.0;
	    double RHTotal = RH * 40.50;
	    double TelemeTotal = Teleme * 17.25;
	    double subtotal = TelemeTotal + RHTotal + HansTotal;
	    double DiscountH1 = 25.0 * Humboldt;
	    double DiscountH = HansTotal - DiscountH1;
	    double DiscountRH1 = 40.5 * RedHawk; 
	    double DiscountRH = RHTotal - DiscountRH1;
	    double total = subtotal - DiscountH - DiscountRH;
	    
	 
	    
	    
	    System.out.print("\n");
	    
	    
	    
	    
	    System.out.print("Display the itemized list? (1 for yes):");
	     list = input.nextDouble();
	     if (list == 1) { //  if the list wants to be shown 
				
	    	 		// this shows how much you will be buying and how much it will be 
					if (Humboldt > 0) {
	    	 		System.out.println(Hans + "lbs of Humboldt Fog @ $25.0 = $" + HansTotal); }
					if (RedHawk > 0) {
					System.out.println(RH + "lbs of RedHawk @ $40.50 = $" + RHTotal);}
					if (Teleme > 0) {
					System.out.println(Teleme + "lbs of Teleme @ $17.25 = $" + TelemeTotal);}
					
					if (Humboldt ==0) if (RedHawk == 0) if (Teleme == 0) {
						System.out.print("No items were purchased.");
					}
					
					
	     }
				 
	    
	     	System.out.print("\n");
	     	//discounts
			System.out.println("Sub Total:	$" + subtotal);
		System.out.println("Discounts...");
			if (Humboldt > 0) {
				System.out.println("Humboldt Fog (Buy 1 Get 1 Free):	-$" + DiscountH);}// how much will be taken off the total with the discounts
			
			if (RedHawk >= 1) {
				System.out.println("Red Hawk (Buy 2 Get 1 Free):	-$" + DiscountRH); // how much will be taken off the total with the discounts
			}
		   
		    
		    if (Humboldt == 0 || RedHawk == 0 ) {
		    	System.out.println ("None	-$0.0");
		    }
			
				System.out.println("Total:	$" + total); // total minus the discounts
				
			}
	}
	
