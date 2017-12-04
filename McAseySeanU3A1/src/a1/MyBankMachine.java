package a1;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyBankMachine {

	public static void main(String[] args) {

		String b;
		double d = 0;
		int i = 0;
		boolean flag = false;
		Scanner s = new Scanner(System.in);

		System.out.println("Please enter your bank's name.");
		b = s.nextLine();
		System.out.println("Please enter your initial deposit.");
		while (!flag) {
			try {
				d = Double.parseDouble(s.nextLine().trim().replaceAll("[$]", ""));
				flag = true;
			} catch (NumberFormatException e) {
				System.out.println("Your input was not a valid number. Please try again.");
			}
		}

		ATM main = new ATM(d, b);

		flag = false;
		while (true) {
			System.out.println("What would you like to do?\n"
					+ "Please enter the number of the action you would like to take.\n" + "Your current balance is: $"
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
			if (i == 1) {
				while (!flag) {
					System.out.println("How much is your deposit?");
					try {
						d = Double.parseDouble(s.nextLine().trim().replaceAll("[$]", ""));
						if (!(d > 0)) {
							System.out.println(
									"Your input was not positive. Deposits and withdrawals must be positive numbers.");
							continue;
						}
						main.deposit(d);
						flag = true;
					} catch (NumberFormatException e) {
						System.out.println("Your input was not a valid number. Please try again.");
					}
				}
			}

			flag = false;
			if (i == 2) {
				while (!flag) {
					System.out.println("How much is your withdrawal?");
					try {
						d = Double.parseDouble(s.nextLine().trim().replaceAll("[$]", ""));
						;
						if (!(d > 0)) {
							System.out.println(
									"Your input was not positive. Deposits and withdrawals must be positive numbers.");
							continue;
						}
						main.withdraw(d);
						flag = true;
					} catch (NumberFormatException e) {
						System.out.println("Your input was not a valid number. Please try again.");
					}
				}
			}

			if (i == 3) {
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

				main.addInterest(x, y, z);
				
			}
			if (i == 4) {
				System.out.println("Thank you for using " + main.name + ". Have a nice day!");
				System.exit(0);
			}

		}

	}

}
