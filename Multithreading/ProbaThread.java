package Multithreading;

public class ProbaThread {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            ProbaMultiThread poehali = new ProbaMultiThread("Корова "+i);

            poehali.start();


            try {
                Thread.sleep(500);
                //poehali.join();
            } catch(InterruptedException e){}

        }

        long finish = System.currentTimeMillis();
        System.out.println("Программа работала "+ (finish-start)+" миллисекунд");
        }
    }

