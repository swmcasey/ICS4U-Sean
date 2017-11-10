package pack;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Triplets {
	public static void main(String[] args) {
		// This program will use a dynamic arrays
		ArrayList<String> nouns = new ArrayList<String>();
		nouns.add("cat");
		nouns.add("dog");
		nouns.add("horse");
		nouns.add("goat");
		nouns.add("fish");
		nouns.add("frog");
		nouns.add("bird");

		ArrayList<String> verbs = new ArrayList<String>();
		verbs.add("slept upon");
		verbs.add("jumped atop");
		verbs.add("raced against");
		verbs.add("ran far from");
		verbs.add("played pranks on");
		verbs.add("conversed with");
		verbs.add("forgot of");

		ArrayList<String> verbs1 = new ArrayList<String>();
		verbs1.add("devour");
		verbs1.add("fight with");
		verbs1.add("jump over");
		verbs1.add("race with");
		verbs1.add("run into");
		verbs1.add("bamboozle");
		verbs1.add("play cards with");
		verbs1.add("elope with");

		ArrayList<String> rhymingNouns = new ArrayList<String>();
		rhymingNouns.add("mouse");
		rhymingNouns.add("blouse");
		rhymingNouns.add("grouse");
		rhymingNouns.add("house");
		rhymingNouns.add("spouse");
		rhymingNouns.add("house");
		rhymingNouns.add("louse");

		//B-section nouns for ABA form. Only used once, so no removal (and no ArrayList) is necessary.
		String[] nonRhymingNouns = { "cat", "hat", "rat", "bat", "that", "gnat" };

		//Adjectives to add a syllable to line 1. Only used once, so no removal (and no ArrayList) is necessary.
		String[] adjectives = { "tall ", "big ", "cool ", "mean ", "red ", "blue " };
		
		//Beginning to final sentence. Only used once, so no removal (and no ArrayList) is necessary.
		String[] conjunctions = { "But it then ", "And then it ", "That's why it "};

		String noun, conjunction, adjective;
		String verb1, verb2, verb3;
		String rhymingNoun1, rhymingNoun2, rhymingNoun3;
		int randomNum;

		// get a random noun from the nouns array
		// use .size() to get the # of elements
		randomNum = (int) (Math.random() * nouns.size());
		noun = nouns.get(randomNum);

		// get the first random verb from the verbs array &
		// remove from ArrayList
		randomNum = (int) (Math.random() * verbs.size());
		verb1 = verbs.get(randomNum);
		verbs.remove(randomNum);

		// get the second random verb from verbs array and remove it
		randomNum = (int) (Math.random() * verbs1.size());
		verb2 = verbs1.get(randomNum);
		verbs1.remove(randomNum);
		
		// get the final random verb from verbs array and remove it
		randomNum = (int) (Math.random() * verbs1.size());
		verb3 = verbs.get(randomNum);
		verbs.remove(randomNum);

		// get the first rhyming noun and remove it
		randomNum = (int) (Math.random() * rhymingNouns.size());
		rhymingNoun1 = rhymingNouns.get(randomNum);
		rhymingNouns.remove(randomNum);

		// get the second rhyming noun and remove it
		randomNum = (int) (Math.random() * rhymingNouns.size());
			// replace it with a non-rhyming noun or don't, at random, to switch between AAA/ABA forms
			if (ThreadLocalRandom.current().nextBoolean()) {
				rhymingNoun2 = rhymingNouns.get(randomNum);
				rhymingNouns.remove(randomNum);
			} else {
				rhymingNoun2 = nonRhymingNouns[(int) (Math.random() * nonRhymingNouns.length)];
			}

		// get the final rhyming noun
		randomNum = (int) (Math.random() * rhymingNouns.size());
		rhymingNoun3 = rhymingNouns.get(randomNum);
		
		// get the start of the last sentence
		randomNum = (int) (Math.random() * conjunctions.length);
		conjunction = conjunctions[randomNum];

		// get the adjective
		randomNum = (int) (Math.random() * adjectives.length);
		adjective = adjectives[randomNum];

		// Display the poem
		System.out.println("The " + noun + " " + verb1 + " a " + adjective + rhymingNoun1 + "\n" + "So it could " + verb2 + " a "
				+ rhymingNoun2 + "\n" + conjunction + verb3 + " a " + rhymingNoun3);
	}
}
