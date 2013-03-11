//package spaceinvaders

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Ship extends Actor {
    private int lives;

    public Ship(int lives) {
        this.lives = lives;
    }

    public void reduceLives() {
        lives--;
        if(lives <= 0)
            removeSelfFromGrid();
    }

    private void moveLeft() {
        Location location = getLocation().getAdjacentLocation(Location.WEST);
        if(canMove(location))
            moveTo(location);
    }

    private void moveRight() {
        Location location = getLocation().getAdjacentLocation(Location.EAST);
        if(canMove(location))
            moveTo(location);
    }

    private boolean canMove(Location location) {
        if(getGrid().isValid(location) && getGrid().get(location) == null)
            return true;
        else
            return false;
    }

    private void fire() {
        Location location = getLocation().getAdjacentLocation(Location.NORTH);
        if(getGrid().isValid(location) && getGrid().get(location) == null) {
            Shot shot = new Shot(Location.NORTH);
            shot.putSelfInGrid(getGrid(), location);
        }
    }

    public void act() {
        if(KeyboardControl.getKey(3))
            moveRight();
        if(KeyboardControl.getKey(1))
            moveLeft();
        if(KeyboardControl.getKey(4))
            fire();
    }
}
