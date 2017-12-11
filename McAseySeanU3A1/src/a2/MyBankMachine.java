package a2;

import java.util.Scanner;

public class MyBankMachine {

	public static void main(String[] args) {

		String b;
		double d = 0;
		int i = 0;
		boolean flag = false;
		Scanner s = new Scanner(System.in);

		System.out.println("Please enter your bank's name."); // takes any
																// string for
																// bank name,
																// only used in
																// exit
		b = s.nextLine();
		System.out.println("Please enter your initial deposit."); // take a
																	// number
																	// for the
																	// preexisting
																	// balance
		while (!flag) {
			try {
				d = Double.parseDouble(s.nextLine().trim().replaceAll("[$]", "")); // ignore
																					// dollar
																					// signs
				flag = true;
			} catch (NumberFormatException e) {
				System.out.println("Your input was not a valid number. Please try again.");
			}
		}

		ATM main = new ATM(d, b); // create a new ATM with the ATM class
		System.out.println("Welcome to the "+main.name+" ");
		
		flag = false; // refresh flag after it was used in the last loop
		while (true) {
			System.out.println("What would you like to do?\n" // prompting user
																// for an action
																// and showing
																// balance
					+ "Please enter the number of the action you would like to take.\n" + "Your current balance is: "
					+ main.getBalance() + "\n" + "1. Deposit\n" + "2. Withdraw\n" + "3. Claim interest\n" + "4. Exit");
			flag = false;
			while (!flag) {
				try {
					i = Integer.parseInt(s.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("The input was not a valid integer. Please enter 1, 2, 3, or 4.");
				}
				if (i > 0 && i < 5) {
					break;
				}
				System.out.println("This number was not 1, 2, 3 or 4. please try again with one of those numbers.");
			}

			// option 1: ask for a number to deposit, deposit it, go back to
			// menu
			if (i == 1) {
				System.out.println("How much is your deposit?");
				while (!flag) {
					try {
						d = Double.parseDouble(s.nextLine().trim().replaceAll("[$]", ""));
						if (!(d > 0)) { // disallowing negative numbers
							System.out.println(
									"Your input was not positive. Deposits and withdrawals must be positive numbers.");
							continue;
						}
						main.deposit(d);
						flag = true;
					} catch (NumberFormatException e) { // catching non-numeric
														// inputs
						System.out.println("Your input was not a valid number. Please try again.");
					}
				}
			}

			// option 2: withdrawals operated in the same way as option 1
			flag = false;
			if (i == 2) {
				if (main.balance > 0) { //however it only allows withdrawals if there is money to be withdrawn
					System.out.println("How much is your withdrawal?");
					while (!flag) {
						try {
							d = Double.parseDouble(s.nextLine().trim().replaceAll("[$]", ""));
							if (!(d > 0)) {
								System.out.println(
										"Your input was not positive. Deposits and withdrawals must be positive numbers.");
								continue;
							}
							if (d < main.balance) {
								main.withdraw(d);
							} else { //and withdrawals greater than the balance cannot be made
								System.out.println("You do not have enough money in your account to withdraw $" + d
										+ ". Please enter\n"
										+ "an amount that is less than your current balance, or 0 to return to the menu.");
							}
							flag = true;
						} catch (NumberFormatException e) {
							System.out.println("Your input was not a valid number. Please try again.");
						}
					}
				} else {
					System.out.println("You do not have enough money to make any withdrawals.");
				}
			}

			if (i == 3) { // option 3 adds interest using the function in the
							// ATM class, just asking for all of the parameters
							// here
							// using loops with try/catch and filtering bad
							// inputs as done earlier
				double y = 0, z = 0;
				int x = 0;

				System.out.println(
						"How many days long is the compounding period? Enter 0 in the case of continuously compounded interest.");
				flag = false;
				do {
					try {
						y = Double.parseDouble(s.nextLine());
						if (y < 0) {
							System.out.println("The coumpounding period cannot be negative.");
							continue;
						}
						flag = true;
					} catch (NumberFormatException error) {
						System.out.println("The input was not a valid number. Please try again.");
					}
				} while (!flag);

				flag = false;
				System.out.println("What is the annual interest rate, as a percentage?");
				do {
					try {
						z = Double.parseDouble(s.nextLine().trim().replaceAll("%", "")) / 100;
						if (z < 0) {
							System.out.println("The interest rate cannot be negative.");
							continue;
						}
						flag = true;
					} catch (NumberFormatException error) {
						System.out.println("The input was not a valid number. Please try again.");
					}
				} while (!flag);

				flag = false;
				System.out.println("For how many days is the interest being calculated?");
				do {
					try {
						x = Integer.parseInt(s.nextLine());
						if (x <= 0) {
							System.out.println(
									"The interest may not be calculated for zero or negative days. Please enter a positive number.");
							continue;
						}
						flag = true;
					} catch (NumberFormatException error) {
						System.out.println("The input was not a valid integer. Please try again.");
					}
				} while (!flag);

				// use the addInterest function to calculate the result and add
				// it to the balance
				main.addInterest(x, y, z);

			}

			if (i == 4) { // exit option
				s.close(); // close scanner
				System.out.println("Thank you for using " + main.name + ". Have a nice day!"); // goodbye
																								// message
																								// using
																								// bank
																								// name
				System.exit(0);
			}

		}

	}

}
