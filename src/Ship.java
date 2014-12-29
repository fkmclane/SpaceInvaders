import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Ship extends Invader {
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

	public void shoot() {
		reduceLives();
	}

	public void reduceLives() {
		lives--;
		if (lives <= 0)
			removeSelfFromGrid();

		try {
			new GameSound(SpaceInvaders.class.getResourceAsStream("sounds/shipdeath.au"));
		}
		catch (Exception e) {} //Ignore
	}

	public void move(int direction) {
		try {
			super.move(direction);
		}
		catch(IllegalArgumentException e) {
			//Ignore
		}
	}

	private void fire() {
		Grid<Invader> grid = getGrid();
		if (grid == null)
			return;

		for (Location location : grid.getOccupiedLocations()) {
			Invader invader = grid.get(location);
			if(invader instanceof ShipShot)
				return;
		}

		Location location = getLocation().getAdjacentLocation(Location.NORTH);
		if (!grid.isValid(location))
			return;

		Invader invader = grid.get(location);
		if (invader != null) {
			invader.shoot();
			return;
		}

		ShipShot shot = new ShipShot();
		shot.putSelfInGrid(grid, location);
	}
}
