import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

// frame of game. Contains all graphics.

public class MazeGame extends JFrame implements KeyListener
{
	JPanel pane;
	 
	Level level;
	Title t;
	InputSpace iS;
	
	
	// creates object and adds beginning interface to choose level
	public MazeGame()  
	{
		super("Maze Game");
		setSize(800,600);
		pane = (JPanel)getContentPane();
		setFocusable(true);
		addKeyListener(this);
		iS = new InputSpace(this);
		t = new Title();
		pane.add(t, BorderLayout.CENTER);
		pane.add(iS, BorderLayout.SOUTH);
		setVisible(true);
		t.repaint();
		addWindowListener(new WindowAdapter()
							  {
							  	public void windowClosing(WindowEvent e)
							  	{
							  		System.exit(0);
							  	}
							  }
						  );
			
		
		
		
		
		
		repaint();
		
		
	}
	
	// attempts to start a level with the name of a user inputed string.  
	public void tryStart(String s)
	{
		
		pane.remove(t);
		pane.remove(iS);
		
		try {
			level = new Level(s, pane, this);
			repaint();
			
		} catch (FileNotFoundException e) {
			pane.add(t, BorderLayout.CENTER);
			pane.add(iS, BorderLayout.SOUTH);
		}
	}
    public void goToMenu()
    {
        pane.remove(level.graphics);
        pane.remove(level.pa);
   		level = null;
    	pane.add(t, BorderLayout.CENTER);
    	pane.add(iS, BorderLayout.SOUTH);

    }
    public void retry(String s)
    {
        
          pane.remove(level.graphics);
          pane.remove(level.pa);
    	  repaint();
    	  String n = level.name;
    	  try {
			level = new Level(n, pane, this);
					
		   } catch (FileNotFoundException e1) {
				e1.printStackTrace();
		   }
    }
	
	// handles key typed events
	public void keyTyped(KeyEvent e)  {
			
    }

    // deals with a key being pressed
    public void keyPressed(KeyEvent e) {
    	repaint();
    	
    	
    	if (level != null)
    	{
    		if (e.getKeyCode() == 82)
    		{
    			
    			pane.remove(level.graphics);
                pane.remove(level.pa);
    			repaint();
    			String n = level.name;
    			try {
					level = new Level(n, pane, this);
					
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				}
    		}
    		else if (e.getKeyCode() == 77)
    		{
    			pane.remove(level.graphics);
                pane.remove(level.pa);
    			level = null;
    			pane.add(t, BorderLayout.CENTER);
    			pane.add(iS, BorderLayout.SOUTH);
    			
    		}
    		else
    			level.keyGet(e.getKeyCode());
    	}
    }

    // deals with a key being released
    public void keyReleased(KeyEvent e) {
	
    }
	
	
	
	// initiates MazeGame object
	public static void main(String[] arg)  
	{
		new MazeGame();
	}


	
}




