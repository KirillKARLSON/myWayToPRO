package WorkWithFile;

/*В метод main приходят три параметра:
1) fileName - путь к файлу;
2) number - число, позиция в файле;
3) text - текст.

Считать текст с файла начиная с позиции number, длиной такой же как и длина переданного текста в третьем параметре.
Если считанный текст такой же как и text, то записать в конец файла строку 'true', иначе записать 'false'.
Используй RandomAccessFile и его методы seek(long pos), read(byte[] b, int off, int len), write(byte[] b).
Используй один из конструкторов класса String для конвертации считанной строчки в текст.

Требования:
•	В методе main класса Solution необходимо использовать RandomAccessFile, который должен использовать файл, который приходит первым параметром.
•	В методе main класса Solution программа должна устанавливать позицию в файле, которая передана во втором параметре.
•	В методе main класса Solution программа должна считывать данные с файла при помощи метода read(byte[] b, int off, int len).
•	Запись должна происходить в конец файла.
•	Если считанный текст такой же как и text, то программа должна записать в конец переданного файла строку 'true'.
•	Если считанный текст НЕ такой же как и text, то программа должна записать в конец переданного файла строку 'false'*/

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;


public class ReadByRandomClass {
    public static void main(String[] args) throws IOException {

        String fileName = args[0];
        Long number = Long.valueOf(args[1]);
        String text = args[2];
        byte[] buf = new byte[text.length()];

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        raf.seek(number);
        raf.read(buf, 0, text.length());
        String text1 = new String(buf);

        System.out.println(text1);

        raf.seek(raf.length());

        if(text1.equals(text)) raf.write("true".getBytes());
        else raf.write("false".getBytes());

        raf.close();





    }
}
