package pack;

import java.text.DecimalFormat;
import java.util.Scanner;

public class FundRaising {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);//initiate scanner to receive user input
		DecimalFormat format = new DecimalFormat("0.00"); //this can be used to force numbers into a valid dollars/cents string
		
		String[][] money = new String[4][8]; //array of string values for money in each school
		for (int i = 0; i < 4; i++) {
			for (int o = 0; o < 8; o++) {
				money[i][o] = "0.00"; //setting default values for $0
			}
		}
		
		int x;
		int y;
		int z;
		
		Double[] totals = new Double[4]; //used to sum grand total by taking totals of $0.25 donations, $0.50 donations, etc
		
		while (true) {
			System.out.println("Which school is doing fundraising?\n" + "0 - Catholic Central\n" + "1 - Holy Cross\n"
					+ "2 - John Paul II\n" + "3 - Mother Teresa\n" + "4 - Regina Mundi\n" + "5 - St. Joeseph (sic)\n"
					+ "6 - St. Mary\n" + "7 - St. Thomas Aquinas\n" + "9 - EXIT");
			while (true) {
				try {
					x = Integer.parseInt(scanner.nextLine().trim());
					if (x == 9) {
						System.exit(0);
					}
					if (x == 0 || x == 1 || x == 2 || x == 3 || x == 4 || x == 5 || x == 6 || x == 7) {
						break;
					}
				} catch (NumberFormatException error) {
				}
				System.out.println(
						"This input was not valid. Please try again by entering one of the integers listed instead.");
			}

			System.out.println("What is the donation amount?\n" + "0 - 25 cents\n" + "1 - 50 cents\n" + "2 - 1 dollar\n"
					+ "3 - 2 dollars");
			while (true) {
				try {
					y = Integer.parseInt(scanner.nextLine().trim());
					if (y == 0 || y == 1 || y == 2 || y == 3) {
						break;
					}
				} catch (NumberFormatException error) {
				}
				System.out.println(
						"This input was not valid. Please try again by entering one of the integers listed instead.");
			}

			System.out.println("What is the school population?");
			while (true) {
				try {
					z = Integer.parseInt(scanner.nextLine().trim());
					if (z > 0) {
						break;
					}
				} catch (NumberFormatException error) {
				}
				System.out.println(
						"This input was not valid. Please try again by entering a positive integer below 2^31-1 instead.");
			}
			money[y][x] = format.format(z * 0.25 * Math.pow(2, y));
			System.out.println("Input entered. Here are the results:\n"
					+ "================================================================================\n");
			String[] schools = { "	CathCen", "Holy C", "JP II", "MotherT", "ReginaM", "St.Joe", "St.Mary", "St.Thom" };

			boolean[][] tabLocations = new boolean[4][8];
			boolean[] tabbedLines = new boolean[4];
			
			for (int i = 0; i < 4; i++) {
				for (int o = 0; o < 8; o++) {
					if(money[i][o].length()>6){
						tabLocations[i][o] = true;
						tabbedLines[o] = true;
					}
				}
			}

			for (int i = 0; i < 8; i++) {
				System.out.print(schools[i]);
				System.out.print("	");
				if(tabLocations[0][i]||tabLocations[1][i]||tabLocations[2][i]||tabLocations[3][i]){
					System.out.print("	");
				}
			}

			System.out.print("TOTAL");
			for (int i = 0; i < 4; i++) {
				System.out.print("\n$" + format.format(0.25 * Math.pow(2, i)) + " - ");
				for (int o = 0; o < 8; o++) {
						System.out.print("$"+money[i][o]);
						System.out.print("	");
						if(!tabLocations[i][o]&tabbedLines[o]){
							System.out.print("	");
					}
				}
				totals[i] = (Double.parseDouble(money[i][0]) + Double.parseDouble(money[i][1])
				+ Double.parseDouble(money[i][2]) + Double.parseDouble(money[i][3])
				+ Double.parseDouble(money[i][4]) + Double.parseDouble(money[i][5])
				+ Double.parseDouble(money[i][6]) + Double.parseDouble(money[i][7]));
				
				System.out.println("$"+format.format(totals[i]));
			}
			System.out.print("							");
			for(int i = 0; i < tabbedLines.length; i++){
				if(tabbedLines[i]){
					System.out.print("	");
				}
			}
			System.out.println("Grand total:	$"+format.format(totals[0]+totals[1]+totals[2]+totals[3]));

			System.out.println("\nWould you like to continue? (Y/N)");
			while (true) {
				String in = scanner.nextLine();
				if (in.trim().equalsIgnoreCase("N")) {
					scanner.close();
					System.exit(0);
					;
				} else if (in.trim().equalsIgnoreCase("Y")) {
					break;
				}
				System.out.println("Invalid input. Please enter Y or N.");
			}
			System.out.println("\n\nPlease enter your next calculation. This input can be\n"
					+ "overwritten if the same school is entered again.");
		}
	}
}