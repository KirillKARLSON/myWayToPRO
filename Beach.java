
public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public synchronized int compareTo(Beach anotherBeach){
        int p = 0;

        if (this.quality == anotherBeach.quality){
            p+=0;
        }
        else if (this.quality > anotherBeach.quality){
            p +=1;

        }

        else {
            p -=1;
        }

        if (this.distance == anotherBeach.distance){
            p +=0;
        }
        else if (this.distance < anotherBeach.distance){
            p +=1;
        }
        else {
            p -=1;}

        return p;

    }

    public static void main(String[] args) {
        Beach beach1 = new Beach ("Малибу", 1000F, 1000);
        Beach beach2 = new Beach ("Анапа", 1500F, 300);

        System.out.println(beach1.compareTo(beach2));


    }



}
