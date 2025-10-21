class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s, 0, s.length(), k);
    }

    private int helper(String s, int start, int end, int k) {
        if (end - start < k) return 0;

        int[] freq = new int[26];
        for (int i = start; i < end; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int mid = start; mid < end; mid++) {
            if (freq[s.charAt(mid) - 'a'] < k) {
                int midNext = mid + 1;
                while (midNext < end && freq[s.charAt(midNext) - 'a'] < k) {
                    midNext++;
                }
                return Math.max(helper(s, start, mid, k), helper(s, midNext, end, k));
            }
        }

        return end - start;
    }
}
