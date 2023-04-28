package WorkWithFile;
/*Напиши программу, которая будет считать подробную информацию о папке и выводить ее на консоль.

Первым делом считай путь к папке с консоли.
Если введенный путь не является директорией - выведи "[полный путь] - не папка" и заверши работу.
Затем посчитай и выведи следующую информацию:

Всего папок - [количество папок в директории и поддиректориях]
Всего файлов - [количество файлов в директории и поддиректориях]
Общий размер - [общее количество байт, которое хранится в директории]

Используй только классы и методы из пакета java.nio.

Квадратные скобки [ ] выводить на экран не нужно.

Требования:
•	Метод main должен считывать путь к папке с консоли.
•	Если введенный путь не является директорией - нужно вывести "[полный путь] - не папка" и завершить работу.
•	Используй только классы и методы из пакета java.nio.
•	На консоль должна быть выведена следующая информация: "Всего папок - [количество папок в директории и поддиректориях]".
•	На консоль должна быть выведена следующая информация: "Всего файлов - [количество файлов в директории и поддиректориях]".
•	На консоль должна быть выведена следующая информация: "Общий размер - [общее количество байт, которое хранится в директории и поддиректориях]"*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;



public class CounterFileDir {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String dir = reader.readLine();

        Path directory = Path.of(dir);

        if (!Files.isDirectory(directory)){
            System.out.println(dir+" не папка");
        } else {
            AtomicInteger countFold = new AtomicInteger();
            AtomicInteger countFile = new AtomicInteger();
            AtomicLong countBytes = new AtomicLong();

            Files.walkFileTree(directory, new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes atr) throws IOException{
                    if (!dir.equals(directory))countFold.incrementAndGet();
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes atr) throws IOException{
                    countFile.incrementAndGet();
                    countBytes.addAndGet(atr.size());
                    return FileVisitResult.CONTINUE;

                }
            });

            System.out.println("Всего папок "+ countFold.get());
            System.out.println("Всего файлов "+ countFile.get());
            System.out.println("Размер всех файлов " + countBytes.get());

        }
    }
}
