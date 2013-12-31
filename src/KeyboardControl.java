//package spaceinvaders;

import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardControl {
	private static ArrayList<Integer> keys =
		new ArrayList<Integer>();

	public static boolean getKey(int key) {
		if (keys.contains((Integer)key)) {
			keys.remove((Integer)key);

			return true;
		}
		else {
			return false;
		}

	}

	public static void addKey(int key) {
		if (!keys.contains((Integer)key))
			keys.add((Integer)key);
	}
}
