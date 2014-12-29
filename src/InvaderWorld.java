import java.util.ArrayList;

import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import info.gridworld.world.World;

public class InvaderWorld extends World<Invader> {
	public InvaderWorld(Grid<Invader> grid) {
		super(grid);
	}

	public void show() {
		if (getMessage() == null)
			setMessage("Click on a grid location to construct or manipulate an invader.");

		super.show();

		try {
			new GameSound(SpaceInvaders.class.getResourceAsStream("sounds/background.au"), true);
		}
		catch (Exception e) {} //Ignore
	}

	public void step() {
		Grid<Invader> grid = getGrid();

		ArrayList<Invader> invaders = new ArrayList<Invader>();
		for (Location location : grid.getOccupiedLocations())
			invaders.add(grid.get(location));

		for (Invader invader : invaders) {
			if (invader.getGrid() == grid)
				invader.act();
		}
	}

	public void add(Location location, Invader occupant) {
		occupant.putSelfInGrid(getGrid(), location);
	}

	public void add(Invader occupant) {
		Location loc = getRandomEmptyLocation();
		if (loc == null)
			return;

		add(loc, occupant);
	}

	public Invader remove(Location location) {
		Invader occupant = getGrid().get(location);
		if (occupant == null)
			return null;

		occupant.removeSelfFromGrid();

		return occupant;
	}

	public boolean keyPressed(String description, Location loc) {
		if (description.equals("W"))
			KeyboardControl.addKey(0);
		else if (description.equals("A"))
			KeyboardControl.addKey(1);
		else if (description.equals("S"))
			KeyboardControl.addKey(2);
		else if (description.equals("D"))
			KeyboardControl.addKey(3);
		else if (description.equals("SPACE"))
			KeyboardControl.addKey(4);
		else
			return false;

		return true;
	}
}
