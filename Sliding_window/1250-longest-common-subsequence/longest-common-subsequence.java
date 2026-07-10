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