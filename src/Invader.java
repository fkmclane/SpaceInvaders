import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Invader {
	private Grid<Invader> grid;
	private Location location;

	public Invader() {
		grid = null;
		location = null;
	}

	public Grid<Invader> getGrid() {
		return grid;
	}

	public Location getLocation() {
		return location;
	}

	public void putSelfInGrid(Grid<Invader> grid, Location location) {
		if (this.grid != null)
			throw new IllegalStateException("This invader is already contained in a grid.");

		Invader invader = grid.get(location);
		if (invader != null)
			invader.removeSelfFromGrid();

		grid.put(location, this);

		this.grid = grid;
		this.location = location;
	}

	public void removeSelfFromGrid() {
		if (grid == null)
			throw new IllegalStateException("This invader is not contained in a grid.");

		if (grid.get(location) != this)
			throw new IllegalStateException("The grid contains a different invader at location " + location + ".");

		grid.remove(location);

		grid = null;
		location = null;
	}

	public void moveTo(Location location) {
		if (grid == null)
			throw new IllegalStateException("This invader is not contained in a grid.");

		if (grid.get(this.location) != this)
			throw new IllegalStateException("The grid contains a different invader at location " + location + ".");

		if (!grid.isValid(location))
			throw new IllegalArgumentException("Location " + location + " is not valid.");

		if (location.equals(this.location))
			return;

		grid.remove(this.location);

		Invader other = grid.get(location);
		if (other != null)
			other.removeSelfFromGrid();

		this.location = location;
		grid.put(location, this);
	}

	public void act() {
		//Do nothing
	}

	public void shoot() {
		removeSelfFromGrid();
	}

	public void move(int direction) {
		if (grid == null)
			throw new IllegalStateException("This invader is not contained in a grid.");

		Location move = getLocation().getAdjacentLocation(direction);

		if (!grid.isValid(move))
			throw new IllegalArgumentException("Location " + location + " is not valid.");

		Invader shot = grid.get(move);
		if (shot instanceof Shot) {
			shoot();
			shot.removeSelfFromGrid();
		}

		if(grid != null)
			moveTo(move);
	}

	public String toString() {
		return getClass().getName() + "[location=" + location + "]";
	}
}
