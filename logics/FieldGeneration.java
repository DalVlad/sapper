package logics;

import java.util.Random;

public class FieldGeneration 
{
	
	public FieldGeneration(int field[][], int x, int y)
	{
		bombsGeneration(field, x, y);
		numbersGeneration(field);
	}
	
	private static void bombsGeneration(int field[][], int x0, int y0)
	{
		for(int i = 0; i < field.length; i++)
		{
			for(int j = 0; j < field.length; j++)
			{
				field[i][j] = 0;
			}
		}
		int x = 0;
		int y = 0;
		int bombs = 0;
		int length = field.length;
		Random r = new Random();
		while (bombs <= 15) // количество бомб
		{
			x = r.nextInt(length);
			y = r.nextInt(length);
			if (field[x][y] == 10 | (x0 == x & y0 == y) | (x0 + 1 == x & y0 + 1 == y) 
					| (x0 - 1 == x & y0 - 1 == y) | (x0 == x & y0 + 1 == y) | (x0 == x & y0 - 1 == y)
					| (x0 + 1 == x & y0 == y) | (x0 - 1 == x & y0 == y) | (x0 + 1 == x & y0 - 1 == y)
					| (x0 - 1 == x & y0 + 1 == y))
			{
				continue;
			}
			else
			{
				field[x][y] = 10;
				bombs += 1;
			}
//			System.out.print("true");  // Проверка
		}
	}
	
	private static void numbersGeneration(int field[][])
	{
		int x = 0;
		int y = 0;
		for(; x < field.length; x += 1)
		{
			y = 0;
			for(; y < field.length; y += 1)
			{
				if (field[x][y] >= 10)
				{
					try
					{
						field[x - 1][y - 1] += 1;
					} catch (Exception e)
					{
					}
					try
					{
						field[x + 1][y + 1] += 1;
					} catch (Exception e)
					{
					}
					try
					{
						field[x][y - 1] += 1;
					} catch (Exception e)
					{
					}
					try
					{
						field[x][y + 1] += 1;
					} catch (Exception e)
					{
					}
					try
					{
						field[x + 1][y] += 1;
					} catch (Exception e)
					{
					}
					try
					{
						field[x - 1][y] += 1;
					} catch (Exception e)
					{
					}
					try
					{
						field[x + 1][y - 1] += 1;
					} catch (Exception e)
					{
					}
					try
					{
						field[x - 1][y + 1] += 1;
					} catch (Exception e)
					{
					}
				}
			}
			
		}
//		System.out.print("true");
	}
}
