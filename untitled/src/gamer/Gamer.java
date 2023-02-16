package gamer;

import java.util.Random;

public class Gamer {
    int x,y;
    String value;
    String[][] field;

    public Gamer(String[][] field){
        this.field=field;
    }

    public void getMove(String[][] field, String value){

        while(true) {
            int x=getRandomXY();
            int y=getRandomXY();
            if (field[x][y]==null) {
                field[x][y] = value;
                return;
            }
        }
    }

    int getRandomXY(){
        Random random=new Random();
        return random.nextInt(3-0)+0;
    }

}
