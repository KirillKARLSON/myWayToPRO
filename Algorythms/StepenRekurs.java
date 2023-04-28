package Algorythms;

/* Возведение в степень рекурсией.
chis - входное число,
p - степень.

Метод stepen вызывает сам себя, каждый раз уменьшая степень на 1 и
умножая chis а chis до тех пор, пока его второй параметр не станет равен 1

Задача разобрана для положительных степеней. */




public class StepenRekurs {


    public static void main(String[] args) {


    int p = 4;
    int chis= 2;


    int result = stepen(chis, p);

    System.out.print(result);}


    public static int stepen (int chis, int p){
        if (p>1) {
           return chis*stepen(chis,--p);
        }
     return chis;
    }

}
