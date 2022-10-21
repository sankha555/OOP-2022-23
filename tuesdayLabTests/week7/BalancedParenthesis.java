import java.util.*;

// Implementing Balanced Parentheses using Stack   
class BalancedParentheses {
    private String inputStr;
    private Stack<Character> stack;
    
    BalancedParentheses(String inputStr) {
        this.inputStr = inputStr;
        initialize();  // Allot space to the stack 
    }
    
    /**
     * Initializes the stack with memory space
     */
    void initialize() {
        stack = new Stack<>();
    }
    
    /**
     * Verifies if given inputStr contains balanced parenthesis (i.e. each bracket has a valid matching pair)
     * @return true, if inputStr contains balanced parenthesis, false otherwise 
     */
    boolean isBalanced(){
        for(char c : inputStr.toCharArray()){
            if(c == '<' || c == '(' || c == '{' || c == '['){
                stack.push(c);
                continue;
            }
            if(stack.isEmpty())
                return false;
            
            char top = stack.pop();
            switch (c) {
                case '>':
                    if (top != '<')
                        return false;
                    break;
                case '}':
                    if (top != '{')
                        return false;
                    break;
                case ']':
                    if (top != '[')
                        return false;
                    break;
                case ')':
                    if (top != '(')
                        return false;
                    break;
                default:
                    return false;
            }
        }
        
        return stack.isEmpty();
    }
}

public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        while(n-- > 0) {
            String inputStr = sc.nextLine();
    
            BalancedParentheses parentheses = new BalancedParentheses(inputStr);
    
            // call balancedParenthesis() method to check whether input string is balanced of not
            if (parentheses.isBalanced())
                System.out.println(inputStr + ": Balanced");
            else
                System.out.println(inputStr + ": Not balanced");
        }
    }
}
