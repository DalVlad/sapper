package logics;

import gi.Start;

public class FieldOpening {
	
	public static void openCells(int x, int y, int[][] field)
	{
		if(Start.fieldCell[x][y].isEnabled()){
			Start.fieldCell[x][y].setIcon();
		}
		if (field[x][y] == 0) {
			try {
				if(Start.fieldCell[x - 1][y - 1].isEnabled()) {
					Start.fieldCell[x - 1][y - 1].setIcon();
					if(field[x - 1][y - 1] == 0) {
						openCells(x - 1, y - 1, field);
					}
				}
			} catch (Exception ignored){}
			try {
				if(Start.fieldCell[x + 1][y + 1].isEnabled()) {
					Start.fieldCell[x + 1][y + 1].setIcon();
					if(field[x + 1][y + 1] == 0) {
						openCells(x + 1, y + 1, field);
					}
				}
			} catch (Exception ignored){}
			try {
				if(Start.fieldCell[x][y - 1].isEnabled()) {
					Start.fieldCell[x][y - 1].setIcon();
					if(field[x][y - 1] == 0) {
						openCells(x, y - 1, field);
					}
				}
			} catch (Exception ignored){}
			try {
				if(Start.fieldCell[x][y + 1].isEnabled()) {
					Start.fieldCell[x][y + 1].setIcon();
					if(field[x][y + 1] == 0) {
						openCells(x, y + 1, field);
					}
				}
			} catch (Exception ignored){}
			try {
				if(Start.fieldCell[x + 1][y].isEnabled()) {
					Start.fieldCell[x + 1][y].setIcon();
					if(field[x + 1][y] == 0) {
						openCells(x + 1, y, field);
					}
				}
			} catch (Exception ignored){}
			try {
				if(Start.fieldCell[x - 1][y].isEnabled()) {
					Start.fieldCell[x - 1][y].setIcon();
					if(field[x - 1][y] == 0) {
						openCells(x - 1, y, field);
					}
				}
			} catch (Exception ignored){}
			try {
				if(Start.fieldCell[x + 1][y - 1].isEnabled()) {
					Start.fieldCell[x + 1][y - 1].setIcon();
					if(field[x + 1][y - 1] == 0) {
						openCells(x + 1, y - 1, field);
					}
				}
			} catch (Exception ignored){}
			try {
				if(Start.fieldCell[x - 1][y + 1].isEnabled()) {
					Start.fieldCell[x - 1][y + 1].setIcon();
					if(field[x - 1][y + 1] == 0) {
						openCells(x - 1, y + 1, field);
					}
				}
			} catch (Exception ignored){}
		}
	}

}