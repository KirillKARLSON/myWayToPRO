package WorkWithFile;

/*Реализуй логику методов:
1. readBytes - должен возвращать все байты файла fileName.
2. readLines - должен возвращать все строки файла fileName. Используй кодировку по умолчанию.
3. writeBytes - должен записывать массив bytes в файл fileName.
4. copy - должен копировать файл resourceFileName на место destinationFileName.

ГЛАВНОЕ УСЛОВИЕ:
Никаких других импортов!

Требования:
Импорты в классе Solution менять нельзя.
Метод readBytes должен возвращать все байты файла fileName.
Метод readLines должен возвращать все строки файла fileName с кодировкой по умолчанию.
Метод writeBytes должен записывать массив bytes в файл fileName.
Метод copy должен копировать файл resourceFileName на место destinationFileName.

*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/*
Своя реализация
*/

public class OwnRealization{
    public static byte[] readBytes(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        byte [] buff = Files.readAllBytes(filePath);


        return buff;
    }

    public static List<String> readLines(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        List <String> list = Files.readAllLines(filePath);


        return list;
    }

    public static void writeBytes(String fileName, byte[] bytes) throws IOException {
        Path filePath = Paths.get(fileName);
        Files.write(filePath, bytes);
    }

    public static void copy(String resourceFileName, String destinationFileName) throws IOException {
        Path fileStart = Paths.get(resourceFileName);
        Path fileEnd = Paths.get(destinationFileName);

        Files.copy(fileStart,fileEnd);
    }


    public static void main(String[] args) throws IOException{

        System.out.println(Arrays.toString(readLines("C:\\Users\\HP\\Desktop\\File1.txt").toArray()));


    }
}
