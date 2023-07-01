package Multithreading.Hippodrome;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    public static Hippodrome game;
    private List<Horse> horses;


    public Hippodrome(List horses){
        this.horses = horses;
    }

    public List getHorses(){
        return horses;
    }
    public static void main(String[] args) throws InterruptedException{


        ArrayList<Horse> horses = new ArrayList<>();


        horses.add(new Horse("Star", 3.0, 0.0));
        horses.add(new Horse("York", 3.0, 0.0));
        horses.add(new Horse("Sheila", 3.0, 0.0));

        game = new Hippodrome(horses);

        game.run();



        game.printWinner();

    }

    public void run() throws InterruptedException{
        for (int i = 1; i<=20; i++){
            move();
            print();
            Thread.sleep(1000);
        }

    }

    public void move(){
        for(Horse h: horses){
            h.move();
        }
    }

    public void print() throws InterruptedException{
        for(Horse h: horses){
            h.print();
        }

        Thread.sleep(2000);

        for(int i = 0; i<10; i++){
            System.out.println();
        }
    }

    public Horse getWinner(){
        Horse winner = horses.get(0);

        for(Horse hor: horses){
            if (hor.getDistance() > winner.getDistance()){
                winner = hor;
            }

        }
        return winner;
    }


    public void printWinner(){
        System.out.println("Winner is "+ getWinner().getName());
    }
}
