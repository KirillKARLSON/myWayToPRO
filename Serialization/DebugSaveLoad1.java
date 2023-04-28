package Serialization;

/*После десериализации объекта класса Solution обнаружили, что данных в словаре [m] нет :(

Исправить 1 ошибку.

Требования:
В классе Solution должен существовать конструктор без параметров.
В классе Solution должен существовать метод size без параметров.
В классе Solution метод size должен возвращать значение типа int.  В итоге в конструкторе Solution был лишний модификатор void*/


import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DebugSaveLoad1 implements Serializable {
    public static void main(String args[]) throws Exception {
        FileOutputStream fileOutput = new FileOutputStream("Expir.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        DebugSaveLoad1 solution = new DebugSaveLoad1();
        outputStream.writeObject(solution);

        System.out.println(solution.getMap());

        fileOutput.close();
        outputStream.close();

        //load
        FileInputStream fiStream = new FileInputStream("Expir.txt");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);

        DebugSaveLoad1 loadedObject = (DebugSaveLoad1) objectStream.readObject();

        fiStream.close();
        objectStream.close();

        //Attention!!
        System.out.println(loadedObject.size());
    }

    public Map<String, String> m = new HashMap<>();

    public Map<String, String> getMap() {
        return m;
    }

    public DebugSaveLoad1 () {
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
    }

    public int size() {
        return m.size();
    }
}
