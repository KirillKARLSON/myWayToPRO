package WorkWithFile;

/*Почитай про все методы класса Path.
Найди такой, который создает относительный путь между текущим и переданным путем.
Реализуй логику метода getDiffBetweenTwoPaths, он должен возвращать относительный путь.
Метод main не участвует в тестировании.

Требования:
•	Класс Solution должен содержать метод Path getDiffBetweenTwoPaths(Path path1, Path path2).
•	Метод Path getDiffBetweenTwoPaths(Path path1, Path path2) должен быть статическим.
•	Метод getDiffBetweenTwoPaths должен возвращать относительный путь между первым аргументом и вторым.
•	Для реализации метода getDiffBetweenTwoPaths используй правильный метод объекта Path.

*/

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathRelatives {
    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("D:/test/data/firstDir");
        Path path2 = Paths.get("D:/test/data/secondDir/third");
        Path resultPath = getDiffBetweenTwoPaths(path1, path2);
        System.out.println(resultPath);   //expected output '../secondDir/third' or '..\secondDir\third'
    }

    public static Path getDiffBetweenTwoPaths(Path path1, Path path2){
        return path1.relativize(path2);
    }
}
