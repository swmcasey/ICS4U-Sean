package pack;

import java.util.ArrayList;

public class Eratosthenes {
	public static void main(String[] args) {
		
		ArrayList<Integer> primes = new ArrayList<Integer>(); // declare an ArrayList to put primes in
		for (int i = 1; i <= 1000; i++) {
			primes.add(i);
		}

		for (int i = 1; i < primes.size(); i++) { // for the lowest prime not yet removed or tested,
			
			for (int c = 2; c <= 1000 / primes.get(i); c++) { // multiply it by all coefficients that won't put it above half the max value and aren't 1,
			
				for (int n = 1; n < primes.size(); n++) { // and test it against every prime that's still in the list
				
					if (primes.get(n) == c * primes.get(i)) { // if the prime i multiplied by this coefficient is equal to this number, it is not prime
					
						primes.remove(n); // so it is removed
						break; // and the coefficient is no longer tested since its value was matched
					}
				}
			}
		}
		for (int i = 0; i < primes.size(); i++) {
			System.out.println(primes.get(i));
		}
	}
}