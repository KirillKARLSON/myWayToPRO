package WorkWithFile;


import java.io.*;


public class MultiThreadFileReader {

    public static String firstFileName;
    public static String secondFileName;

    //напишите тут ваш код

    static {

        try{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        firstFileName = reader.readLine();
        secondFileName = reader.readLine();}
        catch (Exception e){System.out.println ("Хуй!!");}
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);

       systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());

    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //напишите тут ваш код

    public static class ReadFileThread extends Thread implements ReadFileInterface{
        public String fileName;
        public String exit = "";

        public void setFileName(String fullFileName){
            this.fileName = fullFileName;

        }


        public String getFileContent() {


            return exit; }

        public void run(){

            String txt;



            try{


                FileInputStream sys = new FileInputStream(this.fileName);
                BufferedReader reader = new BufferedReader(new InputStreamReader(sys));

                while ((txt = reader.readLine()) !=null) {

                    this. exit = this.exit + txt + " ";
                } reader.close();
            }catch (Exception e){System.out.println("Вы мудак");}


        }
    }

}
