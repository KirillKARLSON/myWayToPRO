package WorkWithFile;

import java.io.CharArrayReader;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountEnglSpells {

   // static String alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";


    public static void main(String[] args) throws Exception {
        Character [] alf = {'A','a','B','b','C','c','D','d','E','e','F','f','G','g','H','h','I','i','J','j','K','k','L','l','M','m','N','n','O','o','P','p','Q','q','R','r','S','s','T','t','U','u','V','v','W','w','X','x','Y','y','Z','z'};
        List <Character> alf1 = new ArrayList<>(Arrays.asList(alf));

        FileInputStream inputStream = new FileInputStream(args[0]);
        int count = 0;
        while (inputStream.available()>0){

            char k = (char) inputStream.read();

           // System.out.print(k+" ");
            if (alf1.contains(k)) count+=1;
        }
        System.out.println("\n"+ count);

    }
}
