package Algorythms;

/*Привет Амиго. Ты знаешь, за нами следят, просматривают нашу переписку. Поэтому нужно шифровать трафик.
Для тебя не составит труда реализовать шифр Цезаря, напомню что это просто сдвиг вправо по алфавиту на key букв.
В методе main есть хороший пример.

Реализуй логику метода String decode(StringReader reader, int key).
Метод получает данные в закодированном виде.
Он должен вернуть дешифрованную строку, что хранится в StringReader - е.
Возвращаемый объект ни при каких условиях не должен быть null.
Метод main не участвует в тестировании.

Требования:
•	Класс Solution должен содержать метод String decode(StringReader reader, int key).
•	Метод decode(StringReader reader, int key) должен вернуть дешифрованную строку что хранится в StringReader - е.
•	Возвращаемый объект ни при каких условиях не должен быть null*/

import java.io.IOException;
import java.io.StringReader;

public class CesarCrypt {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Pmttw(Iuqow(+H1₼G,8");
        System.out.println(decode(reader, -8));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        StringBuilder builder = new StringBuilder();
        int ch1;

        if (reader!= null){
            while ((ch1 = reader.read()) != -1){
                char ch = (char) ch1;
                builder.append((char) (ch+key));
            }
        }

        return builder.toString();
    }
}
