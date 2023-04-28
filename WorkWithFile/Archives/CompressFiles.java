package WorkWithFile.Archives;



/*Архивирую набор файлов из предложенной папки. Путь с именем файлов вношу в список вручную
* В методе addNew ввожу с клавы файл, который нужно заархивить и вплетаю его в получившийся до этого архив, в папку \new*/


import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CompressFiles {
    public static void main(String[] args) throws IOException {
        List<String> paths = new ArrayList<>();

        paths.add("C:\\Users\\HP\\Desktop\\File1.txt");
        paths.add("C:\\Users\\HP\\Desktop\\File2.txt");
        paths.add("C:\\Users\\HP\\Desktop\\File3.txt");
        paths.add("C:\\Users\\HP\\Desktop\\Proba.txt");
        paths.add("C:\\Users\\HP\\Desktop\\Result.txt");


        String zStr = "C:\\Users\\HP\\Desktop\\Archives\\Arch.zip";


        FileOutputStream zipFile = new FileOutputStream("C:\\Users\\HP\\Desktop\\Archives\\Arch.zip");
        ZipOutputStream zip = new ZipOutputStream(zipFile);



        for (int i = 0; i< paths.size(); i++){
            String path = paths.get(i).substring(paths.get(i).lastIndexOf("\\")+1);
            System.out.println("Архивируем "+path);
            zip.putNextEntry(new ZipEntry(path));

            File file = new File(paths.get(i));

            Files.copy(file.toPath(), zip);

        }

        zip.close();

    }

}
