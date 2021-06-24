package gi.buttons;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import gi.Start;
import logics.FieldGeneration;
import logics.FieldOpening;

public class Cell {
	
	private static int x = 0;
	private static int y = 0;
	private final int X;
	private final int Y;
	private JButton button = new JButton();
	
	public Cell(JPanel window, int x, int i, int j)
	{
		this.X = i;
		this.Y = j;
		GridBagConstraints c = new GridBagConstraints();
		button.setPreferredSize(new Dimension(32, 32));
		button.setFont(new Font(null, Font.BOLD, 20));
		button.setMargin(new Insets(0, 0, 0, 0));
		c.gridx = Cell.x;
		c.gridy = Cell.y;
		Cell.x += 1;
		if(Cell.x == x)
		{
			Cell.y += 1;
			Cell.x = 0;
		}
		window.add(button, c);
		
		ActionListener CellActionListener = new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) 
					{
//						for(int i = 0; i < Start.field.length; i +=1)
//						{
//							for(int j = 0; j < Start.field.length; j +=1)
//							{
//								if (Start.field[i][j] >= 10)
//								{
//									Start.fieldCell[i][j].setIcon();
//									Start.fieldCell[i][j].setEnabled();
//								}
//								else
//								{
//									String str =  Integer.toString(Start.field[i][j]);
//									Start.fieldCell[i][j].setText(str);
//									Start.fieldCell[i][j].setEnabled();
//								}
//
//							}
//						}
						String str =  Integer.toString(Start.field[X][Y]);
						if("-1".equals(str))
						{
							new FieldGeneration(Start.field, X, Y);
							for(int [] i: Start.field)				//
							{									//
								System.out.println();			//
								for(int q: i)					//
								{     							//
					                System.out.print(q + ", ");	// Проверка
								}							  	//
							}		
							new FieldOpening(X, Y, Start.field);
							
						}
						else
						{
							new FieldOpening(X, Y, Start.field);
						}
//						new FieldOpening(X, Y, Start.field);
//						button.setEnabled(false);
//						int cell = Start.field[X][Y];
//						if(cell >= 10)
//						{
//							button.setIcon(new ImageIcon("src/images/bombs2.png"));
//						}
//						else
//						{
//							String str =  Integer.toString(cell);
//							button.setText(str);
//						}
						
					}
				};
				
		button.addActionListener(CellActionListener);
	}
	
	public void setIcon()
	{
		button.setIcon(new ImageIcon("src/images/bombs2.png"));
	}
	
	public void setText(String x)
	{
		if("0".equals(x))
		{
			
		}
		else
		{
			button.setText(x);
		}
	}
	
	public void setEnabled()
	{
		button.setEnabled(false);
	}
	
	public void All()
	{
		if(button.isEnabled())
		{
			button.setEnabled(false);
			String str =  Integer.toString(Start.field[X][Y]);
			if(!("0".equals(str)))
			{
				button.setText(str);
			}
		}
	}
	
	public boolean isEnabled()
	{
		return button.isEnabled();
	}
}

