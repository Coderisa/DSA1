import java.util.Stack;

class Solution {
    public boolean checkValidString(String s) {
        // Stack to store indices of '('
        Stack<Integer> leftStack = new Stack<>();
        // Stack to store indices of '*'
        Stack<Integer> starStack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                leftStack.push(i);
            } else if (ch == '*') {
                starStack.push(i);
            } else { // ch == ')'
                // Prefer matching with '(' if available
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } 
                // Otherwise try to match with '*'
                else if (!starStack.isEmpty()) {
                    starStack.pop();
                } 
                // No match found → invalid
                else {
                    return false;
                }
            }
        }
        
        // After processing, match remaining '(' with '*' that appear to the right
        while (!leftStack.isEmpty() && !starStack.isEmpty()) {
            // '(' must come before '*' to be matched (since '*' acts as ')')
            if (leftStack.peek() < starStack.peek()) {
                leftStack.pop();
                starStack.pop();
            } else {
                // '*' appears before '(' → cannot help this '('
                starStack.pop();
            }
        }
        
        // If all '(' are matched, the string is valid
        return leftStack.isEmpty();
    }
}