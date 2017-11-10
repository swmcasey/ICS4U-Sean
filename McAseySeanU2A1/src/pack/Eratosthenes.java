package pack;

public class Eratosthenes {
	public static void main(String[] args) {

		int x = 1000; // upper bound for primes calculation
		Boolean[] notPrime = new Boolean[x]; // array where every number under the limit is false until shown to not be prime

		//setting every notPrime element to false to avoid a NullPointerException
		for (int i = 0; i < notPrime.length; i++) {
			notPrime[i] = false;
		}
		
		notPrime[0] = true; //because 1, the first number (0 in array) is not prime

		//This section multiplies each prime integer by each integer coefficient such that the product
		//is not greater than the highest number, and marks all of these products as not prime numbers
		for (int i = 2; i <= Math.sqrt(x); i++) {
			if (!notPrime[i - 1]) {
				for (int o = 2; o <= x / i; o++) {
					notPrime[i * o - 1] = true;
				}
			}
		}

		//variables for next chunk of code
		String output = "";
		Boolean last = false;
		int count = 0;
		int total = 0;

		for (int i = 0; i < x; i++) {
			if (i == x - 1) {
				last = true; // The last line is printed regardless of whether the line is filled or not
			}
			if (!notPrime[i]) {
				count++;
				total++; //Each prime number found adds to the total of prime numbers
				if (count < 8) { //Numbers are ordered in lines of eight, separated by tabs
					output += i + 1 + "	";
				} else {
					count = 0;
					output += i + 1;
					if (!last) {
						System.out.println(output); //
						output = "";
					}
				}
			}
		}
		
		//conclude with total primes
		System.out.println(output + "\n\nThere are " + total + " primes less than or equal to " + x + ".");
	}
}