package WorkWithFile;


/* В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени.
Закрыть потоки.

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0

Требования:
•	Программа НЕ должна считывать данные с консоли.
•	Программа должна считывать содержимое файла (используй FileReader).
•	Поток чтения из файла (FileReader) должен быть закрыт.
•	Программа должна выводить в консоль каждое имя и сумму всех его значений, все данные должны быть отсортированы в возрастающем порядке по имени*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class ReadFileToMap {

    public static void main(String[] args) throws Exception {

        TreeMap<String, Double> workers = new TreeMap<>();

        String file = "C:\\Users\\HP\\Desktop\\File1.txt";
        BufferedReader reader = new BufferedReader(new FileReader(file));


        while (reader.ready()){
            String[] bufMas = reader.readLine().split(" ");
            if (workers.containsKey(bufMas[0])){
                double val = workers.get(bufMas[0]) + Double.parseDouble(bufMas[1]);
                workers.remove(bufMas[0]);
                workers.put(bufMas[0], val);
            } else {
                workers.put(bufMas[0], Double.parseDouble(bufMas[1]));
            }
        }

        for (Map.Entry<String, Double> str: workers.entrySet()){
            System.out.println(str.getKey()+ " "+ str.getValue());
        }
    }
}
