/*Считать с консоли имя файла.
        Файл содержит слова, разделенные знаками препинания.
        Вывести в консоль количество слов "world", которые встречаются в файле.
        Закрыть потоки.

        Требования:
        •	Программа должна считывать имя файла с консоли (используй BufferedReader).
        •	BufferedReader для считывания данных с консоли должен быть закрыт.
        •	Программа должна считывать содержимое файла (используй FileReader c конструктором принимающим String).
        •	Поток чтения из файла (FileReader) должен быть закрыт.
        •	Программа должна выводить в консоль количество слов "world", которые встречаются в файле*/


package WorkWithFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CountsOfWordinText {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();

        reader.close();


        ArrayList<String> content1 = new ArrayList<>();
        try (BufferedReader read1 = new BufferedReader(new FileReader(file1))) {
            while (read1.ready()){
                content1.add(read1.readLine());
            }
        }

        int count = 0;

        for(String str:content1){

            System.out.println(Arrays.toString(str.split("world")));
            count+= str.split("world", -1).length-1;
        }

        System.out.println(count);


            }

}
