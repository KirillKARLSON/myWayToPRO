import java.util.ArrayList;

/*
Р или Л
*/

public class RoL {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("роза");
        strings.add("лоза");
        strings.add("лира");
        strings = fix(strings);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> strings) {
        //напишите тут ваш код
       for (int i = 0; i< strings.size(); i++){
           String p = strings.get(i);
           if (p.indexOf("р")>-1) strings.remove (i);
       }
        return strings;
    }
}
