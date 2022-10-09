import java.util.*;
// Rename to Solution in hackerrank submission
public class Solution2 {
      private static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            swap(arr, left++, right--);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        // Take inputs here
        Scanner sc = new Scanner(System.in); 
        int N = sc.nextInt(); 
        // Reverse the array using reverse method
        int[] a = new int[N]; 
        for (int i = 0; i < N; i++){
            a[i] = sc.nextInt(); 
        }
        // Output:      
        reverse(a); 
        System.out.println(Arrays.toString(a));
    }
}
