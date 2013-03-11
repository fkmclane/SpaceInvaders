import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

public class InvaderWorld extends ActorWorld
{
    public boolean keyPressed(String description, Location loc)
    {
        System.out.println("keyprssed was called.");
        System.out.println("key " + description + ".");
        if(!description.equals("W") && !description.equals("A") && !description.equals("S") && !description.equals("D") && !description.equals("SPACE"))
        {
            return false;
        }
        
        else
        {
            if(description.equals("W")) KeyboardControl.addKey(0);
            if(description.equals("A")) KeyboardControl.addKey(1);
            if(description.equals("S")) KeyboardControl.addKey(2);
            if(description.equals("D")) KeyboardControl.addKey(3);
            if(description.equals("SPACE")) KeyboardControl.addKey(4);
            
            return true;
        }
    }
}
