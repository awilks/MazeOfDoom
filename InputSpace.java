import java.awt.BorderLayout;
import java.awt.event.*;


import javax.swing.*;

// defines the interface that allows the player to pick a level

public class InputSpace extends JPanel implements ActionListener {
	
	
	public MazeGame main;
	public JTextField f;
	
	//creates the object and the interface components it contains 
	public InputSpace(MazeGame m)
	{
		super();
		main = m;
		f = new JTextField("Level Name", 20);
		JButton b = new JButton("Enter");
		add(f, BorderLayout.NORTH);
		add(b, BorderLayout.SOUTH);
		b.addActionListener(this);
		repaint();
	}
	
	// sends the user inputed text to an instance of the MazeGame class

	public void actionPerformed(ActionEvent e) {
		main.tryStart(f.getText().trim());
		
	}

	
	
	
	
}
