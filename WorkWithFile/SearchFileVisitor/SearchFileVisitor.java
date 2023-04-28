package WorkWithFile.SearchFileVisitor;


import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;


public class SearchFileVisitor extends SimpleFileVisitor<Path>{

    String partOfName;
    String partOfContent;
    int minSize;
    int maxSize;


    private List <Path> foundFiles = new ArrayList<>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public String getPartOfName() {
        return partOfName;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public String getPartOfContent() {
        return partOfContent;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public int getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }



    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length

        String cont = new String(content);



        boolean sizeMAX = true;

        if (!(maxSize == 0) && content.length>maxSize ){
            sizeMAX = false;
        }

        boolean sizeMin = true;

        if (!(minSize == 0) && content.length<minSize){
            sizeMin = false;
        }


        if (sizeMin && maxSize ==0 && partOfName == null && partOfContent == null ){
            foundFiles.add(file);

        }


        if (sizeMAX && minSize==0 && partOfName == null && partOfContent == null ){
            foundFiles.add(file);

        }



        if(sizeMin && sizeMAX && partOfName!=null && file.getFileName().toString().contains(partOfName)){
            foundFiles.add(file);

        }


        if(sizeMin && sizeMAX && partOfContent!=null && cont.contains(partOfContent)){
            foundFiles.add(file);

        }

        return super.visitFile(file, attrs);
    }
}
