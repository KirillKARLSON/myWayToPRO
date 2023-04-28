package Serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteObj {
    public static void main(String[] args) throws Exception{
        Cat cat1 = new Cat(1, "Барсик");
        Cat cat2 = new Cat(2, "Васька");

        FileOutputStream fos = new FileOutputStream("Expir.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(cat1);
        oos.writeObject(cat2);


        oos.close();
        fos.close();
    }
}
