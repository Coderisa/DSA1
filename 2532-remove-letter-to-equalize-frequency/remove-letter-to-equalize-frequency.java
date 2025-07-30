

public class Solution {
    public boolean equalFrequency(String word) {
        int[] freq = new int[26];  // For 'a' to 'z'

        // Count frequency of each character
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        // Try removing each character one by one
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;

            freq[i]--;  // Simulate removal

            // Collect frequencies into a set
            Set<Integer> uniqueFreqs = new HashSet<>();
            for (int f : freq) {
                if (f > 0) uniqueFreqs.add(f);
            }

            // Check if all remaining frequencies are equal
            if (uniqueFreqs.size() == 1) return true;

            freq[i]++;  // Restore original count
        }

        return false;
    }
}
