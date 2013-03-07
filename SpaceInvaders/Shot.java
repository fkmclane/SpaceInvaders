//package spaceinvaders;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Shot extends Actor {
    public Shot(int direction) {
        setDirection(direction);
    }

    public void act() {
        Grid<Actor> grid = getGrid();
        if(grid == null)
            return;

        Location move = getLocation().getAdjacentLocation(getDirection());
        if(!grid.isValid(move)) {
            return;
        }
        
        if(grid.get(move) instanceof Wall) {
            Wall w = (Wall)grid.get(move);
            w.reduceStrength();
            removeSelfFromGrid();
        }
        else if(grid.get(move) != null) {
            grid.get(move).removeSelfFromGrid();
            removeSelfFromGrid();
        }
        else {
            moveTo(move);
        }
    }
}
