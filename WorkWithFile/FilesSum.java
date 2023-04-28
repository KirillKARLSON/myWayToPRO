package WorkWithFile;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilesSum {
    public static void main(String[] args) throws Exception {

        List<String> content2 = new ArrayList<>();
        List<String> content1 = new ArrayList<>();
        List<String> content3 = new ArrayList<>();


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File(reader.readLine());
        File file2 = new File(reader.readLine());

        BufferedReader read1 = new BufferedReader(new FileReader(file1));

        String p = null;
        while ((p = read1.readLine())!=null){

        content1.add(p);}


        PrintStream write1 = new PrintStream(file1);
        BufferedReader read2 = new BufferedReader(new FileReader(file2));

        while ((p = read2.readLine())!=null){

            content2.add(p);}

        for (String d:content2){
            content3.add(d);
        }
        for (String d:content1){
            content3.add(d);
        }

      //  char[] p = content1.toArray();



        for (String d: content3) {
            write1.println(d);
        }

    }
}
