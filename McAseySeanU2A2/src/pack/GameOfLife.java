package pack;

import java.util.Scanner;

public class GameOfLife {
	public static void main(String[] args) {
		int x = 20;
		int y = 20;
		int a;
		int b;
		double n = 1;
		boolean automatic = false;
		String input = "";
		String output = "";
		Scanner ask = new Scanner(System.in);
		int startingCells = 0;
		System.out.println("Welcome to Conway's Game of Life as programmed by Sean McAsey!\n\n"
				+ "This game is an automatic simulation based on subsequent turns. Randomly placed cells on a grid are\n"
				+ "all alive (■) or dead (◯). If alive, a cell will survive into the next turn if bordered by two or three living cells.\n"
				+ "Otherwise, it will die. If a cell is not alive and is surrounded by exactly three neighbours, it will come to\n"
				+ "life the in the next turn. Otherwise, it will continue to not be alive.\n"
				+ "Choose an amount of randomly-distributed cells to start with below, and then enter any input to continue to\n"
				+ "the next turn. In any input afterward, enter \"exit\" to quit the game, or enter \"automatic n\" to automatically\n"
				+ "proceed every n seconds until the program is terminated (decimals are allowed)."
				+ "\nEnter \"custom\" if you want custom grid dimensions, or anything else to proceed with a 20x20 grid.");
		String size = "";
		size = ask.nextLine();
		if((size.trim()).equalsIgnoreCase("custom")){
			System.out.println("What dimensions would you like? Please format your input as INTEGERxINTEGER.");
			while(true){
				try{
					if(size.equalsIgnoreCase("default")){
						x = 20;
						y = 20;
						break;
					}
					size = ask.nextLine();
					size = size.replaceAll("[^0-9x]", "");
					x = Integer.parseInt(size.split("x")[0]);
					y = Integer.parseInt(size.split("x")[1]);
					if(size.split(" ").length>1){
						Integer.parseInt("uh oh");
					}
					break;
				} catch(NumberFormatException error){
					System.out.println("The input was not valid. Enter dimensions in the format \"INTEGERxINTEGER\" or type \"default\" for 20x20 dimensions.");
				} catch(ArrayIndexOutOfBoundsException error){
					System.out.println("The input was not valid. Enter dimensions in the format \"INTEGERxINTEGER\" or type \"default\" for 20x20 dimensions.");
				}
			}
		}
		System.out.println("How many cells would you like in this grid?");
		boolean[][] cells = new boolean[x][y];
		boolean[][] cells1 = new boolean[x][y];
		while (true) {
			try {
				startingCells = Integer.parseInt(ask.nextLine());
				if (startingCells <= x * y && startingCells > 0) {
					break;
				}
			} catch (NumberFormatException error) {
			}
			System.out.println("This many cells cannot fit in the dimensions you've specified.\n"
					+ "The grid only accommodates "+(x*y)+" cells. Please try again.");
		}
		
		
		for (int i = 0; i < startingCells; i++) {
			while (true) {
				a = (int) Math.floor(x * Math.random());
				b = (int) Math.floor(y * Math.random());
				if (!cells[a][b]) {
					cells[a][b] = true;
					break;
				}
			}
		}
		
		
		while (true) {
			output = "\n";
			for (int i = 0; i < y; i++) {
				output+=("\n");
				for (int o = 0; o < x; o++) {
					if(cells[o][i]){
						output+=("■ ");
						continue;
					}
					output+=("◯ ");
				}
			}
			System.out.print(output);
			for (int o = 0; o < y; o++) {
				for (int i = 0; i < x; i++) {
					int consecutiveCells = 0;
					
					
					try{
						if(cells[i-1][o-1]){
							consecutiveCells++;
						}
					} catch (ArrayIndexOutOfBoundsException error){}
					try{
						if(cells[i-1][o]){
							consecutiveCells++;
						}
					} catch (ArrayIndexOutOfBoundsException error){}
					try{
						if(cells[i-1][o+1]){
							consecutiveCells++;
						}
					} catch (ArrayIndexOutOfBoundsException error){}
					
					try{
						if(cells[i][o-1]){
							consecutiveCells++;
						}
					} catch (ArrayIndexOutOfBoundsException error){}
					try{
						if(cells[i][o+1]){
						consecutiveCells++;
						}
					} catch (ArrayIndexOutOfBoundsException error){}
					
					try{
						if(cells[i+1][o-1]){
							consecutiveCells++;
						}
					} catch (ArrayIndexOutOfBoundsException error){}
					try{
						if(cells[i+1][o]){
							consecutiveCells++;
						}
					} catch (ArrayIndexOutOfBoundsException error){}
					try{
						if(cells[i+1][o+1]){
							consecutiveCells++;
						}
					} catch (ArrayIndexOutOfBoundsException error){}
					
					
					
					if (cells[i][o]) {
						if (consecutiveCells == 2 || consecutiveCells == 3) {
							cells1[i][o] = true;
						} else {
							cells1[i][o] = false;
						}
					}
					
					if (!cells[i][o]) {
						if (consecutiveCells == 3) {
							cells1[i][o] = true;
						}
					}
				}
			}
			for (int o = 0; o < y; o++) {
				for (int i = 0; i < x; i++) {
					cells[i][o] = cells1[i][o];
				}
			}
			if(!automatic){
				System.out.println("\nEnter \"exit\" to terminate or \"automatic n\" to continue automatically every n seconds. Enter anything else to continue.");
				input = ask.nextLine();
				if (input.equalsIgnoreCase("exit")) {
					System.exit(0);
				}
				try{
					if (input.split(" ")[0].equalsIgnoreCase("automatic")&&input.split(" ").length==2) {
						n = Double.parseDouble(input.split(" ")[1]);
						automatic = true;
					}
				} catch(ArrayIndexOutOfBoundsException error){} catch(NumberFormatException e){}
			} else {
				try {
					Thread.sleep((long) (1000*n));
				} catch (InterruptedException e) {}
			}
		}
	}
}
