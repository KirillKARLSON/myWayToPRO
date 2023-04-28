package WorkWithFile;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.*;


public class ReadAndSort {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String way = reader.readLine();

        FileInputStream inputStream = new FileInputStream(way);


        while (inputStream.available() > 0){
            int data = inputStream.read();

            if (list.contains(data)){
                continue;
            }
            else{
                list.add(data);
            }

        }
        Collections.sort(list);

        for (int num:list) {
            System.out.print(num+" ");
        }
    }
}
