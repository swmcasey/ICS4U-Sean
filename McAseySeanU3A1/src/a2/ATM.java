package a2;

import java.text.DecimalFormat;

public class ATM {

	public double balance;
	public String name;
	DecimalFormat format = new DecimalFormat("0.00");

	public ATM(Double x, String y) { // The ATM will be constructed with the balance and bank name properties
		balance = x;
		name = y;
	}

	public void deposit(Double x) { // This function deposits an amount into the bank
		balance = balance + x;
	}

	public void withdraw(Double x) { // This function removes an amount from the bank
		balance = balance - x;
	}

	public void addInterest(int x, double y, double z) {
		if (y == 0) {
			balance = balance * Math.pow(Math.E, (x/365 * z)); // calculates and adds continuously compounded interest by yearly rate
															   // if compounding period is 0 using continuous interest formula
		} else{
			balance = balance * Math.pow((1 + z * y / 365), x / y); // calculates and adds interest compounded every y days by
																	// annual rate using normal compound interest formula
		}
	}

	public String getBalance() { // returns balance (which is kept as a full double for specificity with interest) as dollars/cents
		if((format.format(balance)).equals("?")){
			return "Greater than the GDP of Earth. Please restart the program and use smaller values.";
		} else {
			return "$"+format.format(balance)+" CAD";
		}
	}

}
