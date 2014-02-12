// abstract class that all bad guys extend from, gives base qualities

class Baddies extends Thing
{
	Logic logic;
	Hero hero;
	Tile[][] map;
	Brain brain;
	int[] dirs;
	
	
	// creates object and sets starting values
	public Baddies(int x, int y)
	{
		type = 1;
		this.x =x;
		this.y =y;
	}
	
	// creates references to the game logic, hero, and the map
	public void giveInfo(Logic lo, Hero he, Tile[][] m)
	{
		logic = lo;
		hero =he;
		map =m;
	}
	
	// gets badguy's "brain" to give best move
	public void getMove()
	{
		dirs = brain.getDirr(map, hero, this);
		
		move();
		
	}
	// attempts to move bad guy the direction its brain tells it to move
	public void move()
	{
		for(int q =0; q < dirs.length; q++)
		{
			int dirr = dirs[q];
			if (dirr == 0)
				if (x-1 >= 0 && map[x-1][y].canMove(1, x-1, y, map, dirr, logic))
				{
					map[x-1][y].move(1, x-1, y, map, dirr, logic, this, map[x][y]);
					return;
				}
			if (dirr == 1)
				if (y-1 >= 0 && map[x][y-1].canMove(1, x, y-1, map, dirr, logic))
				{
					map[x][y-1].move(1, x, y-1, map, dirr, logic, this, map[x][y]);
					return;
				}
			if (dirr == 2)
				if (x+1 < map.length && map[x+1][y].canMove(1, x+1, y, map, dirr, logic))
				{
					map[x+1][y].move(1, x+1, y, map, dirr, logic, this, map[x][y]);
					return;
				}
			if (dirr == 3)
				if (y+1 < map.length && map[x][y+1].canMove(1, x, y+1, map, dirr, logic))
				{
					map[x][y+1].move(1, x, y+1, map, dirr, logic, this, map[x][y]);
					return;
				}
			
		}
	}
}