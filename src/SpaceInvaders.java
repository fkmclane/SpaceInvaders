/**
 * An implementation of SpaceInvaders in GridWorld.
 *
 * @author Foster McLane
 * @author Max Kirkpatrick
 * @version 0.1
 */

import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

public class SpaceInvaders {
	public static void main(String args[]) {
		Grid<Invader> grid = new BoundedGrid<Invader>(21, 21);
		InvaderWorld world = new InvaderWorld(grid);

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

		world.show();
	}
}
