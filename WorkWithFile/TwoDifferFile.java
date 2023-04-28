package WorkWithFile;

import java.io.*;

public class TwoDifferFile {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream = new FileOutputStream(file2);
        FileOutputStream outputStream1 = new FileOutputStream(file3);

        int count = inputStream.available();
        int i = 0;
        while (inputStream.available()>0){

            //int buf = inputStream.read();
            if (i <(count+1)/2) {
                outputStream.write(inputStream.read());
            }
            else {
                outputStream1.write(inputStream.read());
            }
            i++;
        }
        inputStream.close();
        outputStream.close();
        outputStream1.close();


        }

    }

