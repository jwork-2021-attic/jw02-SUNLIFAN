package S201250181;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Scene {
    public static void main(String[] args) throws IOException {
        Color[] colors = RandomGenerator.generateColor(64);

        for(int i = 0; i < 64; i ++){
            new Monster(colors[i]);
        }
        Line line = new Line(64);
        int index = 0;
        for(Monster m:Monster.monsters.values()){
            line.put(m,index);
            index++;
        }

        Snake theSnake = Snake.getTheSnake();

        Sorter sorter = new QuickSorter();
        //Sorter sorter = new InsertionSorter();
        theSnake.setSorter(sorter);

        String log = theSnake.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result1.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }
    
}
