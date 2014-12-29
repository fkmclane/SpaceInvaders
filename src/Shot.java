import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Shot extends Invader {
	private int direction;

	public Shot(int direction) {
		this.direction = direction;

		try {
			new GameSound(SpaceInvaders.class.getResourceAsStream("sounds/shot.au"));
		}
		catch(Exception e) {} //Ignore
	}

	public void act() {
		Grid<Invader> grid = getGrid();
		if (grid == null)
			return;

		Location move = getLocation().getAdjacentLocation(direction);
		if (!grid.isValid(move)) {
			removeSelfFromGrid();
			return;
		}

		Invader invader = grid.get(move);
		if (invader != null) {
			invader.shoot();
			removeSelfFromGrid();
		}
		else {
			moveTo(move);
		}
	}

	public void move(int direction) {
		Grid<Invader> grid = getGrid();
		if (grid == null)
			return;

		Location move = getLocation().getAdjacentLocation(direction);

		if (!grid.isValid(move)) {
			removeSelfFromGrid();
			return;
		}

		Invader invader = grid.get(move);
		if (invader != null) {
			invader.shoot();
			removeSelfFromGrid();
			return;
		}

		moveTo(move);
	}
}
