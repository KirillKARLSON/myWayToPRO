package WorkWithFile;

/*В метод main первым параметром приходит путь к файлу1, вторым - путь к файлу2.
Файл1 содержит слова, разделенные пробелом или переводом строки (в файле может быть несколько строк).
Все, что не относится к пробелу или переводу строки, разделителем не считать.
Записать в одну строку через запятую в Файл2 слова, длина которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.

Пример выходных данных в файл2:
длинное,короткое,аббревиатура

Требования:
Программа НЕ должна считывать данные с консоли.
Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
Поток чтения из файла (FileReader) должен быть закрыт.
Программа должна записывать через запятую во второй файл все слова из первого файла длина которых строго больше 6(используй FileWriter).
Поток записи в файл (FileWriter) должен быть закрыт.*/


import java.io.*;
import java.util.ArrayList;


public class FromOneToAnByArr {
    public static void main(String[] args) throws Exception{
        String fileName1 = args[0];
        String fileName2 = args[1];

        BufferedReader reader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));

        ArrayList<String> list = new ArrayList<>();

        while(reader.ready()){
            String [] buf = reader.readLine().split(" ");
            for (int i = 0; i < buf.length; i++) {
                if (buf[i].length()>6) list.add(buf[i]);
            }
        }
        reader.close();

        for (int i = 0; i<list.size(); i++){
            if (i == list.size()-1) writer.write(list.get(i));
            else writer.write(list.get(i)+",");
        }

        writer.close();

    }
}
