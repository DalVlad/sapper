package gi;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;

import gi.buttons.*;
import stats.Statistics;

public class Start
{
	
	private static int x;
	private static int y;
	private static JFrame windowGame = null;
	private static JFrame windowLoss = null;
	private static JFrame windowWin = null;
	private static JFrame windowStart = null;
	private static JFrame windowStatistics = null;
	public static int maxBomb;
	public static Cell[][] fieldCell;
	public static int[][] field;

	/**
	 * Конструктор создает все необходимые окна
	 */
	public Start()
	{
		windowLossCreation();
		windowWinCreation();
		windowStartCreation();
		windowStatisticsCreation();
		windowStart.setVisible(true);
	}

	/**
	 * Метод создает массив кнопок и массив чисел затем запускает метод "start"
	 * @param x Высота игрового поля
	 * @param y Ширина игрового поля
	 * @param maxBomb Количество бомб
	 */
	private void settingPreferences(int x, int y, int maxBomb){
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

	/**
	 * Метод создает игровое окно с кнопоками и отображает его
	 */
	private static void start()
	{
		windowGame = new JFrame();
		windowGame.setTitle("Sapeur");
		JPanel panelCenter = windowCreation(windowGame);
		for(int i = 0; i < Start.x; i += 1)
			for(int j = 0; j < Start.y; j += 1)
		{
			fieldCell[i][j] = new Cell(panelCenter, Start.y, i, j);
		}
		if(Start.maxBomb == 10){
			Cell.difficultyLevel = 0;
		}else if(Start.maxBomb == 40){
			Cell.difficultyLevel = 1;
		}else {
			Cell.difficultyLevel = 2;
		}
		windowGame.pack();
		windowGame.setResizable(false);
		windowGame.setVisible(true);
	}

	public static void openWindowLoss(){
		windowLoss.setVisible(true);
	}

	public static void openWindowWin(){
		windowWin.setVisible(true);
	}

	/**
	 * Метод создания стартового окна с выбором сложности
	 */
	private void windowStartCreation(){
		windowStart = new JFrame();
		windowStart.setTitle("Game difficulty");
		JPanel panelCenter = Start.windowCreation(windowStart);
		JButton buttonSimple = buttonCreation("Simple");
		JButton buttonAverage = buttonCreation("Average");
		JButton buttonExpert = buttonCreation("Expert");
		JButton buttonStatistics = buttonCreation("Statistics");
		buttonSimple.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				windowStart.setVisible(false);
				settingPreferences(9, 9, 10);
			}
		});
		buttonAverage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				windowStart.setVisible(false);
				settingPreferences(16, 16, 40);
			}
		});
		buttonExpert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				windowStart.setVisible(false);
				settingPreferences(30, 16, 99);
			}
		});
		buttonStatistics.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				windowStart.setVisible(false);
				windowStatisticsCreation();
				windowStatistics.setVisible(true);
			}
		});
		panelCenter.add(buttonSimple);
		panelCenter.add(buttonAverage);
		panelCenter.add(buttonExpert);
		panelCenter.add(buttonStatistics);
		windowStart.pack();
		windowStart.setResizable(false);
	}

	private void windowLossCreation(){
		windowLoss = new JFrame();
		windowLoss.setTitle("Loss");
		windowCreationCloseAndRestart(windowLoss);
	}

	private void windowWinCreation(){
		windowWin = new JFrame();
		windowWin.setTitle("Win");
		windowCreationCloseAndRestart(windowWin);
	}

	/**
	 * Метод для создания окна с кнопками "Restart" и "Close"
	 * @param window
	 */
	private void windowCreationCloseAndRestart(JFrame window){
		JPanel panelCenter = Start.windowCreation(window);
		JButton buttonClose = buttonCreation("Close");
		JButton buttonRestart = buttonCreation("Restart");
		buttonRestart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				window.setVisible(false);
				windowGame.setVisible(false);
				windowGame = null;
				new Start();
			}
		});
		buttonClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		panelCenter.add(buttonClose);
		panelCenter.add(buttonRestart);
		window.pack();
		window.setResizable(false);
	}

	private void windowStatisticsCreation(){
		windowStatistics = new JFrame();
		JPanel panelCenter = windowCreation(windowStatistics);
		panelCenter.setBackground(Color.WHITE);
		windowStatistics.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		collectStatistics(panelCenter);
		windowStatistics.pack();
		windowStatistics.setResizable(false);
	}

	/**
	 * Сбор статистики и размещение её на панеле
	 * @param panelCenter Панель на которой будет размещаться статистика
	 */
	private void collectStatistics(JPanel panelCenter){
		int[] statistics = Statistics.getStatisticSAEA();
		List<JComponent> component = new ArrayList<JComponent>();
		Font font = new Font(null, Font.PLAIN, 20);
		component.add(new JLabel("Win Simple = " + statistics[0]));
		component.add(new JLabel("Win Average = " + statistics[1]));
		component.add(new JLabel("Win Expert = " + statistics[2]));
		component.add(new JLabel("Total open cells = " + statistics[3]));
		component.add(buttonCreation("Back"));
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		for(int i = 0; i < component.size() - 1; i++, c.gridy += 1){
			component.get(i).setFont(font);
			panelCenter.add(component.get(i), c);
		}
		((JButton)component.get(component.size() - 1)).addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				windowStart.setVisible(true);
				windowStatistics.setVisible(false);
				windowStatistics.removeAll();
			}
		});
		panelCenter.add(component.get(component.size() - 1), c);
	}

	private static JButton buttonCreation(String text){
		JButton button = new JButton();
		button.setPreferredSize(new Dimension(200, 50));
		button.setText(text);
		return button;
	}

	/**
	 * Метод для создания всех окон для игры
	 * @param window
	 * @return Возвращает центральную панель окна
	 */
	public static JPanel windowCreation(JFrame window){
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
		return panelCenter;
	}
}
