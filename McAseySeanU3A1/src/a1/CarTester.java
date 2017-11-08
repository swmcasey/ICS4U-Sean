package a1;

public class CarTester {

	public static void main(String[] args) {
	    Car Car1 = new Car("Rover", "Spaniel", 8, 4);
	    Car Car2 = new Car("Spot", "Border Collie");
	    Car Car3 = new Car();

	    //Print the details of each Car
	    System.out.println(Car1.toString());
	    System.out.println("--------------------------");

	    System.out.println(Car2.toString());
	    System.out.println("--------------------------");

	    //toString() is called by default, no need to write it!
	    System.out.println(Car3);
	    System.out.println("--------------------------");

	    //Car1 barks friendly, Car2 barks angry
	    Car1.barkFriendly();
	    Car2.barkAngry();
	  }

}
