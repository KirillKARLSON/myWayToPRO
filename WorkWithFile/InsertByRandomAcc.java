package WorkWithFile;

/*В метод main приходят три параметра:
1) fileName - путь к файлу;
2) number - число, позиция в файле;
3) text - текст.
Записать text в файл fileName начиная с позиции number.
Запись должна производиться поверх старых данных, содержащихся в файле.
Если файл слишком короткий, то записать в конец файла.
Используй RandomAccessFile и его методы seek и write.

Требования:
•	В методе main класса Solution необходимо использовать RandomAccessFile.
•	В методе main класса Solution программа должна записывать данные в файл при помощи метода write класса RandomAccessFile.
•	Запись в файл должна происходить с указанной позиции с заменой содержимого.
•	Если файл слишком короткий, то запись text должна происходить в конец файла.
*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class InsertByRandomAcc {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        Long number = Long.valueOf(args[1]);
        String text = args[2];

        //Byte [] b = text.;


        RandomAccessFile randAcc = new RandomAccessFile(fileName, "rw");

        if (randAcc.length()> number){
            randAcc.seek(number);
        }else {
            randAcc.seek(randAcc.length());
        }

        randAcc.write(text.getBytes());
        randAcc.close();
    }
}
