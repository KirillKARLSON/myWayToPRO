package WorkWithFile;

/*Тренируюсь скачивать картинку по ссылке из интернета, сначала во временный файл, затем в постоянный*/

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class DownloadPicture {
    public static void main(String[] args) throws Exception {
        URL link = new URL("https://upload.wikimedia.org/wikipedia/ru/a/a5/YellowstoneLogoseries.png");
        InputStream stream = link.openStream();

        Path tempFile = Files.createTempFile("temp1-", ".tmp");
        Path resFile = Files.createFile(Path.of("Run.png"));
        Files.copy(stream, tempFile, StandardCopyOption.REPLACE_EXISTING);
        Files.copy(tempFile, resFile, StandardCopyOption.REPLACE_EXISTING);
        stream.close();


    }
}
