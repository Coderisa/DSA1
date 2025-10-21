class Solution {
    private Map<Integer, Boolean> memo;
    private boolean[] used;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // If the sum of all numbers is less than desiredTotal, no one can win
        int sum = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2;
        if (sum < desiredTotal) return false;
        if (desiredTotal <= 0) return true;

        memo = new HashMap<>();
        used = new boolean[maxChoosableInteger + 1];
        return canWin(desiredTotal);
    }

    private boolean canWin(int total) {
        int key = format(used);
        if (memo.containsKey(key)) return memo.get(key);

        for (int i = 1; i < used.length; i++) {
            if (!used[i]) {
                used[i] = true;
                // If choosing i reaches or exceeds total, or opponent cannot win after this move
                if (i >= total || !canWin(total - i)) {
                    memo.put(key, true);
                    used[i] = false;
                    return true;
                }
                used[i] = false;
            }
        }

        memo.put(key, false);
        return false;
    }

    // Convert boolean[] to an integer key for memoization
    private int format(boolean[] used) {
        int num = 0;
        for (boolean b : used) {
            num <<= 1;
            if (b) num |= 1;
        }
        return num;
    }
}
