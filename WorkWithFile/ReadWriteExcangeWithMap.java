package WorkWithFile;


/*1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно.
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла, считать содержимое файла.
3. Заменить все числа на слова используя словарь map.
4. Результат вывести на экран.
5. Закрыть потоки.

Пример данных в файле:
Это стоит 1 бакс, а вот это - 12.
Переменная имеет имя file1.
110 - это число.

Пример вывода в консоль:
Это стоит один бакс, а вот это - двенадцать.
Переменная имеет имя file1.
110 - это число.

Требования:
•	Класс Solution должен содержать публичное статическое поле map типа Map<Integer, String>, которое должно быть сразу проинициализировано.
•	Программа должна считывать имя файла с консоли (используй BufferedReader).
•	BufferedReader для считывания данных с консоли должен быть закрыт.
•	Программа должна считывать содержимое файла (используй FileReader).
•	Поток чтения из файла (FileReader) должен быть закрыт.
•	Программа должна выводить в консоль все строки из файла, но числа должны быть заменены на слова из словаря map.
•	Класс Solution должен содержать статический блок, в котором добавляются в map тринадцать пар*/


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReadWriteExcangeWithMap {

    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {

        map.put(0, "ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7,"семь");
        map.put(8, "восемь");
        map.put(9,"девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws Exception{


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

       String outString = "";
        try(BufferedReader read1 = new BufferedReader(new FileReader(fileName)))
        {
            while ((outString = read1.readLine()) != null) {

                for (Map.Entry <Integer, String> entry: map.entrySet()){
                    outString = outString.replaceAll("\\b"+entry.getKey()+"\\b", entry.getValue());
                }
                System.out.println(outString);
            }
        }


    }
}
