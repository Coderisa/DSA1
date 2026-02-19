//T- O(N)
//S- O(1)
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Count frequency of characters in p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // Initialize the first window
        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
        }

        // Compare first window
        if (Arrays.equals(pCount, sCount)) {
            result.add(0);
        }

        // Slide the window
        for (int i = p.length(); i < s.length(); i++) {
            // Remove leftmost character
            sCount[s.charAt(i - p.length()) - 'a']--;
            // Add new character
            sCount[s.charAt(i) - 'a']++;

            if (Arrays.equals(pCount, sCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}
