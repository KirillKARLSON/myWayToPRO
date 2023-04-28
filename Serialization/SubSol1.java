package Serialization;

/*Запрети сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя.

Требования:
Класс Solution должен поддерживать интерфейс Serializable.
Класс SubSolution должен быть создан внутри класса Solution.
Класс SubSolution должен быть потомком класса Solution.
При попытке сериализовать объект типа SubSolution должно возникать исключение NotSerializableException.
При попытке десериализовать объект типа SubSolution должно возникать исключение NotSerializableException.*/

import java.io.*;

public class SubSol1 implements Serializable {
    public static class SubSolution extends SubSol1{

        String p;


        Sol1 k;

        public SubSolution(String p, int a){
            this.p = p;
            k = new Sol1(a);
        }





    }

    public static class Sol1{
        int a;
        public Sol1(int a){
            this.a = a;
        }
    }

    public static void main(String[] args) throws IOException {

        FileOutputStream fos = new FileOutputStream("Expir.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(new SubSolution("КЭ", 5));
    }
}
