package S201250181;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Scene {
    public static void main(String[] args) throws IOException {
        int row = 8;
        int col = 8;

        Color[] colors = RandomGenerator.generateColor(row*col);

        for(int i = 0; i < row*col; i ++){
            new Monster(colors[i]);
        }
        
        Matrix matrix = new Matrix(row,col);
        int index = 0;
        for(Monster m:Monster.monsters.values()){
            matrix.put(m,index);
            index++;
        }

        Snake theSnake = Snake.getTheSnake();

        Sorter sorter = new QuickSorter();
        //Sorter sorter = new InsertionSorter();
        theSnake.setSorter(sorter);

        String log = theSnake.lineUp(matrix);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result3.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }
    
}
