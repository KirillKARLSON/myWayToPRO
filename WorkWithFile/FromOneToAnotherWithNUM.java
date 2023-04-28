/*В метод main первым параметром приходит имя файла1, вторым - файла2.
        Файл1 содержит строки со словами, разделенными пробелом.
        Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1, abc3d или 564.
        Закрыть потоки.

        Требования:
        •	Программа НЕ должна считывать данные с консоли.
        •	Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
        •	Поток чтения из файла (FileReader) должен быть закрыт.
        •	Программа должна записывать во второй файл все слова из первого файла которые содержат цифры (используй FileWriter).
        •	Поток записи в файл (FileWriter) должен быть закрыт.*/

package WorkWithFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class FromOneToAnotherWithNUM {
    public static void main(String[] args) throws Exception{

        String file1 = args[0];
        String file2 = args[1];


    ArrayList<String> content1 = new ArrayList<>();
        try(BufferedReader read1 = new BufferedReader(new FileReader(file1)))
        {
        while (read1.ready()) {
            content1.add(read1.readLine());
        }
    }

        BufferedWriter write1 = new BufferedWriter(new FileWriter(file2));

        for (String str : content1) {

            String [] masBuf = str.split(" ");


           for(int i = 0; i<masBuf.length; i++) {


               if (masBuf[i].contains("0") || masBuf[i].contains("1") || masBuf[i].contains("2") || masBuf[i].contains("3") || masBuf[i].contains("4") || masBuf[i].contains("5") || masBuf[i].contains("6") || masBuf[i].contains("7") || masBuf[i].contains("8") || masBuf[i].contains("9")){
                   write1.write(masBuf[i] + " ");
               }
           }
        } write1.close();



}
}
