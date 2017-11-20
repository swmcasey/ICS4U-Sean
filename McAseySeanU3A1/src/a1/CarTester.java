package a1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CarTester {

	public static void main(String[] args) {
		Scanner a = new Scanner(System.in);
		boolean done = false, isUsed = false, flag = false;
		String make1 = "", model1 = "", make = "", model = "", colour = "";
		int price = 0, year = 0;
		System.out.println("Please enter the make of the first car:");
		make = a.nextLine();
		System.out.println("Please enter the model of the first car:");
		model = a.nextLine();
		System.out.println("Please enter the colour of the first car:");
		colour = a.nextLine();
		System.out.println("Please enter the year of the first car:");
		do {
			try {
				year = Integer.parseInt(a.nextLine());
				flag = true;
			} catch (NumberFormatException error) {
				System.out.println("This input was not a valid integer. Please try again.");
				flag = false;
			}
		} while (!flag);
		System.out.println("Please enter the price of the first car:");
		do {
			try {
				price = Integer.parseInt(a.nextLine());
				flag = true;
			} catch (NumberFormatException error) {
				System.out.println("This input was not a valid integer. Please try again.");
				flag = false;
			}
		} while (!flag);
		System.out.println("Is the first car used? Y/N");
		do {
			String i = a.nextLine().trim();
			if (i.equalsIgnoreCase("y") || i.equalsIgnoreCase("yes") || i.equalsIgnoreCase("true")) {
				isUsed = true;
				flag = true;
			} else if (i.equalsIgnoreCase("n") || i.equalsIgnoreCase("false") || i.equalsIgnoreCase("no")) {
				isUsed = false;
				flag = true;
			} else {
				System.out.println(
						"This input was not a valid response. Please try again with the letter Y (yes) or N (no).");
			}
		} while (!flag);

		System.out.println("Please enter the make of the second car:");
		make1 = a.nextLine();
		System.out.println("Please enter the model of the second car:");
		model1 = a.nextLine();

		Car Car1 = new Car(make, model, colour, year, price, isUsed);
		Car Car2 = new Car(make1, model1);
		Car Car3 = new Car();

		// Print the details of each Car
		System.out.println(Car1.toString());
		System.out.println("--------------------------");

		System.out.println(Car2.toString());
		System.out.println("--------------------------");

		// toString() is called by default, no need to write it!
		System.out.println(Car3);
		System.out.println("--------------------------");

		// Car1 barks friendly, Car2 barks angry
		Car1.barkFriendly();
		Car2.barkAngry();
	}

}
