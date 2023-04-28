package WorkWithFile;

/*В классе Solution переопредели логику двух методов:
- visitFile кроме своей логики должен добавлять в archived все пути к zip и rar файлам
- visitFileFailed должен добавлять в failed все пути к недоступным файлам и возвращать SKIP_SUBTREE

Пример вывода:
D:/mydir/BCD.zip

Метод main не участвует в тестировании

Требования:
В классе Solution нужно переопределить метод visitFile.
Метод visitFile, кроме своей логики, должен добавлять в поле archived все пути к zip и rar файлам.
В классе Solution нужно переопределить метод visitFileFailed.
Метод visitFileFailed должен добавлять в поле failed все пути к недоступным файлам и возвращать SKIP_SUBTREE*/


import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class OverrideFileVisit extends SimpleFileVisitor<Path> {

    public static void main(String[] args) throws IOException {
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        final OverrideFileVisit ovFV = new OverrideFileVisit();
        Files.walkFileTree(Paths.get("D:/"), options, 20, ovFV);

        List<String> result = ovFV.getArchived();
        System.out.println("All archived files:");
        for (String path : result) {
            System.out.println("\t" + path);
        }

        List<String> failed = ovFV.getFailed();
        System.out.println("All failed files:");
        for (String path : failed) {
            System.out.println("\t" + path);
        }
    }
    private List<String> archived = new ArrayList<>();
    private List<String> failed = new ArrayList<>();

    public List<String> getArchived() {
        return archived;
    }

    public List<String> getFailed() {
        return failed;
    }

    @Override
    public FileVisitResult visitFile(Path path, BasicFileAttributes att){
        if (path.toString().endsWith(".rar") || path.toString().endsWith(".zip")){
            archived.add(path.toString());

        }
        return FileVisitResult.CONTINUE;
    }


    @Override
    public FileVisitResult visitFileFailed (Path path, IOException exc){
        failed.add(path.toString());

        return FileVisitResult.SKIP_SUBTREE;
    }
}
