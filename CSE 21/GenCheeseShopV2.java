package org.xtext.example.mydsl;
import java.util.Random;
import java.util.Scanner;

public class GenCheeseShopV2 {

        /*
         * Displays the intro message informing the user of various cheeses sold 
         * while populating the names and prices arrays, and initializing the
         * amounts array.
         */
        public static void intro(String[] names, double[] prices, double[] amounts) {

                // Fill-in
                //finalize the input to an int
                final int MAXCHEESE = names.length; // it makes it so that if there is an array of say 100 then it can be resetted 
                if (MAXCHEESE == 0) 
                {
                        System.out.println("We sell 0 kinds of Cheese (in 0.5 lb packages): ");
                        System.out.print("\n");
                        System.out.println("Original Subtotal:         $0.00");
                        System.out.println("Specials... ");
                        System.out.println("None                       -$0.0");
                        System.out.println("New Sub Total:              $0.00 ");
                        System.out.println("Additional 0% Discount:      -$0.0");
                        System.out.println("Final Total:                  $0.00");
                }

                else
                {
                        System.out.println("We sell " + MAXCHEESE + " kinds of Cheese (in 0.5 lb packages): ");
                        if (MAXCHEESE >= 1) {


                                names[0] = "Humboldt Fog";
                                prices[0] = 25.00;
                                System.out.println(names[0] + ": $" + prices[0] + " per pound");
                        }



                        if (MAXCHEESE >= 2) {


                                names[1] = "Red Hawk";
                                prices[1] = 40.50;
                                System.out.println(names[1] + ": $" + prices[1] + " per pound");
                        }

                        if (MAXCHEESE >= 3) {


                                names[2] = "Teleme";
                                prices[2] = 17.25;
                                System.out.println(names[2] + ": $" + prices[2] + " per pound");
                        }

                        Random ranGen = new Random(100);

                        if (MAXCHEESE >= 4) {
                        for (int i = 3; i < MAXCHEESE; i++) {
                                names[i] = "Cheese Type " + (char)('A' + i);
                                prices[i] = ranGen.nextInt(1000)/100.0;
                                amounts[i] = 0;

                                System.out.println(names[i] + ": $" + prices[i] + " per pound");
                                }
                        }

        }
        }

        /*
         * Gets the amount of each cheese the user would like to purchase and populates
         * the amounts array with the user inputs. Performs with input validation 
         * (amount >= 0 and multiple of 0.5).
         */
        public static void getAmount(Scanner sc, String[] names, double[] amounts) {
                for(int i = 0; i < names.length; i++) {
                        System.out.print("Enter the amount of type " + names[i] + " in LB: ");
                        amounts[i] = checkhalf();
                        //checkhalf is my method that sees if the user input is in increments of .5
                }

        }
        public static double checkhalf() {
                Scanner input = new Scanner(System.in);
                double amount = input.nextDouble();
                if(amount%.5 != 0 && amount >= 0) {
                        System.out.println("Invalid input. Enter a value that's multiple of 0.5: ");
                        return checkhalf();
                }
                return amount;
        }

        /*
         * Displays the itemized list of all cheeses bought or a special message if none 
         * were purchased.
         */
        public static void itemizedList(String[] names, double[] prices, double[] amounts) {
                // Fill-in
                for(int i = 0; i < names.length; i++) {
                        if(amounts[i] > 0){
                                System.out.println(amounts[i] + " LB of " + names[i] + " @ $" + prices[i] + " = $" + (amounts[i]*prices[i]));
                        }
                }
        }

        /*
         * Calculates the Original Sub Total, which is the price*amount of each 
         * cheese added together. Returns the Original Sub Total.
         */
        public static double calcSubTotal(double[] prices, double[] amounts) {
                double total = 0;
                for(int i = 0; i < prices.length; i++) {
                        total += (prices[i]*amounts[i]);
                }
                return total;
        }

        /*
         *  Calculates discounts based on special offers on Humboldt Fog and Red Hawk, 
         *  stores them in disSpecials[0] and disSpecials[1], and returns the array. 
         */
        public static double[] discountSpecials(double[] amounts, double[] prices){
                // Fix

                double[] disSpecials = new double[amounts.length];
                try {
                        if(amounts[0] >= 1) {
                                //if cheeses doesn't exist then it wont cause an error... amounts[0] amounts[1]
                                double discount = ((int)(amounts[0]/1))*.5;
                                disSpecials[0] = (discount * prices[0]);
                        }
                        if(amounts[1] >= 1.5) {
                                double discount = ((int)(amounts[1]/1.5))*.5;
                                disSpecials[1] = (discount * prices[1]);        
                        }
                        }catch(Exception e) {
                                //try catch statement tries to run the discount and catches the errors 
                        }
                return disSpecials;             
        }

        /*
         * Displays the Original Sub Total, discounts based on specials, and the New Sub 
         * Total. Returns the New Sub Total.
         */
        public static double printSubTotals(double subTotal, double[] disSpecials) {
                System.out.println("Original Sub-Total: $" + subTotal);
                System.out.println("Specials...");
                if(disSpecials[0] != 0 && disSpecials.length >= 1) {
                        System.out.println("Humboldt Fog (Buy 1 Get 1 Free): -$" + disSpecials[0]);
                        if(disSpecials.length == 1) {
                                return (double)(subTotal - disSpecials[0]);
                        }
                }
                if(disSpecials[1] != 0 && disSpecials.length >= 2) {
                        System.out.println("Red Hawk (Buy 2 Get 1 Free): -$" + disSpecials[1]);
                        return (subTotal - (disSpecials[0]+disSpecials[1]));
                }
                return 0;
        }

        /*
         * Calculates the additional discount based on the New Sub Total and displays 
         * the Final Total.
         */
        public static void printFinalTotal(double newSubTotal) {
                // Fill-in
                System.out.println("New Sub Total: $" + newSubTotal);
                if(newSubTotal >= 250) {
                        System.out.println("Additional 25% Discount: -$" + (newSubTotal*.25));
                        newSubTotal = newSubTotal*.75;
                }else if(newSubTotal >= 150) {
                        System.out.println("Additional 10% Discount: -$" + (newSubTotal*.1));
                        newSubTotal = newSubTotal*.9;
                }else {
                        System.out.println("Additional 0% Discount: -$0");
                }
                System.out.println("Final Total: $" + newSubTotal);

        }

        /*
         * Program starts here
         */
        public static void main(String[] args) {
                try {
                final int MAXCHEESE;
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the number of Cheeses for shop setup: ");
                MAXCHEESE = sc.nextInt();

                // DO NOT CHANGE ANYTHING BELOW
                String[] names = new String[MAXCHEESE];
                double[] prices = new double[MAXCHEESE];
                double[] amounts = new double[MAXCHEESE];

                intro(names, prices, amounts);

                getAmount(sc, names, amounts);

                double subTotal = calcSubTotal(prices, amounts);


                if (MAXCHEESE != 0 ) {
                        System.out.print("\nDisplay the itemized list? (1 for yes) ");
                        int display = sc.nextInt();

                        if (display == 1) {
                                itemizedList(names, prices, amounts);
                        }
                }

                double newSubTotal = printSubTotals(subTotal, discountSpecials(amounts, prices));

                printFinalTotal(newSubTotal);

                sc.close();
                }catch(Exception e) {

                }
        }
}