// a bad guy with little inteligence

public class Zombie extends Baddies {

	// creates object and sets starting attributes
	public Zombie(int x, int y) {
		super(x, y);
		symbol = 'z';
		
		
	}
	// creates references to the game logic, the hero, the map, and its brain
	public void giveInfo(Logic lo, Hero he, Tile[][] m)
	{
		logic = lo;
		hero =he;
		map =m;
		brain = new ZBrain();
	}

}
