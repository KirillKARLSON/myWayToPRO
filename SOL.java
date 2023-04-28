import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SOL {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");


        if (N<1 || N>100) N = scanner.nextInt();

        scanner.close();

        if (N%2 ==0){
            if ((N>=2 && N<=5) || (N>20 && N<=100)) System.out.println("Not weird");
            else {System.out.printf( "%-15s", "Weird" + "Хуй");

                //String s = "0000"+6;
                System.out.printf("%03d\n", 6);
            System.out.println("c");}

        }
        else System.out.println("Weird");

    }
}