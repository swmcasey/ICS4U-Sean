/*
Sean McAsey
2017-10-18

No unoriginal content but book titles.
 */
package pack;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
	public static void main(String[] args) {
		Scanner ask = new Scanner(System.in);
		int guesses = 7;
		int choice;
		Random random = new Random();
		int which = random.nextInt(15);
		String[] a = new String[16];

		String[] bookTitles = { "Of Mice and Men", "The Tale of Genji", "A Tale of Two Cities", "Principia Mathematica",
				"Leviticus", "The Sorrows of Young Werther", "War and Peace", "Divine Comedy", "Don Quixote",
				"Brave New World", "Murder on the Orient Express", "To Kill a Mockingbird", "Catcher in the Rye",
				"A Game of Thrones", "Ulysses", "Cabbages and Kings" };
		String[] animals = { "Wolverine", "Tortoise", "Barnacle", "Sponge", "Anemone", "Termite", "Goldfish",
				"Hippopotamus", "Wombat", "Orangutan", "Chimpanzee", "Finch", "Albatross", "Human", "Giraffe",
				"Aardvark" };
		String[] countries = { "Canada", "Kyrgyzstan", "Mauritania", "South Sudan", "Finland", "Argentina", "Palestine",
				"Uruguay", "Armenia", "Jordan", "Catalonia", "Malta", "Belarus", "Botswana", "Angola", "Cyprus" };
		System.out.println("HANGMAN\n" + "by Sean McAsey\n" + "\n"
				+ "Guess letters (case-insensitive) of the hidden word one at a time.\n"
				+ "Each letter matching a correct guess will be revealed, and you win if all letters are revealed.\n"
				+ "Seven incorrect guesses will result in a loss, which is represented by the hanged stickman.\n"
				+ "Please select a category of phrase/word from below by entering its number.\n" + "\n"
				+ "1. Book Titles\n" + "2. Animals\n" + "3. Countries\n");

		while (true) {
			try {
				choice = Integer.parseInt(ask.nextLine());
				if (choice > 0 && choice < 4) {
					break;
				}
				System.out.println("This input was invalid. Please enter 1, 2, or 3.");
			} catch (NumberFormatException error) {
				System.out.println("This input was invalid. Please enter 1, 2, or 3.");
			}
		}

		if (choice == 1) {
			a = bookTitles;
		} else if (choice == 2) {
			a = animals;
		} else if (choice == 3) {
			a = countries;
		}

		String[] truePhraseArray = new String[a[which].length()];
		for (int i = 0; i < a[which].length(); i++) {
			truePhraseArray[i] = a[which].charAt(i) + "";
		}

		String[] hangedMan = { "\n  ☻", "\n/", "|", "\\", "\n  |", "\n/", "  \\" };
		String[] blanks = new String[truePhraseArray.length];
		ArrayList<String> wrongs = new ArrayList<String>();
		wrongs.add("Nothing, yet.");

		for (int i = 0; i < truePhraseArray.length; i++) {
			if (truePhraseArray[i].equals(" ")) {
				blanks[i] = "  ";
			} else {
				blanks[i] = "_ ";
			}
		}

		boolean done = false;

		System.out.println("Guess your first letter.");
		while (guesses > 0) {
			System.out.print("\nYou have incorrectly guessed:  ");
			System.out.print(wrongs.get(0));
			for (int i = 1; i < wrongs.size(); i++) {
				System.out.print(", " + wrongs.get(i));
			}
			System.out.print("    (" + guesses + "/7 guesses remain)");
			System.out.println("");
			for (int i = 0; i < (7 - guesses); i++) {
				System.out.print(hangedMan[i]);
			}
			System.out.print("\n\n");
			for (int i = 0; i < truePhraseArray.length; i++) {
				System.out.print(blanks[i]);
			}
			System.out.println("\n");
			while (true) {
				try {
					String guess = ask.nextLine();
					if (guess.length() == 1 && ((64 < guess.charAt(0) && guess.charAt(0) < 91)
							|| (96 < guess.charAt(0) && guess.charAt(0) < 123))) {
						boolean right = false;
						for (int i = 0; i < wrongs.size(); i++) {
							if (guess.equalsIgnoreCase(wrongs.get(i))) {
								System.out.println(
										"This input was invalid. Please enter a single unaccented English letter that you have not yet chosen.");
								right = true;
								break;
							}
						}
						for (int i = 0; i < blanks.length; i++) {
							if (guess.equalsIgnoreCase(blanks[i])) {
								System.out.println(
										"This input was invalid. Please enter a single unaccented English letter that you have not yet chosen.");
								right = true;
								break;
							}
						}
						if (right) {
							continue;
						}
						for (int i = 0; i < truePhraseArray.length; i++) {
							if (guess.equalsIgnoreCase(truePhraseArray[i])) {
								blanks[i] = truePhraseArray[i];
								if (i > 0 && blanks[i - 1] != "  ") {
									blanks[i - 1] = blanks[i - 1].trim();
								}
								right = true;
							}
						}
						if (!right) {
							if (wrongs.get(0).equals("Nothing, yet.")) {
								wrongs.remove(0);
							}
							wrongs.add(guess.toLowerCase());
							guesses--;
						}
						done = true;
						for (int i = 0; i < blanks.length; i++) {
							if (!(blanks[i].trim()).equals(truePhraseArray[i].trim())) {
								done = false;
							}
						}
						if (done) {
							System.out.print(" ☻\n/|\\ \n |\n/ \\\n" + a[which]);
							if (guesses == 6) {
								System.out.println("\n\nYou win! \"" + a[which]
										+ "\" was the correct phrase. You had only one incorrect guess.");
								System.exit(0);
							}
							System.out.println("\n\nYou win! \"" + a[which] + "\" was the correct phrase. You had "
									+ (7 - guesses) + " incorrect guesses.");
							System.exit(0);
						}
						break;
					}
					System.out.println(
							"This input was invalid. Please enter a single unaccented English letter that you have not yet chosen.");
				} catch (NumberFormatException error) {
					System.out.println(
							"This input was invalid. Please enter a single unaccented English letter that you have not yet chosen.");
				}
			}
		}
		ask.close();
		for (int i = 0; i < hangedMan.length; i++) {
			System.out.print(hangedMan[i]);
		}
		System.out.print("\n\nYou lose! The correct phrase was:\n" + a[which]);
		System.exit(0);
	}
}
