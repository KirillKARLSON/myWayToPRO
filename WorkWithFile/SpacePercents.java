package WorkWithFile;

import java.io.FileInputStream;

public class SpacePercents {
    public static void main(String[] args) throws Exception{
        FileInputStream inputStream = new FileInputStream(args[0]);

        double sumSpace =0;
        double sumAll=0;

        while (inputStream.available()>0) {

            char k = (char) inputStream.read();

            if (k == ' ') {
                sumSpace += 1;
                sumAll += 1;
            } else {
                sumAll += 1;
            }
        }
            System.out.println(sumSpace);
            System.out.println(sumAll);

            double n = (sumSpace/sumAll)*100;

            String result = String.format("%.2f", n);

            System.out.println(n);
            System.out.println(result);

        }
    }

