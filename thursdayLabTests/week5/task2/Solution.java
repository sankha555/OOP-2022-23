import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    private static String insertSpaces(String sentence, int[] spaces) {
        Arrays.sort(spaces);
        StringBuilder stringBuilder = new StringBuilder();
        int spaceTracker = 0;
        int sentenceTracker = 0;
        while (sentenceTracker < sentence.length()) {
            if (spaceTracker < spaces.length && sentenceTracker == spaces[spaceTracker]) {
                stringBuilder.append(" ");
                ++spaceTracker;
            }
            stringBuilder.append(sentence.charAt(sentenceTracker++));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        int N = sc.nextInt();
        int[] spaces = new int[N];
        for (int i = 0; i < N; i++) {
            spaces[i] = sc.nextInt();
        }
        System.out.println(insertSpaces(sentence, spaces));
    }
}
