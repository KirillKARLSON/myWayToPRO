package WorkWithFile;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class JoinReadding {

    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static String firstFileName;
    public static String secondFileName;

    static {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (Exception e) {
            System.out.println("Хуй!!");
        }

    }
        public static void main(String[] args) {




        /*try{
            joinData();}
        catch (Exception e){
            System.out.println("ХУй");
        }*/

try{
            BufferedReader reader = new BufferedReader( new InputStreamReader(new FileInputStream(firstFileName)));
            String txt;
            while ((txt = reader.readLine()) !=null) {
                allLines.add(txt);
            }
            reader.close();

            BufferedReader reader1 = new BufferedReader( new InputStreamReader(new FileInputStream(secondFileName)));
            String txt1;
            while ((txt1 = reader1.readLine()) !=null) {
                forRemoveLines.add(txt1);
            }
            reader.close();}
catch (Exception e){System.out.println("Хуй");}


try {
    joinData();
}
catch (Exception e){
    System.out.print("ХХХХУЙ");
}

            for(String f: allLines){
                System.out.println(f);
            }
            for(String d: forRemoveLines){
                System.out.println(d);
            }
        }




        public static void joinData() throws CorruptedDataException {


        if (allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
        }
        else{
            allLines.clear();
            CorruptedDataException except = new CorruptedDataException();

           throw except;
        }


        }
}
