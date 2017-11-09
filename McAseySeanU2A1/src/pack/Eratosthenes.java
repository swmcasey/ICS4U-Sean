package pack;

import java.util.ArrayList;

public class Eratosthenes {
	public static void main(String[] args) {
		int x = 100000000; // upper bound for primes
		int total = 0;
		Boolean[] notPrime = new Boolean[x]; // declare an array to put primes
												// in

		for (int i = 0; i < notPrime.length; i++) {
			notPrime[i] = false;
		}
		notPrime[0] = true;

		for (int i = 2; i <= x / 2; i++) {
			if (!notPrime[i - 1]) {
				for (int o = 2; o <= x / i; o++) {
					notPrime[i * o - 1] = true;
				}
			}
		}
		String output = "";
		int count = 0;
		for (int i = 0; i < x; i++) {
			if (!notPrime[i]) {
				count++;
				total++;
				if (total < 30) {
					output += i + 1 + " ";
				} else {
					total = 0;
					output += i + 1 + "\n";
					System.out.println(output);
				}
			}
		}
	}
}