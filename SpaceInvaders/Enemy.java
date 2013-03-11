//package spaceinvaders;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Enemy extends Actor {
    private int step = 0;
    private int steps;
    private double SHOT_CHANCE = 0.80;

    public Enemy(int direction, int steps) {
        setDirection(direction);
        this.steps = steps * 2;
    }

    public void act() {
        Grid<Actor> grid = getGrid();
        if(grid == null)
            return;

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

        if(!(grid.isValid(move) && grid.get(move) == null)) {
            return;
        }
        moveTo(move);

        if(Math.random() > SHOT_CHANCE && !(grid.get(getLocation().getAdjacentLocation(Location.SOUTH).getAdjacentLocation(Location.SOUTH)) instanceof Enemy)) {
            fire();
        }
    }

    private void fire() { //Fix spawning off grid
        Location location = getLocation().getAdjacentLocation(Location.SOUTH);
        if(getGrid().isValid(location) && getGrid().get(location) == null) {
            Shot shot = new Shot(Location.SOUTH);
            shot.putSelfInGrid(getGrid(), location);
        }
    }
}
