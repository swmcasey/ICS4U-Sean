package a1;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

public class Car {
	  //variables for characteristics

	  private String carModel, carMake, carColour;
	  private int carYear, carPrice;
	  private boolean isUsed;

	  //constructors
	  public Car() {
	    carModel = "Ford";
	    carMake = "Model T";
	    carColour = "Black";
	    carYear = 1908;
	    carPrice = 825;
	    isUsed = false;
	  }

	  public Car(String make, String model, String colour, int year, int price, boolean used) {
	    carModel = model;
	    carMake = make;
	    carColour = colour;
	    carYear = year;
	    carPrice = price;
	    isUsed = used;
	  }

	  //Alternate constructor
	  public Car(String make, String model) {
	    //This constructor only uses the name and breed
	    //Set the year and price to random #s
		String[] colours = {"Red", "Orange", "Yellow", "Green", "Blue", "Purple", "White", "Black", "Brown", "Electric Turquoise"};
	    carModel = model;
	    carMake = make;
	    carColour = colours[(int) (10*Math.random())];
	    carYear = (int) (Math.random() * 67) + 1950;
	    carPrice = (int) (Math.random() * 999)*100;
	    isUsed = ThreadLocalRandom.current().nextBoolean();
	  }

	  public void barkFriendly() {
	    System.out.println("Vroom! Vroom!");
	  }

	  public void barkAngry() {
	    System.out.println("SKRRT! SKRRRRRRT!");
	  }

	  public void honk() {
	    System.out.println("HONK");
	  }
	  
	  //method to display all info of the Car
	  public String toString() {
		DecimalFormat format = new DecimalFormat("0.00");
	    String output = "Make:		" + carMake + "\n";
	    output += "Model:		" + carModel + "\n";
	    output += "Colour:		" + carColour+"\n";
	    output += "Price:		$" + format.format(carPrice)+"\n";
	    if(carYear<0){
		    output += "Year:		" + -carYear + " BCE\n";
	    } else {
	    output += "Year:		" + carYear + "\n";
	    }
	    output += "Second-hand:	";
	    if(isUsed){
	    	output+= "Yes";
	    } else {
	    	output+= "No";
	    }
	    //output string is complete, return it
	    return output;
	  }
	}