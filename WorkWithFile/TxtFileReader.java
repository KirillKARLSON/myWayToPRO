package WorkWithFile;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class TxtFileReader extends FileInputStream {
    FileInputStream fileInputStream;

    public TxtFileReader(String fileName) throws Exception {
        super(fileName);


        if (!fileName.endsWith(".txt")) throw new IOException();

    }







    public static void main(String[] args) throws Exception{

        TxtFileReader reader = new TxtFileReader("C:\\Users\\HP\\Desktop\\File1.txt");
        int p = reader.read();

    }
}
