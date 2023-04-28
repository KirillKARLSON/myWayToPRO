package WorkWithFile;

/*Считать с консоли 2 имени файла.
        Вывести во второй файл все символы с четным порядковым номером (нумерация начинается с 1).

        Пример первого файла:
        text in file
        Вывод во втором файле:
        eti ie
        Закрыть потоки ввода-вывод

        Требования:
        •	Программа должна считывать имена файлов с консоли (используй BufferedReader).
        •	BufferedReader для считывания данных с консоли должен быть закрыт.
        •	Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
        •	Поток чтения из файла (FileReader) должен быть закрыт.
        •	Программа должна записывать во второй файл все символы из первого файла с четным порядковым номером (используй FileWriter).
        •	Поток записи в файл (FileWriter) должен быть закрыт.
    */



import java.io.*;

public class FromOneToAnother {
    public static void main(String[] args) throws Exception {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(reader.readLine());
        File file2 = new File(reader.readLine());

        FileReader read1 = new FileReader(file1);
        FileWriter write1 = new FileWriter(file2);

        int i = 0;

        while (read1.ready()) {
            i++;
            char buf = (char) read1.read();
            if (i%2 ==0) write1.write(buf);
        }

        write1.close();
        read1.close();


    }
}
