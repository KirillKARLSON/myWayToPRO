package Algorythms;


/* Обмениваемся значениями двух переменных без введения буферной переменной*/


public class ChangesPosition {



    public static void main(String[] args) {
        int a = 60;
        int b = 50;


        System.out.println ("Первоначальные значения " + a +" "+b);

        a = b-a;
        b = b-a;
        a = b+a;

        System.out.println ("Значения после замены " + a + " "+ b);



    }
}
