package WorkWithFile;

/*Реализуй метод downloadFile(String urlString, Path downloadDirectory), на вход которого подается ссылка для скачивания файла и папка, куда нужно закачать файл.
Все ссылки имеют вид:
https://yastatic.net/morda-logo/i/citylogos/yandex19-logo-ru.png
http://toogle.com/files/rules.txt
https://pacemook.com/photos/image1.jpg

Метод должен создать объект URL и загрузить содержимое файла на локальный диск.
Выкачивай сначала во временную директорию, чтобы в случае неуспешной загрузки в твоей директории не оставались недокачанные файлы.
Затем перемести файл в пользовательскую директорию. Имя для файла возьми из ссылки.
Используй только классы и методы из пакета java.nio.

Требования:
•	Метод downloadFile должен создавать объект URL для переданной ссылки.
•	Метод downloadFile должен создать временный файл с помощью метода Files.createTempFile.
•	Метод downloadFile должен скачать файл по ссылке во временный файл, используя метод Files.copy.
•	Метод downloadFile должен переместить файл из временной директории в пользовательскую, используя метод Files.move.
•	Имя сохраненного файла должно быть таким же, как в URL-ссылке*/

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.file.*;

public class DownloadPicture1 {

    public static void main(String[] args) throws Exception {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("C://Users/HP/Downloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method

        URL url = new URL(urlString);
        InputStream stream = url.openStream();

        Path tempFile = Files.createTempFile("temp1-", ".tmp");
        Files.copy(stream, tempFile, StandardCopyOption.REPLACE_EXISTING);


        String filename = urlString.substring(urlString.lastIndexOf("/"), urlString.lastIndexOf("."));
        String suffix = urlString.substring(urlString.lastIndexOf("."));

        String ffn = ""+downloadDirectory+filename+suffix;

        Path endFile = Paths.get (ffn);
        Files.move(tempFile, endFile, StandardCopyOption.REPLACE_EXISTING);



    return endFile;
    }
}
