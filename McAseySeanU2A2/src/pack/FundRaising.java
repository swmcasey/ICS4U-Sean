package pack;

import java.util.Scanner;

public class FundRaising {
	public static void main(String[] args){
		Scanner ask = new Scanner(System.in);
		String[][] centsRaised = new String[4][8];
		int x;
		int y;
		int z;
		while(true){
			System.out.println("Which school is doing fundraising?\n"
					+ "0 - Catholic Central\n"
					+ "1 - Holy Cross\n"
					+ "2 - John Paul II\n"
					+ "3 - Mother Teresa\n"
					+ "4 - Regina Mundi\n"
					+ "5 - St. Joeseph (sic)\n"
					+ "6 - St. Mary\n"
					+ "7 - St. Thomas Aquinas\n"
					+ "9 - EXIT");
			while(true){
				try{
					x = Integer.parseInt(ask.nextLine().trim());
					if(x==9){
						System.exit(0);
					}
					if(x==0||x==1||x==2||x==3||x==4||x==5||x==6||x==7){
						break;
					}
				} catch (NumberFormatException error) {}
				System.out.println("This input was not valid. Please try again by entering one of the integers listed instead.");
			}
			
			
			System.out.println("What is the donation amount?\n"
					+ "0 - 25 cents"
					+ "1 - 50 cents"
					+ "2 - 1 dollar"
					+ "3 - 2 dollars");
			while(true){
				try{
					y = Integer.parseInt(ask.nextLine().trim());
					if(y==0||y==1||y==2||y==3){
						break;
					}
				} catch (NumberFormatException error) {}
				System.out.println("This input was not valid. Please try again by entering one of the integers listed instead.");
			}
			
			
			System.out.println("What is the school population?");
			while(true){
				try{
					z = Integer.parseInt(ask.nextLine().trim());
					if(z>0){
						break;
					}
				} catch (NumberFormatException error) {}
				System.out.println("This input was not valid. Please try again by entering a positive integer below 2^31-1 instead.");
			}
			centsRaised[y][x] = ("" + (z*25*2^y)).substring(0,("" + (z*25*2^y)).length()-2)+"."+("" + (z*25*2^y)).substring(("" + (z*25*2^y)).length());
			System.out.println("Input entered. Here are the results:\n"
					+ "================================================================================\n"
					+ "			CathCen	Holy C	JP II	MotherT	ReginaM	St.Joe	St.Mary	St.Thom	TOTAL"
					+ "$0.25 -	"+centsRaised[y][x]+"	");
			System.out.println("Please enter your next calculation. This input can be\n"
					+ "overwritten if the same school is entered again.");
		}
	}
}
