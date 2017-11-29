package a1;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MyBankMachine {

	public static void main(String[] args) {

		String n, b;
		double d = 0;
		int i = 0;
		boolean flag = false;
		Scanner s = new Scanner(System.in);

		System.out.println("Please enter your name.");
		n = s.nextLine();
		System.out.println("Please enter your bank's name.");
		b = s.nextLine();
		System.out.println("Please enter your initial deposit.");
		while (!flag) {
			try {
				d = Integer.parseInt(s.nextLine());
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
					+ main.getBalance() + "\n" + "1. Deposit\n" + "2. Withdraw\n" + "3. Claim interest\n");
			while (!flag) {
				try {
					i = s.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("The input was not a valid integer. Please enter 1, 2, or 3.");
				}
				if (i > 0 && i < 4) {
					break;
				}
				System.out.println("This number was not 1, 2, or 3. please try again with one of those numbers.");
			}
			if (i == 1) {
				while (!flag) {
					try {
						d = Integer.parseInt(s.nextLine());
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
					try {
						d = Integer.parseInt(s.nextLine());
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

			flag = false;
			boolean compoundingType = true;
			if (i == 3) {
				System.out.println("Is the interest compounded in periods (1) or continuously (2)?");
				while (!flag) {
					try {
						i = s.nextInt();
					} catch (InputMismatchException e) {
						System.out.println("The input was not a valid integer. Please enter 1 or 2.");
					}
					if (i!=1&&i!=2){
						System.out.println("This number was not 1 or 2. Please choose one of those numbers.");
						continue;
					}
					flag = true;
					if (i == 1) {
						compoundingType = true;
					} else {
						compoundingType = false;
					}
				}
				if(compoundingType){
					System.out.println("Is the compounding period annual (1), biannual (2), quarterly (3) or monthly (4)?");
					flag = false;
					while (!flag) {
						try {
							i = s.nextInt();
						} catch (InputMismatchException e) {
							System.out.println("The input was not a valid integer. Please enter 1, 2, 3, or 4.");
						}
						if (i<1||i>4){
							System.out.println("This number was not 1, 2, 3, or 4. Please choose one of those numbers.");
							continue;
						}
						flag = true;
					}
					System.out.println("aaaa");
					flag = false;
					while (!flag) {
						try {
							i = s.nextInt();
						} catch (InputMismatchException e) {
							System.out.println("The input was not a valid integer. Please enter 1, 2, 3, or 4.");
						}
						if (i<1||i>4){
							System.out.println("This number was not 1, 2, 3, or 4. Please choose one of those numbers.");
							continue;
						}
						flag = true;
					}
				}
			}

		}

	}

}
