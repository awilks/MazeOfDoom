// defines functionality of a cracked floor 

public class CrackedFloor extends WalkableTile {
	
	
	// creates object and sets symbol
	public CrackedFloor(char c)
	{
		symbol = c;
	}
	// overrides move function in WalkableTile. Function moves a Thing to itself and keeps track of time until completley cracked.  
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
		symbol-= (char)1;
		if (symbol== '0')
		{
			map[x][y] = new Wall();
		}
		map[x][y].contains = t;
		logic.graphics.repaint();
			
		
	}

}
