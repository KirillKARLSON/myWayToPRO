package com.javarush.task.pro.task09.task0915;

import java.util.Arrays;
import java.util.StringTokenizer;

/*
StringTokenizer

*/

public class Token {
    public static void main(String[] args) {
        String packagePath = "java.util.stream";
        String[] tokens = getTokens(packagePath, "\\.");
        System.out.println(Arrays.toString(tokens));
    }

    public static String[] getTokens(String query, String delimiter) {
        //напишите тут ваш код
        StringTokenizer tok = new StringTokenizer (query, delimiter);
        int kolToken = tok.countTokens ();
        int i=0;
        String [] tokMas = new String [kolToken];
        while (tok. hasMoreTokens()){

            // = tok. nextToken();

            tokMas [i] = tok.nextToken ();
            i = i+1;

        } return tokMas;
    }
}




