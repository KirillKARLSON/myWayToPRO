package WorkWithFile;

import java.io.*;

public class Whrap extends FileOutputStream{
    public static String fileName = "C:\\Users\\HP\\Desktop\\File1.txt";

    FileOutputStream outputStream;

    public Whrap(FileOutputStream outputStream) throws FileNotFoundException {
        super(fileName);
        this.outputStream = outputStream;
    }

    public static void main(String[] args) throws Exception{
        Whrap outputStream = new Whrap(new FileOutputStream(fileName));
        outputStream.close();
    }

    @Override
    public void write(int b) throws IOException{
        outputStream.write(b);
    }
    @Override
    public void write(byte[] b) throws IOException{
        outputStream.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException{
        outputStream.write(b, off, len);
    }
    @Override
    public void flush () throws IOException{
        outputStream.flush();
    }

    public void close() throws IOException{
        flush();
        outputStream.write("JavaRush © All rights reserved.".getBytes());
        outputStream.close();
    }



}
