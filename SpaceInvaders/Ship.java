//package spaceinvaders

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Ship extends Actor {
	private int lives;

	public Ship(int lives) {
		this.lives = lives;
	}

	public void act() {
		if (KeyboardControl.getKey(3))
			move(Location.EAST);
		if (KeyboardControl.getKey(1))
			move(Location.WEST);
		if (KeyboardControl.getKey(4))
			fire();
	}

	public void reduceLives() {
		lives--;
		if (lives <= 0)
			removeSelfFromGrid();

		try {
			AudioControl death = new AudioControl(SpaceInvaders.class.getResourceAsStream("shipdeath.wav"));
			death.play();
		}
		catch(Exception e) {
			System.err.println("Error playing ship death sound: " + e);
		}
	}

	private void move(int direction) {
		Grid<Actor> grid = getGrid();
		if(grid == null)
			return;

		Location location =
			getLocation().getAdjacentLocation(direction);

		if(!grid.isValid(location))
			return;

		if(grid.get(location) instanceof Shot) {
			reduceLives();
			grid.get(location).removeSelfFromGrid();
			return;
		}

		moveTo(location);
	}

	private void fire() {
		Location location =
			getLocation().getAdjacentLocation(Location.NORTH);
		if (getGrid().isValid(location) && getGrid().get(location) == null) {
			Shot shot = new Shot(Location.NORTH);
			shot.putSelfInGrid(getGrid(), location);
		}

		try {
			AudioControl shot = new AudioControl(SpaceInvaders.class.getResourceAsStream("shot.wav"));
			shot.play();
		}
		catch(Exception e) {
			System.err.println("Error playing shot sound: " + e);
		}
	}
}
