// the base class for all tiles that can be walked on. Defines base functionality.

public class WalkableTile extends Tile 
{
	
	  
	// creates object
	public WalkableTile()
	{
		super();
	}
	
	// checks if Thing can be moved to this
	public boolean canMove(int type, int x, int y, Tile[][] map, int dirr, Logic logic)
	{
		
		if (contains == null)
			return true;
		
		if (contains.type == 2)
		{
			if (dirr == 0)
				if (x-1 >= 0 && map[x-1][y].canMove(2, x-1, y, map, dirr, logic))
					return true;
			if (dirr == 1)
				if (y-1 >= 0 && map[x][y-1].canMove(2, x, y-1, map, dirr, logic))
					return true;
			if (dirr == 2)
				if (x+1 < map.length && map[x+1][y].canMove(2, x+1, y, map, dirr, logic))
					return true;
			if (dirr == 3)
				if (y+1 < map[0].length && map[x][y+1].canMove(2, x, y+1, map, dirr, logic))
					return true;
			if(dirr == 4)
				return false;
					
		}
		if (contains.type == 1)
		{
			if (type ==0)
			{
				logic.gameover();
				return true;
				
			}
			
			return false;
		}
		if (contains.type == 0)
		{
			if (type == 2)
				return false;
			
			logic.gameover();
			return true;
		}
		if (contains.type == 3)
		{
			if (type!=0)
				return false;
			logic.hero.keys++;
			contains = null;
			return true;
		}
		if (contains.type == 4)
		{
			if (type!=0)
				return false;
			if (logic.hero.keys ==0)
				return false;
			logic.hero.keys--;
			contains = null;
			return true;
		}
	
		
		return false;
			
	}
	
	// moves thing to this
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
			
		
	}
} 