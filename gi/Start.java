package gi;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;

import gi.buttons.*;


public class Start
{
	
	private static int x;
	private static int y;
	public static int maxBomb;
	public static Cell[][] fieldCell;
	public static int[][] field;
	
	public Start(int x, int y, int maxBomb)
	{
		Start.x = x;
		Start.y = y;
		Start.maxBomb = maxBomb;
		fieldCell = new Cell[x][y];
		field = new int[x][y];
		for (int[] ints : field) {
			Arrays.fill(ints, -1);
		}
		start();
	}
	
	private void start()
	{
		JFrame window = new JFrame();
		window.setTitle("Sapeur");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		JPanel panelNorth = new JPanel();
		JPanel panelWest = new JPanel();
		JPanel panelEast = new JPanel();
		JPanel panelSouth = new JPanel();
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(Color.CYAN);
		window.add(panelNorth, BorderLayout.NORTH);
		window.add(panelWest, BorderLayout.WEST);
		window.add(panelEast, BorderLayout.EAST);
		window.add(panelSouth, BorderLayout.SOUTH);
		window.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new GridBagLayout());
		for(int i = 0; i < Start.x; i += 1)
			for(int j = 0; j < Start.y; j += 1)
		{
			fieldCell[i][j] = new Cell(panelCenter, Start.x, i, j);
		}

		
		window.pack();
		window.setResizable(false);
		window.setVisible(true);
		
	}
}
