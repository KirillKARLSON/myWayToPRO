package Algorythms;

public class poiskChislaIzRyada {

    /*Задачка на алгоритмы с примером вычисления пропущенного числа в ряде целых чисел.
    * Решение основанно на разнице сумм рядов: 1) который выдан по условию,
    * 2) который есть в действительности. */

    public static void main(String[] args) {
        int counts[] = new int[]{1, 2, 3, 4, 6, 7};

        for (int i = 0; i < counts.length; i++) {
            System.out.println(counts[i]);}

            int sumWait = 7 * (1 + counts[counts.length - 1]) / 2;
            System.out.println("Искомая сумма =" + sumWait);
            int sumReal = 0;

            for (int i = 0; i < counts.length; i++) {
                sumReal = sumReal + counts[i];
            }
            System.out.println("Сумма ряда настоящая =" + sumReal);

            System.out.println("В ряде, полученном на вход, пропущена цифра " + (sumWait - sumReal));

        }
    }