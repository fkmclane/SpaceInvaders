//package spaceinvaders;

import java.awt.Color;

public class Wall extends Rock {
    private int strength;

    public Wall(int s) {
        super(Color.BLACK);
        strength = s;
    }
    
    public void reduceStrength() {
        strength--;
        if(strength <= 0)
        removeSelfFromGrid();
    }
}
