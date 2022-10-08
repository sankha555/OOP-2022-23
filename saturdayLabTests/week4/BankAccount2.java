import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class BankAccount {
	private String accountNo;
	private String name;
	private static int countMale = 0;
	private static int countFemale = 0; 
    /* Create a  parameterized constructor taking 3 arguments as specified in input */
	public BankAccount(String name, String accountNo, char c) {
		this.accountNo = accountNo; 
        this.name = name; 
       // System.out.println(c); 
        if (c == 'F'){
            ++countFemale;
        } else {
            ++countMale; 
        }
	}
	
	public static void printInfo()
	{
		System.out.println("The number of male account holders is "+countMale+ " and the number of female account holders is "+countFemale+".");
	}

}
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in); 
        int N = sc.nextInt();
      sc.nextLine();
      for (int i = 0; i < N; i++){
          String name = sc.nextLine(); 
          String aN = sc.nextLine(); 
          String g = sc.nextLine(); 
          new BankAccount(name, aN, g.charAt(0)); 
      }
      
      /* Call method printInfo */
      BankAccount.printInfo(); 
    }
}
