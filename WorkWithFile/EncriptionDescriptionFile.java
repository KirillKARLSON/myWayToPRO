package WorkWithFile;

/*Придумать механизм шифровки/дешифровки.

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName

где:
fileName - имя файла, который необходимо зашифровать/расшифровать.
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования.
-e - ключ указывает, что необходимо зашифровать данные.
-d - ключ указывает, что необходимо расшифровать данные.

Требования:
•	Считывать с консоли ничего не нужно.
•	Создай поток для чтения из файла, который приходит вторым параметром ([fileName]).
•	Создай поток для записи в файл, который приходит третьим параметром ([fileOutputName]).
•	В режиме "-e" программа должна зашифровать [fileName] и записать в [fileOutputName].
•	В режиме "-d" программа должна расшифровать [fileName] и записать в [fileOutputName].
•	Созданные для файлов потоки должны быть закрыты.*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EncriptionDescriptionFile {
    public static void main(String[] args) throws Exception{

        String fileName = args[1];
        String outputFile = args[2];

        FileInputStream fileInputStream = new FileInputStream(fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(outputFile);


        switch (args[0]){
            case "-e":
                while (fileInputStream.available()>0){
                    fileOutputStream.write(fileInputStream.read()+1);
                }
                break;


            case "-d":

                while (fileInputStream.available()>0){
                    fileOutputStream.write(fileInputStream.read()-1);
                }
                break;
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

}
