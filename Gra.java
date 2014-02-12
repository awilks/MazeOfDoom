import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

// handles all graphics for a level. Inherits from JComponent.

public class Gra extends JComponent //implements ActionListener
{
	
	public int stage;
	public Tile[][] map;
	Font f;
	Font fR;
    public JPanel p;
	
	// creates object , creates a reference for the map, sets stage in gameplay, and creates fonts
	public Gra(Tile[][] m)
	{
		map = m;
		setSize(800, 800);
		stage = 0;
		f = new Font("Serif", Font.BOLD,40);
		fR = new Font("Gothic", Font.PLAIN, 15);

        //adding button stuff 
        /*
        JButton retry = new JButton("retry");
        JButton mainMenu = new JButton("main menu");
        p = new JPanel();
        p.add(retry, BorderLayout.CENTER);
        p.add(mainMenu, BorderLayout.SOUTH);
        add(p, BorderLayout.SOUTH);
        p.repaint();
        repaint();*/
		
	}
	
	
	// draws game graphics
	public void paint(Graphics g)
	{
        
		
		getTopLevelAncestor().repaint();
		if (stage == 0)
		{
			g.setFont(fR);
			for(int i = 0; i<map.length; i++)
			{
				for(int j = 0; j < map[0].length; j++)
				{
					if (map[i][j].containsG != null)
						g.drawString(Character.toString(map[i][j].containsG.symbol),10 + i*15, 20 + j*15);
					else if (map[i][j].contains != null)
						g.drawString(Character.toString(map[i][j].contains.symbol),10 + i*15, 20 + j*15);
					else 
						g.drawString(Character.toString(map[i][j].symbol),10 + i*15, 20 + j*15);
				}
			}
		}
		else if (stage ==1)
		{
			g.setFont(f);
			g.drawString("You Lose", 280, 250);
		}
		else
		{
			g.setFont(f);
			g.drawString("You Win", 280, 250);
		}
	}
	
	
	
}
