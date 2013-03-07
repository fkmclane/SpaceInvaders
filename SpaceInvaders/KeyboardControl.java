//package spaceinvaders;

import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardControl implements KeyListener {
	private static ArrayList<Integer> keys = new ArrayList();

	public static boolean getKey(int key) {
		if(keys.contains((Integer)key)) {
			keys.remove((Integer)key);
			return true;
		}
		else {
			return false;
		}
			
	}
	
	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		if(!keys.contains((Integer)e.getKeyCode()))
			keys.add((Integer)e.getKeyCode());
	}

	public void keyReleased(KeyEvent e) {
		
	}
}
