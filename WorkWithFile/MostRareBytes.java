package WorkWithFile;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class MostRareBytes {

    static ArrayList<Integer> list1 = new ArrayList<>();
    public static int minCount= Integer.MAX_VALUE;



    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String way = reader.readLine();
        readBytesToList(way);

     /*   for(int num:list1){
            System.out.print(num + " ");
        }*/

        minCount();
        //System.out.println("");
        //System.out.println(minCount);

        printResult();
    }

    public static void readBytesToList(String way) throws Exception{
        FileInputStream inputStream = new FileInputStream(way);

        while (inputStream.available() > 0){
            int data = inputStream.read();

                list1.add(data);

        }
        inputStream.close();
    }

    public static void minCount(){
        int count = 0;
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list1.size(); j++) {

                if (list1.get(i) == list1.get(j)){
                    count++;
                }

            }
            if (count<minCount) {
                minCount = count;
            }

        }

    }

    public static void printResult(){
        int count = 0;
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list1.size(); j++) {
                if (list1.get(i) == list1.get(j)){
                    count++;
                }
            }
            if (count == minCount){
                System.out.print(list1.get(i)+" ");

            } count = 0;

        }
    }

}
