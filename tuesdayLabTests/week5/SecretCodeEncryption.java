import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static String cipher(String unencry, int k){
        String s = "";
        for(int i = 0; i < unencry.length(); i++){
            char c = unencry.charAt(i);
            // System.out.println((char)('a' + (c - 'a' + k) % 26));
            s += (char)('a' + (c - 'a' + k) % 26);
        }
        return s;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String e = sc.nextLine();
        int k = Integer.parseInt(sc.nextLine());
        System.out.println(cipher(e, k));
    }
}
