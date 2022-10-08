import java.util.*;

public class SumOfNaturals {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = n*(n+1)/2;
        System.out.println(sum);
    }
}
