import java.util.Scanner;

public class Main {


    public static int [][] multiArray;
    public static void main(String[] args) {
        System.out.println("Сколько строк в массиве?");
        Scanner scan = new Scanner(System.in);
        int str = scan.nextInt();

        multiArray = new int [str][];
        for (int i = 0; i < str; i++) {

            System.out.println("Введите длину "+ i + "строки");
            int a = scan.nextInt();
            multiArray [i]= new int[a];
        }
        for (int i = 0; i < str; i++) {
            for (int j = 0; j < multiArray[i].length; j++) {
                multiArray [i][j]= 1;
                System.out.print(multiArray [i][j]+" ");
            } System.out.println();
        }

    }
}
