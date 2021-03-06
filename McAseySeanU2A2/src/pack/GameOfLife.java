/*
Sean McAsey
2017-10-18
Game Of Life

Includes no unoriginal code.
 */

package pack;

import java.util.Scanner;

public class GameOfLife {
	public static void main(String[] args) {
		
		//declaring variables to be used soon
		
		int x = 20; //width, height of grid -- variable and not constantly 20x20 for purposes of testing and fun
		int y = 20; //these are 20 right now as a default in case they are not changed by user
		
		String size = ""; //optional custom sizing input
		
		String output = ""; //will be used to print grid all at once, to save time and not allow the console to show an unfinished grid
		
		boolean automatic = false; //these will be checked in a loop to see whether to ask to continue,
		double n = 1;				 //or to just automatically repeat in n seconds
		
		Scanner ask = new Scanner(System.in); //the scanner for all inputs
		
		int startingCells = 0; //the amount of cells to randomly place on the board the first time
		
		
		System.out.println("Welcome to Conway's Game of Life as programmed by Sean McAsey!\n\n"
				+ "This game is an automatic simulation based on subsequent turns. Randomly placed cells on a grid are\n"
				+ "all alive (■) or dead (□). If alive, a cell will survive into the next turn if bordered by two or three living cells.\n"
				+ "Otherwise, it will die. If a cell is not alive and is surrounded by exactly three neighbours, it will come to\n"
				+ "life the in the next turn. Otherwise, it will continue to not be alive.\n"
				+ "Choose an amount of randomly-distributed cells to start with below, and then enter any input to continue to\n"
				+ "the next turn. In any input afterward, enter \"exit\" to quit the game, or enter \"automatic n\" to automatically\n"
				+ "proceed every n seconds until the program is terminated (decimals are allowed)."
				+ "\nEnter \"custom\" if you want custom grid dimensions, or anything else to proceed with a 20x20 grid.");
		
		
		size = ask.nextLine(); //ask whether sizing is custom or default
		if((size.trim()).equalsIgnoreCase("custom")){
			
			System.out.println("What dimensions would you like? Please format your input as INTEGERxINTEGER."); //request input in a certain format
			
			while(true){ //keep doing this until an acceptable outcome occurs, to accommodate any number of repeated errors
				
				try{
					
					if(size.equalsIgnoreCase("default")){ //if user changed their mind, allow default settings
						x = 20;
						y = 20;
						break; //leave, since an acceptable outcome has been reached
					}
					
					size = ask.nextLine(); //have user input size, reusing the string that asked whether to do this or not
					size = size.replaceAll(" ", ""); //remove spaces to allow something like "22 x 22" to work instead of just "22x22"
					
					if(!size.replaceAll("[0-9x]", "").trim().equals("")) { //if there's anything aside from digits and the "x" now,
						Integer.parseInt("whoopsie doodle :^)"); //trigger an error to reach the error message
					}
					
					x = Integer.parseInt(size.split("x")[0]); //make an array by splitting around each "x," of which there should be only one,
					y = Integer.parseInt(size.split("x")[1]); //and convert the elements to x and y values to form the grid
					
					if(size.split(" ").length>1){//if there is more than one x,
						Integer.parseInt("uh oh!!"); //trigger an error to reach the error message
					}
					
					break;
				} catch(NumberFormatException error){ //this triggers if numbers are too big, unacceptable characters are present, or there is more than one x
					System.out.println("The input was not valid. Enter dimensions in the format \"INTEGERxINTEGER\" or type \"default\" for 20x20 dimensions.");
				} catch(ArrayIndexOutOfBoundsException error){ //this triggers if there is no x
					System.out.println("The input was not valid. Enter dimensions in the format \"INTEGERxINTEGER\" or type \"default\" for 20x20 dimensions.");
				}
			}
		}

		
		//form cell arrays with the dimensions that have been determined by now
		boolean[][] cells = new boolean[x][y]; //main array of cells' alive-or-dead statuses
		boolean[][] cells1 = new boolean[x][y]; //duplicate array to load changes into so that each cell checks the same 
												//board, not a new one where the preceding cell has updated first
		
		
		System.out.println("How many cells would you like in this grid?"); //ask how many cells user wants randomly dispersed
		
		
		while (true) { //loop this until an acceptable outcome is reached, so that an error message can be given as many times as needed
			
			try {
				
				startingCells = Integer.parseInt(ask.nextLine()); //allow user to input an answer through console
				
				if (startingCells <= x * y && startingCells > 0) { //check that this is a positive integer
					break; //stop asking this question if it's been answered properly
				}
				
			} catch (NumberFormatException error) {} // the error message is not only in the case of a format error, so this just proceeds to the message
			
		// give error message
			System.out.println("This many cells cannot fit in the dimensions of the grid, or the input is not\n"
					+ "a positive integer. The grid only accommodates "+(x*y)+" cells. Please try again."); //x*y will result in the amount of cells elements
		}
		
		
		for (int i = 0; i < startingCells; i++) {//do this (make a random cell alive) until there are as many starting cells as requested
			
			while (true) { //repeat until a cell that was not previously alive is alive, raising the starting cell count by 1
				
				int a = (int) Math.floor(x * Math.random()); //for each dimension, choose a (pseudo)random decimal number from 0 to 1, multiply it by
				int b = (int) Math.floor(y * Math.random()); //a dimension, and floor it, to reach a random integer from 0 to the dimension minus one,
														   	//thus choosing a random element in both dimensions, so any element in the whole array
				
				if (!cells[a][b]) { //iff this random cell isn't alive already,
					cells[a][b] = true; //make it alive
					break; //a cell has been made alive; program can return to the for loop to do the next one
				}
			}
			
		}
		
		
		while (true) { //this loops for all generations until termination of the program
			
			output = "\n"; //clear output from a previous iteration of this loop if there was one, and separate it from the last output
			
			for (int i = 0; i < y; i++) { //do this for each row:
				
				output+=("\n"); //first time, add a line break for neatness, and in subsequent times allow for separating rows
				
				for (int o = 0; o < x; o++) { //do this for each cell in the row, so now every cell in the array is covered:
					
					if(cells[o][i]){ //if the cell is alive,
						output+=("■ "); //make it a dark square,
						continue; //and proceed to try the next cell
					}
					
					output+=("□ "); //make the cell a blank square, since if it were alive it wouldn't have reached this code
				}
			}
			
			System.out.print(output); //display the output in console
			
			for (int o = 0; o < y; o++) { //in each row,
				for (int i = 0; i < x; i++) { //do this for each element:
					
					int consecutiveCells = 0; //start counting consecutive cells to this one
					
					
					//if there is a living cell in a consecutive position that exists, 
					//it adds it to the total of consecutive cells.
					
					//row above, left to right
					if(i>0&&o>0&&cells[i-1][o-1]){
							consecutiveCells++;
					}
					if(i>0&&cells[i-1][o]){
							consecutiveCells++;
					}
					if(i>0&&o<(y-1)&&cells[i-1][o+1]){
							consecutiveCells++;
					}
					
					//same row, left and right
					if(o>0&&cells[i][o-1]){
							consecutiveCells++;
					}
					if(o<(y-1)&&cells[i][o+1]){
						consecutiveCells++;
					}
					

					//row below, left to right
					if(i<(x-1)&&o>0&&cells[i+1][o-1]){
							consecutiveCells++;
					}
					if(i<(x-1)&&cells[i+1][o]){
							consecutiveCells++;
					}
					if(i<(x-1)&&o<(y-1)&&cells[i+1][o+1]){
							consecutiveCells++;
					}
					
					
					
					if (cells[i][o]) { //if the cell is alive, run through the conditions for alive cells:
						
						if (!(consecutiveCells == 2 || consecutiveCells == 3)) { //if it is surrounded by 2 or 3 cells, do nothing, but if not,
							cells1[i][o] = false; //it dies
						}
						
					} else { //otherwise (if it's not alive) run through the condition for dead cells:
						
						if (consecutiveCells == 3) { //if there are exactly 3 living cells around it,
							cells1[i][o] = true; //make it be living too
						}
					}
				}
			}
			
			//make cells the exact same as cells1 without causing passing by reference
			for (int o = 0; o < y; o++) {
				for (int i = 0; i < x; i++) {
					cells[i][o] = cells1[i][o];
				}
			}
			
			
			if(!automatic){ //if user has not decided to make the program automatic yet,
				//ask them for whether to continue, automate, or terminate.
				System.out.println("\nEnter \"exit\" to terminate or \"automatic n\" to continue automatically every n seconds. Enter anything else to continue.");
				String input = ask.nextLine(); //have scanner allow them to answer
				
				if (input.equalsIgnoreCase("exit")) { //terminate if they told the program to terminate
					System.exit(0);
				}
				
				try{ //check if they told the program to be automatic, and used the correct format
					if (input.split(" ")[0].equalsIgnoreCase("automatic")&&input.split(" ").length==2) {
						n = Double.parseDouble(input.split(" ")[1]);
						automatic = true;
						ask.close();
					}
				} catch(ArrayIndexOutOfBoundsException error){} catch(NumberFormatException error){} //just assume it was an "anything else" input if the format was off--
				
				//the program will go through the loop again normally and update a generation if these options haven't told it to do anything else
				
			} else { //however, if it is automatic:
				
				try {
					Thread.sleep((long) (1000*n)); //wait the specified amount of seconds (n) by converting it to milliseconds and then to a long
				} catch (InterruptedException e) {} //this error can apparently happen so if it does it would be best to just move on
				
			}
		}
	}
}
