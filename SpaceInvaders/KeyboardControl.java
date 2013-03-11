//package spaceinvaders;

import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardControl<E> implements KeyListener {
	private static ArrayList<E> keys = new ArrayList();

	public static boolean getKey(E key) {
		if(keys.contains((Integer)key)) {
			keys.remove((Integer)key);
			return true;
		}
		else {
			return false;
		}
			
	}

	public static void setKey(E key) {
		keys.add(key);
	}
}
