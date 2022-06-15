import java.util.Scanner;

public class Cheese {

	private String name;
	private double price;
	private double amount;

	public static int numCheese = 0;
	
	public Cheese() { // Constructor with no parameters
		name = "";
		price = 0;
		amount = 0;
		numCheese++;
	}

	public Cheese(String name) { // Constructor with name as paramter
		this.name = name;
		this.price = 0;
		this.amount = 0;
		numCheese++;
	}

	public Cheese(String name, double price) { // Constructor with 2 parameters
		this.name = name;
		this.price = price;
		this.amount = 0;
		numCheese++;
	}

	public String getName() { // Accessor
		return name;
	}

	public void setName(String newName) { // Mutator 
		name = newName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double newPrice) {
		price = newPrice;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(Scanner input) {
		amount = input.nextDouble();
		if(amount % 0.5 != 0) {
			System.out.print("Invalid input. Enter a value that's multiple of 0.5: ");
			setAmount(input);
		}
		else if(amount < 0) {
			System.out.print("Invalid input. Enter a value >= 0: ");
			setAmount(input);
		}
	}

}
