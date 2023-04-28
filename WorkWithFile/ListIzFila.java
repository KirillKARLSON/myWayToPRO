package WorkWithFile;

import WorkWithFile.StaticFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class ListIzFila {

    public static List<String> lines = new ArrayList<String>();

    static {
        try {
            File file = new File(StaticFile.FILE_NAME);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line !=null ) {
                lines.add(line);

                line = reader.readLine();
            }
        }
        catch(Exception e) {
                    System.out.println("ХУЙ");
        }
        }


            public static void main (String[]args) throws Exception {
               // for (String p: lines){
                    System.out.println(lines);
                //}
                }
            }

