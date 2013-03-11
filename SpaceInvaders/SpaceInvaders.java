//package spaceinvaders;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.*;

public class SpaceInvaders {
	public static void main(String args[]) {
	    Grid g = new BoundedGrid(20, 20);
		InvaderWorld world = new InvaderWorld(g);
		
		for(int i = 2; i <= 8; i+=2)
		{
		    for(int j = 4; j <= 14; j+=2)
		    {
		        world.add(new Location(i, j), new Enemy(Location.EAST, 3));
		    }
		}
		world.add(new Location(19, 10), new Ship(5));
		world.add(new Location(17, 8), new Wall(4));
		world.add(new Location(17, 10), new Wall(4));
		world.add(new Location(17, 12), new Wall(4));
		world.show();
	}
}
