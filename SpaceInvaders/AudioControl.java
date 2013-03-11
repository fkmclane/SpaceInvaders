//package spaceinvaders

import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioSystem;

public class AudioControl {
	private Clip clip;

	public AudioControl(File file) {
		clip = AudioSystem.getClip();
		clip.open(AudioSystem.getAudioInputStream(Main.class.getResourceAsStream(file)));
	}

	public void play() {
		clip.start();
	}

	public void play(int position) {
		clip.setFramePosition(position);
		play();
	}

	public void loop() {
		
	}

	public void pause() {
		clip.stop();
	}
}
