import java.util.*;
import javax.swing.*;
import java.awt.event.*;

import java.awt.BorderLayout;
import java.io.*;
//initiates a level

public class Level implements ActionListener
{
	
	Tile[][] map;
	Hero hero;
	Baddies[] baddies;
	Logic logic;
	Gra graphics;
	JPanel pane;
	Link[] links;
	public boolean newLink;
	public String name;
    MazeGame maze;
    JPanel pa;

    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("retry"))
        {
            maze.retry(name);
        }
        if(e.getActionCommand().equals("main menu"))
        {
            maze.goToMenu();
        }



    }
	
	
	// creates object. Loads in text file. Creates a map using the text file. Initiates graphics and game logic.  Starts the game logic running.  
	public Level (String name, JPanel pane, MazeGame maze) throws FileNotFoundException 
	{
		
		
		this.name = name;
        this.maze =maze;
		Scanner sc = new Scanner(new File(name));
		int ytot = sc.nextInt();
		int xtot = sc.nextInt();
		map = new Tile[xtot][ytot];
		String s;

		for (int i = 0; i<ytot; i++)
		{
			s = sc.next();
			
			for (int j = 0; j<xtot; j++) 
			{
				char c = s.charAt(j);
				if (c > '0' && c <='9')
					map[j][i] = new CrackedFloor(c);
				else if (c >= 'A' && c<='Z')
				{
					Teleport t = new Teleport(c);
					map[j][i] = t;
					if (links == null)
					{
						links = new Link[1];
						links[0] = new Link(c, j, i, t);
					}
					else
					{
						Link l =findLink(c, links, j, i, t);
						if (newLink)
							newLink = false;
						else
							l.linkTo(j, i, t);
							
						
					}
				}
				else
					switch (c)
					{
					
						case '.' : map[j][i] = new Floor();
						break;
						case '#': map[j][i] = new Wall();
						break;
						case '@' : map[j][i] = new Floor();
						hero = new Hero(logic, j,i,map);
						map[j][i].contains = hero; 
						break;
						case '+': map[j][i] = new Floor();
						map[j][i].contains = new Box(j,i);
						break;
						case '*':map[j][i] = new Ice();
						break;
						case '!':map[j][i] = new Floor();
						map[j][i].contains = new Key();
						break;
						case '&': map[j][i] = new Floor();
						map[j][i].contains = new Door();
						break;
						case 'z': map[j][i] = new Floor();
						Zombie z = new Zombie(j,i);
						map[j][i].contains = z;
						addB(z);
						break;
						case 'g': map[j][i] = new Floor();
						Ghost g = new Ghost(j,i);
						map[j][i].containsG = g;
						addB(g);
						break;
						case '$': map[j][i] = new End();
						break;
					
					}
			}
		}
		
		sc.close();
		
		if (links !=null)
		{
			for (int q = 0; q<links.length;q++)
				links[q].finish();
		}
		
		links = null;
		
		
		graphics  = new Gra(map);
		logic = new Logic(map,baddies,graphics,hero);
		//this.pane = pane;
		
		if (baddies != null)
		{
			for (int q = 0; q<baddies.length;q++)
				baddies[q].giveInfo(logic, hero, map);
		}
		
		pane.add(graphics, BorderLayout.CENTER);
        //maybe stuff for buttons
        JButton retry = new JButton("retry");
        JButton mainMenu = new JButton("main menu");
        pa = new JPanel();
        pa.add(retry, BorderLayout.CENTER);
        pa.add(mainMenu, BorderLayout.SOUTH);
        pane.add(pa, BorderLayout.SOUTH);
        pane.getTopLevelAncestor().setVisible(true);
        retry.addActionListener(this);
        mainMenu.addActionListener(this);


		logic.go();
		
		
	}
	// adds a bad guy to the list of bad guys
	
	public void addB(Baddies b)
	{
		if (baddies == null)
		{
			baddies = new Baddies[1];
			baddies[0] = b;
			return;
		}
		
		Baddies[] bTemp = new Baddies[baddies.length +1];
		for (int w = 0; w< baddies.length; w++)
		{
			bTemp[w] = baddies[w];
		}
		bTemp[baddies.length] = b;
		baddies = bTemp;
		
	}
	
	// gets a inputed key and sends  it to be handled by the hero
	
	public void keyGet(int k)
	{
		hero.keyGet(k);
	}
	
	// either returns a link for a teleport or creates a new link for the teleport
	
	public Link findLink(char c, Link[] links, int x, int y, Teleport t)
	{
		
		for(int q = 0; q <links.length; q ++)
		{
			if (links[q].symbol == c)
				return links[q];
		}
		Link[] lTemps = new Link[links.length +1];
		for(int q = 0; q <links.length; q ++)
		{
			lTemps[q] = links[q];
		}
		Link lNew = new Link(c,x,y,t);
		lTemps[links.length] = lNew;
		this.links = lTemps;
		newLink = true;
		
		return lNew;
	}
}
