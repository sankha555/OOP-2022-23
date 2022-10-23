import java.util.HashMap;
import java.util.Map;
// Remove public in hackerrank submission
public class FirstDuplicateDetector {
    private static final NumberWithIndex DEFAULT_PAIR = new NumberWithIndex(-1, -1);

    /**
     * Returns the first repeated number with its first position in the array and DEFAULT_PAIR if
     * no such element exists
     * @param array the array to be scanned for the first duplicate
     * @return an object of NumberWithIndex indicating the first occurrence of repeated integer.
     */
    public static NumberWithIndex getFirstDuplicateWithIndex(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])){
                return new NumberWithIndex(array[i], map.get(array[i]));
            }
            map.put(array[i], i);
        }
        return DEFAULT_PAIR;
    }
}

