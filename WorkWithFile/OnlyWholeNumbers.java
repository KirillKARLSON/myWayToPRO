/*Считать с консоли 2 пути к файлам.
        Вывести во второй файл все целые числа, которые есть в первом файле (54у не является числом).
        Числа выводить через пробел.
        Закрыть потоки.

        Пример тела файла:
        12 text var2 14 8ю 1

        Результат:
        12 14 1

        Требования:
        •	Программа должна считывать пути к файлам с консоли (используй BufferedReader).
        •	BufferedReader для считывания данных с консоли должен быть закрыт.
        •	Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором принимающим FileReader).
        •	Поток чтения из файла (BufferedReader) должен быть закрыт.
        •	Программа должна записывать во второй файл все числа, через пробел, из первого файла (используй BufferedWriter с конструктором FileWriter).
        •	Поток записи в файл (BufferedWriter) должен быть закрыт*/



package WorkWithFile;

import java.io.*;
import java.util.ArrayList;

public class OnlyWholeNumbers {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        reader.close();


        ArrayList<String> content1 = new ArrayList<>();
        try (BufferedReader read1 = new BufferedReader(new FileReader(file1))) {
            while (read1.ready()) {
                content1.add(read1.readLine());
            }
        }


        try (BufferedWriter write1 = new BufferedWriter(new FileWriter(file2))) {
            for (String str : content1) {
                String[] spl = str.split(" ");
                for (String world : spl) {
                    try {
                        int c = Integer.parseInt(world);
                        write1.write(c + " ");
                    } catch (Exception ignore) {
                    }
                }
            }
        }


    }
}