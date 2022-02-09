package gi.buttons;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import gi.Start;
import logics.FieldGeneration;
import logics.FieldOpening;

public class Cell {

	private static int x = 0;
	private static int y = 0;
	private final int X;
	private final int Y;

	private JButton button = new JButton();

	public Cell(JPanel window, int x, int i, int j) {
		this.X = i;
		this.Y = j;
		GridBagConstraints c = new GridBagConstraints();
		button.setPreferredSize(new Dimension(32, 32));
		button.setFont(new Font(null, Font.BOLD, 20));
		button.setMargin(new Insets(0, 0, 0, 0));
		c.gridx = Cell.x;
		c.gridy = Cell.y;
		Cell.x += 1;
		if(Cell.x == x) {
			Cell.y += 1;
			Cell.x = 0;
		}
		window.add(button, c);
		action();
	}

	private void action(){
		ActionListener CellActionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Start.field[X][Y] == -1) {
					new FieldGeneration(Start.field, Start.maxBomb, X, Y);
					FieldOpening.openCells(X, Y, Start.field);
				}
				else {
					FieldOpening.openCells(X, Y, Start.field);
				}
			}
		};
		button.addActionListener(CellActionListener);
	}
	private void setIconBombs()
	{
		button.setIcon(new ImageIcon("images/bombs2.png"));
		button.setDisabledIcon(new ImageIcon("images/bombs2.png"));
	}

	private void setIconNumber(int number)
	{
		button.setIcon(new ImageIcon(String.format("images/number-%s.png", number)));
		button.setDisabledIcon(new ImageIcon(String.format("images/number-%s.png", number)));
	}

	public void setIcon()
	{
		if(button.isEnabled())
		{
			button.setEnabled(false);
			String str =  Integer.toString(Start.field[X][Y]);
			if(!("0".equals(str)) & Start.field[X][Y] < 10)
			{
				setIconNumber(Start.field[X][Y]);
			}else if(Start.field[X][Y] >= 10){
				setIconBombs();
			}
		}
	}
	
	public boolean isEnabled()	{
		return button.isEnabled();
	}
}

