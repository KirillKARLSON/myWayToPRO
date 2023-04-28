package WorkWithFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadDoubleFromFile {

    public static void main(String[] args) throws Exception {
        String[] doub;
        //String stroka = "Huj Hodyachij";
        List <Integer> listInt = new ArrayList<>();
        File file1 = new File("C:\\Users\\HP\\Desktop\\File2.txt");
        File file2 = new File ("C:\\Users\\HP\\Desktop\\File3.txt");



        BufferedReader reader = new BufferedReader(new FileReader(file1));

        BufferedWriter writer = new BufferedWriter(new FileWriter(file2));

        String line = reader.readLine();
        doub = line.split(" ");


        for (int i = 0; i<doub.length; i++){
            Double k = Double.parseDouble(doub[i]);
            listInt.add((int) Math.round(k));
        }

        for (int p:listInt) {
            writer.write(p+" ");
        }
        writer.close();


    }
}
