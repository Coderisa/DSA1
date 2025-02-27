class Solution {
    private int[][] t;

    int Solve(String s, int i, int j) {      
        if (i >= j)
            return 1;
        if (t[i][j] != -1)
            return t[i][j];

        if (s.charAt(i) == s.charAt(j))
            return t[i][j] = Solve(s, i + 1, j - 1);
        else
            return t[i][j] = 0;
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        t = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                t[i][j] = -1;
            }
        }

        int maxLen = 0;
        int sp = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (Solve(s, i, j) == 1) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        sp = i;
                    }
                }
            }
        }

        return s.substring(sp, maxLen + sp);
    }
}
