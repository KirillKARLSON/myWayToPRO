package WorkWithFile;

/*Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).

Пример:
','=44, 's'=115, 't'=116.

Вывести на консоль отсортированный результат:
[символ1] частота1
[символ2] частота2
Закрыть потоки.

Пример вывода:
, 19
- 7
f 361

Требования:
•	Считывать с консоли ничего не нужно.
•	Создай поток для чтения из файла, который приходит первым параметром в main.
•	В файле необходимо посчитать частоту встречания каждого символа и вывести результат.
•	Выведенный в консоль результат должен быть отсортирован по возрастанию кода ASCII.
•	Поток для чтения из файла должен быть закрыт.*/
import java.io.FileInputStream;
import java.util.Map;
import java.util.TreeMap;

public class CountsOfEverySymbols {

    public static void main(String[] args) throws Exception{
        TreeMap<Character, Integer> symbols = new TreeMap<>();

        FileInputStream inputStream = new FileInputStream(args[0]);

        while (inputStream.available()>0){
            char k = (char) inputStream.read();

            if (symbols.containsKey(k)){
                int count = symbols.get(k)+1;
                symbols.remove(k);
                symbols.put(k, count);
            }
            else{
                symbols.put(k, 1);
            }
        }
        inputStream.close();

        for (Map.Entry<Character, Integer> set: symbols.entrySet()){
            System.out.println(set.getKey()+ " "+ set.getValue());
        }
    }
}
