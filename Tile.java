// base class of all tiles. Defines base qualities all tiles share.

public class Tile 
{
	public boolean walkable;
	public char symbol;
	public Thing contains;
	public Ghost containsG;
	
	
	// returns if a thing can move to itself. Overriden in all child classes. 
	public boolean canMove(int type, int x, int y, Tile[][] map, int dirr, Logic logic)
	{
		return true;
	}
	
	//moves a thing to itself. Overriden in all child classes.
	
	public void move(int type, int x, int y, Tile[][] map, int dirr, Logic logic, Thing t, Tile oldT)
	{
		
	}
	
	// checks if a ghost can move to this
	
	public boolean canMoveG()
	{
		if (containsG ==null)
			return true;
		else 
			return false;
	}
	
	// moves ghost to this
	
	public void moveG(int x, int y, Tile[][] map,int dirr, Logic logic, Ghost t, Tile oldT)
	{
		
		oldT.containsG = null;
		t.x = x;
		t.y = y;
		containsG = t;
		if (contains != null)
			if (contains.type == 0)
				logic.gameover();
		
		logic.graphics.repaint();
	}
	
}