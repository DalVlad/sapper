import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Bombs 
{
	
//	private static final ImageIcon BOMBS = new ImageIcon("src/images/bombs.png");
	private static int x = 0;
	private static int y = 0;
	
	public Bombs(JPanel window)
	{
		GridBagConstraints c = new GridBagConstraints();
		JButton bomb = new JButton(new ImageIcon("src/images/bombs2.png"));
		bomb.setPreferredSize(new Dimension(32, 32));
		c.gridx = x;
		c.gridy = y; 
		x += 1;
		if(x == 10)
		{
			y += 1;
			x = 0;
		}
		window.add(bomb, c);
		
	}

}
