// defines the functionality of a Ghost ( a bad guy that can walk through walls)
public class Ghost extends Zombie {

	// creates objects, sets starting attributes, and runs the Zombie class's constructor
	public Ghost(int x, int y) {
		super(x, y);
		symbol = 'g';
		type = 10;
	}
	
	// attempts to move ghost 
	public void move()
	{
		
		for(int q =0; q < dirs.length; q++)
		{
			int dirr = dirs[q];
			if (dirr == 0)
				if (x-1 >= 0 && map[x-1][y].canMoveG())
				{
					map[x-1][y].moveG( x-1, y, map, dirr, logic, this, map[x][y]);
					return;
				}
			if (dirr == 1)
				if (y-1 >= 0 && map[x][y-1].canMoveG())
				{
					map[x][y-1].moveG( x, y-1, map, dirr, logic, this, map[x][y]);
					return;
				}
			if (dirr == 2)
				if (x+1 < map.length && map[x+1][y].canMoveG())
				{
					map[x+1][y].moveG( x+1, y, map, dirr, logic, this, map[x][y]);
					return;
				}
			if (dirr == 3)
				if (y+1 < map.length && map[x][y+1].canMoveG())
				{
					map[x][y+1].moveG( x, y+1, map, dirr, logic, this, map[x][y]);
					return;
				}
			
		}
	}

}
