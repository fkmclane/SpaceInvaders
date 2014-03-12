import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Shot extends Actor {
	public Shot(int direction) {
		setDirection(direction);

		try {
			AudioControl shot = new AudioControl(SpaceInvaders.class.getResourceAsStream("sounds/shot.wav"));
			shot.play();
		}
		catch(Exception e) {
			System.err.println("Error playing shot sound: " + e);
		}
	}

	public void act() {
		Grid<Actor> grid = getGrid();
		if (grid == null)
			return;

		Location move =
			getLocation().getAdjacentLocation(getDirection());
		if (!grid.isValid(move)) {
			removeSelfFromGrid();
			return;
		}

		if (grid.get(move) instanceof Wall) {
			Wall w = (Wall) grid.get(move);
			w.reduceStrength();
			removeSelfFromGrid();
		}
		else if (grid.get(move) instanceof Ship) {
			Ship s = (Ship) grid.get(move);
			s.reduceLives();
			removeSelfFromGrid();
		}
		else if (grid.get(move) != null) {
			grid.get(move).removeSelfFromGrid();
			removeSelfFromGrid();
		}
		else {
			moveTo(move);
		}
	}
}


