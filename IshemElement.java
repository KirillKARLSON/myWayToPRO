import java.util.Arrays;

public class IshemElement {
    public static int [] array = {9,8,7,6,5,4,3,2,1};
    public static int element = 15;

    public static void main(String[] args) {

        boolean b;
        int [] array1 = Arrays.copyOf (array, array.length);
        //noinspection ReassignedVariable
        Arrays.sort (array1);

        int index = Arrays.binarySearch(array1, element);


        if (index < 0) b = false;
        else b = true;

        System.out.println (Arrays.toString (array));
        System.out.print(b);
    }
}
