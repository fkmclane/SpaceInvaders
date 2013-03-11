//package spaceinvaders;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

public class SpaceInvaders {
	public static void main(String args[]) {
		InvaderWorld world = new InvaderWorld();
		world.add(new Ship(5));
		world.show();
	}
}
