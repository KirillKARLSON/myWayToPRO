package WorkWithFile;
/*В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров

Требования:
Программа НЕ должна считывать данные с консоли.
Программа должна считывать содержимое файла (используй FileReader).
Поток чтения из файла (FileReader) должен быть закрыт.
Программа должна выводить в консоль имена, у которых максимальная сумма*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class MostRichFromFileTreeMap{
    public static void main(String[] args) throws Exception{
        TreeMap<String, Double> workers = new TreeMap<>();
        String fileName = args[0];//"C:\\Users\\HP\\Desktop\\File1.txt";
        double maxFee = 0;

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        while (reader.ready()){
            String[] bufMas = reader.readLine().split(" ");
            if (workers.containsKey(bufMas[0])){
                double val = workers.get(bufMas[0]) + Double.parseDouble(bufMas[1]);
                if (val> maxFee) maxFee = val;
                workers.remove(bufMas[0]);
                workers.put(bufMas[0], val);
            } else {
                workers.put(bufMas[0], Double.parseDouble(bufMas[1]));
                if (Double.parseDouble(bufMas[1])>maxFee) maxFee=Double.parseDouble(bufMas[1]);
            }
        }




        for (Map.Entry<String, Double> str: workers.entrySet()){
            if (str.getValue() == maxFee) System.out.println(str.getKey()+ " "+ str.getValue());
        }

    }
}
