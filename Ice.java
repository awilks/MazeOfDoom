// defines the functionality of the Ice tile
public class Ice extends WalkableTile {
	
	// creates object and sets its symbol
	public Ice()
	{
		symbol = '*';
	}
	
	// moves an object to itself and attempts to move it to the next tile in the direction the object is moving
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
		
		if (dirr == 0)
			if (x-1 >= 0 && map[x-1][y].canMove(2, x-1, y, map, dirr, logic))
				map[x-1][y].move(type, x-1, y, map, dirr, logic, contains, this);
		if (dirr == 1)
			if (y-1 >= 0 && map[x][y-1].canMove(2, x, y-1, map, dirr, logic))
				map[x][y-1].move(type, x, y-1, map, dirr, logic, contains, this);
		if (dirr == 2)
			if (x+1 < map.length && map[x+1][y].canMove(2, x+1, y, map, dirr, logic))
				map[x+1][y].move(type, x+1, y, map, dirr, logic, contains, this);
		if (dirr == 3)
			if (y+1 < map[0].length && map[x][y+1].canMove(2, x, y+1, map, dirr, logic))
				map[x][y+1].move(type, x, y + 1, map, dirr, logic, contains, this);
			
		
	}
}
