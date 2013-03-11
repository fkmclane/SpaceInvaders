//package spaceinvaders;

import info.gridworld.actor.Rock;
import java.awt.Color;
import info.gridworld.actor.Rock;

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
