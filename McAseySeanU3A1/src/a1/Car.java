package a1;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

public class Car {
	// variables for characteristics

	private String carModel, carMake, carColour;
	private int carYear, carPrice;
	private boolean isUsed;

	// constructors
	public Car() { // A constructor which does not take values for anything
		carMake = "Ford";
		carModel = "Model T";
		carColour = "Black";
		carYear = 1908;
		carPrice = 825;
		isUsed = false;
	}

	public Car(String make, String model, String colour, int year, int price, boolean used) { // A constructor which takes the user's values for everything
		carModel = model;
		carMake = make;
		carColour = colour;
		carYear = year;
		carPrice = price;
		isUsed = used;
	}

	// Alternate constructor
	public Car(String make, String model) { // A constructor that randomizes everything but make and model, which the user specifies
		String[] colours = { "Red", "Orange", "Yellow", "Green", "Blue", "Purple", "White", "Black", "Brown",
				"Electric Turquoise" }; //colours that will be randomly selected from for the car's colour
		carModel = model;
		carMake = make;
		carColour = colours[(int) (10 * Math.random())];
		carYear = (int) (Math.random() * 67) + 1950;
		carPrice = ((int) (Math.random() * 999)) * 100; //The random price is cast to an int before being  multiplied so that
														//the price is divisible by 100, which is neater. This can yield
														//a number from 0 to 99900.
		isUsed = ThreadLocalRandom.current().nextBoolean();
	}

	public void barkFriendly() {
		System.out.println("The " + carColour + " " + carMake + " " + carModel + " says: \"" + "Vroom! Vroom!\"");
	}

	public void barkAngry() {
		System.out.println("The " + carColour + " " + carMake + " " + carModel + " says: \"" + "SKRRRT! SKRRRRRRT!\"");
	}

	public void honk() { //Honk function that can be called for any car
		System.out.println("The " + carColour + " " + carMake + " " + carModel + " says: \"" + "HONK\"");
	}

	// Method to display all info of the Car
	public String toString() {
		DecimalFormat format = new DecimalFormat("0.00");
		String output = "Make:		" + carMake + "\n";
		output += "Model:		" + carModel + "\n";
		output += "Colour:		" + carColour + "\n";
		output += "Price:		$" + format.format(carPrice) + "\n"; //using DecimalFormat to have a dollars/cents value
		if (carYear < 0) { //formats Car year in case it's negative
			output += "Year:		" + -carYear + " BCE\n";
		} else {
			output += "Year:		" + carYear + "\n";
		}
		output += "Second-hand:	"; //converting Boolean to yes or no
		if (isUsed) {
			output += "Yes";
		} else {
			output += "No";
		}
		// output string is complete, return it
		return output;
	}
}