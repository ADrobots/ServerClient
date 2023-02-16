package field;

import gamer.Gamer;

import java.util.Random;

public class Field {
    private static Field pole;
    String[][] field=new String[3][3];

    void printField(){
        for (int i=0;i< field.length;i++){
            for (int j=0; j< field.length; j++){
                System.out.print(field[i][j]+" ");
            }
            System.out.println();
        }
    }

    void cleanField(){
        for (int i=0;i< field.length;i++){
            for (int j=0; j< field.length; j++){
                field[i][j]="";
            }
        }
    }

    public static void main(String[] args) {
        Field pole=new Field();
        Gamer gamer=new Gamer(pole.field);
        Gamer gamer2=new Gamer(pole.field);


        gamer.getMove(pole.field, "+");
        pole.printField();
        System.out.println();
        gamer2.getMove(pole.field, "-");
        pole.printField();
        System.out.println();
        gamer.getMove(pole.field, "+");
        pole.printField();
        System.out.println();
        gamer2.getMove(pole.field, "-");
        pole.printField();
        System.out.println();
        gamer.getMove(pole.field, "+");
        pole.printField();
        System.out.println();
    }
}
