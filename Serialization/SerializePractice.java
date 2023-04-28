package Serialization;

/*Сериализуй класс Solution.
Подумай, какие поля не нужно сериализовать, пометь ненужные поля модификатором transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.

Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream);
2) создать экземпляр класса Solution - savedObject;
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть);
4) создать другой экземпляр класса Solution с другим параметром;
5) загрузить из потока на чтение объект - loadedObject;
6) проверить, что savedObject.string равна loadedObject.string;
7) обработать исключения.

Требования:
•	Поле pattern должно быть отмечено модификатором transient.
•	Поле currentDate должно быть отмечено модификатором transient.
•	Поле temperature должно быть отмечено модификатором transient.
•	Поле string НЕ должно быть отмечено модификатором transient.*/

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SerializePractice implements Serializable{
    public static void main(String[] args) throws IOException {


        SerializePractice saveObj = new SerializePractice(4);

        System.out.println(saveObj.toString());
    try {
        FileOutputStream fos = new FileOutputStream("Expire.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(saveObj);
        fos.close();
        oos.close();

    }catch (FileNotFoundException e){
        System.out.println("Хуй вам");
    }

    SerializePractice loadObj;
    try {
        FileInputStream fis = new FileInputStream("Expire.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        loadObj = (SerializePractice) ois.readObject();
        fis.close();
        ois.close();
        System.out.println(loadObj.toString());


    } catch (FileNotFoundException e){
        System.out.println("Хуй вам");
    } catch (ClassNotFoundException e) {
        throw new RuntimeException(e);
    }



    }

    transient private final String pattern = "dd MMMM yyyy, EEEE, HH:mm:ss";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public SerializePractice(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
