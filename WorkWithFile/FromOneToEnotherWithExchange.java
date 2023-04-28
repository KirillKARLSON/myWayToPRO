package WorkWithFile;

/*Cчитать с консоли 2 имени файла.
        Первый Файл содержит текст.
        Считать содержимое первого файла и заменить все точки "." на знак "!".
        Результат вывести во второй файл.
        Закрыть потоки.

        Требования:
        •	Программа должна считывать имена файлов с консоли (используй BufferedReader).
        •	BufferedReader для считывания данных с консоли должен быть закрыт.
        •	Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
        •	Поток чтения из файла (BufferedReader) должен быть закрыт.
        •	Программа должна записывать во второй файл содержимое первого файла, где заменены все точки "." на знак "!" (Для записи в файл используй BufferedWriter с конструктором FileWriter).
        •	Поток записи в файл (BufferedWriter) должен быть закрыт/*/


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FromOneToEnotherWithExchange {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();


        ArrayList <String> content1 = new ArrayList<>();
        try (BufferedReader read1 = new BufferedReader(new FileReader(file1))) {
            while (read1.ready()){
                content1.add(read1.readLine());
            }
        }

        for(String str:content1){
            System.out.println(str);
        }


        try(BufferedWriter write1 = new BufferedWriter(new FileWriter(file2))){
            for(String str: content1){
                write1.write(str.replaceAll("\\.","!"));
            }



        }

    }
}
