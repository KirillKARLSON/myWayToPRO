package Algorythms;

/*Two strings,  and , are called anagrams if they contain all the same characters in the same frequencies. For this challenge, the test is not case-sensitive. For example, the anagrams of CAT are CAT, ACT, tac, TCA, aTC, and CtA.

Function Description

Complete the isAnagram function in the editor.

isAnagram has the following parameters:

string a: the first string
string b: the second string
Returns
boolean: If  and  are case-insensitive anagrams, return true. Otherwise, return false.
Input Format

The first line contains a string .
The second line contains a string .

Constraints

Strings  and  consist of English alphabetic characters.
The comparison should NOT be case sensitive.*/

import java.io.*;
import java.util.*;


public class Anagrams {
    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        boolean isAnagrams = false;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();

        char[] a1 = a.toUpperCase().toCharArray();
        char[] b1 = b.toUpperCase().toCharArray();

        Arrays.sort(a1);
        Arrays.sort(b1);

        isAnagrams = isTheWordsAnagrams(a1,b1);

        if (isAnagrams) System.out.println("Anagrams");
        else System.out.println("Not Anagrams");
    }

    public static boolean isTheWordsAnagrams(char[] a1, char[] b1){

        if(a1.length !=b1.length) return false;
        else{
            for (int i = 0; i< a1.length; i++){
                if (a1[i] != b1[i]) return false;
            }
            return true;
        }
    }

}
