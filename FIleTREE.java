


/*еализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используй очередь, рекурсию не используй.
Верни список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.

Требования:
•	Метод getFileTree должен принимать аргументом String root, по которому нужно найти все вложенные файлы.
•	Метод getFileTree должен возвращать список строк.
•	Нужно реализовать метод getFileTree: найти все файлы по указанному пути и добавить их в список.
•	Метод getFileTree должен быть вызван только 1 раз (рекурсию не использовать)*/


import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;


public class FIleTREE {

    //List<String> list = new ArrayList<>();
    public static List<String> getFileTree(String root) throws IOException {

        List<String> list = new ArrayList<>();

        List<String> list1  = new ArrayList<>();

        File folder  = new File(root);

        for (File file: folder.listFiles()){
            if (file.isFile()) list.add(file.getAbsolutePath());
            if (file.isDirectory()) list1.add(file.getAbsolutePath());
        }

        System.out.println(list1);


        for (int i = 0; i<list1.size(); i++){
            File fol = new File(list1.get(i));
            for (File file: fol.listFiles()){
                if (file.isFile()) list.add(file.getAbsolutePath());
                if (file.isDirectory()) list1.add(file.getAbsolutePath());
            }

        }

        System.out.println(list1);
        return list;

    }

    public static void main(String[] args) throws Exception {

       System.out.println(getFileTree("C:\\Users\\HP\\Desktop\\"));



    }
}
