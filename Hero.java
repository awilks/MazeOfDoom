import java.awt.event.*;
import java.util.*;


// defines the functionality of the character representing the player
public class Hero extends Thing 
{
	
	
	public boolean canGet = false;
	Logic logic;
	Tile[][] map; 
	public int keys;
	
	//creates object and sets beginning attributes
	public Hero(Logic l, int xcor, int ycor, Tile[][] m)
	{
		symbol = '@';
		x = xcor;
		y = ycor;
		logic =l;
		map = m;
		keys =0;
	}
	
	// creates a reference to the game logic
	public void setLogic(Logic l)
	{
		logic = l;
	}
	
	// gives the ability to the player to move
	public void getMove()
	{
		canGet = true;
	}
	
	// gets the key the player pressed, then trys to move itself in the direction the key corresponds to
	 public void keyGet(int k) {
			if (canGet)
			{
				switch (k)
				{
					case 37: if (x-1 >= 0 && map[x-1][y].canMove(0, x-1, y, map, 0, logic))
							 {
							  	map[x-1][y].move(0,x-1,y,map,0,logic, this,map[x][y]);
							  	if (map[x][y].containsG != null)
							  		logic.gameover();
							  	else if (map[x][y].symbol == '$')
							  		logic.win();
								logic.go();
							 }
					break;
					case 38: if (y-1 >= 0 && map[x][y-1].canMove(0, x, y-1, map, 1, logic))
							 {
							  	map[x][y-1].move(0,x,y-1,map,1,logic, this,map[x][y]);
							  	if (map[x][y].containsG != null)
							  		logic.gameover();
							  	else if (map[x][y].symbol == '$')
							  		logic.win();
								logic.go();
							 }
					break;
					case 39: if (x+1<map.length && map[x+1][y].canMove(0, x+1, y, map, 2, logic))
							{
								map[x+1][y].move(0,x+1,y,map,2,logic, this,map[x][y]);
								if (map[x][y].containsG != null)
							  		logic.gameover();
								else if (map[x][y].symbol == '$')
							  		logic.win();
								logic.go();
							 }
					break;
					case 40: if (y+1 < map[0].length && map[x][y+1].canMove(0, x, y+1, map, 3, logic))
							{
								map[x][y+1].move(0,x,y+1,map,3,logic, this,map[x][y]);
								if (map[x][y].containsG != null)
							  		logic.gameover();
								else if (map[x][y].symbol == '$')
							  		logic.win();
								logic.go();
							}
					break;
				}
				
			}
    }

    

}	
	
	
