import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Boss extends Invader {
	private int direction;
	private int step = 0;
	private int totalsteps;

	public Boss(int direction, int steps) {
		this.direction = direction;
		this.totalsteps = steps;
	}

	public void act() {
		Grid<Invader> grid = getGrid();
		if (grid == null)
			return;

		move(direction);

		step++;
		if (step == totalsteps) {
			direction += Location.HALF_CIRCLE;
			step = 0;
		}
	}

	public void move(int direction) {
		try {
			super.move(direction);
		}
		catch (IllegalArgumentException e) {} //Ignore
	}

	public void removeSelfFromGrid() {
		try {
			new GameSound(SpaceInvaders.class.getResourceAsStream("sounds/bossdeath.au"));
		}
		catch (Exception e) {} //Ignore

		super.removeSelfFromGrid();
	}
}
