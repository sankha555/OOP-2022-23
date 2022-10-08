import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        int N = 26;
        int []freq = new int[N];
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'A']++;
        }
        for(int i = 0; i < N; i++){
            System.out.print((char)(i + 'A'));
            System.out.print(" ");
            for(int j = 0; j < freq[i]; j++)
                System.out.print("#");
            System.out.println();
        }
    }
}