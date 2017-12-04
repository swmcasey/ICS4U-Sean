package a1;

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
			balance = balance * Math.pow(Math.E, x/y * z); // calculates continuously compounded interest by yearly rate if compounding period is 0
		}
		balance = balance * Math.pow((1 + z * y / 365), x / y); // calculates interest compounded every y days by annual rate
	}

	public String getBalance() { // returns balance (kept as a full double for specificity with interest) as dollars/cents
		return format.format(balance);
	}

}
