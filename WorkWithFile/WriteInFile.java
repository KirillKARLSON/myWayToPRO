package WorkWithFile;

import javax.xml.transform.Result;
import java.io.*;


public class WriteInFile {
    public  static void main (String[] args) throws IOException {

      BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
     String path = reader.readLine();

        BufferedWriter writer = new BufferedWriter( new FileWriter(path));
        /*writer.write ("Хуй ходячий");
        writer.flush();
        writer.close();*/

        String info;
        do {
            info = reader.readLine();
            writer.write(info);
            writer.flush();
        }while (!info.equals ("exit"));

        reader.close();
        writer.close();


    }
}
