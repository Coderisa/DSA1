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
  /*
 CODE WITH MIK
   //Approach-1 (Recursion + Memoization)
//T.C : O(m*n)
//S.C : O(m*n)
public class Solution {
    private int[][] t;

    public int LCS(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0)
            return t[m][n] = 0;

        if (t[m][n] != -1)
            return t[m][n];

        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return t[m][n] = 1 + LCS(s1, s2, m - 1, n - 1);

        return t[m][n] = Math.max(LCS(s1, s2, m, n - 1), LCS(s1, s2, m - 1, n));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        t = new int[m + 1][n + 1];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }

        return LCS(text1, text2, m, n);
    }
}


//Approach-2 (Bottom Up)
//T.C : O(m*n)
//S.C : O(m*n)
public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        int[][] t = new int[m + 1][n + 1];
        
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
                }
            }
        }
        
        return t[m][n];
    }
}



//Approach-3 (Bottom Up space optmized)
/*
Since, in bottm up approach, we are using results of only two rows, t[i] and t[i-1]. So, we can take only two rows.
*/
//T.C : O(m*n)
//S.C : O(n)
/*
public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        int[][] t = new int[2][n+1];
        
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    t[i % 2][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    t[i % 2][j] = 1 + t[(i + 1) % 2][j - 1];
                } else {
                    t[i % 2][j] = Math.max(t[i % 2][j - 1], t[(i + 1) % 2][j]);
                }
            }
        }
        
        return t[m % 2][n];
    }
}
  */