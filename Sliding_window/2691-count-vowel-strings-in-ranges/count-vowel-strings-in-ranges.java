class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefix = new int[words.length];
        int count = 0;
        
        for (int i = 0; i < words.length; i++) {
            if (isVowelString(words[i])) {
                count++;
            }
            prefix[i] = count;
        }
        
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            result[i] = (l == 0) ? prefix[r] : prefix[r] - prefix[l - 1];
        }
        return result;
    }
    
    private boolean isVowelString(String s) {
        if (s == null || s.isEmpty()) return false;
        char first = s.charAt(0);
        char last = s.charAt(s.length() - 1);
        return isVowel(first) && isVowel(last);
    }
    
    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}