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

		Location move = getLocation().getAdjacentLocation(getDirection());
		if (!grid.isValid(move)) {
			removeSelfFromGrid();
			return;
		}

		Actor actor = grid.get(move);
		if (actor instanceof Wall) {
			Wall w = (Wall) actor;
			w.reduceStrength();
			removeSelfFromGrid();
		}
		else if (actor instanceof Ship) {
			Ship s = (Ship) actor;
			s.reduceLives();
			removeSelfFromGrid();
		}
		else if (actor != null) {
			actor.removeSelfFromGrid();
			removeSelfFromGrid();
		}
		else {
			moveTo(move);
		}
	}
}


