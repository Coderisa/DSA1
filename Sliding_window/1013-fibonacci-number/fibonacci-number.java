class Solution {

    int solve(int n, int []dp){
        if(n<=1) return n;
        if(dp[n] !=-1) return dp[n];
        return  dp[n]=solve(n-1,dp)+solve(n-2, dp);
    }
    public int fib(int n) {
        if (n <=1) return n;
        int dp[] = new int [n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);}
}


/*class Solution {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }

        return b;
    }
}
*/