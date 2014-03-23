import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class GameSound extends Thread {
	private Clip clip;

	public GameSound(InputStream stream) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
		this(stream, false);
	}

	public GameSound(InputStream stream, boolean loop) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
		clip = AudioSystem.getClip();

		clip.open(AudioSystem.getAudioInputStream(new BufferedInputStream(stream)));
		if (loop)
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		else
			clip.start();

		start();
	}

	public void run() {
		while (clip.isRunning()) {
			try {
				Thread.sleep(100);
			}
			catch (Exception e) {} //Ignore
		}

		clip.close();
	}
}
