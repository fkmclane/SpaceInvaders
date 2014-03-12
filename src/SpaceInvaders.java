/**
 * An implementation of SpaceInvaders in GridWorld.
 *
 * On my honor I have neither given nor received help on this assignment.
 *
 *
 *
 *
 *
 *
 * @author Foster McLane
 * @author Max Kirkpatrick
 * @version 0.1
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

public class SpaceInvaders {
	public static void main(String args[]) {
		Grid<Actor> g = new BoundedGrid<Actor>(21, 21);
		InvaderWorld world = new InvaderWorld(g);
		world.add(new Location(0, 1), new Boss(Location.EAST, 18));
		for (int i = 2; i <= 8; i += 2) {
			for (int j = 1; j <= 13; j += 2) {
				world.add(new Location(i, j),
						new Enemy(Location.EAST, 8, 3));
			}
		}
		world.add(new Location(20, 3), new Ship(5));
		world.add(new Location(18, 2), new Wall(4));
		world.add(new Location(18, 3), new Wall(4));
		world.add(new Location(18, 7), new Wall(4));
		world.add(new Location(18, 8), new Wall(4));
		world.add(new Location(18, 12), new Wall(4));
		world.add(new Location(18, 13), new Wall(4));
		world.add(new Location(18, 17), new Wall(4));
		world.add(new Location(18, 18), new Wall(4));

		try {
			AudioControl background = new AudioControl(SpaceInvaders.class.getResourceAsStream("sounds/background.wav"));
			background.loop();
		}
		catch(Exception e) {
			System.err.println("Error playing background audio: " + e);
		}

		world.show();
	}
} 
