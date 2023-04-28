import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Mnozh1{
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        bufferedReader.close();

        for (int i =1; i<=10; i++){
            int res = N*i;
            System.out.println(N + " x "+i+" = "+res);
        }
    }
}
