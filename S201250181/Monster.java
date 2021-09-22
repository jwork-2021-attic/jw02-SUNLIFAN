package S201250181;

import java.util.HashMap;

import S201250181.Line.Position;
public class Monster implements Linable{
    public static HashMap<Integer,Monster> monsters = new HashMap<>();
    private int r;
    private int g;
    private int b;
    private int rank;
    private Position position;
    
    public Monster(Color c){
        this.r = c.getR();
        this.g = c.getG();
        this.b = c.getB();
        this.rank = 1000*r+b+g;
        monsters.put(rank,this);

    }

    public static Monster getMonsterByRank(int rank){
        return monsters.get(rank);
    }

    public int rank(){return rank;}

    public void swapPosition(Monster another){
        Position p = another.position;
        this.position.setLinable(another);
        p.setLinable(this);
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public int getValue() {
        return rank;
    }

    public String toString() {
        return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m    " + this.rank() + "  \033[0m";
    }

}
