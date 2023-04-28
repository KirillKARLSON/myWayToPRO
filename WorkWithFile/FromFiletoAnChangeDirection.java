package WorkWithFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class FromFiletoAnChangeDirection {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        BufferedReader reader1 = new BufferedReader(new FileReader(fileName));

        while(reader1.ready()){
            char [] buf = reader1.readLine().toCharArray();
            for(int i = buf.length-1; i>=0; i--){
                System.out.print(buf[i]);

            }
            System.out.println();
        }
    }

}
