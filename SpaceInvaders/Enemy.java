//package spaceinvaders;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Enemy extends Actor {
    private int step = 0;
    private int steps;
    private int counter = 0;
    private int slowness;
    private double SHOT_CHANCE = 0.90;

    public Enemy(int direction, int steps, int speed) {
        setDirection(direction);
        this.steps = steps * 2;
        slowness = 5 - speed;
    }

    public void act() {
        Grid<Actor> grid = getGrid();
        if(grid == null)
            return;
        
        if(counter == slowness) {
            Location checkLocation = getLocation().getAdjacentLocation(Location.SOUTH).getAdjacentLocation(Location.SOUTH);
            System.out.println(checkLocation);
            if(Math.random() > SHOT_CHANCE && grid.isValid(checkLocation) && !(grid.get(checkLocation) instanceof Enemy)) {
                System.out.println("canFire");
                fire();
            }
        
            Location move = getLocation().getAdjacentLocation(getDirection());
            
            step++;
            if(step == steps / 2) {
                setDirection(getDirection() + Location.HALF_CIRCLE);
            }
            else if(step > steps) {
                step = 0;
                setDirection(getDirection() + Location.HALF_CIRCLE);
                move = new Location(getLocation().getRow() + 1, getLocation().getCol());
            }
            
            if(!grid.isValid(move)) {
                removeSelfFromGrid();
                return;
            }
            
            if(grid.get(move) instanceof Shot) {
                removeSelfFromGrid();
                grid.get(move).removeSelfFromGrid();
                return;
            }
            
            moveTo(move);
            
            counter = 0;
        }
        
        counter++;
    }

    private void fire() {
        Location location = getLocation().getAdjacentLocation(Location.SOUTH);
        if(getGrid().isValid(location) && getGrid().get(location) == null) {
            Shot shot = new Shot(Location.SOUTH);
            shot.putSelfInGrid(getGrid(), location);
        }
    }
}
