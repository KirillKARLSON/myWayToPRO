package WorkWithFile;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.io.FileInputStream;



//C:\Users\HP\Desktop\Result.txt
//C:\Users\HP\Desktop\Proba.txt
//C:\Users\HP\Desktop\File1.txt
//C:\Users\HP\Desktop\File2.txt


public class OpenFile {

    public static void main(String[] args) throws IOException {
        // напишите тут ваш код

        Scanner scan = new Scanner (System.in);
        String way = scan.nextLine();

        //scan.close();
        FileInputStream sys = new FileInputStream (way);
        BufferedReader reader = new BufferedReader( new InputStreamReader( sys));

        String txt;

        while ((txt = reader.readLine()) !=null) {

            System.out.println(txt);
        }

        }
}
