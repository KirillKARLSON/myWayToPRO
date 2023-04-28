package WorkWithFile.Archives;

/*Учусь распаковывать архив из нескольких файлов, предварительно созданный в папке*/

import java.io.*;
import java.util.zip.*;

public class UnpackedArchive {
    public static void main(String[] args) {
        try(var file = new ZipFile("C:\\Users\\HP\\Desktop\\Archives\\Archives.zip")){
            var entries = file.entries();
            var uncomprDir = new File("C:\\Users\\HP\\Desktop\\UnpackedArchives\\");

            while (entries.hasMoreElements()){
                var entry = entries.nextElement();
                processFile(file, uncomprDir, entry);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void processFile(ZipFile file, File uncomprDir, ZipEntry entry) throws IOException{
        //доделать!!
     try (var is = file.getInputStream(entry);
        var bis = new BufferedInputStream(is)
     ){
         var uncomprFile = uncomprDir+entry.getName();

         try( var os = new FileOutputStream(uncomprFile);
              var bos = new BufferedOutputStream(os)
                 ){
             while (bis.available()>0){
                 bos.write(bis.read());
             }
         }
     }
   }
}
