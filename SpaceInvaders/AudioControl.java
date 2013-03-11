//package spaceinvaders

import javax.sound.sampled.Clip;
import javax.

public class AudioControl {
	private Clip clip;

	public AudioControl(File file) {
		clip = AudioSystem.getClip();
		clip.open(AudioSystem.getAudioInputStream(Main.class.getResourceAsStream(file)));
	}

	public play() {
		play(0);
	}

	public play(int position) {
		clip.setFramePosition(position);
		clip.start();
	}

	public loop() {
	}

	public pause() {
		clip.stop();
	}
}
