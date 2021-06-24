package logics;

import gi.Start;

public class FieldOpening {
	
	public FieldOpening(int x, int y, int field[][])
	{
		openZero(x, y, field);
	}
	
	private void openZero(int x, int y, int field[][])
	{
		if(Start.fieldCell[x][y].isEnabled()){Start.fieldCell[x][y].All();}
			if (field[x][y] == 0)
			{
				try
				{
					if(Start.fieldCell[x - 1][y - 1].isEnabled())
					{
						Start.fieldCell[x - 1][y - 1].All();
						if(field[x - 1][y - 1] == 0) {openZero(x - 1, y - 1, field);}
					}
				} catch (Exception e)
				{
				}
				try
				{
					if(Start.fieldCell[x + 1][y + 1].isEnabled())
					{
						Start.fieldCell[x + 1][y + 1].All();
						if(field[x + 1][y + 1] == 0) {openZero(x + 1, y + 1, field);}
					}
				} catch (Exception e)
				{
				}
				try
				{
					if(Start.fieldCell[x][y - 1].isEnabled())
					{
						Start.fieldCell[x][y - 1].All();
						if(field[x][y - 1] == 0) {openZero(x, y - 1, field);}
					}
				} catch (Exception e)
				{
				}
				try
				{
					if(Start.fieldCell[x][y + 1].isEnabled())
					{
						Start.fieldCell[x][y + 1].All();
						if(field[x][y + 1] == 0) {openZero(x, y + 1, field);}
					}
				} catch (Exception e)
				{
				}
				try
				{
					if(Start.fieldCell[x + 1][y].isEnabled())
					{
						Start.fieldCell[x + 1][y].All();
						if(field[x + 1][y] == 0) {openZero(x + 1, y, field);}
					}
				} catch (Exception e)
				{
				}
				try
				{
					if(Start.fieldCell[x - 1][y].isEnabled())
					{
						Start.fieldCell[x - 1][y].All();
						if(field[x - 1][y] == 0) {openZero(x - 1, y, field);}
					}
				} catch (Exception e)
				{
				}
				try
				{
					if(Start.fieldCell[x + 1][y - 1].isEnabled())
					{
						Start.fieldCell[x + 1][y - 1].All();
						if(field[x + 1][y - 1] == 0) {openZero(x + 1, y - 1, field);}
					}
				} catch (Exception e)
				{
				}
				try
				{
					if(Start.fieldCell[x - 1][y + 1].isEnabled())
					{
						Start.fieldCell[x - 1][y + 1].All();
						if(field[x - 1][y + 1] == 0) {openZero(x - 1, y + 1, field);}
					}
				} catch (Exception e)
				{
				}
			}
	}

}