import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
 static boolean areAnagram(char[] str1, char[] str2)
    {
        // Get lengths of both strings
        int n1 = str1.length;
        int n2 = str2.length;
 
        // If length of both strings is not same,
        // then they cannot be anagram
        if (n1 != n2)
            return false;
 
        // Sort both strings
        Arrays.sort(str1);
        Arrays.sort(str2);
 
        // Compare sorted strings
        for (int i = 0; i < n1; i++)
            if (str1[i] != str2[i])
                return false;
 
        return true;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in=new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0;i<t;i++){
        String numstr1 = in.next();
        String numstr2 = in.next();
        char[] charArray1 = numstr1.toCharArray();
        char[] charArray2 = numstr2.toCharArray();
            if(areAnagram(charArray1, charArray2)){
                System.out.println("Yes");
            }
            else{
                 System.out.println("No");
            }
        }
    }
}
