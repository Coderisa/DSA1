 /* TLE due to no memeoixzation
 class Solution {
    int m, n;

    public int solve(String s1,String s2, int i , int j){
        if(i>=s1.length() || j>= s2.length()) return 0;
        if(s1.charAt(i)== s2.charAt(j))
          return 1+solve(s1,s2,i+1,j+1);
        else
          return Math.max(solve(s1,s2,i,j+1) , solve(s1,s2,i+1,j));
    }
    public int longestCommonSubsequence(String text1, String text2) {
         m= text1.length();
         n= text2.length();
        return solve(text1,text2,0,0);
    }
}
*/

/* RECURSON+MEMOIZATION
import java.util.Arrays;

class Solution {
    int[][] t = new int[1000][1000];   // better as instance variable
    
    public int solve(String s1, String s2, int i, int j) {
        if (i >= s1.length() || j >= s2.length()) return 0;
        if (t[i][j] != -1) return t[i][j];
        
        if (s1.charAt(i) == s2.charAt(j))
            return t[i][j] = 1 + solve(s1, s2, i + 1, j + 1);
        else
            return t[i][j] = Math.max(solve(s1, s2, i, j + 1),
                                      solve(s1, s2, i + 1, j));
    }
    
    public int longestCommonSubsequence(String text1, String text2) {
        // Fill the entire 2D array with -1 (all 1000×1000 cells)
        for (int i = 0; i < t.length; i++) {
            Arrays.fill(t[i], -1);
        }
        return solve(text1, text2, 0, 0);
    }
}
*/
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        // Fill table from bottom-right to top-left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }
}