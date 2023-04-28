package Multithreading;

public class OneHandOfYeld extends Thread {

    public OneHandOfYeld(){
        this.start();
    }

    public static void main(String[] args) {
        new OneHandOfYeld();
        new OneHandOfYeld();
        new OneHandOfYeld();

    }

    public void run(){
        System.out.println(Thread.currentThread().getName() + " уступает дорогу");
        Thread.yield();
        System.out.println (Thread.currentThread().getName() + " продолжает движение");
    }
}
