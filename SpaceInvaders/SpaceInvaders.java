//package spaceinvaders;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

public class SpaceInvaders {
	public static void main(String args[]) {
		ActorWorld world = new ActorWorld();
		world.add(new Boss(Location.EAST, 10));
		world.add(new Wall(4));
		world.add(new Shot(Location.NORTH));
		world.add(new Enemy(Location.WEST, 4));
		world.show();
	}
}
