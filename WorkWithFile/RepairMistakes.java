package WorkWithFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/*
Исправить ошибку. Классы и интерфейсы
*/

public class RepairMistakes {
    {
        System.out.println("This is the Solution class");
    }

    public static void main(String... args) throws Exception {
        try (
                FileOutputStream outputStream = new FileOutputStream(args[0]);
                InputStream is = RepairMistakes.class.getClassLoader().getResourceAsStream(args[1]);
        ) {

            //assert is != null;
            byte[] b = new byte[is.available()];
            outputStream.write(is.read(b));

            int value = 123_456_789;
            System.out.println(value);

            Example result = null;
            String s = "c";
            switch (s) {
                case "a": {
                    result = new RepairMistakes().new A();
                    break;
                }
                case "b": {
                    result = new RepairMistakes().new B();
                    break;
                }
                case "c": {
                    result = new RepairMistakes().new C();
                    break;
                }
            }

            if (result instanceof C) {
                C p = (C) result;
                System.out.println(p.getClass().getSimpleName());
            }

        } catch (IOException e) {
        }
    }

    interface Example {
    }

    class A implements Example {
        {
            System.out.println("This is the A class");
        }
    }

    class B implements Example {
        {
            System.out.println("This is the B class");
        }
    }

    class C extends A {
        {
            System.out.println("This is the C class");
        }
    }
}

