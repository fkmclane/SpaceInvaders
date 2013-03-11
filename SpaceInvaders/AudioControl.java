//package spaceinvaders

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioControl {
	private Clip clip = AudioSystem.getClip();

	public AudioControl(String file) throws LineUnavailableException,
		UnsupportedAudioFileException, IOException {
		this(new File(file));
	}

	public AudioControl(InputStream file) throws LineUnavailableException,
		UnsupportedAudioFileException, IOException {
		clip.open(AudioSystem.getAudioInputStream(file));
	}

	public AudioControl(File file) throws LineUnavailableException,
		UnsupportedAudioFileException, IOException {
		clip.open(AudioSystem.getAudioInputStream(file));
	}

	public void play() {
		clip.start();
	}

	public void play(int position) {
		clip.setFramePosition(position);
		play();
	}

	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void pause() {
		clip.stop();
	}
}
