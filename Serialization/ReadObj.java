package Serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadObj {
    public static void main(String[] args) throws Exception{
        FileInputStream read = new FileInputStream("Expir.txt");
        ObjectInputStream ois = new ObjectInputStream(read);

        Cat bars = (Cat) ois.readObject();
        Cat vas = (Cat) ois.readObject();

        System.out.println(bars);
        System.out.println(vas);

        read.close();
        ois.close();

        System.out.println(400/15);

    }
}
