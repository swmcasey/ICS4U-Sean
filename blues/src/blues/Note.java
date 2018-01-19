package blues;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class Note {
	public File soundFile;
	public AudioInputStream audioIn;
	public static Clip clip;
	public AudioFormat format;
	public Note(float y) throws IOException, UnsupportedAudioFileException, LineUnavailableException{
		soundFile = new File("a.wav");
		audioIn = AudioSystem.getAudioInputStream(soundFile);
		format = audioIn.getFormat();
		new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, y, 16, format.getChannels(), format.getChannels() * 2, 100, format.isBigEndian());
		AudioInputStream tone = AudioSystem.getAudioInputStream(format, audioIn);
		clip = AudioSystem.getClip();
		clip.open(tone);
	} 
	
	public void play(){
		clip.start();
	}
	
	
}
