//package spaceinvaders

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Ship extends Actor
{
    private int lives;
    
    public Ship(int lives)
    {
        this.lives = lives;
    }
    
    public void reduceLives()
    {
        lives--;
        if(lives <= 0)
            removeSelfFromGrid();
    }
    
    private void moveLeft()
    {
        moveTo(getLocation().getAdjacentLocation(Location.EAST));
    }
    
    private void moveRight()
    {
        moveTo(getLocation().getAdjacentLocation(Location.WEST));
    }
    
    private void fire()
    {
        Shot s = new Shot(Location.NORTH);
        s.putSelfInGrid(getGrid(), getLocation().getAdjacentLocation(Location.NORTH));
    }
    
    public void act()
    {
        
    }
}
