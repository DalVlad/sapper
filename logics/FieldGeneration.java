package logics;

import java.util.Arrays;
import java.util.Random;

public class FieldGeneration 
{
	/**
	 * Генерирует поле
	 * @param field игровое поле
	 * @param maxBombs количество бомб
	 * @param x расположение нажатой кнопки по "x"
	 * @param y расположение нажатой кнопки по "y"
	 */
	public FieldGeneration(int[][] field, int maxBombs, int x, int y)
	{
		bombsGeneration(field, maxBombs, x, y);
		numbersGeneration(field);
	}

	/**
	 * Генерирует бомбы.
	 * @param field игровое поле
	 * @param maxBombs количество бомб
	 * @param x0 расположение нажатой кнопки по "x"
	 * @param y0 расположение нажатой кнопки по "y"
	 */
	private static void bombsGeneration(int[][] field, int maxBombs, int x0, int y0)
	{
		for (int[] ints : field) {
			Arrays.fill(ints, 0);
		}
		int x = 0;
		int y = 0;
		int bombs = 0;
		int lengthX = field.length;
		int lengthY = field[0].length;
		Random r = new Random();
		while (bombs <= maxBombs)
		{
			x = r.nextInt(lengthX);
			y = r.nextInt(lengthY);
			boolean isBombNear = field[x][y] == 10 | (x0 == x & y0 == y) | (x0 + 1 == x & y0 + 1 == y)
					| (x0 - 1 == x & y0 - 1 == y) | (x0 == x & y0 + 1 == y) | (x0 == x & y0 - 1 == y)
					| (x0 + 1 == x & y0 == y) | (x0 - 1 == x & y0 == y) | (x0 + 1 == x & y0 - 1 == y)
					| (x0 - 1 == x & y0 + 1 == y);
			if (!isBombNear)
			{
				field[x][y] = 10;
				bombs += 1;
			}
		}
	}

	/**
	 * Генерирует числа количества бомб рядом
	 * @param field игровое поле
	 */
	private static void numbersGeneration(int[][] field)
	{
		int x = 0;
		int y = 0;
		for(; x < field.length; x += 1)
		{
			y = 0;
			for(; y < field[0].length; y += 1) {
				if (field[x][y] >= 10) {
					try {
						field[x - 1][y - 1] += 1;
					} catch (Exception ignored){}
					try {
						field[x + 1][y + 1] += 1;
					} catch (Exception ignored){}
					try {
						field[x][y - 1] += 1;
					} catch (Exception ignored){}
					try {
						field[x][y + 1] += 1;
					} catch (Exception ignored){}
					try {
						field[x + 1][y] += 1;
					} catch (Exception ignored){}
					try {
						field[x - 1][y] += 1;
					} catch (Exception ignored){}
					try {
						field[x + 1][y - 1] += 1;
					} catch (Exception ignored){}
					try {
						field[x - 1][y + 1] += 1;
					} catch (Exception ignored){}
				}
			}
			
		}
	}
}
