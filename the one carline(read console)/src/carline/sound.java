package carline;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

	

	public class sound {
	   public static void playError() {
	      try {
	         // specify the sound file path
	         File soundFile = new File("C:\\Users\\patel\\Downloads\\Sound recordings\\scanning_error.wav");

	         // create an AudioInputStream object
	         AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);

	         // create a Clip object and open the audio input stream
	         Clip clip = AudioSystem.getClip();
	         clip.open(audioIn);

	         // start playing the sound
	         clip.start();

	         // wait for the sound to finish playing
	         while (!clip.isRunning()) {
	            Thread.sleep(10);
	         }
	         while (clip.isRunning()) {
	            Thread.sleep(10);
	         }

	         // close the clip and audio input stream
	         clip.close();
	         audioIn.close();

	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	   public static void playScan(int num) {
		      try {
for (int i=(num+"").length()-1; i>-1; i--) {		    		 
		         // specify the sound file path
		         File soundFile = new File("C:\\Users\\patel\\Downloads\\Sound recordings\\"+(int)(num/Math.pow(10, i))%10+".wav");
		         // create an AudioInputStream object
		         AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);

		         // create a Clip object and open the audio input stream
		         Clip clip = AudioSystem.getClip();
		         clip.open(audioIn);

		         // start playing the sound
		         clip.start();

		         // wait for the sound to finish playing
		         while (!clip.isRunning()) {
		            Thread.sleep(1);
		         }
		         while (clip.isRunning()) {
		            Thread.sleep(1);
		         }

		         // close the clip and audio input stream
		         clip.close();
		         audioIn.close();}

		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		   }
		   
	   public static void playRepeated() {
		      try {
		         // specify the sound file path
		         File soundFile = new File("C:\\Users\\patel\\Downloads\\Sound recordings\\scanned_twice.wav");

		         // create an AudioInputStream object
		         AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);

		         // create a Clip object and open the audio input stream
		         Clip clip = AudioSystem.getClip();
		         clip.open(audioIn);

		         // start playing the sound
		         clip.start();

		         // wait for the sound to finish playing
		         while (!clip.isRunning()) {
		            Thread.sleep(10);
		         }
		         while (clip.isRunning()) {
		            Thread.sleep(10);
		         }

		         // close the clip and audio input stream
		         clip.close();
		         audioIn.close();

		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		   }
	   public static void main (String []args) {
		 playScan(1964284692);
	
	}}

