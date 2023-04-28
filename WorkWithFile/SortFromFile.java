package WorkWithFile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortFromFile {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner (System.in);
        String way = scan.nextLine();

        FileInputStream sys = new FileInputStream (way);
        BufferedReader reader = new BufferedReader( new InputStreamReader( sys));

        String txt;
        List <Integer> list = new ArrayList<>();
        while ((txt = reader.readLine()) !=null) {
            int a = Integer.parseInt (txt);
            if (a%2==0) list.add(a);


        }
        Collections.sort(list);

        for (Integer print: list){
            System.out.println(print);
        }

    }
}
