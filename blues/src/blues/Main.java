package blues;

import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main {

	public static void main(String[] args) {
		
		//The program will combine random amounts of eighth notes that add up to the length of the bar.
		//Each combination of eighth notes will be a single note of that length.
		
		//The last note of the bar may be tied to the first note of the next bar (made into one note)
		//to allow syncopation, which will make it sound like a blues style. The eighth notes will be
		//read as swung eighths, meaning every 2 eighth notes, in order, are read as two thirds of a 
		//quarter note and then one third of a quarter note, rather than each being one half of it.
		
		//Each note will be played as a random pure tone belonging to an appropriate scale.
		ArrayList<Integer> measure = partition(8);
		for(int x : measure){
			System.out.println(x);
		}
		try {
			Note c = new Note(72000);
			c.play();
		} catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<Integer> partition(int x) {
		ArrayList<Integer> rhythm = new ArrayList<Integer>();
		while (x > 0) {
			int y = (int) (Math.random() * (x)) + 1;
			x -= y;
			rhythm.add(y);
		}
		return rhythm;
	}
}
