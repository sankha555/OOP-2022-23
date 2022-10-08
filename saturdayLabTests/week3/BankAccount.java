import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class BankAccount {
    private String accountno;
    private int balance;
    public BankAccount(String s, int b) {
        accountno=s;
        balance=b;
    }
    public String getAccountno() {
        return accountno;
    }
    public void setAccountno(String accountno) {
        this.accountno = accountno;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    public void printInfo()
    {
        System.out.println("The bank account number is "+accountno+" and balance is "+balance+".");
    }

}


public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int balance=sc.nextInt();
        BankAccount b=new BankAccount(s,balance);
        b.printInfo();
        b.setBalance(sc.nextInt());
        b.printInfo();
    }

}
