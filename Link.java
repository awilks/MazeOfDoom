// links two teleports to eachother
public class Link {
	public char symbol;
	public int x1;
	public int y1;
	public int x2;
	public int y2;
	public Teleport t1;
	public Teleport t2;
	
	// creates the object, sets the symbol for the group of teleports, and creates a reference to one of the teleports.
	public Link(char c, int x, int y, Teleport t)
	{
		
		symbol = c;
		x1 = x;
		y1 = y;
		t1 = t;
	}
	
	// creates a reference to a teleport
	public void linkTo(int x, int y, Teleport t)
	{
		x2 = x;
		y2 = y;
		t2 = t;
	}
	// links its two teleports to eachother
	public void finish()
	{
		t1.link(x2, y2);
		t2.link(x1, y1);
	}

}
