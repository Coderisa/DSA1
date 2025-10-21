import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        int n = s.length();

        if (n < totalLen) return result;

        // Frequency map of words
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // Try every possible starting point within wordLen range
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i;
            Map<String, Integer> windowCount = new HashMap<>();
            int count = 0;

            while (right + wordLen <= n) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordCount.containsKey(word)) {
                    windowCount.put(word, windowCount.getOrDefault(word, 0) + 1);
                    count++;

                    // If word appears too many times, shrink window
                    while (windowCount.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        windowCount.put(leftWord, windowCount.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // If all words matched
                    if (count == words.length) {
                        result.add(left);
                    }
                } else {
                    // Reset window
                    windowCount.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}
