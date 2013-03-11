//package spaceinvaders;

import info.gridworld.actor.Rock;

public class Wall extends Rock {
    private int strength;

    public Wall(int strength) {
        super(null);
        this.strength = strength;
    }
    
    public void reduceStrength() {
        strength--;
        if(strength <= 0)
            removeSelfFromGrid();
    }
    
    public String getImageSuffix() {
        return Integer.toString(strength);
    }
}
