class Solution {
    public boolean isValid(String s) {
        // Use a stack to keep track of characters
        Stack<Character> stack = new Stack<>();
        
        // Iterate through each character in the string
        for (char c : s.toCharArray()) {
            if (c == 'c') {
                // Check if the last two characters on the stack are 'a' and 'b'
                // If not, the string is invalid
                if (stack.size() < 2 || stack.pop() != 'b' || stack.pop() != 'a') {
                    return false;
                }
                // After popping 'a' and 'b', 'c' is implicitly processed
            } else {
                // Push 'a' or 'b' onto the stack
                stack.push(c);
            }
        }
        
        // After processing all characters, the stack should be empty
        return stack.isEmpty();
    }
}