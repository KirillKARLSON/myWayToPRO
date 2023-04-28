public class StringExpir {

    public static void main(String[] args) {
        StringBuilder a = new StringBuilder("Привет Медвед");
        a.append (" ");
        a.append ("сцуко");

        System.out.println (a);

        a.deleteCharAt (1);
        System.out.println (a);

        a.replace (0,5, "Hello");
        System.out.println (a);

        a.reverse ();
        System.out.println (a);

        String b = a. toString();
        b.toUpperCase();
        System.out.println (b);
    }
}
