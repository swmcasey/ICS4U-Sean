package pack;

import java.text.DecimalFormat;
import java.util.Scanner;

public class FundRaising {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		DecimalFormat format = new DecimalFormat("0.00");
		String[][] money = new String[4][8];
		for(int i = 0;i<4;i++){
			for(int o = 0;o<8;o++){
				money[i][o] = "0.00";
			}
		}
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
					x = Integer.parseInt(scanner.nextLine().trim());
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
					+ "0 - 25 cents\n"
					+ "1 - 50 cents\n"
					+ "2 - 1 dollar\n"
					+ "3 - 2 dollars");
			while(true){
				try{
					y = Integer.parseInt(scanner.nextLine().trim());
					if(y==0||y==1||y==2||y==3){
						break;
					}
				} catch (NumberFormatException error) {}
				System.out.println("This input was not valid. Please try again by entering one of the integers listed instead.");
			}
			
			
			System.out.println("What is the school population?");
			while(true){
				try{
					z = Integer.parseInt(scanner.nextLine().trim());
					if(z>0){
						break;
					}
				} catch (NumberFormatException error) {}
				System.out.println("This input was not valid. Please try again by entering a positive integer below 2^31-1 instead.");
			}
			money[y][x] = format.format(z*0.25*Math.pow(2, y));
			System.out.println("Input entered. Here are the results:\n"
					+ "================================================================================\n"
					+ "	CathCen	Holy C	JP II	MotherT	ReginaM	St.Joe	St.Mary	St.Thom	TOTAL");
			
			
			int[] extraTabs = new int[8];
			for(int i = 0;i<8;i++){
				for(int o = 0;o<4;o++){
					if((""+money[o][i]).length()>6){
						extraTabs[i]++;
						break;
					}
				}
			}
			
			
			for(int i = 0;i<4;i++){
				System.out.print("\n$"+format.format(0.25*Math.pow(2,i))+" - ");
				for(int o = 0;o<8;o++){
					System.out.print(money[i][o]);
					for(int a = 0;a<=extraTabs[o];a++){
						System.out.print("	");
					}
				}
				System.out.println(format.format(Double.parseDouble(money[i][0])+Double.parseDouble(money[i][1])+Double.parseDouble(money[i][2])+Double.parseDouble(money[i][3])+Double.parseDouble(money[i][4])+Double.parseDouble(money[i][5])+Double.parseDouble(money[i][6])+Double.parseDouble(money[i][7])));
			}
			
			
			System.out.println("\nWould you like to continue? (Y/N)");
			while(true){
				String in = scanner.nextLine();
				if(in.trim().equalsIgnoreCase("N")){
					System.exit(0);;
				} else if(in.trim().equalsIgnoreCase("Y")){
					break;
				}
				System.out.println("Invalid input. Please enter Y or N.");
			}
			System.out.println("\n\nPlease enter your next calculation. This input can be\n"
					+ "overwritten if the same school is entered again.");
		}
	}
}

/*+money[0][0]+"	$"+money[0][1]+"	$"+money[0][2]+"	$"+money[0][3]+"	$"+money[0][4]+"	$"+money[0][5]+"	$"+money[0][6]+"	$"+money[0][7]+"	$"+(format.format(Double.parseDouble(money[0][0])+Double.parseDouble(money[0][1])+Double.parseDouble(money[0][2])+Double.parseDouble(money[0][3])+Double.parseDouble(money[0][4])+Double.parseDouble(money[0][5])+Double.parseDouble(money[0][6])+Double.parseDouble(money[0][7])))+"\n"
+ "$0.50 -	$"+money[1][0]+"	$"+money[1][1]+"	$"+money[1][2]+"	$"+money[1][3]+"	$"+money[1][4]+"	$"+money[1][5]+"	$"+money[1][6]+"	$"+money[1][7]+"	$"+(format.format(Double.parseDouble(money[1][0])+Double.parseDouble(money[1][1])+Double.parseDouble(money[1][2])+Double.parseDouble(money[1][3])+Double.parseDouble(money[1][4])+Double.parseDouble(money[1][5])+Double.parseDouble(money[1][6])+Double.parseDouble(money[1][7])))+"\n"
+ "$1.00 -	$"+money[2][0]+"	$"+money[2][1]+"	$"+money[2][2]+"	$"+money[2][3]+"	$"+money[2][4]+"	$"+money[2][5]+"	$"+money[2][6]+"	$"+money[2][7]+"	$"+(format.format(Double.parseDouble(money[2][0])+Double.parseDouble(money[2][1])+Double.parseDouble(money[2][2])+Double.parseDouble(money[2][3])+Double.parseDouble(money[2][4])+Double.parseDouble(money[2][5])+Double.parseDouble(money[2][6])+Double.parseDouble(money[2][7])))+"\n"
+ "$2.00 -	$"+money[3][0]+"	$"+money[3][1]+"	$"+money[3][2]+"	$"+money[3][3]+"	$"+money[3][4]+"	$"+money[3][5]+"	$"+money[3][6]+"	$"+money[3][7]+"	$"+(format.format(Double.parseDouble(money[3][0])+Double.parseDouble(money[3][1])+Double.parseDouble(money[3][2])+Double.parseDouble(money[3][3])+Double.parseDouble(money[3][4])+Double.parseDouble(money[3][5])+Double.parseDouble(money[3][6])+Double.parseDouble(money[3][7])))
*/