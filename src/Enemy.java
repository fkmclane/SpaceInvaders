import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Enemy extends Invader {
	private int direction;
	private int step = 0;
	private int totalsteps;
	private int counter = 0;
	private int slowness;
	private int animation = 0;
	private double SHOT_CHANCE = 0.90;

	public Enemy(int direction, int steps, int speed) {
		this.direction = direction;
		this.totalsteps = steps * 2;
		slowness = 5 - speed;
		if (slowness < 0)
			slowness = 0;
	}

	public void act() {
		Grid<Invader> grid = getGrid();
		if (grid == null)
			return;

		animation ^= 1;

		if (counter == slowness) {
			if (Math.random() > SHOT_CHANCE)
				fire();

			step++;

			Location move;
			if (step > totalsteps) {
				move(Location.SOUTH);

				step = 0;
				direction += Location.HALF_CIRCLE;
			}
			else {
				move(direction);

				if (step == totalsteps / 2)
					direction += Location.HALF_CIRCLE;
			}

			counter = 0;
		}

		counter++;
	}

	public void move(int direction) {
		try {
			super.move(direction);
		}
		catch(IllegalArgumentException e) {
			removeSelfFromGrid();
		}
	}

	private void fire() {
		Grid<Invader> grid = getGrid();
		if (grid == null)
			return;

		Location location = getLocation().getAdjacentLocation(Location.SOUTH);
		if (!grid.isValid(location) || grid.get(location) != null)
			return;

		Location enemy = location.getAdjacentLocation(Location.SOUTH);
		while (grid.isValid(enemy)) {
			if (grid.get(enemy) instanceof Enemy)
				return;

			enemy = enemy.getAdjacentLocation(Location.SOUTH);
		}

		EnemyShot shot = new EnemyShot();
		shot.putSelfInGrid(grid, location);
	}

	public String getImageSuffix() {
		return Integer.toString(animation);
	}

	public void removeSelfFromGrid() {
		try {
			new GameSound(SpaceInvaders.class.getResourceAsStream("sounds/enemydeath.au"));
		}
		catch (Exception e) {} //Ignore

		super.removeSelfFromGrid();
	}
}
