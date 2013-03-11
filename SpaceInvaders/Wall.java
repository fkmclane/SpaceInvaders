//package spaceinvaders;

import java.awt.Color;
import info.gridworld.actor.Rock;

public class Wall extends Rock {
    private int strength;

    public Wall(int strength) {
        super(Color.BLACK);
        this.strength = strength;
    }
    
    public void reduceStrength() {
        strength--;
        if(strength <= 0)
            removeSelfFromGrid();
    }
    
    public String getImagePrefix() {
        return Integer.toString(strength);
    }
}
