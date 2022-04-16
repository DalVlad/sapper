package gi.buttons;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import gi.Start;
import logics.FieldGeneration;
import logics.FieldOpening;
import stats.Statistics;

public class Cell {

	public static int difficultyLevel;
	private static int x = 0;
	private static int y = 0;
	private static int allOpenCell = 0;
	private final int X;
	private final int Y;

	private JButton button = new JButton();

	/**
	 * Создает кнопку и располагает её на панеле
	 * @param window Окно в котором будут распологаться кнопки
	 * @param y Ширина поля
	 * @param i Счетчик цикла. Используется для хранения расположения кнопки по координате "X"
	 * @param j Счетчик цикла. Используется для хранения расположения кнопки по координате "Y"
	 */
	public Cell(JPanel window, int y, int i, int j) {
		this.X = i;
		this.Y = j;
		GridBagConstraints c = new GridBagConstraints();
		button.setPreferredSize(new Dimension(32, 32));
		button.setFont(new Font(null, Font.BOLD, 20));
		button.setMargin(new Insets(0, 0, 0, 0));
		c.gridx = Cell.x;
		c.gridy = Cell.y;
		Cell.x += 1;
		if(Cell.x == y) {
			Cell.y += 1;
			Cell.x = 0;
		}
		window.add(button, c);
		action();
	}

	/**
	 * Метод создает обработчик при нажатии на кнопку
	 */
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

	/**
	 * Метод запускается при проигрыше
	 */
	private static void loss()
	{
		for(Cell[] cell: Start.fieldCell){
			for(Cell cell1: cell){
				cell1.setAllIcon();
			}
		}
		allOpenCell = 0;
		Start.openWindowLoss();
	}

	/**
	 * Метод запускается при выигрыше
	 */
	private static void win(){
		for(Cell[] cell: Start.fieldCell){
			for(Cell cell1: cell){
				cell1.setAllIcon();
			}
		}
		Start.openWindowWin();
	}

	/**
	 * Метод устанавливает все иконки на поле
	 */
	private void setAllIcon(){
		if(button.isEnabled()){
			button.setEnabled(false);
			button.setIcon(new ImageIcon("images/cell.png"));
			button.setDisabledIcon(new ImageIcon("images/cell.png"));
		}
		if(Start.field[X][Y] >= 10){
			button.setIcon(new ImageIcon("images/bomb.png"));
			button.setDisabledIcon(new ImageIcon("images/bomb.png"));
		}
	}

	/**
	 * Метод показывающий количество бомб рядом
	 * @param number Количество бомб поблизости
	 */
	private void setIconNumber(int number)
	{
		button.setIcon(new ImageIcon(String.format("images/number-%s.png", number)));
		button.setDisabledIcon(new ImageIcon(String.format("images/number-%s.png", number)));
	}

	/**
	 * Метод определяющий какую иконку установить.
	 * Также запускает методы проигрыша "loss" и выигрыша "win"
	 */
	public void setIcon()
	{
		if(button.isEnabled())
		{
			allOpenCell++;
			button.setEnabled(false);
			String str =  Integer.toString(Start.field[X][Y]);
			if(!("0".equals(str)) & Start.field[X][Y] < 10)
			{
				setIconNumber(Start.field[X][Y]);
			}else if(Start.field[X][Y] >= 10){
				Statistics.writeStatistic(difficultyLevel, 0, allOpenCell);
				loss();
			}
			if(allOpenCell + 1 == ((Start.field.length * Start.field[0].length) - Start.maxBomb)){
				Statistics.writeStatistic(difficultyLevel, 1, allOpenCell);
				allOpenCell = 0;
				win();
			}
		}
	}

	/**
	 * Определяет влюченна кнопка или нет
	 */
	public boolean isEnabled()	{
		return button.isEnabled();
	}
}

