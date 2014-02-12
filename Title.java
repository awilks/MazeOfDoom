import javax.swing.*;
import java.awt.*;

// displays title of game
public class Title extends JComponent {
	
	
	// draws title
	public void paint(Graphics g)
	{
		Font f = new Font("Serif", Font.BOLD, 40);
		g.setFont(f);
		g.setColor(Color.BLACK);
		g.drawString("Mazes of Doom",250  , 200);
	}
	
}
