// defines the functionality for a wall tile

public class Wall extends Tile 
{
	//creates object and sets symbol
	public Wall ()
	{
		
		symbol = '#';
	}
	
	// always tells a thing it can't move to this
	public boolean canMove(int type, int x, int y, Tile[][] map, int dirr, Logic logic)
	{
		return false;
	}
}