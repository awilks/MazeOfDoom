// defines the flow of the game. Provides some of the game logic.

public class Logic
{
	public Tile[][] map;
	public Baddies[] baddies;
	public Gra graphics;
	public Hero hero;
	int thing = -1;
	public boolean gameover = false;
	
	// creates object and references to other objects.
	public Logic (Tile[][] ma, Baddies[] baddie, Gra graphic, Hero he)
	{
		map = ma;
		baddies = baddie;
		graphics = graphic;
		hero = he;
		hero.setLogic(this);
	}
	
	// main logic loop. Controls when player and bad guys can move.
	public void go ()
	{
		if (gameover)
			return;
		
		if (thing == -1 || thing == -2)
			hero.getMove();
		else
			baddies[thing].getMove();
		
		
		
		thing++;
		
		
		if (baddies != null)
		{
			if (thing == baddies.length)
				thing = -1;
		}	
		else
			thing =-2;
		
		
		if (thing > 0 || thing == -1)
			go();
		
	
	}
	
	// ends game with lose status
	public void gameover()
	{
		graphics.stage = 1;
		graphics.repaint();
		hero.canGet = false;
		gameover =true;
	}
	// end game with win status
	public void win()
	{
		graphics.stage = 2;
		graphics.repaint();
		hero.canGet = false;
		gameover =true;
	}
}
	
