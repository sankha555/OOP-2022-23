import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        
        // Rotate s2 by `i` characters to the left
        int flag = 0;
        for(int i = 0; i < s1.length(); i++){
            String s3 = s2.substring(i) + s2.substring(0, i);
            
            // Check if string s1 and string s3 are equal
            if (s1.equals(s3)){
                flag = 1;
                break;
            }
        }
        
        if(flag == 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
