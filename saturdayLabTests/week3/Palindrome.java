import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	private static boolean isPalindrome(String s){
        /* Complete the code to return bool whether string is Palindrome or not */
        boolean f=true;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)!=s.charAt(n-1-i)) f=false;
        }
        return f;
    }
    public static void main(String[] args) {
        /* Take the input String*/
        Scanner sc=new Scanner(System.in);
      	/* Call the method isPalindrome */
        boolean f=isPalindrome(sc.next());
      	/* Based on the returned type of boolean, print the desired output.*/
        if(f) System.out.println("This is a palindrome.");
        else System.out.println("This is not a palindrome.");
      
    }
}
