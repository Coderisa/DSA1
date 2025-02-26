public class Solution {
    public String reverseWords(String s) {
        // Trim the input string to remove leading and trailing spaces
        s = s.trim();
        
        // Split the string by one or more spaces using regex
        String[] words = s.split("\\s+");
        
        // Reverse the array of words
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i != 0) {
                reversed.append(" ");
            }
        }
        
        // Convert StringBuilder to String and return
        return reversed.toString();
    }
}

    
