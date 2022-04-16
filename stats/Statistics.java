package stats;

import java.io.*;

public abstract class Statistics {

    /**
     * statisticSAEA - Статистика Simple, Average, Expert, allOpenCell
     * statisticSAEA[0] - Win Simple
     * statisticSAEA[1] - Win Average
     * statisticSAEA[2] - Win Expert
     * statisticSAEA[3] - Total open cells
     */
    private static File statistic = new File("stats" + File.separator + "statistic.bin");
    public static int[] statisticSAEA = new int[]{0, 0, 0, 0};

    /**
     * Записывает статистику в файл
     * @param difficultyLevel
     * @param lossOrWin Два значения
     *                  0 - loss
     *                  1 - win
     * @param allOpenCell
     */
    public static void writeStatistic(int difficultyLevel, int lossOrWin, int allOpenCell){
        try {
            if(!statistic.exists()){
                statistic.createNewFile();
            }else{
                FileInputStream fis = new FileInputStream(statistic);
                ObjectInputStream ois = new ObjectInputStream(fis);
                statisticSAEA = (int[]) ois.readObject();
                ois.close();
            }
            writeFile(difficultyLevel, lossOrWin, allOpenCell);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Считывает статистику из файла
     */
    private static void readStatistic(){
        try {
            if(!statistic.exists()){
                statistic.createNewFile();
                writeFile(0, 0, 0);
            }
            FileInputStream fis = new FileInputStream(statistic);
            ObjectInputStream ois = new ObjectInputStream(fis);
            statisticSAEA = (int[]) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int[] getStatisticSAEA(){
        readStatistic();
        return statisticSAEA;
    }

    private static void writeFile(int difficultyLevel, int lossOrWin, int allOpenCell) throws IOException {
        statisticSAEA[difficultyLevel] += lossOrWin;
        statisticSAEA[3] += allOpenCell;
        FileOutputStream fos = new FileOutputStream(statistic);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(statisticSAEA);
        oos.close();
    }

}
