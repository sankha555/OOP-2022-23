import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    
    static String toNum(String s)
    {
        long num=Long.parseLong(s);
        num/=80;
        String ans=Long.toString(num);
        int n=ans.length();
        for(int i=n-3;i>=1;i-=3)
        {
            ans = new StringBuffer(ans).insert(i, ",").toString();
        }
        return ans;
    }
    static String formatNumber(String s){
        String ans="";
        StringTokenizer st = new StringTokenizer(s, ";");
        while (st.hasMoreTokens())
        {
            ans=ans+toNum(st.nextToken())+";";
        }
        return ans; 
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        
        for(int i=0;i<n;i++)
        {
            String s=sc.nextLine();
            System.out.println(formatNumber(s));
        }
    }
}
