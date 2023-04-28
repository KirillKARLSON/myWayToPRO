package WorkWithFile;

/*В метод main первым параметром приходит имя файла.
        В этом файле каждая строка имеет следующий вид:
        имя день месяц год
        где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
        [день] - int, [месяц] - int, [год] - int
        данные разделены пробелами.

        Заполнить список PEOPLE используя данные из файла.
        Закрыть потоки.

        Пример входного файла:
        Иванов Иван Иванович 31 12 1987
        Вася 15 5 2013

        Требования:
        •	Класс Solution должен содержать публичную константу PEOPLE типа List<Person>, которая должна быть сразу проинициализирована.
        •	Программа НЕ должна считывать данные с консоли.
        •	Программа должна считывать содержимое файла (используй FileReader).
        •	Поток чтения из файла (FileReader) должен быть закрыт.
        •	Программа должна заполнить список PEOPLE данными из файла.
        •	Программа должна правильно работать с двойными именами, например Анна-Надежда*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.text.SimpleDateFormat;



public class FromFileToListPARCE {

    public static final List<Person1> PEOPLE = new ArrayList<Person1>();

    public static void main(String[] args) throws Exception{

        String way = args[0];

        BufferedReader reader = new BufferedReader(new FileReader(way));
        while (reader.ready()) {
            String[] buf = reader.readLine().split(" ");
            String name1 = "";
            String date1 = "";

            for (int i = 0; i < buf.length; i++) {
                try {
                  int c = Integer.parseInt(buf[i]);
                  date1 += buf[i]+"/";

                } catch (Exception e){

                   if (name1.equals(""))name1 += buf[i];
                   else name1+=" "+buf[i];

                }

            }
            System.out.println(date1);
            System.out.println(name1);

            Date datePers=new SimpleDateFormat("dd/MM/yyyy").parse(date1);
            PEOPLE.add(new Person1(name1, datePers));
        }

        for(Person1 p: PEOPLE ){
            System.out.println(p.getName()+" "+p.getBirthDate());
        }


    }
}
