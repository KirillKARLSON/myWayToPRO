package TinkoffExam;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//import static jdk.vm.ci.code.CodeUtil.log2;

public class DelimRulet {

    public static double log2 (long x){
        return Math.ceil(Math.log(x)/Math.log(2));
    }

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(reader.readLine());


        double doubValue = log2(n);
        int log2n = (int) doubValue;

        System.out.println(log2n);


    }
}
