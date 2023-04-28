public class TablUmnozh {
    public static int[][] MULTIPLICATION_TABLE;

    public static void main(String[] args) {
        //напишите тут ваш код
        MULTIPLICATION_TABLE = new int[10][10];

        for (int i = 1; i < MULTIPLICATION_TABLE.length + 1; i++) {

            for (int j = 1; j < MULTIPLICATION_TABLE.length + 1; j++) {
                System.out.print('*' + " ");
            }
            System.out.println();
        }
    }
}
