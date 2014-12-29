import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Enemy extends Invader {
	private int direction;
	private int step = 0;
	private int steps;
	private int counter = 0;
	private int slowness;
	private int animation = 0;
	private double SHOT_CHANCE = 0.90;

	public Enemy(int direction, int steps, int speed) {
		this.direction = direction;
		this.steps = steps * 2;
		slowness = 5 - speed;
		if(slowness < 0)
			slowness = 0;
	}

	public void act() {
		Grid<Invader> grid = getGrid();
		if (grid == null)
			return;

		animation = ~animation;

		if (counter == slowness) {
			Location checkLocation = getLocation().getAdjacentLocation(Location.SOUTH).getAdjacentLocation(Location.SOUTH);

			if (Math.random() > SHOT_CHANCE)
				fire();

			Location move = getLocation().getAdjacentLocation(direction);

			step++;
			if (step == steps / 2) {
				direction += Location.HALF_CIRCLE;
			}
			else if (step > steps) {
				step = 0;
				direction += Location.HALF_CIRCLE;
				move = new Location(getLocation().getRow() + 1, getLocation().getCol());
			}

			if (!grid.isValid(move)) {
				removeSelfFromGrid();
				return;
			}

			Invader shot = grid.get(move);
			if (shot instanceof Shot) {
				removeSelfFromGrid();
				shot.removeSelfFromGrid();
			}

			moveTo(move);
			counter = 0;
		}

		counter++;
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
