//package spaceinvaders;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Enemy extends Actor {
	private int step;
	private int steps;

	public Enemy(int direction, int steps) {
		setDirection(direction);
		step = 0;
		this.steps = steps * 2;
	}

	public void act() {
		Grid<Actor> grid = getGrid();
		if(grid == null)
			return;

		Location move = getLocation().getAdjacentLocation(getDirection());
		if(!(grid.isValid(move) && grid.get(move) == null)) {
			return;
		}

		step++;
		if(step == steps / 2) {
			setDirection(getDirection() + Location.HALF_CIRCLE);
			moveTo(move);
		}
		else if(step == steps) {
			step = 0;
			setDirection(getDirection() + Location.HALF_CIRCLE);
			moveTo(new Location(getLocation().getRow() + 1, getLocation().getCol()));
		}
	}
}
