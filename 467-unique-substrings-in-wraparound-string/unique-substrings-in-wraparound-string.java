class Solution {
    public int findSubstringInWraproundString(String s) {
        if (s == null || s.length() == 0) return 0;

        // maxLen[i] stores the max length of valid substring ending with char 'a' + i
        int[] maxLen = new int[26];
        int k = 0; // current length of valid substring

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && (s.charAt(i) - s.charAt(i - 1) + 26) % 26 == 1) {
                k++;
            } else {
                k = 1;
            }

            int index = s.charAt(i) - 'a';
            maxLen[index] = Math.max(maxLen[index], k);
        }

        int total = 0;
        for (int len : maxLen) {
            total += len;
        }

        return total;
    }
}
