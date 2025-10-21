class Solution {
    public int uniquePaths(int m, int n) {
        // Total moves = (m - 1) downs + (n - 1) rights = m + n - 2
        // Choose (m - 1) downs from (m + n - 2) total moves
        long res = 1;
        int down = m - 1;
        int total = m + n - 2;

        for (int i = 1; i <= down; i++) {
            res = res * (total - down + i) / i;
        }

        return (int) res;
    }
}
