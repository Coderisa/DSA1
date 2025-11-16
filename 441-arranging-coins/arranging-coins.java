class Solution {
    public int arrangeCoins(int n) {
         /*long b = 0, e = n;
        long ans = 0;
        while (b <= e) {
            long mid = b + (e - b) / 2;
            long coins = mid * (mid + 1) / 2; // safe in long
            if (coins <= n) {
                ans = mid;
                b = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return (int) ans; // cast back to int
    }
}//10^9-
/*Use long for mid and multiplication to avoid overflow.
✅ Cast ans back to int at the end (since return type is int).

             */
return (int)(Math.sqrt(2 * (long)n +0.25) -0.5)   ;          

    }
}