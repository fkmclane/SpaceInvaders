import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Enemy extends Actor {
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
		Grid<Actor> grid = getGrid();
		if (grid == null)
			return;

		animation = (animation + 1) % 2;

		if (counter == slowness) {
			Location checkLocation = getLocation().getAdjacentLocation(Location.SOUTH).getAdjacentLocation(Location.SOUTH);

			if (Math.random() > SHOT_CHANCE && grid.isValid(checkLocation) && !(grid.get(checkLocation) instanceof Enemy))
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

			if (grid.get(move) instanceof Shot) {
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
		if (getGrid().isValid(location) && getGrid().get(location) == null) {
			Shot shot = new Shot(Location.SOUTH);
			shot.putSelfInGrid(getGrid(), location);
		}
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
