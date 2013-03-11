//package spaceinvaders;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Boss extends Actor {
	private int step;
	private int steps;

	public Boss(int direction, int steps) {
		setDirection(direction);
		step = 0;
		this.steps = steps;
	}

	public void act() {
		Grid<Actor> grid = getGrid();
		if(grid == null)
			return;

		Location move = getLocation().getAdjacentLocation(getDirection());
		if(!(grid.isValid(move) && grid.get(move) == null)) {
			return;
		}
		moveTo(move);

		step++;
		if(step == steps) {
			setDirection(getDirection() + Location.HALF_CIRCLE);
			step = 0;
		}
	}
	
	public void removeSelfFromGrid() {
        try {
            AudioControl death = new AudioControl("bossdeath.wav");
            death.play();
        }
        catch(Exception e) {
            System.err.println("Error playing boss death sound: " + e);
        }
        super.removeSelfFromGrid();
    }
}
