// defines the functionality of teleport tile
public class Teleport extends WalkableTile {
	
	public int lx;
	public int ly;
	
	// creates the object and sets the symbol
	public Teleport(char c)
	{
		super();
		symbol = c;
	}
	
	// links it to another teleport
	public void link(int xcor, int ycor)
	{
		lx = xcor;
		ly = ycor;
	}
	
	//moves a Thing to itself.
	public void move(int type, int x, int y, Tile[][] map, int dirr, Logic logic, Thing t, Tile oldT)
	{
		
		
		
		oldT.contains = null;
		
		t.x = x;
		t.y = y;
		
		
		if (contains == null)
		{
		
		}
		else if (contains.type == 2 && type != 2)
		{
			if (dirr == 0)
				map[x-1][y].move(2, x-1, y, map, dirr, logic, contains,this);
					
			if (dirr == 1)
				map[x][y-1].move(2, x, y-1, map, dirr, logic, contains, this);
					
			if (dirr == 2)
				map[x+1][y].move(2, x+1, y, map, dirr, logic, contains, this);
					
			if (dirr == 3)
				map[x][y+1].move(2, x, y+1, map, dirr, logic, contains, this);
					
		}
		
		contains = t;
		
		logic.graphics.repaint();
		
		if (dirr !=4)
		{
			if (map[lx][ly].canMove(type, lx, ly, map, 4, logic))
				map[lx][ly].move(type, lx, ly, map, 4, logic, contains, this);
		}
			
		
	}

}
