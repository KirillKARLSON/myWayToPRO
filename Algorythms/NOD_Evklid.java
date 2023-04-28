package Algorythms;

/*В задаче ищем наибольший общий делитель двух числел - a и b
* Методом Евклида. Классический метод в несколько раз длиннее и сложнее
* */




public class NOD_Evklid {

    public static void main(String[] args) {
        int a = 42;
        int b = 56;

        while (a!=0 && b!=0){
            if (a>b){
                a = a%b;
            }
            else b = b%a;
        }
        System.out.println (b+a);
    }
}
