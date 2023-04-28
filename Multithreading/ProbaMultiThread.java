package Multithreading;

public class ProbaMultiThread extends Thread{
public String name;

public ProbaMultiThread(String name){
    this.name = name;
}

public String getMyName(){
    return this.name;
}

    public void run(){
        System.out.println("Hello!! I'm "+ getMyName());
    }
}
