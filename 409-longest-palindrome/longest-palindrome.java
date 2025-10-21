import java.util.*;

class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        int length = 0;
        boolean hasOdd = false;

        for (int freq : count.values()) {
            length += freq / 2 * 2; // Add even part
            if (freq % 2 == 1) hasOdd = true; // Track if any odd count exists
        }

        // If there's at least one odd count, we can place one character in the center
        return hasOdd ? length + 1 : length;
    }
}
