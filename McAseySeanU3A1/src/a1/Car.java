package a1;

public class Car {
	  //variables for characteristics

	  private String carModel, carMake, carPrice;
	  private int carYear;

	  //constructors
	  public Car() {
	    carModel = "Ford";
	    carMake = "Model T";
	    carYear = 1908;
	    carPrice = "$825";
	  }

	  public Car(String model, String make, int agg, int hung) {
	    carModel = model;
	    carMake = make;
	    carYear = agg;
	    carPrice = "$"+hung;
	  }

	  //Alternate constructor
	  public Car(String model, String make) {
	    //This constructor only uses the name and breed
	    //Set the year and price to random #s

	    carModel = model;
	    carMake = make;
	    carYear = (int) (Math.random() * 37) + 1980;
	    carPrice = "$"+(((int) (Math.random() * 999))*100) ;
	  }

	  public void barkFriendly() {
	    System.out.println("Arf! Arf!");
	  }

	  public void barkAngry() {
	    System.out.println("GRR! RRRFFF!");
	  }

	  //method to display all info of the Car
	  public String toString() {
	    String output = "Model: " + carModel + "\n";
	    output += "Make: " + carMake + "\n";
	    output += "Year: " + carYear + "\n";
	    output += "Price: " + carPrice;
	    //output string is complete, return it
	    return output;
	  }
	}