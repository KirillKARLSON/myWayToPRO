package Serialization;
/*Реализуй логику записи в файл и чтения из файла для класса ClassWithStatic.
Метод load должен инициализировать объект включая статические поля данными из файла.
Метод main не участвует в тестировании.

Требования:
•	Должна быть реализована возможность сохранения/загрузки объектов типа Solution.ClassWithStatic с помощью методов save/load.
•	Класс Solution не должен поддерживать интерфейс Serializable.
•	Класс Solution.ClassWithStatic не должен поддерживать интерфейс Serializable.
•	Класс Solution.ClassWithStatic должен быть публичным.
•	Класс Solution.ClassWithStatic не должен поддерживать интерфейс Externalizable.*/


import java.io.*;


public class ClassWithStatic {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

           // File yourFile = File.createTempFile("Result.tmp", null);
            OutputStream outputStream = new FileOutputStream("Result.txt");
            InputStream inputStream = new FileInputStream("Result.txt");

            ClassWithStatic1 classWithStatic = new ClassWithStatic1();
            classWithStatic.i = 3;
            classWithStatic.j = 4;
            classWithStatic.save(outputStream);
            outputStream.flush();
            //outputStream.close();


            ClassWithStatic1 loadedObject = new ClassWithStatic1();
            loadedObject.staticString = "something";
            loadedObject.i = 6;
            loadedObject.j = 7;

            loadedObject.load(inputStream);
            //here check that the classWithStatic object is equal to the loadedObject object - проверьте тут, что classWithStatic и loadedObject равны


            inputStream.close();

            System.out.println(loadedObject.i+ " "+loadedObject.j);

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class ClassWithStatic1 {
        public static String staticString = "This is a static test string";
        public int i;
        public int j;

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод

           PrintWriter prW = new PrintWriter(outputStream);
           prW.println(staticString);
           prW.println(this.i);
           prW.println(this.j);

           prW.close();

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод


            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            staticString = br.readLine();
            this.i = Integer.parseInt(br.readLine());
            this.j = Integer.parseInt(br.readLine());

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ClassWithStatic1 that = (ClassWithStatic1) o;

            if (i != that.i) return false;
            return j == that.j;

        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }

    }


}

