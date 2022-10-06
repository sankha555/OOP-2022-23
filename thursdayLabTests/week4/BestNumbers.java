import java.util.Arrays;

public class BestNumbers {
    private static final int[] INITIAL_BEST_NUMBERS = {1, 2, 3, 4, 5};
    private final int[] bestNumbersArray;
    private int changes = 0;
    private static BestNumbers bestNumbers;

    private BestNumbers() {
        bestNumbersArray = INITIAL_BEST_NUMBERS;
    }

    public static BestNumbers getBestNumbers() {
        if (bestNumbers == null) {
            bestNumbers = new BestNumbers();
        }
        return bestNumbers;
    }

    // Changes the number at rank (or index) supplied to be the newBestNumber for that rank
    // If no more changes allowed, print "No more changes allowed"
    public void changeNumberAtRank(int rank, int newBestNumberForRank) {
        if (changes == 3) {
            System.out.println("No more changes allowed");
            return;
        }
        bestNumbersArray[rank] = newBestNumberForRank;
        ++changes;
    }

    public void printBestNumbers() {
        System.out.println(Arrays.toString(bestNumbersArray));
    }

    public int getChangesRemaining() {
        return 3 - changes;
    }
}
