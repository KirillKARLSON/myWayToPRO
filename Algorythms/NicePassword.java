package Algorythms;


/*Реализуй логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов.
2) только цифры и латинские буквы разного регистра.
3) обязательно должны присутствовать цифры, и буквы разного регистра.
Все сгенерированные пароли должны быть уникальные.

Пример правильного пароля:
wMh7smNu

Требования:
•	Класс Solution должен содержать метод getPassword().
•	Длина пароля должна составлять 8 символов.
•	Пароль должен содержать хотя бы одну цифру.
•	Пароль должен содержать хотя бы одну латинскую букву нижнего регистра.
•	Пароль должен содержать хотя бы одну латинскую букву верхнего регистра.
•	Пароль не должен содержать других символов, кроме цифр и латинских букв разного регистра.
•	Сгенерированные пароли должны быть уникальными */


import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class NicePassword {
    public static void main(String[] args) throws Exception{
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws IOException {

        String passwordString="";

        char[] nums = "0123456789".toCharArray();
        char[] bigLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char [] smallLetters = "abcdefghijklmnopqrstuvwxyz".toCharArray();


        for (int i = 0; i < 5; i++) {
            int groupNumb = (int) (Math.random()*3);
            int numbInChar;
            if (groupNumb == 0){
                numbInChar = (int) (Math.random()*9);
                passwordString += nums[numbInChar];
            }
            if (groupNumb == 1){
                numbInChar = (int) (Math.random()*bigLetters.length-1);
                passwordString += bigLetters[numbInChar];
            }

            if (groupNumb == 2){
                numbInChar = (int) (Math.random()*smallLetters.length-1);
                passwordString += smallLetters[numbInChar];
            }
        }

        for (int i = 1; i <= 3; i++) {
            int numbInChar;
            if (i == 1){
                numbInChar = (int) (Math.random()*9);
                passwordString += nums[numbInChar];
            }
            if (i == 2){
                numbInChar = (int) (Math.random()*bigLetters.length-1);
                passwordString += bigLetters[numbInChar];
            }

            if (i == 3){
                numbInChar = (int) (Math.random()*smallLetters.length-1);
                passwordString += smallLetters[numbInChar];
            }

        }

        System.out.println(passwordString);




        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        baos.write(passwordString.getBytes());


        return baos;
    }
}
