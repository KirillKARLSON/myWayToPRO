package Multithreading.Hippodrome;

public class Horse {
    String name;
    double speed;
    double distance;

    public Horse(String name, double speed, double distance){
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName(){
        return name;
    }

    public double getSpeed(){
        return speed;
    }

    public double getDistance(){
        return distance;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSpeed(double speed){
        this.speed = speed;
    }

    public void setDistance(double distance){
        this.distance = distance;
    }


    public void move(){
        distance+=speed*Math.random();
    }

    public void print(){
        int points = (int) distance;
        for (int i = 0; i<points; i++){
            System.out.print(".");
        }
        String horseName = getName();
        System.out.println(horseName);
    }
}
