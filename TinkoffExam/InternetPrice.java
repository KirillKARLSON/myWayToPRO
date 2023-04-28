package TinkoffExam;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;


public class InternetPrice {
    public static void main(String[] args) throws Exception{

        String stringIn;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        stringIn = reader.readLine();
        String[] nums = stringIn.split(" ");

        int a = Integer.parseInt(nums[0]);
        int b = Integer.parseInt(nums[1]);
        int c = Integer.parseInt(nums[2]);
        int d = Integer.parseInt(nums[3]);

        if (d<b) System.out.println(a);
        else System.out.println ((d-b)*c+a);



    }
}
