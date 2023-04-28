package WorkWithFile.Properties;

/* 1)Читаю файл .PROPERTIES, сначала по значениям, а затем весь объект.
* 2) Читаю properties из файла .xml */

import java.io.*;
import java.util.Properties;

public class PropertiesDemonstration {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\HP\\IdeaProjects\\untitled\\src\\WorkWithFile\\Properties\\123.PROPERTIES");
        Properties prop = new Properties();
        prop.load(new FileReader(file));

        String name = prop.getProperty("name");
        int age = Integer.parseInt(prop.getProperty("age"));
        int stage = Integer.parseInt(prop.getProperty("workStage"));

        System.out.println("Our man has name "+name+". He is "+age+" years old. He works in our company for "+stage+" years");



        File file1 = new File("C:\\Users\\HP\\IdeaProjects\\untitled\\src\\WorkWithFile\\Properties\\Prop.xml");
        Properties properties = new Properties();


        properties.loadFromXML(new FileInputStream(file1));




        for(String key: prop.stringPropertyNames()){
            System.out.print(key+ " ");
        }

        String name1 = properties.getProperty("name");
        int level = Integer.parseInt(properties.getProperty("level"));
        System.out.println();


        System.out.println("Вывел из XML файла: "+name1 + " "+ level);


        prop.put("Dlina","Zdoroven");




    }
}
