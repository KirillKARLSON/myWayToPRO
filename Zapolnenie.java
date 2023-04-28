import java.util.Arrays;

public class Zapolnenie {


public static int [] array = new int [10];
public static int ValueStart = 10;
public static int ValueEnd = 13;
    public static void main(String[] args) {
        int firstPart= (array.length + 1)/2;
        Arrays.fill (array, 0, firstPart, ValueStart);
        Arrays.fill (array, firstPart, array.length, ValueEnd);

        System.out.println (Arrays.toString(array));
    }
}
