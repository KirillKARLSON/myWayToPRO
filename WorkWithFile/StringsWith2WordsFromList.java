package WorkWithFile;

/*Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words.
Закрыть потоки.

Пример:
words содержит слова А, Б, В (количество слов в списке words может быть любым).

Строки:
В Б А Д //3 слова из words, не подходит
А Б А Д //3 слова из words, не подходит
Д А Д //1 слово из words, не подходит
Д А Б Д //2 слова - подходит, выводим
Д А А Д //2 слова - подходит, выводим

Требования:
•	Класс Solution должен содержать публичное статическое поле words типа List<String>, которое должно быть сразу проинициализировано.
•	Класс Solution должен содержать статический блок, в котором добавляются три или больше слов в список words.
•	Программа должна считывать имя файла с консоли (используй BufferedReader).
•	BufferedReader для считывания данных с консоли должен быть закрыт.
•	Программа должна считывать содержимое файла (используй FileReader).
•	Поток чтения из файла (FileReader) должен быть закрыт.
•	Программа должна выводить в консоль все строки из файла, которые содержат всего 2 слова из списка words */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StringsWith2WordsFromList {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        reader.close();

        BufferedReader reader1 = new BufferedReader(new FileReader(path));

        while(reader1.ready()){

            String bufOut = reader1.readLine();
            String [] buf = bufOut.split(" ");
            int count = 0;
            for (String word: words){
                for (int i = 0; i<buf.length; i++){
                    if (word.equals(buf[i])) count=count+1;
                }
            }
            if (count == 2) System.out.println(bufOut);
        }

    }

}
