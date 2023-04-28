package WorkWithFile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



/*Считать с консоли имя файла.
        Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
        Программа запускается с одним параметром: id (int).
        Закрыть потоки.

        В файле данные разделены пробелом и хранятся в следующей последовательности:
        id productName price quantity
        где id - int.
        productName - название товара, может содержать пробелы, String.
        price - цена, double.
        quantity - количество, int.

        Информация по каждому товару хранится в отдельной строке.

        Пример содержимого файла:
        194 хлеб 12.6 25
        195 масло сливочное 52.2 12
        196 молоко 22.9 19

        Пример вывода для id = 195:
        195 масло сливочное 52.2 12

        Требования:
        •	Программа должна считать имя файла с консоли.
        •	В методе main создай для файла поток для чтения.
        •	Программа должна найти в файле и вывести информацию о id, который передается первым параметром.
        •	Поток для чтения из файла должен быть закрыт.
*/

public class SearchIDinFile {

    public static void main(String[] args) throws Exception {

        List<String> content1 = new ArrayList<>();

        Scanner scan = new Scanner(args[0]);
        String id = scan.nextLine();

        scan.close();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();

        reader.close();

        BufferedReader read1 = new BufferedReader(new FileReader(fileName1));

        String p = null;
        while ((p = read1.readLine())!=null){

            content1.add(p);}

        read1.close();

        for (String z: content1){
            if (z.startsWith(id+" ")) System.out.println(z);
        }






    }
}
