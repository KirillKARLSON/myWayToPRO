package WorkWithFile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class ThreeFileSum {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        FileOutputStream outputStream = new FileOutputStream(file1);
        FileInputStream inputStream = new FileInputStream(file2);
        FileInputStream inputStream1 = new FileInputStream(file3);


        while (inputStream.available()>0){
            outputStream.write(inputStream.read());
        }

        while (inputStream1.available()>0){
            outputStream.write(inputStream1.read());
        }



    }
}
