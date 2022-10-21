import java.util.*;

class UniquePermutations{
    private int numUnique;
    private HashSet<String> uniquePermutations;
    
    UniquePermutations(){
        numUnique = 0;
        uniquePermutations = new HashSet<>();
    }
    
    /**
     * Rotates the inputStr by one unit each time, and calls `addPermutation`
     * @param inputStr String input read from scanner
     */
    public void findAllPermutations(String inputStr){
        for(int i = 0; i < inputStr.length(); i++){
            String t = inputStr.substring(i) + inputStr.substring(0, i);
            addPermutation(t);
        }
    }
    
    /**
     * Adds the permutation if it is numUnique to
     * @param s String that is provided by rotation from the findAllPermutations() function call
     * @return true if numUnique permutation, false if repeated permutation
     */
    private boolean addPermutation(String s){
        boolean isInserted = uniquePermutations.add(s);
        if(isInserted)
            numUnique++;
        return isInserted;
    }
    
    @Override
    public String toString() {
        return "Number of numUnique permutations = " + numUnique + "\n" +
                "Permutations: " + uniquePermutations.toString();
    }
}

public class Solution {
    
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();
        
        UniquePermutations permutations = new UniquePermutations();
        permutations.findAllPermutations(inputStr);
        
        System.out.println(permutations);
    }
}
