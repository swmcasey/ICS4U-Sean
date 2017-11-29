package a1;

import java.text.DecimalFormat;

public class ATM {

	public double balance;
	public String name;
	DecimalFormat format = new DecimalFormat("0.00");
	
	public ATM(Double x, String y) {
		balance = x;
		name = y;
	}
	
	public void deposit(Double x){
		balance = balance + x;
	}

	public void withdraw(Double x){
		balance = balance - x;
	}

	public void addInterest(int x, double y){
		balance = balance*Math.pow(Math.E, x*y);
	}

	public void addInterestDiscrete(int x, int y, double z){
		balance = balance*Math.pow((1+z), x);
	}
	
	public String getBalance(){
		return format.format(balance);
	}

}
