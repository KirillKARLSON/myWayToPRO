
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
Три массива
*/

public class Solution {

    public static ArrayList<Integer> numbers = new ArrayList<>();
    public static ArrayList<Integer> divBy3 = new ArrayList<>();
    public static ArrayList<Integer> divBy2 = new ArrayList<>();
    public static ArrayList<Integer> others = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        for (int i = 0; i<20; i++){
            numbers.add (Integer.parseInt (reader.readLine()));


        }
        printList (numbers);
    }

    public static void printList(ArrayList<Integer> list) {
        //напишите тут ваш код
        for (Integer element: list) {
            if (element%3 == 0) divBy3.add (element);
            if (element%2 == 0) divBy2.add (element);
            if (element%3 != 0 && element%2 != 0) others.add (element);

        }
        for (Integer element: divBy3){
            System.out.println (element);
        } System.out.println();

       for (Integer element: divBy2) {
            System.out.println (element);
        } System.out.println();
        for (Integer element: others) {
            System.out.println (element);
        }

    }
}
