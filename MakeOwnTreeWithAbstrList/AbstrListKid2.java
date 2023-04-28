package MakeOwnTreeWithAbstrList;

import java.util.Arrays;
import java.util.List;

public class AbstrListKid2 {
    public static void main(String[] args) {
        List<String> list = new AbstrListKid();
        //list.get(5);

        for (int i = 1; i < 16 ; i++) {
           list.add(String.valueOf(i));
        }


        System.out.println(list.get(5));
        System.out.println(list.size());
        System.out.println(((AbstrListKid) list).getParent("8"));






        //System.out.println();






    }
}
