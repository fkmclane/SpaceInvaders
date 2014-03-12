//package spaceinvaders;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

public class InvaderWorld extends ActorWorld {
	public InvaderWorld(Grid<Actor> g) {
		super(g);
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
