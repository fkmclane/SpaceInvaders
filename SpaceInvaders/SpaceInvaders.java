//package spaceinvaders;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

public class SpaceInvaders {
	public static void main(String args[]) {
	    Grid<Actor> g = new BoundedGrid<Actor>(21, 21);
		InvaderWorld world = new InvaderWorld(g);
		
		for(int i = 2; i <= 8; i += 2)
		{
		    for(int j = 1; j <= 13; j += 2)
		    {
		        world.add(new Location(i, j), new Enemy(Location.EAST, 8, 3));
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
