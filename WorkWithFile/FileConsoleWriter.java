package WorkWithFile;

/* Реализуй логику FileConsoleWriter.
Класс FileConsoleWriter должен содержать приватное поле FileWriter fileWriter.
Класс FileConsoleWriter должен содержать все конструкторы, которые инициализируют fileWriter для записи.
Класс FileConsoleWriter должен содержать пять методов write и один метод close:

public void write(char[] cbuf, int off, int len) throws IOException
public void write(int c) throws IOException
public void write(String str) throws IOException
public void write(String str, int off, int len) throws IOException
public void write(char[] cbuf) throws IOException
public void close() throws IOException
При записи данных в файл, должен дублировать эти данные на консоль.

Важно: нужно использовать 8-й уровень языка (java language level)!

Требования:
•	Класс FileConsoleWriter должен содержать приватное поле FileWriter fileWriter, которое не должно быть сразу проинициализировано.
•	Класс FileConsoleWriter должен иметь пять конструкторов которые инициализируют fileWriter для записи.
•	Класс FileConsoleWriter должен содержать метод write(char[] cbuf, int off, int len) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
•	Класс FileConsoleWriter должен содержать метод write(int c) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
•	Класс FileConsoleWriter должен содержать метод write(String str) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
•	Класс FileConsoleWriter должен содержать метод write(String str, int off, int len) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
•	Класс FileConsoleWriter должен содержать метод write(char[] cbuf) throws IOException, в котором данные для записи должны записываться в fileWriter и дублироваться в консоль.
•	Класс FileConsoleWriter должен содержать метод close() throws IOException, в котором должен вызываться такой же метод поля fileWriter*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileConsoleWriter{

    private FileWriter fileWriter;
    private String fileName;
    private boolean append;
    private File file;

    private FileDescriptor fd;
    private Charset charset;


    public FileConsoleWriter(String fileName, FileWriter fileWriter) throws IOException {
        this.fileName = fileName;
        this.fileWriter = fileWriter;
    }

    public FileConsoleWriter(String fileName, boolean append, FileWriter fileWriter) throws IOException {
        this.fileName = fileName;
        this.append = append;
        this.fileWriter = fileWriter;
    }

    public FileConsoleWriter(File file, FileWriter fileWriter) throws IOException {
        this.file = file;
        this.fileWriter = fileWriter;
    }

    public FileConsoleWriter(File file, boolean append, FileWriter fileWriter) throws IOException {
        this.file = file;
        this.append = append;
        this.fileWriter = fileWriter;
    }

    public FileConsoleWriter(FileDescriptor fd, FileWriter fileWriter) {
        this.fd = fd;
        this.fileWriter = fileWriter;
    }




    public void write(char[] cbuf, int off, int len) throws IOException{
        fileWriter.write(cbuf, off, len);
        System.out.println(String.copyValueOf(cbuf,off,len));
    }

    public void write(int c) throws IOException{
        fileWriter.write(c);
        System.out.println(c);
    }

    public void write(String str) throws IOException{
        fileWriter.write(str);
        System.out.println(str);
    }

    public void write(char[] cbuf) throws IOException{
        fileWriter.write(cbuf);
        System.out.println(cbuf);
    }

    public void write(String str, int off, int len) throws IOException{
        fileWriter.write(str, off, len);
        System.out.println(String.valueOf(str.toCharArray(), off, len));
    }

    public void close() throws IOException{
        fileWriter.close();
    }




    public static void main(String[] args) {

    }
}
